<%--
  Created by IntelliJ IDEA.
  User: chenli
  Date: 14-1-6
  Time: 下午3:35
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer class="footer">
    <div class="row-fluid">
        <div class="span3 offset3 text-left">
            <p class="bottom-p"><a href="#" class="custom-a">© 2012-2013  三峡学院_重庆三峡学院官方论坛</a></p>
            <p class="bottom-p"><a href="#" class="custom-a">Powered by  重庆三峡学院08级信息与计算科学承建</a></p>
        </div>
        <div class="span4 offset1 text-right">
            <p class="bottom-p">
                <a href="#" class="custom-a">手机版 | 三峡学院_重庆三峡学院官方论坛 (黑ICP备13002212号-1)</a>
                <a title="防水墙保卫网站远离侵害" target="_blank" href="http://discuz.qq.com/service/security">
                    <img src="/img/security.png">
                </a>
            </p>
            <p class="bottom-p1">
                GMT+8, 2014-1-6 15:30 , Processed in 1.033987 second(s), 12 queries
            </p>
        </div>
    </div>
</footer>

<script type="text/javascript">
    $(document).ready(ResetPosition);
    $(window).resize(ResetPosition);
    function ResetPosition() {
        var $footer = $('.footer');
        $footer.css("top", $(window).height() - $footer.height());
    }
</script>