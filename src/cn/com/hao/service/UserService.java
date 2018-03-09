package cn.com.hao.service;

import cn.com.hao.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author : hao
 * @description :
 * @time : 2018/3/9 15:16
 */
public interface UserService {
    User login(User user);
}
