<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2019/4/22
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>M&K Fashion</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="e-commerce site well design with responsive view." />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="${pageContext.request.contextPath}/home/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" /><link href="${pageContext.request.contextPath}/home/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,100,200,500,900,800,700,600' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/home/css/stylesheet.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/home/css/responsive.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/home/owl-carousel/owl.carousel.css" type="text/css" rel="stylesheet" media="screen" />
    <link href="${pageContext.request.contextPath}/home/owl-carousel/owl.transitions.css" type="text/css" rel="stylesheet" media="screen" />
    <script src="${pageContext.request.contextPath}/home/javascript/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/jquerysession.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/home/javascript/template.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/home/javascript/jstree.min.js"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/common.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/global.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/owl-carousel/owl.carousel.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/myfunction.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/register.js" type="text/javascript"></script>
</head>
<body class="account-register col-2">
<div class="preloader loader" style="display: block;"> <img src="${pageContext.request.contextPath}/home/image/loader.gif"  alt="#"/></div>
<header>
    <div class="header-top">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div class="top-right pull-right">
                        <div id="top-links" class="nav pull-right">
                            <ul class="list-inline">
                                <li class="dropdown"><a href="#" title="我的账户" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <span>我的账户</span> <span class="caret"></span></a>
                                    <ul class="dropdown-menu dropdown-menu-right">
                                        <c:if test="${sessionScope.user == null}">
                                            <li><a href="/home/user/registerPage">注册</a></li>
                                            <li><a href="/home/user/loginPage">登录</a></li>
                                        </c:if>
                                        <c:if test="${sessionScope.user != null}">
                                            <li>${sessionScope.user.displayName}</li>
                                            <li><a href="/home/user/destroy">退出</a></li>
                                        </c:if>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="header-inner">
            <div class="col-sm-4 col-xs-6 header-left">
                <div class="shipping">
                    <div class="shipping-img"></div>
                    <div class="shipping-text">+91(000)1234-1234<span class="shipping-detail">Week From 9:00am To 7:00pm</span></div>
                </div>
            </div>
            <div class="col-sm-4 col-xs-6 header-middle">
                <div class="header-middle-top">
                    <div id="logo"> <a href="/home/index"><img src="${pageContext.request.contextPath}/home/image/LegoStore.jpg" title="E-Commerce" alt="E-Commerce" class="img-responsive" /></a> </div>
                </div>
            </div>
            <div class="col-sm-4 col-xs-6 header-right">
                <div id="cart" class="btn-group btn-block">
                    <button type="button" class="btn btn-inverse btn-block btn-lg dropdown-toggle cart-dropdown-button"><span id="cart-total"><a href="/home/cart/showShoppingCart">我的购物车</a></span></button>
                </div>
                <div id="search" class="input-group">
                    <input type="text" name="search" value="" placeholder="Search" class="form-control input-lg" />
                    <span class="input-group-btn">
                    <button type="button" class="btn btn-default btn-lg"><i class="fa fa-search"></i></button>
                    </span> </div>
            </div>
        </div>
    </div>
</header>
<nav id="menu" class="navbar">
    <div class="nav-inner container">
        <div class="navbar-header"><span id="category" class="visible-xs">Categories</span>
            <button type="button" class="btn btn-navbar navbar-toggle" ><i class="fa fa-bars"></i></button>
        </div>
        <div class="navbar-collapse">
            <ul class="main-navigation">
                <li><a href="${pageContext.request.contextPath}/home/index.html" class="parent"  >首页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> </li>
                <li><a href="/home/product/queryNewProductList?pageNum=1&pageSiz=20" class="parent"  >新品上市&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> </li>
                <li><a href="/home/product/queryProductList?type=BOTTINE_SHOES&pageNum=1&pageSiz=20"   class="parent"  >秋冬女靴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> </li>
                <li><a href="/home/product/queryProductList?type=THIN_SHOES&pageNum=1&pageSiz=20"   class="parent"  >四季单鞋&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> </li>
                <li><a href="/home/product/queryProductList?type=SANDAL_SHOES&pageNum=1&pageSiz=20"   class="parent"  >夏日凉鞋&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> </li>
                <li><a href="#" >关于我们&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
                <li><a href="#" >联系我们</a> </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <ul class="breadcrumb">
    </ul>
    <div class="row">
        <div class="col-sm-3 hidden-xs column-left" id="column-left">
            <div class="column-block">
                <div class="columnblock-title">Account</div>
                <div class="account-block">
                    <div class="list-group"> <a class="list-group-item" href="/home/user/loginPage">登录</a> <a class="list-group-item" href="/home/user/registerPage">注册</a> <a class="list-group-item" href="forgetpassword.html">忘记密码?</a></div>
                </div>
            </div>
        </div>
        <div class="col-sm-9" id="content">
            <h1>注册用户</h1>
            <p>If you already have an account with us, please login at the <a href="login">login page</a>.</p>
            <form class="form-horizontal" enctype="multipart/form-data" method="post" action="register.html">
                <fieldset id="account">
                    <legend>Your Personal Details</legend>
                    <div style="display: none;" class="form-group required">
                        <label class="col-sm-2 control-label">Customer Group</label>
                        <div class="col-sm-10">
                            <div class="radio">
                                <label>
                                    <input type="radio" checked="checked" value="1" name="customer_group_id">
                                    Default</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group required">
                        <label for="input-realName" class="col-sm-2 control-label">真实姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="input-realName" placeholder="真实姓名" value="" name="realName">
                        </div>
                    </div>
                    <div class="form-group required">
                        <label for="input-sex" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="input-sex" placeholder="性别" value="" name="sex">
                        </div>
                    </div>
                    <div class="form-group required">
                        <label for="input-age" class="col-sm-2 control-label">年龄</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="input-age" placeholder="年龄" value="" name="age">
                        </div>
                    </div>
                    <div class="form-group required">
                        <label for="input-telephone" class="col-sm-2 control-label">手机</label>
                        <div class="col-sm-10">
                            <input type="tel" class="form-control" id="input-telephone" placeholder="Telephone" value="" name="telephone">
                        </div>
                    </div>
                </fieldset>
                <fieldset id="address">
                    <legend>Your Address</legend>
                    <div class="form-group">
                        <label for="input-address" class="col-sm-2 control-label">地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="input-address" placeholder="地址" value="" name="address">
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Your Password</legend>
                    <div class="form-group required">
                        <label for="input-displayName" class="col-sm-2 control-label">昵称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="input-displayName" placeholder="昵称" value="" name="displayName">
                        </div>
                    </div>
                    <div class="form-group required">
                        <label for="input-username" class="col-sm-2 control-label">Username</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="input-username" placeholder="Username" value="" name="username">
                        </div>
                    </div>
                    <div class="form-group required">
                        <label for="input-password" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="input-password" placeholder="Password" value="" name="password">
                        </div>
                    </div>
                </fieldset>
                <fieldset id="check">
                    <legend>Check</legend>
                    <div style="display: none;" class="form-group required">
                        <label class="col-sm-2 control-label">Customer Group</label>
                        <div class="col-sm-10">
                            <div class="radio">
                                <label>
                                    <input type="radio" checked="checked" value="1" name="customer_group_id">
                                    Default</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group required">
                        <label for="input-verCode" class="col-sm-2 control-label">验证码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="input-verCode" placeholder="验证码" value="" name="verCode">
                            <input id="button-getVerCode" type="button" class="btn btn-primary" value="获取验证码">
                            <span id="notify_message" style="color:red"></span>
                        </div>
                    </div>
                </fieldset>
                <div class="buttons">
                    <div class="pull-right">
                        &nbsp;
                        <input type="button" id="submit-register" class="btn btn-primary" value="Continue">
                        &nbsp;&nbsp;
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>
