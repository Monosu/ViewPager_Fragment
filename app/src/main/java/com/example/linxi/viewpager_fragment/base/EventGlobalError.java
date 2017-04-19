package com.example.linxi.viewpager_fragment.base;

/**
 * Created by linxi on 2017/4/19.
 */

public class EventGlobalError {
    private int code;
    private String reason;

    public EventGlobalError(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public int getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }
}
