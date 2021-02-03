$(function () {
    $('#menus').tree({
        url: basePath+'/hjj/role/getMenusTreeByRoleId?roleId='+roleId,
        checkbox: true,
    });
});

function saveRoleMenu() {
    var nodes = $('#menus').tree('getChecked', ['checked','indeterminate']);
    if(nodes.length>0){
        var checkedNodes = nodes.map(node => node.id); // 角色ID
        $.post(basePath+'/hjj/role/saveRoleMenu', {roleId, menuIds: checkedNodes}, function (data) {
            if(data==="success"){
                $.messager.alert('提示信息','保存成功！','info');
            }
        });
    } else {
        $.post(basePath+'/hjj/role/deleteRoleMenu', {roleId}, function (data) {
            if(data==="success"){
                $.messager.alert('提示信息','保存成功！','info');
            }
        });
    }
}

function treeChecked(selected, treeMenu) {
    var tree = $('#'+treeMenu);
    var roots = tree.tree('getRoots'); // 返回tree的所有根节点数组
    var check = selected.checked?"check":"uncheck";
    for (let i = 0; i < roots.length; i++) {
        var node = tree.tree('find', roots[i].id);
        tree.tree(check, node.target);
    }
}