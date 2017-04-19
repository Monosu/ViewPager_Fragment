package com.example.linxi.viewpager_fragment.metadata;

/**
 * Created by linxi on 2017/4/19.
 */

public class ReqDeviceInfo {
    private String idetification;
    private Integer platform=0;

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getIdetification() {
        return idetification;
    }

    public void setIdetification(String idetification) {
        this.idetification = idetification;
    }
}
