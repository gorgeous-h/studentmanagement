package com.yhpt.studentmanagement.mapper;

import com.yhpt.studentmanagement.entity.Menu;
import com.yhpt.studentmanagement.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RoleMapper {

    List<Role> getRoles(Map<String, Object> params);

    int getRolesCount(Map<String, Object> params);

    Role getRoleById(Integer id);

    void insertRole(Role role);

    void updateRole(Role role);

    void deleteRole(Integer roleId);

    List<Integer> getMenuIdsByRoleId(Integer roleId);

    List<Menu> getMenusByRoleId(Integer roleId);

    List<Menu> getMenusSorted(@Param("sortName") String sortName, @Param("sortOrder") String sortOrder);

    void deleteRoleMenu(Integer roleId);

    void insertRoleMenu(@Param("roleId") Integer roleId, @Param("menuId") Integer menuId);

    void deleteRoleMenu2(@Param("roleId") Integer roleId, @Param("menuId") Integer menuId);

    List<Role> getAllRole();

}
