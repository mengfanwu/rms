package com.mengfw.rms.service;

import com.mengfw.rms.common.BaseService;
import com.mengfw.rms.model.User;

/**
 * Created by MFW on 2017/5/23.
 */
public interface UserService extends BaseService<User> {
    User query(Integer id);
}
