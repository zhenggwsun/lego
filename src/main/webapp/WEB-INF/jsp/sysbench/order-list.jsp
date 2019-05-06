<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2019/5/4
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
                    <ul class="sub-menu opened">
                        <li class="current">
                            <a href="/sysbench/order/queryOrderList?pageNum=1&pageSize=10">
                                <i class="iconfont">&#xe6a7;</i>
                                订单列表
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="list" >
                    <a href="javascript:;">
                        <i class="iconfont">&#xe6a3;</i>
                        系统统计
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu" style="display:none">
                        <li>
                            <a href="/sysbench/echarts1">
                                <i class="iconfont">&#xe6a7;</i>
                                柱状图
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="content">
            <!-- 右侧内容框架，更改从这里开始 -->
            <form class="layui-form xbs" action="/sysbench/order/queryOrderList" method="get" >
                <div class="layui-form-pane" style="text-align: center;">
                    <div class="layui-form-item" style="display: inline-block;">
                        <label class="layui-form-label xbs768">时间范围</label>
                        <div class="layui-input-inline xbs768">
                            <input class="layui-input" placeholder="开始时间" id="LAY_demorange_s" name="startDate">
                        </div>
                        <div class="layui-input-inline xbs768">
                            <input class="layui-input" placeholder="截止时间" id="LAY_demorange_e" name="endDate">
                        </div>
                        <div class="layui-input-inline" style="width:80px">
                            <button class="layui-btn"  lay-submit="" lay-filter="sreach" type="submit"><i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </div>
                </div>
            </form>
            <xblock><!--<button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon">&#xe640;</i>批量删除</button>-->
                <a href="/sysbench/order/export"><button class="layui-btn" onclick=""><i class="layui-icon">&#xe64c;</i>数据导出</button></a>
                <span class="x-right" style="line-height:40px">共有数据：${requestScope.PaginationModel.total} 条</span>
            </xblock>
            <table class="layui-table">
                <thead>
                <tr>
                    <th>
                        ID
                    </th>
                    <th>
                        商品名称
                    </th>
                    <th>
                        鞋码
                    </th>
                    <th>
                        数量
                    </th>
                    <th>
                        总价
                    </th>
                    <th>
                        地址
                    </th>
                    <th>
                        下单时间
                    </th>
                    <th>
                        所属用户
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.PaginationModel.list}" var="model">
                <tr>
                    <td>
                        ${model.order.id}
                    </td>
                    <td>
                        ${model.product.productName}
                    </td>
                    <td >
                            ${model.order.size}
                    </td>
                    <td >
                            ${model.order.number}
                    </td>
                    <td >
                            ${model.order.cost}
                    </td>
                    <td >
                            ${model.address.fullAddress}
                    </td>
                    <td>
                        <fmt:formatDate value="${model.order.gmtCreate}" pattern="yyyy/MM/dd  HH:mm:ss" />
                    </td>
                    <td >
                            ${model.user.displayName}
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <!-- 右侧内容框架，更改从这里结束 -->
        </div>
        <xblock>
            <c:choose>
                <c:when test="${requestScope.PaginationModel.pageNum > 1}">
                    <a href="/sysbench/order/queryOrderList?startDate=${param.startDate}&endDate=${param.endDate}&pageNum=${param.pageNum-1}&pageSiz=10"><button class="layui-btn">上一页</button></a>
                </c:when>
                <c:otherwise>
                    <a href="/sysbench/order/queryOrderList?startDate=${param.startDate}&endDate=${param.endDate}&pageNum=${param.pageNum-1}&pageSiz=10"><button class="layui-btn" style="color: grey" disabled="disabled">上一页</button></a>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${requestScope.PaginationModel.pageNum < requestScope.PaginationModel.totalPages}">
                    <a href="/sysbench/order/queryOrderList?startDate=${param.startDate}&endDate=${param.endDate}&pageNum=${param.pageNum+1}&pageSiz=10"><button class="layui-btn">下一页</button></a>
                </c:when>
                <c:otherwise>
                    <a href="/sysbench/order/queryOrderList?startDate=${param.startDate}&endDate=${param.endDate}&pageNum=${param.pageNum+1}&pageSiz=10"><button class="layui-btn" style="color: grey" disabled="disabled">下一页</button></a>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${requestScope.PaginationModel.totalPages == 0}">
                    <span class="x-right" style="line-height:40px">第0页/共 0 页</span>
                </c:when>
                <c:otherwise>
                    <span class="x-right" style="line-height:40px">第${requestScope.PaginationModel.pageNum}页/共 ${requestScope.PaginationModel.totalPages} 页</span>
                </c:otherwise>
            </c:choose>
        </xblock>
    </div>
    <!-- 右侧主体结束 -->
</div>
<!-- 中部结束 -->
<!-- 底部开始 -->

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
<!-- 页面动态效果 -->
<script>

    layui.use(['laydate'], function(){
        laydate = layui.laydate;//日期插件

        //以上模块根据需要引入
        //



        var start = {
            max: '2099-06-16 23:59:59'
            ,istoday: false
            ,choose: function(datas){
//                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };

        var end = {
            max: '2099-06-16 23:59:59'
            ,istoday: false
            ,choose: function(datas){
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };

        document.getElementById('LAY_demorange_s').onclick = function(){
            start.elem = this;
            laydate(start);
        }
        document.getElementById('LAY_demorange_e').onclick = function(){
            end.elem = this
            laydate(end);
        }

    });

    //批量删除提交
    function delAll () {
        layer.confirm('确认要删除吗？',function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
        });
    }
    /*用户-添加*/
    function member_add(title,url,w,h){
        x_admin_show(title,url,w,h);
    }
    /*用户-查看*/
    function member_show(title,url,id,w,h){
        x_admin_show(title,url,w,h);
    }

    /*用户-停用*/
    function member_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){
            //发异步把用户状态进行更改
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="layui-icon">&#xe62f;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="layui-btn layui-btn-disabled layui-btn-mini">已停用</span>');
            $(obj).remove();
            layer.msg('已停用!',{icon: 5,time:1000});
        });
    }

    /*用户-启用*/
    function member_start(obj,id){
        layer.confirm('确认要启用吗？',function(index){
            //发异步把用户状态进行更改
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="layui-icon">&#xe601;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span>');
            $(obj).remove();
            layer.msg('已启用!',{icon: 6,time:1000});
        });
    }
    // 用户-编辑
    function member_edit (title,url,id,w,h) {
        x_admin_show(title,url,w,h);
    }
    /*密码-修改*/
    function member_password(title,url,id,w,h){
        x_admin_show(title,url,w,h);
    }
    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }
</script>
<script>
    //百度统计可去掉
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>
</html>