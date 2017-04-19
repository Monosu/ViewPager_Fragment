package com.example.linxi.viewpager_fragment.metadata;

import java.io.Serializable;

/**
 * Created by linxi on 2017/4/19.
 */

public class ReqAuthMsg implements Serializable {
    private static final long serialVersionUID=-2767248681139745362L;

    private String authId;
    private String account;
    private String passwd;
    private int accountType;
    private Integer isSetPasswd;
    private String verifyCode;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public Integer getIsSetPasswd() {
        return isSetPasswd;
    }

    public void setIsSetPasswd(Integer isSetPasswd) {
        this.isSetPasswd = isSetPasswd;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
