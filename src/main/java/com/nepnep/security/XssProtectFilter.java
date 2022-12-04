package com.nepnep.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class XssProtectFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        XssRequestWrapper wrappedRequest = new XssRequestWrapper((HttpServletRequest) request);
        String body = IOUtils.toString(wrappedRequest.getReader());

        if (!StringUtils.isBlank(body)) {
            Map<String, Object> oldJsonObject = new ObjectMapper().readValue(body, HashMap.class);
            Map<String, Object> newJsonObject = new HashMap<>();
            oldJsonObject.forEach((key, value) -> newJsonObject.put(key, XssUtils.charEscape(value.toString())));
            wrappedRequest.resetInputStream(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(newJsonObject).getBytes());
        }

        chain.doFilter(wrappedRequest, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}


