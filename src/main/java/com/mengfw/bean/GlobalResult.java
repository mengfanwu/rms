package com.mengfw.bean;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by MFW on 2017/5/28.
 */
@Data
public class GlobalResult implements Serializable{
    private static final long serialVersionUID = -1098881142851628429L;
    private boolean success = false;
    private boolean login = true;
    private String message;
    private Map<String, Object> model = Maps.newHashMap();

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
