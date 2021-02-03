$(function () {
    menu = {
        menuRole: function () {
            var row = $("#menus").datagrid('getSelected');
            if(row){
                var url=basePath+'/hjj/menu/toMenuRoleForm?menuId='+row.id+'&menuName='+row.name;
                var title='菜单角色';
                addTab(title, url);
            } else {
                $.messager.alert('提示操作！', '请选择一条记录！', 'info');
            }
        }
    };
    
    $('#menus').edatagrid({
        url: basePath+'/hjj/menu/getMenus',
        idField:"id",
        fit:true,
        border:false,
        striped:true,
        rownumbers:true,
        pagination:true,
        singleSelect:true,
        multiSort:true,
        pageSize:20,
        pageList:[10,20,30],
        pageNumber:1,
        toolbar:'#toolbar',
        columns:[[
            {
                field:'name',
                title:'菜单',
                width:100,
                editor:{type:'validatebox',options:{required:true}},
                formatter:function(value){
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            },
            {
                field:'url',
                title:'URL',
                width:150,
                editor:{type:'validatebox',options:{required:true}},
                formatter:function(value){
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            },
            {
                field:'description',
                title:'描述',
                width:150,
                editor:{type:'textbox'},
                formatter:function(value){
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            },
            {
                field:'sortNum',
                title:'排序',
                width:100,
                align:'center',
                sortable:true,
                editor:{type:'textbox'},
            },
        ]],
        onSave: function(index, row){
            $.post(basePath+'/hjj/menu/saveMenu', row, function(data){
                if(data==="success"){
                    $.messager.alert('提示信息','保存成功！','info');
                    $('#menus').edatagrid('reload');
                } else {
                    $.messager.alert('提示信息','保存失败！','info');
                }
            });
        },
        onDestroy: function (index, row) {
            $.post(basePath+'/hjj/menu/deleteMenu',{menuId:row.id},function(data){
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
    $('#menus').edatagrid('load',{
        name:$.trim($('#name').val()),
    });
}

function addMenu(){
    $('#menus').edatagrid('addRow');
}
