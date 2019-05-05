<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2019/5/4
  Time: 15:49
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
<!-- 中部开始 -->
<div class="wrapper">
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="content">
            <!-- 右侧内容框架，更改从这里开始 -->
            <form class="layui-form">

                <div class="layui-form-item">
                    <label for="L_product_id" class="layui-form-label">
                        商品id
                    </label>
                    <div class="layui-input-inline">
                        <input type="hidden" name="id" value="${requestScope.model.id}">
                        <input type="number" id="L_product_id" name="productId" required lay-verify="product_id"
                               autocomplete="off" value="${requestScope.model.productId}" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_size" class="layui-form-label">
                        尺码
                    </label>
                    <div class="layui-input-inline">
                        <select id="L_size" name="size" lay-verify="">
                            <option value="${requestScope.model.size}">${requestScope.model.size}</option>
                            <option value="36">36</option>
                            <option value="37">37</option>
                            <option value="38">38</option>
                            <option value="39">39</option>
                            <option value="40">40</option>
                            <option value="41">41</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_for_sale" class="layui-form-label">
                        库存
                    </label>
                    <div class="layui-input-inline">
                        <input type="number" id="L_for_sale" name="forSale" value="${requestScope.model.forSaleCount}"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_save" class="layui-form-label">
                    </label>
                    <div class="layui-input-inline">
                        <button id="L_save"class="layui-btn" key="set-mine" lay-filter="save" lay-submit>
                            保存
                        </button>
                    </div>

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
                $.post("/sysbench/repertory/update",data.field, function (result) {
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
