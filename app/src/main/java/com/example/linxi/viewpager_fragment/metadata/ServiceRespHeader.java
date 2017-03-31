package com.example.linxi.viewpager_fragment.metadata;

/**
 * Created by linxi on 2017/3/29.
 */

public class ServiceRespHeader {
    private int returnCode;
    private int sequence;
    private String business;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    private String version;
    private String returnMsg;
    private int subCode;
    private String subMsg;

    public void copy(ServiceRespHeader obj){
        if (null==obj)
            return;
        this.setBusiness(obj.getBusiness());
        this.setReturnCode(obj.getReturnCode());
        this.setReturnMsg(obj.getReturnMsg());
        this.setSequence(obj.getSequence());
        this.setVersion(obj.getVersion());
        this.setSubCode(obj.getSubCode());
        this.setSubMsg(obj.getSubMsg());
    }

    public String getSubMsg() {
        return subMsg;
    }

    public void setSubMsg(String subMsg) {
        this.subMsg = subMsg;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public int getSubCode() {
        return subCode;
    }

    public void setSubCode(int subCode) {
        this.subCode = subCode;
    }
}
