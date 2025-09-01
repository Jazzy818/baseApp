package com.jzcradle.api.request;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class RepeatableHttpInputMessage implements HttpInputMessage {

    private final org.springframework.http.HttpHeaders headers;
    private final java.io.InputStream body;

    public RepeatableHttpInputMessage(HttpInputMessage inputMessage) throws java.io.IOException {
        this.headers = inputMessage.getHeaders();
        // 读取输入流并缓存到字节数组中
        byte[] bodyBytes = inputMessage.getBody().readAllBytes();
        // 使用 ByteArrayInputStream 包装字节数组，确保输入流可重复读取
        this.body = new ByteArrayInputStream(bodyBytes);
    }

    @Override
    public HttpHeaders getHeaders() {
        return this.headers;
    }

    @Override
    public InputStream getBody() {
        return this.body;
    }
}
