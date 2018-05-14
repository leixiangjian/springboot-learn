#WebMvcRegistrationsAdapter<br>
	如果保留Spring Boot MVC特性，你只需添加其他的MVC配置（拦截器，格式化处理器，视图控制器等）。你可以添加自己的 WebMvcConfigurerAdapter 类型的 @Configuration 类，而不需要注解 @EnableWebMvc <br>
	如果希望使用自定义的 RequestMappingHandlerMapping ， RequestMappingHandlerAdapter ，或 ExceptionHandlerExceptionResolver ，你可以声明一个 WebMvcRegistrationsAdapter 实例提供这些组件 <br>
```
@Configuration
public class WebMvcConfig extends WebMvcRegistrationsAdapter {

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new CustomRequestMappingHandlerMapping();
    }
}

```

#全面控制Spring MVC<br>
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

#静态资源<br>
	默认情况下，Spring Boot从classpath下的 /static （ /public ， /resources 或 /META-INF/resources ）文件夹，或从 ServletContext 根目录提供静态内容