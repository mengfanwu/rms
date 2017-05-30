package com.mengfw.service.impl;

import com.mengfw.common.BaseServiceImpl;
import com.mengfw.mapper.UserMapper;
import com.mengfw.model.User;
import com.mengfw.service.UserService;
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
