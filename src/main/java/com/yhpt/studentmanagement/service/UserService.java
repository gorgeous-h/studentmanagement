package com.yhpt.studentmanagement.service;

import com.yhpt.studentmanagement.entity.Role;
import com.yhpt.studentmanagement.entity.User;
import com.yhpt.studentmanagement.mapper.LoginMapper;
import com.yhpt.studentmanagement.mapper.UserMapper;
import com.yhpt.studentmanagement.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/10 16:50
 * @Description:
 */
@Transactional
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LoginMapper loginMapper;

    // mysql分页：https://www.w3schools.com/php/php_mysql_select_limit.asp
    public Map<String, Object> getUsers(Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();
        map.put("rows", userMapper.getUsers(params));
        map.put("total", userMapper.getUsersCount(params));
        return map;
    }

    public void saveUser(UserVO userVO) {
        if(userVO.getId()==null){
            userMapper.insertUser(userVO);
        } else {
            userMapper.updateUser(userVO);
        }
    }

    public UserVO getUserVOById(Integer id) {
        UserVO userVO = null;
        if(id!=null){
            userVO = new UserVO();
            User user = userMapper.getUserById(id);
            BeanUtils.copyProperties(user, userVO);
            Role role = user.getRole();
            if(role!=null){
                userVO.setRoleId(role.getId());
            }
        }
        return userVO;
    }

    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public User getUserByUsername(String username) {
        return loginMapper.getUserByUsername(username);
    }

    public void deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
    }

    public void modifyPwd(Integer id, String password) {
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        userMapper.modifyPwd(user);
    }

}
