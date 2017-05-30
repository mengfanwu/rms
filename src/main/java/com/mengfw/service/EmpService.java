package com.mengfw.service;

import com.mengfw.common.BaseService;
import com.mengfw.model.Emp;

/**
 * Created by MFW on 2017/5/29.
 */
public interface EmpService extends BaseService<Emp> {
    Emp queryByMobile(String mobile);
}
