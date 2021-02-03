$(function () {
    // if(userId===1&&username==="admin"){
    if(role&&role.id===1){
        $('#remove').linkbutton('enable');
        $('#modifyRole').linkbutton('enable');
    }

    user = {
        search: function(){
            $('#users').datagrid('load',{
                nickname: $('#nickname_s').textbox('getValue'),
            });
        },
        add: function(){
            user.redo();
            $('#username').textbox({readonly:false});
            $('#password').parent().show();
            $('#user_dialog').panel('setTitle','添加用户').dialog('center').dialog('open');
        },
        edit: function(){
            user.redo();
            var users = $('#users').datagrid('getSelected');
            if(users){
                $('#username').textbox({readonly:true});
                $('#password').parent().hide();
                $('#user_dialog').panel('setTitle','修改用户').dialog('center').dialog('open');
                $('#user_form').form('load', basePath+'/hjj/user/getUserById?userId='+users.id);
            } else {
                $.messager.alert('提示信息','请选中一条记录！','info');
            }
        },
        save: async function(){
            var id = $('#id').val();
            var userExist = false;
            var username = $('#username').textbox('getValue');
            if(!id){
                userExist = await $.post(basePath+'/hjj/user/getUserByUsername',{username});
            }
            if(userExist){
                $.messager.alert('提示信息', '用户名已被占用！','info');
            } else {
                $('#user_form').form('submit',{
                    url: basePath+'/hjj/user/saveUser',
                    onSubmit:function(param){
                        var pwd = MD5($('input[name="username"]').val()+MD5($('#password').val()));
                        $('input[name="password"]').val(pwd);
                        return $(this).form('enableValidation').form('validate');
                    },
                    success:function(data){
                        if(data==='success'){
                            $.messager.alert('提示信息','保存成功！','info');
                            user.redo();
                            $('#users').datagrid('reload');
                        } else {
                            $.messager.alert('提示信息','保存失败！','info');
                        }
                    }
                });
            }
        },
        remove: function(){
            var users = $('#users').datagrid('getSelected');
            if(users){
                $.messager.confirm('确认操作', "确定要删除选中的记录？", function (flag) {
                    if(flag){
                        $.post(basePath+'/hjj/user/deleteUser',{userId:users.id},function (data) {
                            if(data==="success"){
                                $.messager.alert('提示信息', '删除成功！','info');
                                $('#users').datagrid('reload');
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

    $('#role').combobox({
        valueField:'id',
        textField:'name',
        data:JSON.parse(roles),
        // panelHeight:'auto',
        limitToList:true
    });

    $('#users').datagrid({
        url:basePath+"/hjj/user/getUsers",
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
                field: 'nickname',
                title: '昵称',
                width: 100,
                align: 'center',
                formatter:function (value) {
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            },
            {
                field: 'username',
                title: '用户名',
                width: 100,
                align: 'center',
                formatter:function (value) {
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            },
            {
                field: 'email',
                title: '邮箱',
                width: 100,
                formatter:function (value) {
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            },
            {
                field: 'roleName',
                title: '角色',
                width: 100,
                formatter:function (value) {
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            },
            {
                field: 'createTime',
                title: '创建时间',
                width: 150,
                align: 'center',
                formatter:function (value) {
                    return value?`<span title="${value}">${value}</span>`:'';
                }
            },
        ]]
    });

});
