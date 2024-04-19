package com.abc.customfilter;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//specific browser only allowed to access the resources-source validation filter
@Configuration
public class BrowserFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		String userAgent = request.getHeader("User-Agent");
		if (userAgent != null && userAgent.contains("Mozilla")) {
			filterChain.doFilter(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied: Unsupported Browser");
		}
	}

}
/*
Note : we can create the own filters by this way.


*/