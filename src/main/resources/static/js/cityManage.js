$(function () {
    provinces = JSON.parse(provinces);

    $('#cities').edatagrid({
        url: basePath+'/hjj/city/getCities',
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
                field:'provinceId',
                title:'省份',
                width:100,
                editor:{
                    type:'combobox',
                    options:{
                        valueField:'id',
                        textField:'name',
                        data:provinces,
                        // panelHeight:'auto',
                        required:true
                    }
                },
                formatter:function(value, row){
                    // var province = provinces.filter(p => p.id === value);
                    // if(province&&province.length>0){
                    //     value = province[0].name;
                    // }
                    // return value?`<span title="${value}">${value}</span>`:'';
                    var provinceName = row.provinceName;
                    return provinceName?`<span title="${provinceName}">${provinceName}</span>`:'';
                }
            },
            {
                field:'provinceName',
                title:'省份名称',
                width:100,
                hidden:true,
            },
            {
                field:'name',
                title:'城市',
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
            $.post(basePath+'/hjj/city/saveCity', row, function(data){
                if(data==="success"){
                    $.messager.alert('提示信息','保存成功！','info');
                    $('#cities').edatagrid('reload');
                } else {
                    $.messager.alert('提示信息','保存失败！','info');
                }
            });
        },
        onDestroy: function (index, row) {
            $.post(basePath+'/hjj/city/deleteCity',{cityId:row.id},function(data){
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
    $('#cities').edatagrid('load',{
        name:$.trim($('#name').val()),
    });
}

function addCity(){
    $('#cities').edatagrid('addRow', {
        row: {
            provinceId: 19
        }
    });
}

function batchImport() {
    $('#uploadCityExcelFile').filebox('clear');
    $('#city_dialog').panel('setTitle','批量导入').dialog('center').dialog('open');
}

function uploadCityExcelFile() {
    var cityExcelFile = $('#uploadCityExcelFile').filebox('getValue');
    if(!cityExcelFile){
        $.messager.alert('提示信息','请选择文件！','info');
    } else {
        $('#confirm').linkbutton('disable');
        $.messager.progress({
            text:"正在处理...",
            interval:300
        });
        $('#city_form').form('submit',{
            url:basePath+"/hjj/city/saveCitiesByExcel",
            success:function(data){
                $('#confirm').linkbutton('enable');
                $.messager.progress('close');
                if(data==="success"){
                    $.messager.alert('提示信息','操作成功！','info');
                    $('#city_dialog').dialog('close');
                    $('#cities').edatagrid('reload');
                } else {
                    $.messager.alert('提示信息','操作失败！','info');
                }
            }
        });
    }
}
