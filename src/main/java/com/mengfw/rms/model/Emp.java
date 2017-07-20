package com.mengfw.rms.model;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by MFW on 2017/5/29.
 */
@Data
public class Emp implements Serializable{
    private static final long serialVersionUID = 2818742071581506933L;
    @Id
    private Integer id;
    private String name;
    private String orgCode;
    private String mobile;
    private String email;
    private String token;
    private String password;
    private Integer postId;
    private Integer majorId;
    private Date lastLoginTime;
}
