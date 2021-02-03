$(function () {

    school = {
        search: function(){
            $('#schools').datagrid('load',{
                name: $('#name_s').textbox('getValue'),
            });
        },
        add: function(){
            var url=basePath+'/hjj/school/toSchoolForm';
            var title='学校表单';
            addTab(title, url);
        },
        edit: function(){
            var schools = $('#schools').datagrid('getSelected');
            if(schools){
                var url=basePath+'/hjj/school/toSchoolForm?schoolId='+schools.id;
                var title='学校表单';
                addTab(title, url);
            } else {
                $.messager.alert('提示信息','请选中一条记录！','info');
            }
        },
        remove: function(){
            var schools = $('#schools').datagrid('getSelected');
            if(schools){
                $.messager.confirm('确认操作', "确定要删除选中的记录？", function (flag) {
                    if(flag){
                        $.post(basePath+'/hjj/school/deleteSchool',{schoolId:schools.id},function (data) {
                            if(data==="success"){
                                $.messager.alert('提示信息', '删除成功！','info');
                                $('#schools').datagrid('reload');
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
            $('#user_dialog').dialog('close');
            $('#user_form').form('clear');
        },
    };

    $('#schools').datagrid({
        url:basePath+"/hjj/school/getSchools",
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
                field: 'regionName',
                title: '地区',
                width: 100,
                formatter:function(value){
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            },
            {
                field: 'schoolTypeName',
                title: '学校类型',
                width: 100,
                formatter:function(value){
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            },
            {
                field: 'name',
                title: '学校',
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