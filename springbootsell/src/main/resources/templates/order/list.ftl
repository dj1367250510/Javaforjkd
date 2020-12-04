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
                    <h3>
                        订单主表页
                    </h3>
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>订单id</th>
                            <th>姓名</th>
                            <th>手机号</th>
                            <th>地址</th>
                            <th>金额</th>
                            <th>订单状态</th>
                            <th>支付状态</th>
                            <th>创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#--遍历获取订单列表-->
                        <#list orderMasterPage.content as orderMaster>
                            <tr>
                                <td>${orderMaster.orderId}</td>
                                <td>${orderMaster.buyerName}</td>
                                <td>${orderMaster.buyerPhone}</td>
                                <td>${orderMaster.buyerAddress}</td>
                                <td>${orderMaster.orderAmount}</td>
                                <td>
                                    <#if orderMaster.orderStatus == 0>
                                        新订单
                                    </#if>

                                    <#if orderMaster.orderStatus == 1>
                                        订单完结
                                    </#if>

                                    <#if orderMaster.orderStatus == 2>
                                        订单取消
                                    </#if>
                                </td>

                                <td>
                                    <#if orderMaster.payStatus == 0>
                                        等待支付
                                    </#if>

                                    <#if orderMaster.payStatus == 1>
                                        支付成功
                                    </#if>
                                </td>

                                <td>${orderMaster.createTime}</td>
                                <td>
                                    <a href="/seller/order/detail/list?orderId=${orderMaster.orderId}">订单详情</a>
                                </td>
                                <td>
                                    <#if orderMaster.orderStatus == 0 && orderMaster.payStatus == 0>
                                        <a href="/seller/order/cancel?orderId=${orderMaster.orderId}">订单取消</a>
                                    </#if>

                                    <#if orderMaster.orderStatus == 0 && orderMaster.payStatus == 1>
                                        <a href="/seller/order/cancel?orderId=${orderMaster.orderId}">订单完结</a>
                                    </#if>

                                    <#if orderMaster.orderStatus == 1 && orderMaster.payStatus == 1>
                                        订单完结
                                    </#if>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-12 column">
                    <#--                    pull-right 控件靠右-->
                    <ul class="pagination pull-right">

                        <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                            <#else >
                        <li ><a href="/seller/order/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                            </#if>

                            <#list 1..orderMasterPage.getTotalPages() as index>
                            <#if currentPage == index>
                        <li class="disabled"><a href="#">${index}</a></li>
                    <#else>
                        <li><a href="/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                        </#list>

                            <#if currentPage gte orderMasterPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                        <#else>
                        <li><a href="/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                        </#if>
                    </ul>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
