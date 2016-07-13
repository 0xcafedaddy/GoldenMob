<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" href="${ctx}/static/css/style.css">
    <script src="${ctx}/static/js/lib/jquery-2.2.3.min.js"></script>
    <script src="${ctx}/static/js/news/index.js"></script>
        <title>
            NewsDog - Entertainment India News - NewsDog
        </title>
        <meta http-equiv=Content-Type content="text/html;charset=utf-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0"/>
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" type="text/css" href="./css/style.css"/>
        <meta property="description" content='xxx is the SMALLEST India news app'/>
        <meta property="keywords" content="India news"/>
        <meta property="og:title" content="NewsDog - Entertainment India News"/>
        <meta property="og:url" content=""/>
        <meta property="og:type" content="site"/>
        <meta property="og:image" content=""/>
     
    </head>
    <body class="en">
        <header>
            <a class="logo" href="/">
                <span class="svg"><svg class="icon icon-newsdog"><use xlink:href="#icon-newsdog"></use></svg></span>
            </a> 
            <a class="facebook-like" href="https://www.facebook.com/newsdogapp/" target="_blank"><span class="svg"><svg class="icon icon-facebook"><use xlink:href="#icon-Facebook"></use></svg></span>Follow Us</a>
            <a class="download-app" href="/app">Download App</a>
        </header>

        <nav  class="navbar">
            <ul>
                
                <li ><a href="/">For you</a></li>
                <li class="on"><a href="/entertainment/">Entertainment</a></li>
                <li ><a href="./politic/">Politic</a></li>
                <li ><a href="./ent/">Entertainment</a></li>
                <li ><a href="./sports/">Sports</a></li>
                <li ><a href="./health/">Health</a></li>
                <li ><a href="./life/">Life</a></li>
                <li ><a href="./fun/">Fun</a></li>
                <li ><a href="./tech/">Technology</a></li>
                <li ><a href="./arts/">Arts</a></li>
                <li ><a href="./culture/">Culture</a></li>
                <li ><a href="./business/">Business</a></li>
                <li ><a href="./fashion/">Fashion</a></li>
                <li ><a href="./motivation/">Motivation</a></li>
            </ul>
        </nav>

        <div id="articles-wrapper">
        <div class="articles">
        
        
			<h5>${item.title }</h5>
			<img src="${item.imgURL }"></img>
		
        
        <c:forEach items="${sessionScope.itemList}" var="item" varStatus="vs">
		 <section class="one-images">
			<a href="/a/article/5783200276f3dfd9674ed057/" target="_blank" style="min-height: 153.333px; padding-right: 210px;">
				<h2 class="title">${item.title }</h2>
				<div class="images">
					<span class="image" data-width="200" data-height="350" style="width: 200px; height: 133.333px;">
					<img src="${item.imgURL}" class="show"></span>
				</div>
				<span class="meta-hidden"></span>
				
				<span class="meta">
					<span class="source">${item.author }</span>
					<span class="time">${item.postDate }</span> 
				</span>
			</a>
		</section>
        </c:forEach>
        
       
                
        <a class="nextPageBtn" href="?read_tag='fun'"></a>
    
        </div>
        </div>
        <script type="text/javascript" src="http://static.newsdog.today/javascripts/lib/jquery-2.2.3.min.js"></script>
        <script type="text/javascript" src="http://static.newsdog.today/javascripts/news/index.js"></script>

    </body>
</html>
