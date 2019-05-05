/**
 * Created by Eric on 2019/4/23.
 */
$(document).ready(function() {
    //登录
    $('#submit-login').click(function(){
        $.post("/home/user/login",
            {
                username:$('#input-username').val(),
                password:$('#input-password').val()
            },
            function(data,status){
                if (data.success == true){
                    $("#notify_message").html("登录成功");
                    window.location.href="/home/index";
                }else{
                    $("#notify_message").html("用户名或密码有误");
                }
            });
        settime(obj);
    });
});


