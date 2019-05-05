/**
 * Created by Eric on 2019/4/23.
 */
$(document).ready(function() {
    //地址
    //已存在
    $.get("/home/address/queryList",
        {
        },
        function(data,status){
            var itemList = "";
            for(var i=0; i < data.data.length; i++){
                var item;
                if(i==0){
                    item ="<option selected='selected' value='"+data.data[i].id+"'>"+data.data[i].fullName+","+data.data[i].fullAddress+","+data.data[i].addressDetail+"</option>";
                }else {
                    item = "<option  value='" + data.data[i].id + "'>" + data.data[i].fullName + "," + data.data[i].fullAddress + "," + data.data[i].addressDetail + "</option>";
                }
                itemList += item;
            }
            $('#address-select').html(itemList);
        });
    //新增
    $('#button-shipping-address').click(function(){
        $.post("/home/address/add",
            {
                fullName:$('#input-shipping-name').val(),
                tel:$('#input-shipping-phone-number').val(),
                fullAddress:$('#input-shipping-full-address').val(),
                addressDetail:$('#input-shipping-address-detailed').val()
            },
            function(data,status){
                //重新加载
                window.location.reload();
            });
    });
//初始化弹框
    toastr.options= {
        "closeButton":false,//显示关闭按钮
        "debug":false,//启用debug
        "positionClass":"toast-top-center",//弹出的位置
        "showDuration":"300",//显示的时间
        "hideDuration":"1000",//消失的时间
        "timeOut":"5000",//停留的时间
        "extendedTimeOut":"2000",//控制时间
        "showEasing":"swing",//显示时的动画缓冲方式
        "hideEasing":"linear",//消失时的动画缓冲方式
        "showMethod":"fadeIn",//显示时的动画方式
        "hideMethod":"fadeOut"//消失时的动画方式
    };
    //订单
    $('#button-create').click(function(){
        $.post("/home/order/create",
            {
                addressId:$('#address-select').val()
            },
            function(data,status){
                //重新加载
                toastr.success("订单已生成,跳转中。。。");
                function jump(count) {
                    window.setTimeout(function(){
                        count--;
                        if(count > 0) {
                            jump(count);
                        } else {
                            window.location.href="/home/index";
                        }
                    }, 1000);
                }
                jump(2);
            });
    });
});


