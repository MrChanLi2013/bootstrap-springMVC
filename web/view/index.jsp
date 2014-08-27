<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/common-tag.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <%@include file="common/import.jsp" %>
    <title>bootstrap事例</title>
    <link href="/css/home/home.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<%@include file="common/top.jsp" %>
<div class="container">
    <div>
        <div id="myCarousel" class="carousel slide">
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class=""></li>
                <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="2" class=""></li>
            </ol>
            <div class="carousel-inner">
                <div class="item">
                    <img src="/img/banner01.jpg" alt="">
                </div>
                <div class="item">
                    <img src="/img/banner03.jpg" alt="">
                </div>
                <div class="item active">
                    <img src="/img/gklqcx2014.jpg" alt="">
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
        </div>
    </div>
</div>

<div class="container">
    <div class="row-fluid">
        <div class="span5">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#snews" data-toggle="tab"><strong>学校新闻</strong></a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="snews">
                    <c:if test="${newsList != null}">
                        <ul class="news">
                            <c:forEach items="${newsList}" var="news">
                                <li>
                                    <a href="#">${news.title}</a>
                                    <span><fmt:formatDate value="${news.createdAt}" pattern="yyyy-MM-dd"/></span>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="span5">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#sgonggao" data-toggle="tab"><strong>通知公告</strong></a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="sgonggao">
                    <ul class="news">
                        <li>
                            <a href="#">重庆三峡学院2014级新生入学报到安排</a>
                            <span>2014-08-21</span>
                        </li>
                        <li>
                            <a href="#">关于校园网临时中断的通知</a>
                            <span>2014-08-18</span>
                        </li>
                        <li>
                            <a href="#">关于数字校园数据库维护通知</a>
                            <span>2014-08-12</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="span2">
            <img src="../img/xiaoxun.jpg" style="height: 240px;width: 200px">
        </div>
    </div>
</div>
<%@include file="common/bottom.jsp" %>
</body>
</html>