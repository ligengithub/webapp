package com.example.webapp.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@Component
//@Order(Integer.MIN_VALUE)
//@WebFilter(urlPatterns = "/**",filterName = "myFilter")
public class CorsFilter implements Filter {
    private Logger log = LoggerFactory.getLogger(this.getClass());


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("myfilter");

        try {
            if (StringUtils.isEmpty(((HttpServletRequest) servletRequest).getHeader("x-forwarded-host"))) {
                this.setHttpServletResponseHeader(servletResponse);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void destroy() {

    }

    private void setHttpServletResponseHeader(ServletResponse servletResponse) {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization, Idempotent");
        response.setHeader("Access-Control-Allow-Credentials", "true");
    }

}
