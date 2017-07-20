package com.mengfw.rms.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by MFW on 2017/5/28.
 */
@Data
public class GlobalRequest implements Serializable{
    private static final long serialVersionUID = -390983456088378753L;
    private String url;
    private String method;
    private String ip;
    private Integer accountId;
    private boolean login;
}
