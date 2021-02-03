package com.yhpt.studentmanagement.mapper;

import com.yhpt.studentmanagement.entity.User;
import com.yhpt.studentmanagement.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    List<User> getUsers(Map<String, Object> params);

    int getUsersCount(Map<String, Object> params);

    User getUserById(Integer id);

    void insertUser(UserVO user);

    void updateUser(UserVO user);

    void deleteUser(Integer userId);

    void modifyPwd(User user);

}
