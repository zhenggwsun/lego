<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2019/5/2
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="e-commerce site well design with responsive view." />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="${pageContext.request.contextPath}/home/owl-carousel/owl.carousel.css" type="text/css" rel="stylesheet" media="screen" />
    <link href="${pageContext.request.contextPath}/home/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="${pageContext.request.contextPath}/home/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,100,200,500,900,800,700,600' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/home/css/stylesheet.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/home/css/responsive.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/home/owl-carousel/owl.transitions.css" type="text/css" rel="stylesheet" media="screen" />
    <script src="${pageContext.request.contextPath}/home/javascript/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/home/javascript/template.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/home/javascript/jstree.min.js"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/common.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/index.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/global.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/owl-carousel/owl.carousel.min.js" type="text/javascript"></script>
</head>
<body>
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
<div class="mainbanner" >
    <div id="main-banner" class="owl-carousel home-slider">
        <div class="item"> <a href="#"><img src="image/banners/Main-Banner1.jpg" alt="main-banner1" class="img-responsive" /></a> </div>
        <div class="item"> <a href="#"><img src="image/banners/Main-Banner2.jpg" alt="main-banner2" class="img-responsive" /></a> </div>
        <div class="item"> <a href="#"><img src="image/banners/Main-Banner3.jpg" alt="main-banner3" class="img-responsive" /></a> </div>
    </div>

</div>
<div class="container">
    <div class="row">
        <div class="cms_banner">
            <div class="col-md-4 cms-banner-left"> <a href="#"><img alt="#" src="image/banners/subbanner1.jpg"></a> </div>
            <div class="col-md-4 cms-banner-middle"> <a href="#"><img alt="#" src="image/banners/subbanner2.jpg"></a> </div>
            <div class="col-md-4 cms-banner-right"> <a href="#"><img alt="#" src="image/banners/subbanner3.jpg"></a> </div>
        </div>
    </div>
    <div class="row">
        <div id="content" class="col-sm-12">
            <div class="customtab">
                <h3 class="productblock-title">新品上市</h3>
                <div id="tab-latest" class="tab-content">
                    <div class="box">
                        <div id="latest-slidertab" class="row owl-carousel product-slider">
                            <div class="item">
                                <div class="product-thumb transition">
                                    <div class="image product-imageblock"> <a href="product.html"><img src="image/shoes/shoes18.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                        <div class="button-group">
                                            <button type="button" class="addtocart-btn" >Add To Cart</button>
                                        </div>
                                    </div>
                                    <div class="caption product-detail">
                                        <h4 class="product-name"><a href="#" title="2018新款冬靴">2018新款冬靴</a></h4>
                                        <p class="price product-price">$122.00</p>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="product-thumb transition">
                                    <div class="image product-imageblock"> <a href="product.html"><img src="image/shoes/shoes19.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                        <div class="button-group">
                                            <button type="button" class="addtocart-btn" >Add To Cart</button>
                                        </div>
                                    </div>
                                    <div class="caption product-detail">
                                        <h4 class="product-name"><a href="#" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                        <p class="price product-price">$122.00<span class="price-tax">Ex Tax: $100.00</span></p>
                                        <div class="rating"> <span class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-2x"></i></span> </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="product-thumb transition">
                                    <div class="image product-imageblock"> <a href="product.html"><img src="image/shoes/shoes20.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                        <div class="button-group">
                                            <button type="button" class="addtocart-btn" >Add To Cart</button>
                                        </div>
                                    </div>
                                    <div class="caption product-detail">
                                        <h4 class="product-name"><a href="#" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                        <p class="price product-price">$122.00<span class="price-tax">Ex Tax: $100.00</span></p>
                                        <div class="rating"> <span class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-2x"></i></span> </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="product-thumb transition">
                                    <div class="image product-imageblock"> <a href="product.html"><img src="image/shoes/shoes4.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                        <div class="button-group">
                                            <button type="button" class="addtocart-btn" >Add To Cart</button>
                                        </div>
                                    </div>
                                    <div class="caption product-detail">
                                        <h4 class="product-name"><a href="#" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                        <p class="price product-price">$122.00<span class="price-tax">Ex Tax: $100.00</span></p>
                                        <div class="rating"> <span class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-2x"></i></span> </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="product-thumb transition">
                                    <div class="image product-imageblock"> <a href="product.html"><img src="image/shoes/shoes5.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                        <div class="button-group">
                                            <button type="button" class="addtocart-btn" >Add To Cart</button>
                                        </div>
                                    </div>
                                    <div class="caption product-detail">
                                        <h4 class="product-name"><a href="#" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                        <p class="price product-price">$122.00<span class="price-tax">Ex Tax: $100.00</span></p>
                                        <div class="rating"> <span class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-2x"></i></span> </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="product-thumb transition">
                                    <div class="image product-imageblock"> <a href="product.html"><img src="image/shoes/shoes6.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                        <div class="button-group">
                                            <button type="button" class="addtocart-btn" >Add To Cart</button>
                                        </div>
                                    </div>
                                    <div class="caption product-detail">
                                        <h4 class="product-name"><a href="#" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                        <p class="price product-price">$122.00<span class="price-tax">Ex Tax: $100.00</span></p>
                                        <div class="rating"> <span class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-2x"></i></span> <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-2x"></i></span> </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <h3 class="productblock-title">爆款推荐</h3>
                <div class="box">
                    <div id="feature-slider" class="row owl-carousel product-slider">
                        <div class="item product-slider-item">
                            <div class="product-thumb transition">
                                <div class="image product-imageblock"> <a href="product.html"> <img src="image/shoes/shoes7.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                    <div class="button-group">
                                        <button type="button" class="addtocart-btn" >Add To Cart</button>
                                    </div>
                                </div>
                                <div class="caption product-detail">
                                    <h4 class="product-name"><a href="product.html" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                    <p class="price product-price"> <span class="price-new">$254.00</span></p>
                                </div>
                            </div>
                        </div>
                        <div class="item product-slider-item">
                            <div class="product-thumb transition">
                                <div class="image product-imageblock"> <a href="product.html"> <img src="image/shoes/shoes8.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                    <div class="button-group">
                                        <button type="button" class="addtocart-btn" >Add To Cart</button>
                                    </div>
                                </div>
                                <div class="caption product-detail">
                                    <h4 class="product-name"><a href="product.html" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                    <p class="price product-price"> <span class="price-new">$254.00</span> <span class="price-old">$272.00</span> <span class="price-tax">Ex Tax: $210.00</span> </p>
                                </div>
                            </div>
                        </div>
                        <div class="item product-slider-item">
                            <div class="product-thumb transition">
                                <div class="image product-imageblock"> <a href="product.html"> <img src="image/shoes/shoes9.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                    <div class="button-group">
                                        <button type="button" class="addtocart-btn" >Add To Cart</button>
                                    </div>
                                </div>
                                <div class="caption product-detail">
                                    <h4 class="product-name"><a href="product.html" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                    <p class="price product-price"> <span class="price-new">$254.00</span> <span class="price-old">$272.00</span> <span class="price-tax">Ex Tax: $210.00</span> </p>
                                </div>
                            </div>
                        </div>
                        <div class="item product-slider-item">
                            <div class="product-thumb transition">
                                <div class="image product-imageblock"> <a href="#"> <img src="image/shoes/shoes10.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                    <div class="button-group">
                                        <button type="button" class="addtocart-btn" >Add To Cart</button>
                                    </div>
                                </div>
                                <div class="caption product-detail">
                                    <h4 class="product-name"><a href="product.html" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                    <p class="price product-price"> <span class="price-new">$254.00</span> <span class="price-old">$272.00</span> <span class="price-tax">Ex Tax: $210.00</span> </p>
                                </div>
                            </div>
                        </div>
                        <div class="item product-slider-item">
                            <div class="product-thumb transition">
                                <div class="image product-imageblock"> <a href="#"> <img src="image/shoes/shoes11.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                    <div class="button-group">
                                        <button type="button" class="addtocart-btn" >Add To Cart</button>
                                    </div>
                                </div>
                                <div class="caption product-detail">
                                    <h4 class="product-name"><a href="product.html" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                    <p class="price product-price"> <span class="price-new">$254.00</span> <span class="price-old">$272.00</span> <span class="price-tax">Ex Tax: $210.00</span> </p>
                                </div>
                            </div>
                        </div>
                        <div class="item product-slider-item">
                            <div class="product-thumb transition">
                                <div class="image product-imageblock"> <a href="#"> <img src="image/shoes/shoes12.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                    <div class="button-group">
                                        <button type="button" class="addtocart-btn" >Add To Cart</button>
                                    </div>
                                </div>
                                <div class="caption product-detail">
                                    <h4 class="product-name"><a href="product.html" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                    <p class="price product-price"> <span class="price-new">$254.00</span> <span class="price-old">$272.00</span> <span class="price-tax">Ex Tax: $210.00</span> </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <h3 class="productblock-title">当季热卖</h3>
                <div class="box">
                    <div id="special-slider" class="row owl-carousel product-slider">
                        <div class="item product-slider-item">
                            <div class="product-thumb transition">
                                <div class="image product-imageblock"> <a href="product.html"> <img src="image/shoes/shoes13.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                    <div class="button-group">
                                        <button type="button" class="addtocart-btn" >Add To Cart</button>
                                    </div>
                                </div>
                                <div class="caption product-detail">
                                    <h4 class="product-name"><a href="product.html" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                    <p class="price product-price"> <span class="price-new">$254.00</span> <span class="price-old">$272.00</span> <span class="price-tax">Ex Tax: $210.00</span> </p>
                                </div>
                            </div>
                        </div>
                        <div class="item product-slider-item">
                            <div class="product-thumb transition">
                                <div class="image product-imageblock"> <a href="product.html"> <img src="image/shoes/shoes14.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                    <div class="button-group">
                                        <button type="button" class="addtocart-btn" >Add To Cart</button>
                                    </div>
                                </div>
                                <div class="caption product-detail">
                                    <h4 class="product-name"><a href="product.html" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                    <p class="price product-price"> <span class="price-new">$254.00</span> <span class="price-old">$272.00</span> <span class="price-tax">Ex Tax: $210.00</span> </p>
                                </div>
                            </div>
                        </div>
                        <div class="item product-slider-item">
                            <div class="product-thumb transition">
                                <div class="image product-imageblock"> <a href="product.html"> <img src="image/shoes/shoes15.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                    <div class="button-group">
                                        <button type="button" class="addtocart-btn" >Add To Cart</button>
                                    </div>
                                </div>
                                <div class="caption product-detail">
                                    <h4 class="product-name"><a href="product.html" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                    <p class="price product-price"> <span class="price-new">$254.00</span> <span class="price-old">$272.00</span> <span class="price-tax">Ex Tax: $210.00</span> </p>
                                </div>
                            </div>
                        </div>
                        <div class="item product-slider-item">
                            <div class="product-thumb transition">
                                <div class="image product-imageblock"> <a href="#"> <img src="image/shoes/shoes16.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                    <div class="button-group">
                                        <button type="button" class="addtocart-btn" >Add To Cart</button>
                                    </div>
                                </div>
                                <div class="caption product-detail">
                                    <h4 class="product-name"><a href="product.html" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                    <p class="price product-price"> <span class="price-new">$254.00</span> <span class="price-old">$272.00</span> <span class="price-tax">Ex Tax: $210.00</span> </p>
                                </div>
                            </div>
                        </div>
                        <div class="item product-slider-item">
                            <div class="product-thumb transition">
                                <div class="image product-imageblock"> <a href="#"> <img src="image/shoes/shoes17.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                    <div class="button-group">
                                        <button type="button" class="addtocart-btn" >Add To Cart</button>
                                    </div>
                                </div>
                                <div class="caption product-detail">
                                    <h4 class="product-name"><a href="product.html" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                    <p class="price product-price"> <span class="price-new">$254.00</span> <span class="price-old">$272.00</span> <span class="price-tax">Ex Tax: $210.00</span> </p>
                                </div>
                            </div>
                        </div>
                        <div class="item product-slider-item">
                            <div class="product-thumb transition">
                                <div class="image product-imageblock"> <a href="#"> <img src="image/shoes/shoes18.jpg" alt="lorem ippsum dolor dummy" title="lorem ippsum dolor dummy" class="img-responsive" /> </a>
                                    <div class="button-group">
                                        <button type="button" class="addtocart-btn" >Add To Cart</button>
                                    </div>
                                </div>
                                <div class="caption product-detail">
                                    <h4 class="product-name"><a href="product.html" title="lorem ippsum dolor dummy">lorem ippsum dolor dummy</a></h4>
                                    <p class="price product-price"> <span class="price-new">$254.00</span> <span class="price-old">$272.00</span> <span class="price-tax">Ex Tax: $210.00</span> </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="brand_carouse" class="owl-carousel brand-logo">
                <div class="item text-center"> <a href="#"><img src="image/brand/brand1.png" alt="Disney" class="img-responsive" /></a> </div>
                <div class="item text-center"> <a href="#"><img src="image/brand/brand2.png" alt="Dell" class="img-responsive" /></a> </div>
                <div class="item text-center"> <a href="#"><img src="image/brand/brand3.png" alt="Harley" class="img-responsive" /></a> </div>
                <div class="item text-center"> <a href="#"><img src="image/brand/brand4.png" alt="Canon" class="img-responsive" /></a> </div>
                <div class="item text-center"> <a href="#"><img src="image/brand/brand5.png" alt="Canon" class="img-responsive" /></a> </div>
                <div class="item text-center"> <a href="#"><img src="image/brand/brand6.png" alt="Canon" class="img-responsive" /></a> </div>
                <div class="item text-center"> <a href="#"><img src="image/brand/brand7.png" alt="Canon" class="img-responsive" /></a> </div>
                <div class="item text-center"> <a href="#"><img src="image/brand/brand8.png" alt="Canon" class="img-responsive" /></a> </div>
                <div class="item text-center"> <a href="#"><img src="image/brand/brand9.png" alt="Canon" class="img-responsive" /></a> </div>
                <div class="item text-center"> <a href="#"><img src="image/brand/brand5.png" alt="Canon" class="img-responsive" /></a> </div>
            </div>
        </div>
    </div>
</div>
<footer>
    <div class="container">
        <div class="row">
            <div class="col-sm-3 footer-block">
                <h5 class="footer-title">Information</h5>
                <ul class="list-unstyled ul-wrapper">
                    <li><a href="about-us.html">About Us</a></li>
                    <li><a href="checkout.html">Delivery Information</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                    <li><a href="#">Terms &amp; Conditions</a></li>
                </ul>
            </div>
            <div class="col-sm-3 footer-block">
                <h5 class="footer-title">Customer Service</h5>
                <ul class="list-unstyled ul-wrapper">
                    <li><a href="contact.html">Contact Us</a></li>
                    <li><a href="#">Returns</a></li>
                    <li><a href="#">Site Map</a></li>
                    <li><a href="#">Wish List</a></li>
                </ul>
            </div>
            <div class="col-sm-3 footer-block">
                <h5 class="footer-title">Extras</h5>
                <ul class="list-unstyled ul-wrapper">
                    <li><a href="#">Brands</a></li>
                    <li><a href="gift.html">Gift Vouchers</a></li>
                    <li><a href="affiliate.html">Affiliates</a></li>
                    <li><a href="#">Specials</a></li>
                </ul>
            </div>
            <div class="col-sm-3 footer-block">
                <div class="content_footercms_right">
                    <div class="footer-contact">
                        <h5 class="contact-title footer-title">Contact Us</h5>
                        <ul class="ul-wrapper">
                            <li><i class="fa fa-map-marker"></i><span class="location2"> Warehouse & Offices,<br>
                                12345 Street name, California<br>
                                USA</span></li>
                            <li><i class="fa fa-envelope"></i><span class="mail2"><a href="#">info@localhost.com</a></span></li>
                            <li><i class="fa fa-mobile"></i><span class="phone2">+91 0987-654-321</span></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <a id="scrollup">Scroll</a> </footer>
<div class="footer-bottom">
    <div class="container">
        <div class="copyright">Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/"></a></div>
        <div class="footer-bottom-cms">
            <div class="footer-payment">
                <ul>
                    <li class="mastero"><a href="#"><img alt="" src="image/payment/mastero.jpg"></a></li>
                    <li class="visa"><a href="#"><img alt="" src="image/payment/visa.jpg"></a></li>
                    <li class="currus"><a href="#"><img alt="" src="image/payment/currus.jpg"></a></li>
                    <li class="discover"><a href="#"><img alt="" src="image/payment/discover.jpg"></a></li>
                    <li class="bank"><a href="#"><img alt="" src="image/payment/bank.jpg"></a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>

