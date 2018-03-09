package cn.com.hao.controller;

import cn.com.hao.MD5Util;
import cn.com.hao.common.Result;
import cn.com.hao.common.ResultGenerator;
import cn.com.hao.pojo.User;
import cn.com.hao.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author : hao
 * @description :
 * @time : 2018/3/9 14:53
 */
@Controller
public class ControllerUser {

    @Autowired
    private UserService userService;

    private static final Logger log = Logger.getLogger(ControllerUser.class);

    @RequestMapping("/login")
    public @ResponseBody Result login(User user) {
        try {
            String Md5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
            user.setPassword(Md5pwd);
        } catch (Exception e) {
            user.setPassword("");
        }
        log.debug("���յ��û���Ϊ��" + user.getUsername() + "________���ܺ������Ϊ��" + user.getPassword());
        User result = userService.login(user);

        if (result == null) {
            log.debug("���ݲ���δ��ѯ���û���Ϣ��");
            return ResultGenerator.genFailResult("��������ȷ���û���������");
        }
        return ResultGenerator.genSuccessResult(result);
    }

}
