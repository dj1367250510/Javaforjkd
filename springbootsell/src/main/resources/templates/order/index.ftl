<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--    边栏nav-->
    <#include "../common/nav.ftl">
    <#--     右侧-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>订单id</th>
                            <th>订单总金额 </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${orderMaster.orderId}</td>
                            <td>${orderMaster.orderAmount}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>

                                    <table class="table table-bordered table-condensed">
                                        <thead>
                                        <tr>
                                            <th>商品id</th>
                                            <th>商品名称</th>
                                            <th>商品价格</th>
                                            <th>数量</th>
                                            <th>总额</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#list orderDetailList as orderDetail>
                                            <tr>
                                                <td>${orderDetail.productId}</td>
                                                <td>${orderDetail.productName}</td>
                                                <td>${orderDetail.productPrice}</td>
                                                <td>${orderDetail.productQuantity}</td>
                                                <td>${(orderDetail.productPrice)*(orderDetail.productQuantity)}</td>
                                            </tr>
                                        </#list>
                                        </tbody>
                                    </table>
                                </div>

                <div class="col-md-12 column">
                    <#if orderMaster.orderStatus ==0 && orderMaster.payStatus ==0 >
                        <a href="/seller/order/cancel?orderId=${orderMaster.orderId}"
                           type="button" class="btn btn-default btn-danger">取消订单</a>
                    </#if>

                    <#if (orderMaster.orderStatus ==1  && orderMaster.payStatus ==1)
                        ||(orderMaster.orderStatus ==0  && orderMaster.payStatus ==1)
                    >
                        订单已完结，你还来隔着瞅啥呢！！！
                    </#if>
                </div>



            </div>
        </div>
    </div>
</div>
</body>
</html>