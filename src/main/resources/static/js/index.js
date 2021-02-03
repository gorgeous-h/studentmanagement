$(function () {
    index = {
        modifyPwd: function () {
            var password = document.forms["modifyPwd"]["password"].value;
            var newPassword = document.forms["modifyPwd"]["newPassword"].value;
            if(!password){
                $('#error').text('请输入原密码').fadeIn().delay(1000).fadeOut();
            }else if(!newPassword){
                $('#error').text('请输入新密码').fadeIn().delay(1000).fadeOut();
            } else {
                $.post(basePath+'/hjj/user/checkPwd', {userId, password: MD5(username+MD5(password))}, function (pass) {
                    if(!pass){
                        $('#error').text('原密码错误！').fadeIn().delay(1000).fadeOut();
                    } else {
                        $.post(basePath+'/hjj/user/modifyPwd', {userId, password: MD5(username+MD5(newPassword))}, function (data) {
                            if(data){
                                myModal.close();
                                $('#error').text('密码修改成功！').fadeIn().delay(1000).fadeOut();
                            }
                        });
                    }
                });
            }

        },
        clearForm: function () {
            document.getElementById("modifyPwd_form").reset();
        }
    };

    var myModal = modal("myModal", "triggerBtn", "closeBtn", index.clearForm);
    myModal.init();

    $.post(basePath+'/hjj/role/getMenusByRoleId', {roleId: role.id}, function (data) {
        if(data&&data.length>0){
            var menus = document.getElementById('menus');
            for(let i = 0; i < data.length; i++){
                var li = document.createElement('li');
                li.textContent = data[i].name;
                li.dataset.url = data[i].url;
                menus.appendChild(li)
            }
        }
    });

    // 事件代理
    $('#mymenu').on('click', function (event) {
        var target = event.target;
        var url = $.trim(target.dataset.url);
        var title = $.trim(target.innerText);
        if(url&&title){
            addTab(title, basePath+url);
        }
    });

});

function addTab(title, url, icon){
    var myTabs = $('#tabs');
    if (myTabs.tabs('exists', title)){
        myTabs.tabs('select', title);
    } else {
        var site = url.lastIndexOf("\/");
        var id=url.substring(site + 1, url.length);
        var content = '<iframe scrolling="auto" id="'+id+'" frameborder="0" src="'+url+'" style="width:100%;height:100%;display:block;"></iframe>';
        myTabs.tabs('add',{
            title:title,
            content:content,
            // iconCls:icon,
            closable:true
        });
    }
}
