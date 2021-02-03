package com.yhpt.studentmanagement.service;

import com.yhpt.studentmanagement.entity.User;
import com.yhpt.studentmanagement.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: hjj
 * @Date: 2020/11/9 17:42
 * @Description:
 */
@Transactional
@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;

    public User getUserByUsername(String username) {
        return loginMapper.getUserByUsername(username);
    }

}
