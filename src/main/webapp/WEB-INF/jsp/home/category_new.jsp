<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2019/4/21
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="${pageContext.request.contextPath}/home/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/home/javascript/template.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/home/javascript/jstree.min.js"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/common.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/global.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/owl-carousel/owl.carousel.min.js" type="text/javascript"></script></head>
<body class="category col-2 left-col">
<div class="preloader loader" style="display: block;"> <img src="${pageContext.request.contextPath}/home/image/loader.gif" alt="#"/></div>
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
        <div id="content" class="col-sm-9">
            <div class="category-page-wrapper">
                <div class="col-md-6 list-grid-wrapper">
                    <div class="btn-group btn-list-grid">
                        <button type="button" id="list-view" class="btn btn-default list" data-toggle="tooltip" title="List"><i class="fa fa-th-list"></i></button>
                        <button type="button" id="grid-view" class="btn btn-default grid" data-toggle="tooltip" title="Grid"><i class="fa fa-th"></i></button>
                    </div>
                </div>
                <br />
                <div class="grid-list-wrapper">
                    <c:forEach items="${requestScope.PaginationModel.list}" var="product">

                    <div class="product-layout product-list col-xs-12">
                        <div class="product-thumb">
                            <div class="image product-imageblock"> <a href="/home/product/queryProduct?id=${product.id}">
                                <img src="${pageContext.request.contextPath}/uploaded/${product.photo}" title="${product.productName}" class="img-responsive" /> </a>
                            </div>
                            <div class="caption product-detail">
                                <h4 class="product-name">${product.productName}</h4>
                                <p class="price product-price"><span class="price-old">￥${product.price* 1.2}</span> ￥${product.price} </p>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
                <div class="category-page-wrapper">
                    <div class="result-inner">第${requestScope.PaginationModel.pageNum}页/共 ${requestScope.PaginationModel.totalPages} 页</div>
                    <div class="pagination-inner">
                        <ul class="pagination">
                            <c:if test="${requestScope.PaginationModel.pageNum > 1}">
                                <li><a href="/home/product/queryNewProductList?pageNum=${param.pageNum-1}&pageSiz=20">上一页</a></li>
                            </c:if>
                            <c:if test="${requestScope.PaginationModel.pageNum < requestScope.PaginationModel.totalPages}">
                                <li><a href="/home/product/queryNewProductList?pageNum=${param.pageNum+1}&pageSiz=20">下一页</a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

