package com.sb.service.impl;

import com.sb.entity.User;
import com.sb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sb.service.UserService;

import java.util.List;

/**
 * Created by Administrator on 2018/5/23 0023.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired private UserMapper userMapper;

    public List<User> queryAllUsers(){
        return userMapper.queryAllUsers();
    }

}
