package mengfw.rms.service.impl;

import mengfw.rms.common.BaseServiceImpl;
import mengfw.rms.mapper.UserMapper;
import mengfw.rms.model.User;
import mengfw.rms.service.UserService;
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
