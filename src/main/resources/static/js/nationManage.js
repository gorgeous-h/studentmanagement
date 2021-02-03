$(function () {
    $('#nations').edatagrid({
        url: basePath+'/hjj/nation/getNations',
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
                title:'民族',
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
            $.post(basePath+'/hjj/nation/saveNation', row, function(data){
                if(data==="success"){
                    $.messager.alert('提示信息','保存成功！','info');
                    $('#nations').edatagrid('reload');
                } else {
                    $.messager.alert('提示信息','保存失败！','info');
                }
            });
        },
        onDestroy: function (index, row) {
            $.post(basePath+'/hjj/nation/deleteNation',{nationId:row.id},function(data){
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
    $('#nations').edatagrid('load',{
        name:$.trim($('#name').val()),
    });
}

function addNation(){
    $('#nations').edatagrid('addRow');
}

function batchImport() {
    $('#uploadNationExcelFile').filebox('clear');
    $('#nation_dialog').panel('setTitle','批量导入').dialog('center').dialog('open');
}

function uploadNationExcelFile() {
    var nationExcelFile = $('#uploadNationExcelFile').filebox('getValue');
    if(!nationExcelFile){
        $.messager.alert('提示信息','请选择文件！','info');
    } else {
        $('#confirm').linkbutton('disable');
        $.messager.progress({
            text:"正在处理...",
            interval:300
        });
        $('#nation_form').form('submit',{
            url:basePath+"/hjj/province/saveProvincesByExcel",
            queryParams: {
                tableName: 'nation'
            },
            success:function(data){
                $('#confirm').linkbutton('enable');
                $.messager.progress('close');
                if(data==="success"){
                    $.messager.alert('提示信息','操作成功！','info');
                    $('#nation_dialog').dialog('close');
                    $('#nations').edatagrid('reload');
                } else {
                    $.messager.alert('提示信息','操作失败！','info');
                }
            }
        });
    }
}
