/**
 * Created by Eric on 2019/4/23.
 */
$(document).ready(function() {

    //注册数据交互
    //初始化submitRegister单击事件
    $('#submit-register').click(function () {
        //验证码判断verificationCode
        // $.session.set('verificationCode',1234);
        var code;
        var key = "verificationCode";
        $.get("/common/session/get?key="+key,function(data,status){
            if (data.success == true){
                code = data.data;
                console.log(code);
                register(code);
            }
        });
        // var code = $.session.get('verificationCode');
        // console.log($.session.get('verificationCode'));
        

    });
    //发送短信
    $('#button-getVerCode').click(function(){
        console.log($('#input-telephone').val());
        var countdown=60;
        sendMessage();
        function sendMessage(){
            var obj = $("#button-getVerCode");
            if($('#input-telephone').val() == null || $('#input-telephone').val() == ''){
                //获得焦点
                $("#input-telephone")[0].focus();
            }else {
                $.post("/home/user/verificationCode",
                    {
                        phoneNumber:$('#input-telephone').val()
                    },
                    function(data,status){
                    console.log(data.success)
                        if (data.success == true){
                            $("#notify_message").html("短信已发送，请注意查收");
                        }else{
                            $("#notify_message").html("短信发送失败");
                        }
                    });
                settime(obj);
            }

        }
        function settime(obj) { //发送验证码倒计时
            if (countdown == 0) {
                obj.attr('disabled',false);
                //obj.removeattr("disabled");
                obj.val("免费获取验证码");
                countdown = 60;
                return;
            } else {
                obj.attr('disabled',true);
                obj.val("重新发送(" + countdown + ")");
                countdown--;
            }
            setTimeout(function() {
                    settime(obj) }
                ,1000)
        }
    });

});

function register(code) {
    if (code == null || code != $('#input-verCode').val()){
        //报错，验证码有误
        $("#notify_message").html("验证码有误");
    }else{
        $.post("/home/user/register",
            {
                realName:$('#input-realName').val(),
                sex:$('#input-sex').val(),
                age:$('#input-age').val(),
                telephone:$('#input-telephone').val(),
                address:$('#input-address').val(),
                displayName:$('#input-displayName').val(),
                username:$('#input-username').val(),
                password:$('#input-password').val()
            },
            function(data,status){
                console.log(data.success)
                if (data.success == true){
                    window.location.href="/home/user/loginPage";
                    console.log("注册成功!");
                }else{
                    console.log("注册失败!");
                }
            });
    }
}


