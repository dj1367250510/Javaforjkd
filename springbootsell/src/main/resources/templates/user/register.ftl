<html lang ="zh">
<#include "../common/header.ftl">
<body>
<div class="container col-md-offset-4 col-lg-offse-4col-xl-offset-4" style=" padding-top: 250px">
    <div class="row clearfix">
        <div class="col-md-12 column" >
            <form class="form-horizontal" role="form" action="/seller/user/register" method="post">
                <div class="form-group">
                    <label for="inputOpenid" class="col-sm-2 control-label">用户账号</label>
                    <div class="col-sm-10">
                        <input name="openid" type="text" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputUsername" class="col-sm-2 control-label">用户姓名</label>
                    <div class="col-sm-10">
                        <input number="username" type="text" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">用户密码</label>
                    <div class="col-sm-10">
                        <input name="password" type="password" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">确认密码</label>
                    <div class="col-sm-10">
                        <input name="password" type="password" />
                    </div>
                </div>

                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">提交</button>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>