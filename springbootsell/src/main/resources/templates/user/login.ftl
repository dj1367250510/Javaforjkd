<html lang ="zh">
<#include "../common/header.ftl">
<body>
<div class="container col-md-offset-4 col-lg-offse-4col-xl-offset-4" style=" padding-top: 250px">
    <div class="row clearfix">
        <div class="col-md-12 column" >
            <form class="form-horizontal" role="form" action="/seller/user/login" method="post">
                <div class="form-group">
                    <label for="inputOpenid" class="col-sm-2 control-label">用户账号</label>
                    <div class="col-sm-10">
                        <input name="openid" type="text" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">用户密码</label>
                    <div class="col-sm-10">
                        <input name="password" type="password" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label><input type="checkbox" />记住密码</label>
                        </div>
                    </div>
                </div>

                <span class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">登录</button>
                    <a href="/seller/user/register">
                        <button type="button" class="btn btn-default">注册</button>
                    </a>
                </span>
            </form>
        </div>
    </div>
</div>
</body>
</html>