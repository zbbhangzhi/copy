package com.sb.mapper;

import com.sb.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2018/5/23 0023.
 */
@Component
public interface UserMapper {
    List<User> queryAllUsers();
}
