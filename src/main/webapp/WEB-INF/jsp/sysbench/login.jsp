<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2019/5/3
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台登录-X-admin1.1</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/sysbench/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sysbench/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sysbench/css/xadmin.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/Swiper/3.4.2/css/swiper.min.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/Swiper/3.4.2/js/swiper.jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/sysbench/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/sysbench/js/xadmin.js"></script>

</head>
<body>
<div class="login-logo"><h1>Lego Store</h1></div>
<div class="login-box">
    <form class="layui-form layui-form-pane" action="">

        <h3>登录你的帐号</h3>
        <label class="login-title">帐号</label>
        <div class="layui-form-item">
            <label class="layui-form-label login-form"><i class="iconfont">&#xe6b8;</i></label>
            <div class="layui-input-inline login-inline">
                <input type="text" name="username" lay-verify="required" placeholder="请输入你的帐号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <label class="login-title">密码</label>
        <div class="layui-form-item">
            <label class="layui-form-label login-form"><i class="iconfont">&#xe82b;</i></label>
            <div class="layui-input-inline login-inline">
                <input type="text" name="password" lay-verify="required" placeholder="请输入你的密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="form-actions">
            <button class="btn btn-warning pull-right" lay-submit lay-filter="login"  type="submit">登录</button>
        </div>
    </form>
</div>
<div class="bg-changer">
    <div class="swiper-container changer-list">
        <div class="swiper-wrapper">
            <div class="swiper-slide"><img class="item" src="${pageContext.request.contextPath}/sysbench/images/a.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${pageContext.request.contextPath}/sysbench/images/b.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${pageContext.request.contextPath}/sysbench/images/c.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${pageContext.request.contextPath}/sysbench/images/d.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${pageContext.request.contextPath}/sysbench/images/e.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${pageContext.request.contextPath}/sysbench/images/f.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${pageContext.request.contextPath}/sysbench/images/g.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${pageContext.request.contextPath}/sysbench/images/h.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${pageContext.request.contextPath}/sysbench/images/i.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${pageContext.request.contextPath}/sysbench/images/j.jpg" alt=""></div>
            <div class="swiper-slide"><img class="item" src="${pageContext.request.contextPath}/sysbench/images/k.jpg" alt=""></div>
            <div class="swiper-slide"><span class="reset">初始化</span></div>
        </div>
    </div>
    <div class="bg-out"></div>
    <div id="changer-set"><i class="iconfont">&#xe696;</i></div>
</div>
<script>
    $(function  () {
        layui.use('form', function(){
            var form = layui.form();
            //监听提交
            form.on('submit(login)', function(data){
                $.post("/sysbench/user/login",data.field, function (result) {
                    if(result.success == true){
                        location.href="/sysbench/index";
                    }else{
                        layer.msg(result.errorMsg);
                    }
                });
                return false;
            });
        });
    })

</script>
</body>
</html>