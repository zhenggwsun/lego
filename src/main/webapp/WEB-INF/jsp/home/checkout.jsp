
<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2019/5/3
  Time: 12:46
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

    <link href="${pageContext.request.contextPath}/home/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="${pageContext.request.contextPath}/home/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,100,200,500,900,800,700,600' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/home/css/stylesheet.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/home/css/responsive.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/home/owl-carousel/owl.carousel.css" type="text/css" rel="stylesheet" media="screen" />
    <link href="${pageContext.request.contextPath}/home/owl-carousel/owl.transitions.css" type="text/css" rel="stylesheet" media="screen" />
    <link href="${pageContext.request.contextPath}/home/css/toastr.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/home/javascript/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/home/javascript/template.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/home/javascript/jstree.min.js"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/toastr.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/common.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/global.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/checkout.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/owl-carousel/owl.carousel.min.js" type="text/javascript"></script></head>
<body class="checkout col-2 left-col">
<div class="preloader loader" style="display: block;"> <img src="image/loader.gif"  alt="#"/></div>
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
                    <input type="text" name="search" value="" id="search-text" placeholder="Search" class="form-control input-lg" />
                    <span class="input-group-btn">
                    <button type="button" class="btn btn-default btn-lg" id="button-search"><i class="fa fa-search"></i></button>
                    </span> </div>
            </div>
            <script>
                $(document).ready(function() {
                    $('#button-search').click(function () {
                        var value = $('#search-text').val();
                        window.location.href="/home/product/searchProduct?key="+value+"&pageNum=1&pageSiz=20";
                    });
                });
            </script>
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
                <li><a href="${pageContext.request.contextPath}/home/index" class="parent"  >首页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> </li>
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
        <div id="column-left" class="col-sm-3 hidden-xs column-left">
            <div class="column-block">
                <div class="columnblock-title">Categories</div>
                <div class="category_block">
                    <ul class="box-category treeview-list treeview">
                        <li><a href="/home/product/queryProductList?type=SNEAKER_SHOES&pageNum=1&pageSiz=20" class="activSub">运动鞋</a></li>
                        <li><a href="/home/product/queryProductList?type=CASUAL_SHOES&pageNum=1&pageSiz=20" class="activSub">休闲鞋</a></li>
                        <li><a href="/home/product/queryProductList?type=BOTTINE_SHOES&pageNum=1&pageSiz=20" class="activSub">女靴</a></li>
                        <li><a href="/home/product/queryProductList?type=SANDAL_SHOES&pageNum=1&pageSiz=20">凉鞋</a></li>
                        <li><a href="/home/product/queryProductList?type=HIGH_HEELED_SHOES&pageNum=1&pageSiz=20">高跟鞋</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-sm-9" id="content">
            <h1>Checkout</h1>
            <div id="accordion" class="panel-group">


                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title"><a class="accordion-toggle collapsed" data-parent="#accordion" data-toggle="collapse" href="#collapse-shipping-address" aria-expanded="false"> Step 1: 地址<i class="fa fa-caret-down"></i></a></h4>
                    </div>
                    <div id="collapse-shipping-address" role="heading"  class="panel-collapse collapse in" aria-expanded="false" style="">
                        <div class="panel-body">
                            <form class="form-horizontal">
                                <div class="radio">
                                    <label>
                                        <input type="radio" checked="checked" value="existing" name="shipping_address">
                                        I want to use an existing address</label>
                                </div>
                                <div id="shipping-existing" >
                                    <select class="form-control" id="address-select" name="address_id">
                                        <option selected="selected" value="4">李天天, 中国, 北京, 海淀区, 中关村软件园</option>
                                    </select>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" value="new" name="shipping_address">
                                        I want to use a new address</label>
                                </div>
                                <br>
                                <div id="shipping-new" style="display: none;">
                                    <div class="form-group required">
                                        <label for="input-shipping-name" class="col-sm-2 control-label">收件人</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="input-shipping-name" placeholder="收件人" value="" name="name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="input-shipping-phone-number" class="col-sm-2 control-label">手机号码</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="input-shipping-phone-number" placeholder="手机号码" value="15556711567" name="phone-number">
                                        </div>
                                    </div>
                                    <div class="form-group required">
                                        <label for="input-shipping-full-address" class="col-sm-2 control-label">地址</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="input-shipping-full-address" placeholder="地址" value="中国，北京" name="full-address">
                                        </div>

                                    </div>
                                    <div class="form-group required">
                                        <label for="input-shipping-address-detailed" class="col-sm-2 control-label">详细地址</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="input-shipping-address-detailed" placeholder="详细地址：如道路、门牌号、小区、楼栋号、单元室等" value="" name="address_detailed">
                                        </div>
                                    </div>
                                </div>

                                <div class="buttons clearfix">
                                    <div class="pull-right">
                                        <input type="button" class="btn btn-primary" data-loading-text="Loading..." id="button-shipping-address" value="Continue">
                                    </div>
                                </div>
                            </form>
                            <script type="text/javascript">
                                $('input[name=\'shipping_address\']').on('change', function() {
                                    if (this.value == 'new') {
                                        $('#shipping-existing').hide();
                                        $('#shipping-new').show();
                                    } else {
                                        $('#shipping-existing').show();
                                        $('#shipping-new').hide();
                                    }
                                });
                            </script>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title"><a class="accordion-toggle" data-parent="#accordion" data-toggle="collapse" href="#collapse-checkout-confirm" aria-expanded="true">Step 2: 确认订单<i class="fa fa-caret-down"></i></a></h4>
                    </div>
                    <div id="collapse-checkout-confirm" role="heading" class="panel-collapse collapse" aria-expanded="true" style="height: 0px;">
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <td class="text-left">产品名称</td>
                                        <td class="text-left">尺码</td>
                                        <td class="text-right">数量</td>
                                        <td class="text-right">单价</td>
                                        <td class="text-right">总计</td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${requestScope.cartModel.list}" var="model">
                                    <tr>
                                        <td class="text-left">${model.product.productName}</td>
                                        <td class="text-left">${model.repertory.size}</td>
                                        <td class="text-right">${model.num}</td>
                                        <td class="text-right">￥${model.product.price}</td>
                                        <td class="text-right">￥${model.product.price * model.num}</td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <td class="text-right" colspan="4"><strong>总计:</strong></td>
                                        <td class="text-right">￥${requestScope.cartModel.total}</td>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <div class="buttons">
                                <div class="pull-right">
                                    <input type="button" data-loading-text="Loading..." class="btn btn-primary" id="button-create" value="Confirm Order">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
