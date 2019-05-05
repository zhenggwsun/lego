<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2019/5/4
  Time: 15:04
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
<!-- 中部开始 -->
<div class="wrapper">
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="content">
            <!-- 右侧内容框架，更改从这里开始 -->
            <form class="layui-form">
                <div class="layui-form-item">
                    <label for="L_product_name" class="layui-form-label">
                        商品名称
                    </label>
                    <div class="layui-input-inline">
                        <input type="hidden" name = "productId" value="${requestScope.ProductModel.product.id}"/>
                        <input type="text" id="L_product_name" name="productName" required lay-verify="product_name"
                               autocomplete="off" value="${requestScope.ProductModel.product.productName}" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_categroy" class="layui-form-label">
                        分类
                    </label>
                    <div class="layui-input-inline">
                        <select id="L_categroy" name="categroy" lay-verify="">
                            <option value="${requestScope.ProductModel.product.categroy}" selected = "selected">${requestScope.ProductModel.product.categroy}</option>
                            <option value="运动鞋">运动鞋</option>
                            <option value="休闲鞋">休闲鞋</option>
                            <option value="女靴">女靴</option>
                            <option value="凉鞋">凉鞋</option>
                            <option value="单鞋">单鞋</option>
                            <option value="高跟鞋">高跟鞋</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_price" class="layui-form-label">
                        价格
                    </label>
                    <div class="layui-input-inline">
                        <input type="number" id="L_price" name="price" value="${requestScope.ProductModel.product.price}"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label for="L_sign" class="layui-form-label">
                        产品描述
                    </label>
                    <div class="layui-input-block">
                        <textarea placeholder="随便写些什么刷下存在感" id="L_sign" name="productDesc" autocomplete="off"
                                  class="layui-textarea" style="height: 80px;">${requestScope.ProductModel.product.productDesc}</textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_sign" class="layui-form-label">
                    </label>
                    <button class="layui-btn" key="set-mine" lay-filter="save" lay-submit>
                        保存
                    </button>
                </div>
            </form>
            <!-- 右侧内容框架，更改从这里结束 -->
        </div>
    </div>
    <!-- 右侧主体结束 -->
</div>
<!-- 中部结束 -->

<script>
    $(function  () {
        layui.use('form', function(){
            var form = layui.form();
            //监听提交
            form.on('submit(save)', function(data){
                $.post("/sysbench/product/update",data.field, function (result) {
                    if(result.success == true){
                        layer.msg("更新成功");
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.location.reload();
                        parent.layer.close(index); //再执行关闭
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