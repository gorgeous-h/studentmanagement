package com.yhpt.studentmanagement.service;

import com.yhpt.studentmanagement.common.tree.TreeNode;
import com.yhpt.studentmanagement.entity.Menu;
import com.yhpt.studentmanagement.entity.Role;
import com.yhpt.studentmanagement.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/16 10:59
 * @Description:
 */
@Transactional
@Service
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;

    public void saveMenu(Menu menu) {
        if(menu.getId()==null){
            menuMapper.insertMenu(menu);
        } else {
            menuMapper.updateMenu(menu);
        }
    }

    public Map<String, Object> getMenus(Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();
        map.put("rows", menuMapper.getMenus(params));
        map.put("total", menuMapper.getMenusCount(params));
        return map;
    }

    public Menu getMenuById(Integer id) {
        return menuMapper.getMenuById(id);
    }

    public void deleteMenu(Integer menuId) {
        menuMapper.deleteMenu(menuId);
    }

    public List<TreeNode> getRolesByMenuId(Integer menuId) {
        List<TreeNode> treeNodes = null;
        List<Integer> roleIds = menuMapper.getRolesByMenuId(menuId);
        List<Role> roles = menuMapper.getRolesSorted("id", "asc");
        if(roles.size()>0){
            treeNodes = new ArrayList<>();
            TreeNode treeNode = null;
            for(Role role : roles){
                treeNode = new TreeNode();
                treeNode.setId(role.getId());
                treeNode.setText(role.getName());
                treeNode.setChecked(roleIds.contains(role.getId()));

                treeNodes.add(treeNode);
            }
        }
        return treeNodes;
    }

    public List<Integer> getRolesByMenuId2(Integer menuId) {
        return menuMapper.getRolesByMenuId(menuId);
    }

    public void deleteMenuRole(Integer menuId) {
        menuMapper.deleteMenuRole(menuId);
    }

    public void insertMenuRole(Integer menuId, List<Integer> roleIds) {
        for(Integer roleId : roleIds){
            menuMapper.insertMenuRole(menuId, roleId);
        }
    }

    public void deleteMenuRole(Integer menuId, List<Integer> roleIds) {
        for(Integer roleId : roleIds){
            menuMapper.deleteMenuRole2(menuId, roleId);
        }
    }

}
