package com.mengfw.rms.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by MFW on 2017/5/28.
 */
@Data
public class GlobalContext implements Serializable{
    private static final long serialVersionUID = 345767461167815939L;
    private GlobalRequest globalRequest;
    private GlobalResult globalResult;

    public GlobalContext(GlobalRequest globalRequest) {
        this.globalRequest = globalRequest;
        this.globalResult = new GlobalResult();
        globalResult.setLogin(globalRequest.isLogin());
    }
}
