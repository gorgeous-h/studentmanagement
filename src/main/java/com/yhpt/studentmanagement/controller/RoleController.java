package com.yhpt.studentmanagement.controller;

import com.yhpt.studentmanagement.common.tree.TreeNode;
import com.yhpt.studentmanagement.entity.Menu;
import com.yhpt.studentmanagement.entity.Role;
import com.yhpt.studentmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/12 14:15
 * @Description:
 */
@RequestMapping("/hjj")
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ModelAttribute
    private void getRoleById(@RequestParam(value="id",required=false) Integer id, Model model){
        if(id!=null){
            Role role = roleService.getRoleById(id);
            if(role!=null){
                model.addAttribute("role", role);
            }
        }
    }

    @RequestMapping("/role/roleManage")
    public String roleManage(){
        return "dictionary/roleManage";
    }

    @ResponseBody
    @RequestMapping("/role/getRoles")
    public Map<String, Object> getRoles(HttpServletRequest request){
        int pageNO = Integer.parseInt(request.getParameter("page"));// 当前页
        int pageSize = Integer.parseInt(request.getParameter("rows"));// 每页行数
        Map<String, Object> params = new HashMap<>();
        params.put("pageNO", pageNO);
        params.put("pageSize", pageSize);
        params.put("name", request.getParameter("name"));
        return roleService.getRoles(params);
    }

    @ResponseBody
    @RequestMapping("/role/saveRole")
    public String saveRole(@ModelAttribute("user") Role role){
        if(role.getId()==null){
            LocalDateTime createTime = role.getCreateTime();
            if(createTime==null){
                role.setCreateTime(LocalDateTime.now());
            }
        }
        roleService.saveRole(role);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/role/deleteRole")
    public String deleteRole(HttpServletRequest request){
        String roleId = request.getParameter("roleId");
        if (!StringUtils.isEmpty(roleId)){
            roleService.deleteRole(NumberUtils.parseNumber(roleId, Integer.class));
        }
        return "success";
    }

    @RequestMapping("/role/toRoleMenuForm")
    public String toRoleMenuForm(HttpServletRequest request, Model model){
        model.addAttribute("roleId", request.getParameter("roleId"));
        model.addAttribute("roleName", request.getParameter("roleName"));
        return "dictionary/roleMenuForm";
    }

    @ResponseBody
    @RequestMapping("/role/getMenusTreeByRoleId")
    public List<TreeNode> getMenusTreeByRoleId(HttpServletRequest request){
        List<TreeNode> treeNodes = null;
        String roleIdStr = request.getParameter("roleId");
        if(!StringUtils.isEmpty(roleIdStr)){
            treeNodes = roleService.getMenusTreeByRoleId(NumberUtils.parseNumber(roleIdStr, Integer.class));
        }
        return treeNodes;
    }

    @ResponseBody
    @RequestMapping("/role/deleteRoleMenu")
    public String deleteRoleMenu(HttpServletRequest request){
        String roleIdStr = request.getParameter("roleId");
        if(!StringUtils.isEmpty(roleIdStr)){
            roleService.deleteRoleMenu(NumberUtils.parseNumber(roleIdStr, Integer.class));
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/role/saveRoleMenu")
    public String saveRoleMenu(@RequestParam(value = "menuIds[]") List<Integer> menuIds, HttpServletRequest request){
        String roleIdStr = request.getParameter("roleId");
        Integer roleId = null;
        if(!StringUtils.isEmpty(roleIdStr)){
            roleId = NumberUtils.parseNumber(roleIdStr, Integer.class);
        }
        if(roleId!=null){
            List<Integer> oldMenuIds = roleService.getMenuIdsByRoleId(roleId); // 原来的值
            List<Integer> intersectionMenuIds = new ArrayList<>(oldMenuIds);
            // 需要添加的值
            List<Integer> addRoleMenu = new ArrayList<>(menuIds);
            // 需要删除的值
            List<Integer> deleteRoleMenu = new ArrayList<>();
            if(oldMenuIds.size()>0){
                deleteRoleMenu = new ArrayList<>(oldMenuIds);
                intersectionMenuIds.retainAll(menuIds); // 交集
                addRoleMenu.removeAll(intersectionMenuIds);
                deleteRoleMenu.removeAll(intersectionMenuIds);
            }

//            System.out.println("原来的值："+oldMenuIds);
//            System.out.println("提交的值："+menuIds);
//            System.out.println("相同的值"+intersectionMenuIds);
//            System.out.println("需要添加的值："+addRoleMenu);
//            System.out.println("需要删除的值："+deleteRoleMenu);

            roleService.insertRoleMenu(roleId, addRoleMenu);
            roleService.deleteRoleMenu(roleId, deleteRoleMenu);
            return "success";
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/role/getMenusByRoleId")
    public List<Menu> getMenusByRoleId(HttpServletRequest request){
        List<Menu> menus = new ArrayList<>();
        String roleIdStr = request.getParameter("roleId");
        if(!StringUtils.isEmpty(roleIdStr)){
            menus = roleService.getMenusByRoleId(NumberUtils.parseNumber(roleIdStr, Integer.class));
        }
        return menus;
    }

}
