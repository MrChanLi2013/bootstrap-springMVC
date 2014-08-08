<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/common-tag.jsp" %>
<html>
<head>
    <title>用户注册</title>
    <%@include file="../common/import.jsp" %>
    <script type="text/javascript" src="/js/user/register.js"></script>
    <link href="/css/user/register.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<%@include file="../common/top.jsp" %>
<div class="container">
    <div class="container">
        <div class="row-fluid register-top-div">
            <div class="span6 text-left">
                <h5>立即注册</h5>
            </div>
            <div class="span6 text-right">
                <h6><a href="#">已有账号?现在登录</a></h6>
            </div>
        </div>
        <br/>
    </div>
    <div class="container" style="margin-left: 100px;">
        <div class="row-fluid">
            <div class="span7">
                <c:if test="${error != null}">
                    <div class="alert alert-block alert-error" role="alert" style="font-size: 13px">
                        <a class="close" data-dismiss="alert" href="#">x</a>

                        <p><strong>有 <c:out value="${error.size()}"/> 处问题导致无法提交:</strong></p>
                        <ul>
                            <c:forEach items="${error}" var="vector">
                                <li><c:out value="${vector.value}"/></li>
                            </c:forEach>
                        </ul>
                    </div>
                </c:if>
                <div>
                    <form class="form-horizontal" action="/user/add.do" method="post" id="register-from">
                        <div class="control-group">
                            <label class="control-label" for="username"><abbr title="required">*</abbr>用户名：</label>
                                <span id="checklist-username"
                                      style="position: absolute;left: 685px;zoom: 1;z-index: 20;display: none;">
                                    <div class="checklist-wrapper">
                                    <span class="checklist-arrow">
                                        <em class="arrowa">◆</em>
                                        <em class="arrowb">◆</em>
                                    </span>
                                        <ul class="checklist">
                                            <li class="checklist-item">长度为2~16个字符</li>
                                            <li class="checklist-item">支持数字,大小写字母和汉字</li>
                                            <li class="checklist-item">不允许有空格</li>
                                        </ul>
                                    </div>
                                </span>

                            <div class="controls">
                                <input type="text" name="username" id="username"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="password"><abbr title="required">*</abbr>密码：</label>
                            <span id="checklist-pwd"
                                  style="position: absolute;left: 685px;zoom: 1;z-index: 20;display: none;">
                                    <div class="checklist-wrapper">
                                    <span class="checklist-arrow">
                                        <em class="arrowa">◆</em>
                                        <em class="arrowb">◆</em>
                                    </span>
                                        <ul class="checklist">
                                            <li class="checklist-item">长度为6~16个字符</li>
                                            <li class="checklist-item">不允许有空格</li>
                                        </ul>
                                    </div>
                                </span>

                            <div class="controls">
                                <input type="password" name="password" id="password"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="confirm-password"><abbr
                                    title="required">*</abbr>确认密码：</label>

                            <div class="controls">
                                <input type="password" name="confirmPwd" id="confirm-password"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="email">电子邮箱：</label>

                            <div class="controls">
                                <input type="text" name="email" id="email"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="verificationCode"><abbr
                                    title="required">*</abbr>验证码：</label>

                            <div class="controls">
                                <input type="text" name="verificationCode" id="verificationCode"/>
                                <br/>
                                <img id="verificationImage" src="/getVerificationImage.do" style="margin-top: 10px;">
                                <span style="font-size: 12px;"><a href="#" onclick="refresh()">看不清？换一换</a></span>
                                <br/>
                            </div>
                        </div>
                        <br/>

                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="btn btn-primary">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="span4">
                <div class="reg-sms">
                    <h3 class="reg-sms-title">公告：</h3>

                    <div class="reg-sms-content">
                        <p>注册须知：这里是一群贪玩的女人，一群好的男人，一所快乐的家，一个情感停泊的中转码头，请思考思考思考在思考之后加入~~~</p>
                        <p>①未满18周岁人士请在指导下发帖。</p>
                        <p>②本论坛非管理人员，不得在论坛内泡本群的PLMM...</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../common/bottom.jsp" %>
</body>
<script type="text/javascript">
    function refresh() {
        document.getElementById("verificationImage").src = "/getVerificationImage.do?" + Math.random();
    }
</script>
</html>