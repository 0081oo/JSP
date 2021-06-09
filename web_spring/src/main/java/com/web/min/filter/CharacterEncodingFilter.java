package com.web.min.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 만약 이거 안되면 pom.xml 에서 Servlet을 4.0.1, javax.servlet-api 로 바꾸기 
// 이렇게 세줄 쓰면 web.xml 에 필터 등록할 필요도 없음
//@Component
//@WebFilter(urlPatterns="/*", filterName="encodingFilter")
//@Order(1)
public class CharacterEncodingFilter implements Filter {

    public CharacterEncodingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		response.setCharacterEncoding("utf-8");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
