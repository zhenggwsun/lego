/**
 * Created by Eric on 2019/4/23.
 */
$(document).ready(function() {
    //item数量变更
    $('#update-cart').click(function(){
        $.post("/home/cart/update",
            {
                productId:$('#input-id').val(),
                number:$('#input-num').val(),
                size:$('#input-size').val()
            },
            function(data,status){
                window.location.reload();
            });
    });
    //删除item
    $('#update-cart').click(function(){
        $.post("/home/cart/delete",
            {
                productId:$('#input-username').val(),
                size:$('#input-password').val()
            },
            function(data,status){
                if (data.success == true){
                    $("#notify_message").html("登录成功");
                    window.location.href="/home/index";
                }else{
                    $("#notify_message").html("用户名或密码有误");
                }
            });
    });
});


