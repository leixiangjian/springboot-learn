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

# 静态资源<br>
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

## web-jars

# 类型格式转换
## converter
## formatter

# Http消息格式转换
## HttpMessageConverters

	