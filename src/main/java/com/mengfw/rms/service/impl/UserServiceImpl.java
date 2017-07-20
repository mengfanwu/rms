package com.mengfw.rms.service.impl;

import com.mengfw.rms.common.BaseServiceImpl;
import com.mengfw.rms.mapper.UserMapper;
import com.mengfw.rms.model.User;
import com.mengfw.rms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MFW on 2017/5/23.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User query(Integer id) {
        return userMapper.query(id);
    }
}
