package edu.ordersystem.dto;

public class ValueDto {

    private int code = 200;//状态码
    private String message;//错误信息
    private Object value;//传输数据

    public ValueDto() {
    }

    public ValueDto(int code, String message, Object value) {
        this.code = code;
        this.message = message;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
