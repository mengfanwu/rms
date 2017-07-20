package com.mengfw.rms.service;

import com.mengfw.rms.common.BaseService;
import com.mengfw.rms.model.Emp;

/**
 * Created by MFW on 2017/5/29.
 */
public interface EmpService extends BaseService<Emp> {
    Emp queryByMobile(String mobile);
}
