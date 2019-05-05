/**
 * Created by Eric on 2019/4/23.
 */
$(document).ready(function() {
    //初始化弹框
    toastr.options= {
        "closeButton":false,//显示关闭按钮
        "debug":false,//启用debug
        "positionClass":"toast-top-center",//弹出的位置
        "showDuration":"300",//显示的时间
        "hideDuration":"1000",//消失的时间
        "timeOut":"5000",//停留的时间
        "extendedTimeOut":"1000",//控制时间
        "showEasing":"swing",//显示时的动画缓冲方式
        "hideEasing":"linear",//消失时的动画缓冲方式
        "showMethod":"fadeIn",//显示时的动画方式
        "hideMethod":"fadeOut"//消失时的动画方式
    };
    //加入购物车
    $('#add-cart').click(function(){
        //判断是否登录
        var key = "user";
        $.get("/common/session/get?key="+key,function(data,status){
            if (data.success == true){
                if (data.data == null){
                    window.location.href="/home/user/loginPage";
                }else{
                    $.post("/home/cart/add",
                        {
                            productId:$('#input-id').val(),
                            number:$('#input-quantity').val(),
                            size:$("input[name='size']:checked").val()
                        },
                        function(data,status){
                            toastr.success("成功加入购物车");
                        });
                }
            }
        });

    });

});


