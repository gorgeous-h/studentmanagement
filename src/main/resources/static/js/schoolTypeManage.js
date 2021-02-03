$(function () {
    $('#schoolTypes').edatagrid({
        url: basePath+'/hjj/schoolType/getSchoolTypes',
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
                title:'学校类型',
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
            $.post(basePath+'/hjj/schoolType/saveSchoolType', row, function(data){
                if(data==="success"){
                    $.messager.alert('提示信息','保存成功！','info');
                    $('#schoolTypes').edatagrid('reload');
                } else {
                    $.messager.alert('提示信息','保存失败！','info');
                }
            });
        },
        onDestroy: function (index, row) {
            $.post(basePath+'/hjj/schoolType/deleteSchoolType',{schoolTypeId:row.id},function(data){
                if(data==="success"){
                    $.messager.alert('提示信息','删除成功！','info');
                } else {
                    $.messager.alert('提示信息','删除失败！','info');
                }
            });
        }
    });

});

function searchh(){
    $('#schoolTypes').edatagrid('load',{
        name:$.trim($('#name').val()),
    });
}

function addSchoolType(){
    $('#schoolTypes').edatagrid('addRow');
}
