<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2019/4/21
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        .unchecked{
            border:  1px  solid  gray;
            padding:  1px  1px  1px  1px;
        }
        .checked{
            border:  1px  solid  #c00;
            padding:  1px  1px  1px  1px;
        }
    </style>
    <title>Lego Fashion</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="e-commerce site well design with responsive view." />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="${pageContext.request.contextPath}/home/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="${pageContext.request.contextPath}/home/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,100,200,500,900,800,700,600' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/home/css/stylesheet.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/home/css/responsive.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/home/css/toastr.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/home/owl-carousel/owl.carousel.css" type="text/css" rel="stylesheet" media="screen" />
    <link href="${pageContext.request.contextPath}/home/owl-carousel/owl.transitions.css" type="text/css" rel="stylesheet" media="screen" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/jquery.fancybox.css" type="text/css" media="screen" />
    <script src="${pageContext.request.contextPath}/home/javascript/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/toastr.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/home/javascript/template.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/home/javascript/jstree.min.js"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/common.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/global.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/javascript/product.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/home/owl-carousel/owl.carousel.min.js" type="text/javascript"></script><script type="text/javascript" src="${pageContext.request.contextPath}/home/javascript/jquery.fancybox.js"></script>
    <script  type="text/javascript">
        var  obj={
            colorSpan:"",
            sizeSpan:""
        };
        function  change(span)
        {
            $(span).prev().attr("checked",'checked');

            var  value  =    $("input[name='size']:checked").val();
            console.log(value);
            $('span[name="'+$(span).attr('name')+'"]').each(function(){
                if(this.checked&&this!=span)
                {
                    this.className="unchecked";
                    this.checked=false;
                }
            });
            obj[$(span).attr('name')]=span.innerHTML;
            span.className="checked";
            span.checked=true;
            select();
        }
        function  select()
        {
            var  html='';
            for(var  i  in  obj)
            {
                if(obj[i]!='')
                {
                    html+='<font  color=orange>"'+  obj[i]+'"</font>  、';
                }
            }

        }
    </script>
</head>
<body class="product col-2 left-col">
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
        </div>
        <div id="content" class="col-sm-9">
            <div class="row">
                <div class="col-sm-6">
                    <div class="thumbnails">
                        <div><img  height="400px" width="400px" src="${pageContext.request.contextPath}/uploaded/${requestScope.ProductModel.product.photo}" /></div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <h1 class="productpage-title">${requestScope.ProductModel.product.productName}</h1>
                    <hr>
                    <ul class="list-unstyled productinfo-details-top">
                        <li>
                            <h2 class="productpage-price">￥${requestScope.ProductModel.product.price}</h2>
                        </li>
                    </ul>
                    <hr>
                    <ul class="list-unstyled product_info">
                        <li>
                            <label>类别:</label>
                            <span> <a href="#">${requestScope.ProductModel.product.categroy}</a></span></li>
                        <li>
                            <label>产品码:</label>
                            <span> ${requestScope.ProductModel.product.id}</span></li>
                        <li>
                            <label>尺码:</label>
                                <c:forEach items="${requestScope.ProductModel.repertory}" var="model">
                                    <input  type="radio"  name="size"  value="${model.size}"  style="display:none"/>
                                    <span  class='unchecked'    name='sizeSpan'    checked='false'  onclick='change(this);'  >${model.size}</span>
                                </c:forEach>
                        </li>
                    </ul>
                    <hr>
                    <p class="product-desc"> ${requestScope.ProductModel.product.productDesc}</p>
                    <div id="product">
                        <div class="form-group">
                            <label class="control-label qty-label" for="input-quantity">Qty</label>
                            <input type="text" name="quantity" value="1" size="2" id="input-quantity" class="form-control productpage-qty" />
                            <input type="hidden" id="input-id" name="product_id" value="${requestScope.ProductModel.product.id}" />
                            <div class="btn-group">
                                <button type="button" id="add-cart" data-loading-text="Loading..." class="btn btn-primary btn-lg btn-block addtocart">Add to Cart</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="productinfo-tab">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#tab-description" data-toggle="tab">Description</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="tab-description">
                        <div class="cpt_product_description ">
                            <div>
                                ${requestScope.ProductModel.product.productDesc}
                            </div>
                        </div>
                        <!-- cpt_container_end --></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>


