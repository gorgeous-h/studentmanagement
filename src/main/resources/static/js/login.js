$(function () {


});

function login() {
    var username = $.trim(document.forms["loginForm"]["username"].value);
    var password = $.trim(document.forms["loginForm"]["password"].value);
    if(!username){
        $('#error').text('请输入用户名').fadeIn().delay(1000).fadeOut();
    }else if(!password){
        $('#error').text('请输入密码').fadeIn().delay(1000).fadeOut();
    } else {
        $.post(basePath+'/loginValidate', {username: username, password: MD5(username+MD5(password))}, function (result) {
            if(result==="success"){
                location.href = basePath+'/hjj/index';
            } else {
                $('#error').text(result).fadeIn().delay(1000).fadeOut();
            }
        });
    }
    return false;
}
