$(function () {
    provinces = JSON.parse(provinces);

    region = {
        search: function(){
            $('#regions').datagrid('load',{
                name: $('#name_s').textbox('getValue'),
            });
        },
        add: function(){
            region.redo();
            $('#province').combobox('setValue', 19);
            $('#region_dialog').panel('setTitle','添加地区').dialog('center').dialog('open');
        },
        edit: function(){
            region.redo();
            var regions = $('#regions').datagrid('getSelected');
            if(regions){
                $('#region_dialog').panel('setTitle','修改地区').dialog('center').dialog('open');
                $('#region_form').form('load', basePath+'/hjj/region/getRegionVOById?regionId='+regions.id);
            } else {
                $.messager.alert('提示信息','请选中一条记录！','info');
            }
        },
        save: function(){
            $('#region_form').form('submit',{
                url: basePath+'/hjj/region/saveRegion',
                onSubmit:function(param){
                    return $(this).form('enableValidation').form('validate');
                },
                success:function(data){
                    if(data==='success'){
                        $.messager.alert('提示信息','保存成功！','info');
                        region.redo();
                        $('#regions').datagrid('reload');
                    } else {
                        $.messager.alert('提示信息','保存失败！','info');
                    }
                }
            });
        },
        remove: function(){
            var regions = $('#regions').datagrid('getSelected');
            if(regions){
                $.messager.confirm('确认操作', "确定要删除选中的记录？", function (flag) {
                    if(flag){
                        $.post(basePath+'/hjj/region/deleteRegion',{regionId:regions.id},function (data) {
                            if(data==="success"){
                                $.messager.alert('提示信息', '删除成功！','info');
                                $('#regions').datagrid('reload');
                            } else {
                                $.messager.alert('提示信息','删除失败！','info');
                            }
                        });
                    }
                });
            } else {
                $.messager.alert('警告操作！', '请选中一条记录！', 'info');
            }
        },
        redo: function(){
            $('#region_dialog').dialog('close');
            $('#region_form').form('clear');
        },
    };

    $('#province').combobox({
        valueField:'id',
        textField:'name',
        data:provinces,
        limitToList:true,
        onChange:function(newValue, oldValue){
            $('#city').combobox({
                url:basePath+"/hjj/city/getCitiesByProvinceId",
                queryParams: {
                    "provinceId" : newValue
                },
                valueField:'id',
                textField:'name',
                limitToList:true,
            });
        }
    });

    $('#regions').datagrid({
        url:basePath+"/hjj/region/getRegions",
        fit:true,
        striped:true,
        rownumbers:true,
        border:false,
        pagination:true,
        singleSelect:true,
        pageNumber:1,
        pageSize:10,
        pageList:[10,20,30],
        toolbar : '#toolbar',
        columns:[[
            {
                field: 'id',
                title: 'id',
                width: 100,
                hidden: true
            },
            {
                field: 'provinceName',
                title: '省份',
                width: 100,
                formatter:function(value){
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            },
            {
                field: 'cityName',
                title: '城市',
                width: 100,
                formatter:function(value){
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            },
            {
                field: 'name',
                title: '地区',
                width: 100,
                formatter:function(value){
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            },
            {
                field:'createTime',
                title:'创建时间',
                width:150,
                align:'center',
                formatter:function(value){
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            }
        ]]
    });

});

function batchImport() {
    $('#uploadRegionExcelFile').filebox('clear');
    $('#region2_dialog').panel('setTitle','批量导入').dialog('center').dialog('open');
}

function uploadRegionExcelFile() {
    var regionExcelFile = $('#uploadRegionExcelFile').filebox('getValue');
    if(!regionExcelFile){
        $.messager.alert('提示信息','请选择文件！','info');
    } else {
        $('#confirm').linkbutton('disable');
        $.messager.progress({
            text:"正在处理...",
            interval:300
        });
        $('#region2_form').form('submit',{
            url:basePath+"/hjj/region/saveRegionsByExcel",
            success:function(data){
                $('#confirm').linkbutton('enable');
                $.messager.progress('close');
                if(data==="success"){
                    $.messager.alert('提示信息','操作成功！','info');
                    $('#region2_dialog').dialog('close');
                    $('#regions').datagrid('reload');
                } else {
                    $.messager.alert('提示信息','操作失败！','info');
                }
            }
        });
    }
}
