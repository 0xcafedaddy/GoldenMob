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
        <header >
            <a class="logo" href="/">
                <span class="svg">
                <svg class="icon icon-newsdog" style="position: absolute; width: 0; height: 0;" width="0" height="0" version="1.1" >
					<img src="${ctx}/static/img/logo.svg"/>                	
                </svg>
                </span>
            </a> 
            <a class="download-app" href="/app">Download App</a>
        </header>

        <nav  class="navbar">
            <ul>
	            	<c:choose> 
            			<c:when test="${sessionScope.flag == '/' }">
            				<li  class="on"><a href="${ctx }/">For you</a></li>
            			</c:when>
            			<c:otherwise>
            				<li ><a href="${ctx }/">For you</a></li>
            			</c:otherwise>
            		</c:choose>
	            	
            		<c:choose> 
            			<c:when test="${sessionScope.flag == 'ent' }">
            				<li class="on"><a href="${ctx }/ent/" ">Entertainment</a></li>
            			</c:when>
            			<c:otherwise>
            				<li ><a href="${ctx }/ent/" ">Entertainment</a></li>
            			</c:otherwise>
            		</c:choose>
            		
            		<c:choose> 
            			<c:when test="${sessionScope.flag == 'politic' }">
            				<li class="on"><a href="${ctx }/politic/">Politic</a></li>
            			</c:when>
            			<c:otherwise>
            				<li ><a href="${ctx }/politic/">Politic</a></li>
            			</c:otherwise>
            		</c:choose>
	                	
	                <c:choose> 
            			<c:when test="${sessionScope.flag == 'sports' }">
            				<li class="on"><a href="${ctx }/sports/">Sports</a></li>
            			</c:when>
            			<c:otherwise>
            				 <li ><a href="${ctx }/sports/">Sports</a></li>
            			</c:otherwise>
            		</c:choose>	
	                <c:choose> 
            			<c:when test="${sessionScope.flag == 'health' }">
            				<li class="on"><a href="${ctx }/health/">Health</a></li>
            			</c:when>
            			<c:otherwise>
            				 <li ><a href="${ctx }/health/">Health</a></li>
            			</c:otherwise>
            		</c:choose>	
            		
            		 <c:choose> 
            			<c:when test="${sessionScope.flag == 'life' }">
            				<li class="on"><a href="${ctx }/life/">Life</a></li>
            			</c:when>
            			<c:otherwise>
            				 <li ><a href="${ctx }/life/">Life</a></li>
            			</c:otherwise>
            		</c:choose>	
            		
            		 <c:choose> 
            			<c:when test="${sessionScope.flag == 'fun' }">
            				<li class="on"><a href="${ctx }/fun/">Fun</a></li>
            			</c:when>
            			<c:otherwise>
            				<li ><a href="${ctx }/fun/">Fun</a></li>
            			</c:otherwise>
            		</c:choose>	 	
	                
	                 <c:choose> 
            			<c:when test="${sessionScope.flag == 'tech' }">
            				<li class="on"><a href="${ctx }/tech/">Technology</a></li>
            			</c:when>
            			<c:otherwise>
            				<li ><a href="${ctx }/tech/">Technology</a></li>
            			</c:otherwise>
            		</c:choose>	 	
            		
            		 <c:choose> 
            			<c:when test="${sessionScope.flag == 'arts' }">
            				<li class="on"><a href="${ctx }/arts/">Arts</a></li>
            			</c:when>
            			<c:otherwise>
            				<li ><a href="${ctx }/arts/">Arts</a></li>
            			</c:otherwise>
            		</c:choose>	 	
            		
            		 <c:choose> 
            			<c:when test="${sessionScope.flag == 'culture' }">
            				<li class="on"><a href="${ctx }/culture/">Culture</a></li>
            			</c:when>
            			<c:otherwise>
            				<li ><a href="${ctx }/culture/">Culture</a></li>
            			</c:otherwise>
            		</c:choose>	 	
	                
            		 <c:choose> 
            			<c:when test="${sessionScope.flag == 'business' }">
            				<li class="on"><a href="${ctx }/business/">Business</a></li>
            			</c:when>
            			<c:otherwise>
            				<li ><a href="${ctx }/business/">Business</a></li>
            			</c:otherwise>
            		</c:choose>	 	
	                
	                 <c:choose> 
            			<c:when test="${sessionScope.flag == 'fashion' }">
            				<li class="on"><a href="${ctx }/fashion/">Fashion</a></li>
            			</c:when>
            			<c:otherwise>
            				<li ><a href="${ctx }/fashion/">Fashion</a></li>
            			</c:otherwise>
            		</c:choose>	 	
	                
	                 <c:choose> 
            			<c:when test="${sessionScope.flag == 'motivation' }">
            				<li class="on"><a href="${ctx }/motivation/">Motivation</a></li>
            			</c:when>
            			<c:otherwise>
            				<li ><a href="${ctx }/motivation/">Motivation</a></li>
            			</c:otherwise>
            		</c:choose>	 	
            </ul>
        </nav>

        <div id="articles-wrapper">
        <div class="articles">
        
        
			<h5>${item.title }</h5>
			<img src="${item.imgURL }"></img>
		
        
        <c:forEach items="${sessionScope.itemList}" var="item" varStatus="vs">
		 <section class="one-images">
			<a href="${ctx}/a/?uuid=${item.uuid}&category=${item.category}&keywords=${item.keyWords}" target="_blank" style="min-height: 153.333px; padding-right: 210px;">
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
                
        <a class="nextPageBtn" href="?start="></a>
    
        </div>
        </div>
        <script type="text/javascript" src="http://static.newsdog.today/javascripts/lib/jquery-2.2.3.min.js"></script>
       
    </body>
</html>
