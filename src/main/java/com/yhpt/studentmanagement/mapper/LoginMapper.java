package com.yhpt.studentmanagement.mapper;

import com.yhpt.studentmanagement.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {

    User getUserByUsername(String username);

}
