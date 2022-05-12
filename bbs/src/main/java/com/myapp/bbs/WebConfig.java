package com.myapp.bbs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.myapp.bbs.interceptor.LoginCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 인터셉터를 추가하는 메소드
		registry
			.addInterceptor(new LoginCheckInterceptor())
			.addPathPatterns("/board/**")							// 인터셉터를 적용할 컨트롤러 주소
			.excludePathPatterns("/board/list", "/board/get");		// 인터셉터를 적용안 할 주소- 리스트와 조회는 로그인을 안 하더라도 볼 수 있게
		
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 저장된 파일(이미지)의 경로를 지정한다. (이미지를 사용하기 위함)
		registry
			.addResourceHandler("/media/**")
			.addResourceLocations("file:///C:/SPRING/spring-workspace/bbs/src/main/resources/static/media/");
	}
}
