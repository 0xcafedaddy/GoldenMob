<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
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



<title>${sessionScope.article.title }</title>
<script src="${ctx}/static/js/lib/jquery-2.2.3.min.js"></script>
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/mobile.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/holga.css" />
<meta property="og:image" content="${sessionScope.article.imgURL }">

<style>
#ad_root {
	display: none;
	font-size: 14px;
	min-height: 250px;
	line-height: 16px;
	position: relative;
	margin: 0px 1em 1.5em;
	background-color: #F6F6F6;
	border-radius: 4px;
	border: 1px solid #DCDCDC;
}

.thirdPartyMediaClass {
	height: 157px;
	width: 100%;
}

.thirdPartyTitleClass {
	font-weight: 600;
	font-size: 16px;
	margin: 8px 10px 4px 10px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	color: #333;
}

.thirdPartyBodyClass {
	display: -webkit-box;
	-webkit-line-clamp: 2;
	overflow: hidden;
	color: #333;
	margin: 8px 10px 4px 10px;
}

.thirdPartyCallToActionClass {
	color: #e70034;
	font-weight: 600;
	margin: 8px 10px 15px 10px;
	display: inline-block;
	padding: 6px 20px;
	border: 1px solid #e70034;
	border-radius: 4px;
}
</style>

</head>
<body class="web en">

	<svg style="position: absolute; width: 0; height: 0;" width="0"
		height="0" version="1.1" xmlns="http://www.w3.org/2000/svg"
		xmlns:xlink="http://www.w3.org/1999/xlink">
<defs>
<symbol id="icon-masala" viewBox="0 0 149 32">
<path class="path1"
			d="M1.3 25.7V3h8c2.7 0 5 .8 6.8 2.6 2 1.8 2.8 4 2.8 7V16c0 2.8-1 5-2.7 6.8-1.7 1.8-4 2.7-6.8 2.7h-8zM5.8 6.5v15.7h3.4c1.5 0 2.7-.6 3.6-1.7 1-1 1.4-2.5 1.4-4.3v-3.8c0-1.7-.5-3-1.4-4.3-1-1-2-1.5-3.6-1.5H5.8zM32 25.7c0-.4-.3-.8-.4-1.2l-.2-1.3c-.5.8-1 1.5-2 2-.7.6-1.6.8-2.7.8-1.7 0-3-.4-4-1.3-1-1-1.5-2.2-1.5-3.8 0-1.7.7-3 2-4 1.2-.8 3-1.3 5.5-1.3h2.6v-1.3c0-.8-.2-1.5-.7-2-.4-.4-1-.6-2-.6-.6 0-1.2.2-1.6.5-.4.4-.6 1-.6 1.5H22c0-1.5.5-2.7 2-3.8 1.2-1 3-1.5 5-1.5s3.7.5 5 1.5 1.8 2.5 1.8 4.4v7c0 .8 0 1.5.2 2.2 0 .7.3 1.4.6 2H32zm-4-3c.7 0 1.4-.3 2-.6.6-.3 1-.8 1.3-1.3v-2.4h-2.6c-1 0-1.7.2-2.2.7-.5.5-.7 1-.7 1.8 0 .5.2 1 .5 1.3.4.5 1 .6 1.6.6zM44 4.8h-4.5V1.3H44v3.5zm0 21h-4.5v-17H44v17zM52.6 25.7H48V1.3h4.6v24.4zM62.4 18.6l.2 1L66 8.7h4.8L64 28.2c-.5 1.2-1 2.2-2 3-.8 1-2 1.3-3.7 1.3h-1L56 32l.6-3.4h.9c.7 0 1.3 0 1.7-.4l1-1.4.5-1.3-6-17h5l2.7 10zM92.7 19.7l6-16.7h6v22.7H100V10.2l-5.6 15.5h-3L85.5 10v15.7H81V3h6l5.7 16.7zM118.4 25.7c0-.4-.3-.8-.4-1.2 0-.5-.2-1-.3-1.3-.4.8-1 1.5-1.8 2-1 .6-1.8.8-3 .8-1.6 0-3-.4-4-1.3-1-1-1.4-2.2-1.4-3.8 0-1.7.7-3 2-4 1.2-.8 3-1.3 5.5-1.3h2.7v-1.3c0-.8-.2-1.5-.7-2-.4-.4-1-.6-2-.6-.6 0-1.2.2-1.6.5-.4.4-.6 1-.6 1.5h-4.4c0-1.5.5-2.7 2-3.8 1.2-1 3-1.5 5-1.5s3.7.5 5 1.5c1.2 1 1.8 2.5 1.8 4.4v7c0 .8 0 1.5.2 2.2 0 .7.3 1.4.6 2h-4.6zm-4-3c.7 0 1.4-.3 2-.6.6-.3 1-.8 1.3-1.3v-2.4H115c-1 0-1.6.2-2 .7-.6.5-.8 1-.8 1.8 0 .5.2 1 .5 1.3.4.5 1 .6 1.6.6zM134.8 21c0-.5-.3-1-.7-1.3-.4-.3-1.3-.7-2.6-1-2-.3-3.5-1-4.5-1.7-1.2-.8-1.7-2-1.7-3.3 0-1.4.6-2.7 2-3.7 1-1 2.7-1.5 4.8-1.5 2.2 0 4 .5 5.2 1.5 1.3 1 2 2.3 2 3.8H134.5c0-.6-.2-1-.6-1.5-.5-.5-1-.7-2-.7-.7 0-1.2.2-1.7.6-.4.3-.6.8-.6 1.3s.2 1 .7 1.3c.4.3 1.3.6 2.7 1 2 .3 3.7 1 4.7 1.7 1 .8 1.5 2 1.5 3.3 0 1.6-.6 2.8-2 3.8-1.2 1-3 1.4-5 1.4-2.3 0-4-.5-5.4-1.7-1.3-1-2-2.4-2-4h4.3c0 1 .4 1.6 1 2 .6.4 1.3.6 2.2.6.8 0 1.5-.3 2-.6.4-.3.6-.8.6-1.4zM152 25.7l-.3-1.2c0-.5-.2-1-.3-1.3-.4.8-1 1.5-1.8 2-.8.6-1.7.8-2.8.8-1.8 0-3-.4-4-1.3-1-1-1.5-2.2-1.5-3.8 0-1.7.6-3 2-4 1.2-.8 3-1.3 5.5-1.3h2.5v-1.3c0-.8-.2-1.5-.6-2-.4-.4-1-.6-2-.6-.6 0-1.2.2-1.6.5-.3.4-.5 1-.5 1.5H142c0-1.5.6-2.7 2-3.8 1.2-1 3-1.5 5-1.5s3.8.5 5 1.5c1.3 1 2 2.5 2 4.4v9.2l.7 2H152zm-4-3c.7 0 1.4-.3 2-.6.7-.3 1-.8 1.3-1.3v-2.4h-2.5c-1 0-1.7.2-2.2.7-.5.5-.8 1-.8 1.8 0 .5.2 1 .6 1.3.4.5 1 .6 1.5.6zM164 25.7h-4.4V1.3h4.5v24.4zM177.8 25.7c0-.4-.3-.8-.4-1.2 0-.5-.2-1-.3-1.3-.3.8-1 1.5-1.7 2-.8.6-1.7.8-2.8.8-1.7 0-3-.4-4-1.3-1-1-1.5-2.2-1.5-3.8 0-1.7.6-3 2-4 1.2-.8 3-1.3 5.5-1.3h2.6v-1.3c0-.8-.2-1.5-.6-2-.4-.4-1-.6-2-.6-.6 0-1.2.2-1.6.5-.4.4-.6 1-.6 1.5h-4.4c0-1.5.5-2.7 2-3.8 1.2-1 3-1.5 5-1.5s3.7.5 5 1.5c1.2 1 1.8 2.5 1.8 4.4v7c0 .8 0 1.5.2 2.2 0 .7.3 1.4.6 2h-4.6zm-4-3c.6 0 1.4-.3 2-.6.6-.3 1-.8 1.3-1.3v-2.4h-2.5c-1 0-1.7.2-2.2.7-.5.5-.7 1-.7 1.8 0 .5 0 1 .5 1.3.5.5 1 .6 1.7.6z" /></symbol>
</defs>
</svg>
	<nav>
		<a class="logo" href="/"> <span class="svg"><svg
					class="icon icon-masala">
					<use xlink:href="#icon-masala"></use></svg>
		</span> </a> <a class="download-app" href="${ctx }/app">Download App</a>
	</nav>
	<div class="nav-hidden"></div>
	<div class="navbar">
		<ul>
			<c:choose>
				<c:when test="${sessionScope.flag == '/' }">
					<li class="on"><a href="${ctx }/">For you</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="${ctx }/">For you</a>
					</li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${sessionScope.flag == 'ent' }">
					<li class="on"><a href="${ctx }/ent/"">Entertainment</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="${ctx }/ent/"">Entertainment</a>
					</li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${sessionScope.flag == 'politic' }">
					<li class="on"><a href="${ctx }/politic/">Politic</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="${ctx }/politic/">Politic</a>
					</li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${sessionScope.flag == 'sports' }">
					<li class="on"><a href="${ctx }/sports/">Sports</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="${ctx }/sports/">Sports</a>
					</li>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${sessionScope.flag == 'health' }">
					<li class="on"><a href="${ctx }/health/">Health</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="${ctx }/health/">Health</a>
					</li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${sessionScope.flag == 'life' }">
					<li class="on"><a href="${ctx }/life/">Life</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="${ctx }/life/">Life</a>
					</li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${sessionScope.flag == 'fun' }">
					<li class="on"><a href="${ctx }/fun/">Fun</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="${ctx }/fun/">Fun</a>
					</li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${sessionScope.flag == 'tech' }">
					<li class="on"><a href="${ctx }/tech/">Technology</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="${ctx }/tech/">Technology</a>
					</li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${sessionScope.flag == 'arts' }">
					<li class="on"><a href="${ctx }/arts/">Arts</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="${ctx }/arts/">Arts</a>
					</li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${sessionScope.flag == 'culture' }">
					<li class="on"><a href="${ctx }/culture/">Culture</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="${ctx }/culture/">Culture</a>
					</li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${sessionScope.flag == 'business' }">
					<li class="on"><a href="${ctx }/business/">Business</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="${ctx }/business/">Business</a>
					</li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${sessionScope.flag == 'fashion' }">
					<li class="on"><a href="${ctx }/fashion/">Fashion</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="${ctx }/fashion/">Fashion</a>
					</li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${sessionScope.flag == 'motivation' }">
					<li class="on"><a href="${ctx }/motivation/">Motivation</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="${ctx }/motivation/">Motivation</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>

	<!-- 文章标题 -->
	<header>
		<h1>${sessionScope.article.title }</h1>
		<section class="article-info">
			<span class="time"> ${sessionScope.article.add_time } </span>
		</section>
		<b> </b>
	</header>


	<!-- 文章内容 -->
	<article>
	<div class="content">
	${sessionScope.article.content }
	</div>
	</article>
	<h3 class="related_articles_header ">Related stories</h3>
	<ul class="related_articles">
		<c:forEach items="${sessionScope.relatedItem }" var="item">
			<li><a href="${ctx}/detial/?id=${item.uuid}" target="_blank">
				<span class="related_articles_img" style="background-image:url(${item.imgURL}), url(${ctx }/static/img/dm.png);"></span> 
				<span class="related_articles_text">${item.title }</span> </a></li>
		</c:forEach>
	</ul>
	<script type="text/javascript" src="${ctx }/static/js/news/mobile.js"></script>
	<div class="bar-hidden"></div>
</body>
</html>
