package com.emal.kladr.rest;

public class JSONOperationResponse {
    private boolean error;
    private String errorMessage;
    private Object data;

    public JSONOperationResponse() {
    }

    public JSONOperationResponse(Object data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void addError(String errorMessage) {
        setError(true);
        setErrorMessage(errorMessage);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
