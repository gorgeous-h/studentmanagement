package com.yhpt.studentmanagement.controller;

import com.yhpt.studentmanagement.common.tree.TreeNode;
import com.yhpt.studentmanagement.entity.Menu;
import com.yhpt.studentmanagement.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hjj
 * @Date: 2020/11/16 10:31
 * @Description:
 */
@RequestMapping("/hjj")
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/menu/menuManage")
    public String menuManage(){
        return "dictionary/menuManage";
    }

    @ResponseBody
    @RequestMapping("/menu/getMenus")
    public Map<String, Object> getMenus(HttpServletRequest request){
        int pageNO = Integer.parseInt(request.getParameter("page"));// 当前页
        int pageSize = Integer.parseInt(request.getParameter("rows"));// 每页行数
        Map<String, Object> params = new HashMap<>();
        params.put("pageNO", pageNO);
        params.put("pageSize", pageSize);
        params.put("name", request.getParameter("name"));
        params.put("sort", request.getParameter("sort"));
        params.put("order", request.getParameter("order"));
        return menuService.getMenus(params);
    }

    @ResponseBody
    @RequestMapping("/menu/saveMenu")
    public String saveMenu(HttpServletRequest request){
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String url = request.getParameter("url");
        String description = request.getParameter("description");
        String sortNumStr = request.getParameter("sortNum");
        Menu menu = new Menu();
        if(!StringUtils.isEmpty(idStr)){
            menu.setId(NumberUtils.parseNumber(idStr, Integer.class));
        }
        menu.setName(name);
        menu.setUrl(url);
        menu.setDescription(description);
        Integer sortNum = null;
        if(!StringUtils.isEmpty(sortNumStr)){
            sortNum = NumberUtils.parseNumber(sortNumStr, Integer.class);
        }
        menu.setSortNum(sortNum);
        menuService.saveMenu(menu);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/menu/deleteMenu")
    public String deleteMenu(HttpServletRequest request){
        String menuId = request.getParameter("menuId");
        if (!StringUtils.isEmpty(menuId)){
            menuService.deleteMenu(NumberUtils.parseNumber(menuId, Integer.class));
        }
        return "success";
    }

    @RequestMapping("/menu/toMenuRoleForm")
    public String toMenuRoleForm(HttpServletRequest request, Model model){
        model.addAttribute("menuId", request.getParameter("menuId"));
        model.addAttribute("menuName", request.getParameter("menuName"));
        return "dictionary/menuRoleForm";
    }

    @ResponseBody
    @RequestMapping("/menu/getRolesByMenuId")
    public List<TreeNode> getRolesByMenuId(HttpServletRequest request){
        List<TreeNode> treeNodes = null;
        String menuIdStr = request.getParameter("menuId");
        if(!StringUtils.isEmpty(menuIdStr)){
            treeNodes = menuService.getRolesByMenuId(NumberUtils.parseNumber(menuIdStr, Integer.class));
        }
        return treeNodes;
    }

    @ResponseBody
    @RequestMapping("/menu/saveMenuRole")
    public String saveMenuRole(@RequestParam(value = "roleIds[]") List<Integer> roleIds, HttpServletRequest request){
        String menuIdStr = request.getParameter("menuId");
        Integer menuId = null;
        if(!StringUtils.isEmpty(menuIdStr)){
            menuId = NumberUtils.parseNumber(menuIdStr, Integer.class);
        }
        if(menuId!=null){
            List<Integer> oldRoleIds = menuService.getRolesByMenuId2(menuId); // 原来的值
            List<Integer> intersectionRoleIds = new ArrayList<>(oldRoleIds);
            // 需要添加的值
            List<Integer> addMenuRole = new ArrayList<>(roleIds);
            // 需要删除的值
            List<Integer> deleteMenuRole = new ArrayList<>();
            if(oldRoleIds.size()>0){
                deleteMenuRole = new ArrayList<>(oldRoleIds);
                intersectionRoleIds.retainAll(roleIds); // 交集
                addMenuRole.removeAll(intersectionRoleIds);
                deleteMenuRole.removeAll(intersectionRoleIds);
            }

//            System.out.println("原来的值："+oldRoleIds);
//            System.out.println("提交的值："+roleIds);
//            System.out.println("相同的值"+intersectionRoleIds);
//            System.out.println("需要添加的值："+addMenuRole);
//            System.out.println("需要删除的值："+deleteMenuRole);

            menuService.insertMenuRole(menuId, addMenuRole);
            menuService.deleteMenuRole(menuId, deleteMenuRole);
            return "success";
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/menu/deleteMenuRole")
    public String deleteMenuRole(HttpServletRequest request){
        String menuIdStr = request.getParameter("menuId");
        if(!StringUtils.isEmpty(menuIdStr)){
            menuService.deleteMenuRole(NumberUtils.parseNumber(menuIdStr, Integer.class));
        }
        return "success";
    }

}
