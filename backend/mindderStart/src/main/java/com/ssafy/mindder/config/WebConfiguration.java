package com.ssafy.mindder.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mindder.interceptor.JwtInterceptor;

import org.springframework.beans.factory.annotation.Value;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer{
	
	private final String uploadFilePath;

	public WebConfiguration(@Value("${file.path.upload-files}") String uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}
	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		System.out.println("CORS Setting");
//		default 설정.
//		Allow all origins.
//		Allow "simple" methods GET, HEAD and POST.
//		Allow all headers.
//		Set max age to 1800 seconds (30 minutes).
		registry.addMapping("/**").allowedOrigins("*")
//		.allowedOrigins("http://localhost:8080", "http://localhost:8081")
			.allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(),
					HttpMethod.DELETE.name(), HttpMethod.HEAD.name(), HttpMethod.OPTIONS.name(),
					HttpMethod.PATCH.name())
//			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH", "HEAD")
			.maxAge(1800);
	}
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/swagger-ui.html**").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
//	 @Override
//	    public void addInterceptors(InterceptorRegistry registry) {
//	        registry.addInterceptor(new JwtInterceptor())
//	                .addPathPatterns("/**") // 해당 경로에 접근하기 전에 인터셉터가 가로챈다.
//	                .excludePathPatterns("/users/check-nickname") // 해당 경로는 인터셉터가 가로채지 않는다.
//	        		.excludePathPatterns("/users/check-email")
//	        		.excludePathPatterns("/users/email-confirm")
//	        		.excludePathPatterns("/users/login")
//	        		.excludePathPatterns("/users/join")
//	        		.excludePathPatterns("/users/social")
//	        		.excludePathPatterns("/users/temp-password")
//	        		.excludePathPatterns("/swagger-resources/**")
//	        		.excludePathPatterns("/swagger-ui.html")
//	        		.excludePathPatterns("/v2/api-docs")
//	        		.excludePathPatterns("/webjars/**");
//	        		
//	    }
	
}
