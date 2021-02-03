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
public interface MenuMapper {

    List<Menu> getMenus(Map<String, Object> params);

    int getMenusCount(Map<String, Object> params);

    Menu getMenuById(Integer id);

    void insertMenu(Menu menu);

    void updateMenu(Menu menu);

    void deleteMenu(Integer menuId);

    List<Integer> getRolesByMenuId(Integer menuId);

    List<Role> getRolesSorted(@Param("sortName") String sortName, @Param("sortOrder") String sortOrder);

    void deleteMenuRole(Integer menuId);

    void deleteMenuRole2(@Param("menuId") Integer menuId, @Param("roleId") Integer roleId);

    void insertMenuRole(@Param("menuId") Integer menuId, @Param("roleId") Integer roleId);

}
