package com.sb.user;

import com.sb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sb.service.UserService;

import java.util.List;

/**
 * Created by Administrator on 2018/5/23 0023.
 */
@Controller
public class UserController {
    @Autowired private UserService userService;

    @RequestMapping("queryAllUsers")
    public List<User> queryAllUsers(){
        return userService.queryAllUsers();
    }

}
