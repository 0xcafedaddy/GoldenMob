<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <title>
            ${sessionScope.article.title }
        </title>
        
        <link rel="stylesheet" type="text/css" href="http://static.newsdog.today/stylesheets/mobile.css"/>
       
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
        border:1px solid #DCDCDC;
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
        border:1px solid #e70034;
        border-radius: 4px;
      }
    </style>

    </head>
    <body class="web en">
<svg style="position: absolute; width: 0; height: 0;" width="0" height="0" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
<defs>

</defs>
</svg>
        <nav>
            <a class="logo" href="/">
                <span class="svg"><svg class="icon icon-newsdog"><use xlink:href="#icon-newsdog"></use></svg></span>
            </a> 
            <a class="facebook-like" href="https://www.facebook.com/newsdogapp/" target="_blank"><span class="svg"><svg class="icon icon-facebook"><use xlink:href="#icon-Facebook"></use></svg></span>Follow Us</a>
            <a class="download-app" href="/app">Download App</a>
        </nav>
        <div class="nav-hidden">
        </div>
        <div  class="navbar">
            <ul>
                <li class="on"><a href="${ctx }/">For you</a></li>
                <li ><a href="${ctx }/ent/" >Entertainment</a></li>
                <li ><a href="${ctx }/politic/">Politic</a></li>
                <li ><a href="${ctx }/sports/">Sports</a></li>
                <li ><a href="${ctx }/health/">Health</a></li>
                <li ><a href="${ctx }/life/">Life</a></li>
                <li ><a href="${ctx }/fun/">Fun</a></li>
                <li ><a href="${ctx }/tech/">Technology</a></li>
                <li ><a href="${ctx }/arts/">Arts</a></li>
                <li ><a href="${ctx }/culture/">Culture</a></li>
                <li ><a href="${ctx }/business/">Business</a></li>
                <li ><a href="${ctx }/fashion/">Fashion</a></li>
                <li ><a href="${ctx }/motivation/">Motivation</a></li>
            </ul>
        </div>



        <header >
            <h1>${sessionScope.article.title }
            </h1>
            <section class="article-info">
                <span class="time">
				${sessionScope.article.add_time }
                </span>
                <span class="source">
                tollywood.net
                </span>
                /
                <a class="original">
                    View source
                </a>
            </section>
            <b>
            </b>
        </header>
        <article >
            
       	${sessionScope.article.content }
           

        </article>
    <div class="fb-ad" data-placementid="508207026019625_602505163256477" data-format="native" data-nativeadid="ad_root" data-testmode="false"></div>
    <div id="ad_root">
      <a class="fbAdLink">
        <div class="fbAdMedia thirdPartyMediaClass"></div>
        <div class="fbAdTitle thirdPartyTitleClass"></div>
        <div class="fbAdBody thirdPartyBodyClass"></div>
        <div class="fbAdCallToAction thirdPartyCallToActionClass">Ad</div>
      </a>
    </div>
        <h3 class="related_articles_header hidden">Related stories</h3>
        <ul class="related_articles"></ul>
        <footer class="hidden">
        </footer>
        <div class="bar">
            <div class="close_btn">
            </div>
            <div class="icon">
            </div>
            <div class="text">
                <h6>
                    NewsDog
                </h6>
                <span>
                    Not using <b>NewsDog</b> yet?
                </span>
            </div>
            <!--<a class="app_download" href = "http://m.onelink.me/ed2d56a0" target="_blank">
                Get App
            </a>-->
            <a class="app_download" href="https://app.appsflyer.com/com.newsdog.lite?pid=Portal&c=Detail&af_r=http://newsdog.today/a/downloads/" target="_blank">
                Get App
            </a>
        </div>
        <div class="bar-hidden">
        </div>
        <section class="nodata hidden">
        </section>
        
 </body>
 </html>       
        