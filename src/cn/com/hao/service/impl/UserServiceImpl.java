package cn.com.hao.service.impl;

import cn.com.hao.mapper.UserMapper;
import cn.com.hao.pojo.User;
import cn.com.hao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : hao
 * @description :
 * @time : 2018/3/9 15:16
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
