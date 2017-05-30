package com.mengfw.model;


import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by MFW on 2017/5/23.
 */
@Data
public class User implements Serializable{
    private static final long serialVersionUID = 1025679096446928010L;
    @Id
    private Integer id;

    private String name;

    public User(Integer id) {
        this.id = id;
    }

    public User() {
    }
}
