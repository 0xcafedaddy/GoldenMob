<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<link rel="shortcut icon" href="${ctx }/static/img/favicon.ico">
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-81626726-1', 'auto');
  ga('send', 'pageview');

</script>


	<style type="text/css">
		.app-banner-words{
		    margin-top: 3%;
    		margin-left: 42%;
			float:left;color:#fff}
		.app-banner-words-one{font-size:48px}
		.app-banner-words-two{font-size:20px;margin-top:10px}
		.app-banner-words-down{
		width:430px;
		height:144px;
		background:url('${ctx}/static/img/down.png') no-repeat;
		position:relative;
		margin:50px 0 0}
		.app-banner-words-down>a{width:265px;height:60px;display:block;position:absolute}
		.appinfo,.slide,.slide_pic{position:relative}
		.app-banner-words-downiph{top:0;left:0}
		.app-banner-words-downand{top:83px;left:0}
	</style>

</head>
<body style="background-image: url("${ctx }/static/img/bg.png"); background-attachment: fixed;">
	<div class="app-banner-words">
            <div class="app-banner-words-down">
                <a href="https://itunes.apple.com/us/app/daily-masala/id1124754706?mt=8" class="app-banner-words-downiph"></a>
                <a href="https://play.google.com/store/apps/details?id=com.masala.susyimes.holga" class="app-banner-words-downand"></a>
            </div>
        </div>
</body>
</html>