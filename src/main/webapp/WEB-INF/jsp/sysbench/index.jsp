<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2019/5/3
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="/sysbench/index">Lego Store</a></div>
    <div class="open-nav"><i class="iconfont">&#xe699;</i></div>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">${sessionScope.admin.displayName}</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a href="/sysbench/user/loginPage">切换帐号</a></dd>
                <dd><a href="/sysbench/user/destroy">退出</a></dd>
            </dl>
        </li>
    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<div class="wrapper">
    <!-- 左侧菜单开始 -->
    <div class="left-nav">
        <div id="side-nav">
            <ul id="nav">
                <li class="list" current>
                    <a href="/sysbench/index">
                        <i class="iconfont">&#xe761;</i>
                        欢迎页面
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                </li>
                <li class="list">
                    <a href="javascript:;">
                        <i class="iconfont">&#xe70b;</i>
                        商品管理
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="/sysbench/product/queryProductList?pageNum=1&pageSize=10">
                                <i class="iconfont">&#xe6a7;</i>
                                商品列表
                            </a>
                        </li>
                        <li>
                            <a href="/sysbench/repertory/queryList?pageNum=1&pageSize=10">
                                <i class="iconfont">&#xe6a7;</i>
                                库存管理
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="list">
                    <a href="javascript:;">
                        <i class="iconfont">&#xe70b;</i>
                        用户管理
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="/sysbench/user/queryUserList?pageNum=1&pageSize=10">
                                <i class="iconfont">&#xe6a7;</i>
                                用户列表
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="list">
                    <a href="javascript:;">
                        <i class="iconfont">&#xe70b;</i>
                        订单管理
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="/sysbench/order/queryOrderList?pageNum=1&pageSize=10">
                                <i class="iconfont">&#xe6a7;</i>
                                订单列表
                            </a>
                        </li>
                    </ul>
                </li>

                <%--<li class="list" >
                    <a href="javascript:;">
                        <i class="iconfont">&#xe6a3;</i>
                        系统统计
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu" style="display:none">
                        <li>
                            <a href="./echarts1.html">
                                <i class="iconfont">&#xe6a7;</i>
                                拆线图
                            </a>
                        </li>
                        <li>
                            <a href="./echarts2.html">
                                <i class="iconfont">&#xe6a7;</i>
                                柱状图
                            </a>
                        </li>
                        <li>
                            <a href="./echarts3.html">
                                <i class="iconfont">&#xe6a7;</i>
                                地图
                            </a>
                        </li>
                        <li>
                            <a href="./echarts4.html">
                                <i class="iconfont">&#xe6a7;</i>
                                饼图
                            </a>
                        </li>
                        <li>
                            <a href="./echarts5.html">
                                <i class="iconfont">&#xe6a7;</i>
                                k线图
                            </a>
                        </li>
                        <li>
                            <a href="./echarts6.html">
                                <i class="iconfont">&#xe6a7;</i>
                                仪表图
                            </a>
                        </li>
                        <li>
                            <a href="http://echarts.baidu.com/examples.html">
                                <i class="iconfont">&#xe6a7;</i>
                                更多案例
                            </a>
                        </li>
                    </ul>
                </li>--%>
            </ul>
        </div>
    </div>
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="content">
            <!-- 右侧内容框架，更改从这里开始 -->
            <blockquote class="layui-elem-quote">
                <strong>Welcome to Lego Store !</strong>
            </blockquote>
        </div>
    </div>
    <!-- 右侧主体结束 -->
</div>
<!-- 中部结束 -->

<!-- 底部结束 -->
<!-- 背景切换开始 -->
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
<!-- 背景切换结束 -->
</body>
</html>
