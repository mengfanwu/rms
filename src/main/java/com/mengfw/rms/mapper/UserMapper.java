package com.mengfw.rms.mapper;

import com.mengfw.rms.model.User;

/**
 * Created by MFW on 2017/5/23.
 */
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {
    User query(Integer id);
}
