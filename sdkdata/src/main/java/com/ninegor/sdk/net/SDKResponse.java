package com.ninegor.sdk.net;

/**
 * Created by joye on 2017/2/25.
 */

public class SDKResponse {


    /**
     * resultCode : -1
     * resultMessage : 账号或密码有误
     */

    private int resultCode;
    private String resultMessage;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public boolean isSuccess(){
        return resultCode==0;
    }
}
