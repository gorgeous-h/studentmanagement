$(function () {
    role = {
        roleMenu: function () {
            var row = $("#roles").datagrid('getSelected');
            if(row){
                var url=basePath+'/hjj/role/toRoleMenuForm?roleId='+row.id+'&roleName='+row.name;
                var title='角色菜单';
                addTab(title, url);
            } else {
                $.messager.alert('提示操作！', '请选择一条记录！', 'info');
            }
        }
    };
    
    $('#roles').edatagrid({
        url: basePath+'/hjj/role/getRoles',
        idField:"id",
        fit:true,
        border:false,
        striped:true,
        rownumbers:true,
        pagination:true,
        singleSelect:true,
        pageSize:20,
        pageList:[10,20,30],
        pageNumber:1,
        toolbar:'#toolbar',
        columns:[[
            {
                field:'name',
                title:'角色',
                width:100,
                editor:{type:'validatebox',options:{required:true}},
                formatter:function(value){
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            },
            {
                field:'createTime',
                title:'创建时间',
                width:150,
                align:'center',
            }
        ]],
        onSave: function(index, row){
            $.post(basePath+'/hjj/role/saveRole', row, function(data){
                if(data==="success"){
                    $.messager.alert('提示信息','保存成功！','info');
                    $('#roles').edatagrid('reload');
                } else {
                    $.messager.alert('提示信息','保存失败！','info');
                }
            });
        },
        onDestroy: function (index, row) {
            $.post(basePath+'/hjj/role/deleteRole',{roleId:row.id},function(data){
                if(data==="success"){
                    $.messager.alert('提示信息','删除成功！','info');
                } else {
                    $.messager.alert('提示信息','删除失败！','info');
                }
            });
        }
    });

    function addTab(title, url){
        var jq = top.jQuery;
        if (jq("#tabs").tabs('exists', title)){
            $.messager.alert('提示信息', '请先关闭之前的标签页再打开!','info');
        } else {
            var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="display:block;width:100%;height:100%;"></iframe>';
            jq("#tabs").tabs('add',{ title:title, content:content, closable:true });
        }
    }

});

function searchh(){
    $('#roles').edatagrid('load',{
        name:$.trim($('#name').val()),
    });
}

function addRole(){
    $('#roles').edatagrid('addRow');
}
