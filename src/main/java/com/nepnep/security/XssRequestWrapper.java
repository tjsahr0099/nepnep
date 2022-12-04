package com.nepnep.security;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class XssRequestWrapper extends HttpServletRequestWrapper {

    private byte[] rawData;
    private HttpServletRequest request;
    private ResettableServletInputStream servletStream;

    public XssRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
        this.servletStream = new ResettableServletInputStream();
    }

    public void resetInputStream(byte[] data) {
        servletStream.stream = new ByteArrayInputStream(data);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (rawData == null) {
            rawData = IOUtils.toByteArray(this.request.getReader(),"utf-8");
            servletStream.stream = new ByteArrayInputStream(rawData);
        }
        return servletStream;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        if (rawData == null) {
            rawData = IOUtils.toByteArray(this.request.getReader());
            servletStream.stream = new ByteArrayInputStream(rawData);
        }
        return new BufferedReader(new InputStreamReader(servletStream));
    }


    private class ResettableServletInputStream extends ServletInputStream {

        private InputStream stream;

        @Override
        public int read() throws IOException {
            return stream.read();
        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setReadListener(ReadListener listener) {
        }
    }
}