package com.yhpt.studentmanagement.service;

import com.yhpt.studentmanagement.common.tree.TreeNode;
import com.yhpt.studentmanagement.entity.Menu;
import com.yhpt.studentmanagement.entity.Role;
import com.yhpt.studentmanagement.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/12 14:16
 * @Description:
 */
@Transactional
@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public Map<String, Object> getRoles(Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();
        map.put("rows", roleMapper.getRoles(params));
        map.put("total", roleMapper.getRolesCount(params));
        return map;
    }

    public Role getRoleById(Integer id) {
        return roleMapper.getRoleById(id);
    }

    public void saveRole(Role role) {
        if(role.getId()==null){
            roleMapper.insertRole(role);
        } else {
            roleMapper.updateRole(role);
        }
    }

    public void deleteRole(Integer roleId) {
        roleMapper.deleteRole(roleId);
    }

    public List<TreeNode> getMenusTreeByRoleId(Integer roleId) {
        List<TreeNode> treeNodes = null;
        List<Integer> menuIds = roleMapper.getMenuIdsByRoleId(roleId);
        List<Menu> menus = roleMapper.getMenusSorted("id", "asc");
        if(menus.size()>0){
            treeNodes = new ArrayList<>();
            TreeNode treeNode = null;
            for(Menu menu : menus){
                treeNode = new TreeNode();
                treeNode.setId(menu.getId());
                treeNode.setText(menu.getName());
                treeNode.setChecked(menuIds.contains(menu.getId()));

                treeNodes.add(treeNode);
            }
        }
        return treeNodes;
    }

    public void deleteRoleMenu(Integer roleId) {
        roleMapper.deleteRoleMenu(roleId);
    }

    public List<Integer> getMenuIdsByRoleId(Integer roleId) {
        return roleMapper.getMenuIdsByRoleId(roleId);
    }

    public List<Menu> getMenusByRoleId(Integer roleId) {
        return roleMapper.getMenusByRoleId(roleId);
    }

    public void insertRoleMenu(Integer roleId, List<Integer> menuIds) {
        for(Integer menuId : menuIds){
            roleMapper.insertRoleMenu(roleId, menuId);
        }
    }

    public void deleteRoleMenu(Integer roleId, List<Integer> menuIds) {
        for(Integer menuId : menuIds){
            roleMapper.deleteRoleMenu2(roleId, menuId);
        }
    }

    public List<Role> getAllRole(){
        return roleMapper.getAllRole();
    }

}
