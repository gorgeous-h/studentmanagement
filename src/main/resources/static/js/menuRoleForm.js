$(function () {
    $('#roles').tree({
        url: basePath+'/hjj/menu/getRolesByMenuId?menuId='+menuId,
        checkbox: true,
    });
});

function saveMenuRole() {
    var nodes = $('#roles').tree('getChecked', ['checked','indeterminate']);
    if(nodes.length>0){
        // 从对象数组中提取属性值为数组：https://cloud.tencent.com/developer/ask/36701
        var checkedNodes = nodes.map(node => node.id); // 角色ID
        $.post(basePath+'/hjj/menu/saveMenuRole', {menuId, roleIds: checkedNodes}, function (data) {
            if(data==="success"){
                $.messager.alert('提示信息','保存成功！','info');
            }
        });
    } else {
        $.post(basePath+'/hjj/menu/deleteMenuRole', {menuId}, function (data) {
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
