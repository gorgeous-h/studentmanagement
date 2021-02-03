$(function () {
    student = {
        search: function(){
            $('#students').datagrid('load',{
                name: $('#name').textbox('getValue'),
            });
        },
        add: function(){
            var url=basePath+'/hjj/student/toStudentForm';
            var title='学生表单';
            addTab(title, url);
        },
        edit: function () {
            var students = $('#students').datagrid('getSelected');
            if(students){
                var url=basePath+'/hjj/student/toStudentForm?studentId='+students.id;
                var title='学生表单';
                addTab(title, url);
            } else {
                $.messager.alert('提示信息','请选中一条记录！','info');
            }
        },
        remove: function(){
            var students = $('#students').datagrid('getSelected');
            if(students){
                $.messager.confirm('确认操作', "确定要删除选中的记录？", function (flag) {
                    if(flag){
                        $.post(basePath+'/hjj/student/deleteStudent',{studentId:students.id},function (data) {
                            if(data==="success"){
                                $.messager.alert('提示信息', '删除成功！','info');
                                $('#students').datagrid('reload');
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
    };

    $('#students').datagrid({
        url:basePath+"/hjj/student/getStudents",
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
                field: 'schoolRegionName',
                title: '省市区(学校)',
                width: 180,
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
                field: 'schoolName',
                title: '学校',
                width: 180,
                formatter:function(value){
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            },
            {
                field: 'name',
                title: '学生',
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
