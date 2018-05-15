# WebMvcRegistrationsAdapter<br>
		如果保留Spring Boot MVC特性，你只需添加其他的MVC配置（拦截器，格式化处理器，视图控制器等）。
	你可以添加自己的 WebMvcConfigurerAdapter 类型的 @Configuration 类，而不需要注解 @EnableWebMvc
	如果希望使用自定义的 RequestMappingHandlerMapping ， RequestMappingHandlerAdapter ，
	或 ExceptionHandlerExceptionResolver ，你可以声明一个 WebMvcRegistrationsAdapter 实例提供这些组件
```
@Configuration
public class WebMvcConfig extends WebMvcRegistrationsAdapter {

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new CustomRequestMappingHandlerMapping();
    }
}

```

# 全面控制Spring MVC<br>
		添加自己的 @Configuration ，并使用 @EnableWebMvc 注解
```
@Configuration
public class MyConfiguration {
	@Bean
	public HttpMessageConverters customConverters() {
		HttpMessageConverter<?> additional = ...
		HttpMessageConverter<?> another = ...
		return new HttpMessageConverters(additional, another);
	}
}
```

##ConfigurableWebBindingInitializer
	在controller中定义
```
		@InitBinder
    public void initBinder(WebDataBinder webDataBinder) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class , new CustomDateEditor(simpleDateFormat , true));
    }
```
# 资源引用

## 静态资源<br>
		默认情况下，Spring Boot从classpath下的 /static （ /public ， /resources 或 /META-INF/resources ）文件夹，
	或从 ServletContext 根目录提供静态内容,这是通过Spring MVC的 ResourceHttpRequestHandler 实现的，你可以自定
	义 WebMvcConfigurerAdapter 并覆写 addResourceHandlers 方法来改变该行为（加载静态文件）.
		Springboot2.0使用的是Spring5.0,Spring5.0中WebMvcConfigurerAdapter算过时的，不再建议使用，
	那么我们可以使用WebMvcConfigurationSupport来代替。示例代码如下
```
@Configuration
public class CustomerInterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor());
        super.addInterceptors(registry);
    }
}
```
## web-jars

# 类型格式转换
## converter
```
	@Override
	public FormattingConversionService mvcConversionService() {
		StringToDateConverter stringToDateConverter = new StringToDateConverter("yyyy-MM-dd HH:mm");
		FormattingConversionService formattingConversionService = super.mvcConversionService();
		formattingConversionService.addConverter(stringToDateConverter);
		return formattingConversionService;
	}
```
## formatter
```
	@Override
	public void addFormatters(FormatterRegistry registry) {
	    registry.addFormatter(new BookFormatter());
	}
```
# Http消息格式转换
## HttpMessageConverters
### 选择HttpMessageConverter
	springmvc通过自定义http accept或者content-type自动选择HttpMessageConverter
### 如何加入HttpMessageConverter
	通过configureMessageConverters这个方法添加转换器，会直接忽略掉其他的转换器；
	通过extendMessageConverters扩展方法扩展转换器是在原有基础上增加；
	request的requestBody与response的responseBody将会通过转换器进行处理。
```
@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport{
	private static final Logger logger = LoggerFactory.getLogger(WebConfiguration.class);
	@Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (HttpMessageConverter<?> messageConverter : converters) {
        	logger.info("{}",messageConverter.getClass().getName()); //2
        }
    }
	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new CustomerStringHttpMessageConverter());
	}
```
### 消息转换器种类
	1).org.springframework.http.converter.ByteArrayHttpMessageConverter
	2).org.springframework.http.converter.StringHttpMessageConverter
	3).org.springframework.http.converter.ResourceHttpMessageConverter
	4).org.springframework.http.converter.ResourceRegionHttpMessageConverter
	5).org.springframework.http.converter.xml.SourceHttpMessageConverter
	6).org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter
	7).org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter
	8).org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

# 拦截器
```
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CustomerHandlerInterceptor());
		registry.addWebRequestInterceptor(new CustomerWebRequestInterceptor());
	}
```
# 过滤器
```
@Configuration
public class ConfigurationFilter {
	@Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }
	
	@Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CustomerFilter());//添加过滤器
        registration.addUrlPatterns("/*");//设置过滤路径，/*所有路径
        registration.addInitParameter("name", "alue");//添加默认参数
        registration.setName("CustomerFilter");//设置优先级
        registration.setOrder(1);//设置优先级
        return registration;
    }
}



```
