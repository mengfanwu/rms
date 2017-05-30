package com.mengfw.service;

import com.mengfw.common.BaseService;
import com.mengfw.model.User;

/**
 * Created by MFW on 2017/5/23.
 */
public interface UserService extends BaseService<User> {
    User query(Integer id);
}
