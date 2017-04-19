package com.example.linxi.viewpager_fragment.metadata;

/**
 * Created by linxi on 2017/4/19.
 */

public class UserLogin {
    private ReqDeviceInfo deviceInfo;
    private ReqAuthMsg auth;

    public ReqAuthMsg getAuth() {
        return auth;
    }

    public void setAuth(ReqAuthMsg auth) {
        this.auth = auth;
    }

    public ReqDeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(ReqDeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}
