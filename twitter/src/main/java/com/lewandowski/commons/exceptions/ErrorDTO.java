package com.lewandowski.commons.exceptions;

import javax.servlet.http.HttpServletRequest;

public class ErrorDTO {
    private String url;
    private String message;

    public ErrorDTO() {
    }

    public ErrorDTO(HttpServletRequest req, Exception exception) {
        url = req.getRequestURL().toString();
        message = exception.getMessage();
    }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
