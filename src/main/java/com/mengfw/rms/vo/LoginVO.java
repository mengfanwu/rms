package com.mengfw.rms.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by MFW on 2017/5/30.
 */
@Data
public class LoginVO implements Serializable{
    private static final long serialVersionUID = 5570040997955780044L;
    private String token;
    private Integer empId;
}
