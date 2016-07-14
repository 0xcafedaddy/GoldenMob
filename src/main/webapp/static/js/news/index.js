$(function() {
    $.ajaxSetup({
        cache: true
    });
//    $.getScript('//connect.facebook.net/en_US/sdk/xfbml.ad.js?_=" + new Date().getTime() + "#xfbml=1&version=v2.5&appId=508207026019625', function() {
//        FB.init({
//            appId: '508207026019625',
//            xfbml: true,
//            version: 'v2.6' // or v2.0, v2.1, v2.2, v2.3
//        });
//        FB.Event.subscribe('ad.loaded', function(placementId) {
//            $(".facebookAd").not(".on").each(function() {
//                if ($(this).find("h2").text() != "") {
//                    $(this).addClass('on');
//                    $(this).children('div').css("opacity", 0);
//                    $(this).find("a").attr("target", "_blank");
//                }
//            });
//        });
//        FB.Event.subscribe('ad.error', function(errorCode, errorMessage, placementId) {
//            console.log('Audience Network error (' + errorCode + ') ' + errorMessage);
//        });
//    });
    var url = "http://www.qq.com";
    if (navigator.userAgent.match(/Android/)) {
    	//设置不显示头
    	
    	var url = "http://cn.bing.com";
    }
    $("body").append($('<div class="bar">\
    <div class="close_btn">\
    </div>\
    <div class="icon">\
    </div>\
    <div class="text">\
    <h6>\
    NewsDog\
    </h6>\
    <span>\
    Not using <b>DailyMasala</b> yet?\
    </span>\
    </div>\
    <a class="app_download" href="'+url+'" target="_blank">\
    Get App\
    </a>\
    <div class="bar-hidden">\
    </div>\
    </div>'));
    var marginLeft = $("nav li.on").offset().left - ($(window).width() - $("nav li.on").width()) / 2;
    $("nav").scrollLeft(marginLeft);
    var imgWidth = (Math.min($(window).width(), 640) - 20 - 20) / 3;
    var imgHeight = imgWidth * 2 / 3;
    $(".image").width(imgWidth);
    $(".image").height(imgHeight);
    $(".image").each(function(i, e) {
        if ($(this).data("width") / $(this).data("height") > 3 / 2) {
            $(this).addClass('h100');
        }
    });
    $(".one-images a").css('min-height', imgHeight + 20).css("padding-right", imgWidth + 10);
    /*var myScroll = new IScroll('#articles-wrapper', {
    mouseWheel: true
    });
    myScroll.on("scrollEnd", function() {
    var all = $("#articles-wrapper").height() - $("#articles-wrapper .articles").height();
    if (this.y - all < 50 && this.directionY == 1) {
    loadNextPage();
    }
    });*/
    $('img').each(function() {
        if ($(this).height() > 20) {
            if ($(this).width() / $(this).height() > 3 / 2) {
                $(this).closest('.image').addClass('h100');
            }
        }
        $(this).addClass('show');
    });
    $('img').load(function() {
        if ($(this).width() / $(this).height() > 3 / 2) {
            $(this).closest('.image').addClass('h100');
        }
        $(this).addClass('show');
    });
    var urls = [
        [0, location.href]
    ];
    $(document).scroll(function(event) {
        if ($(document).height() - $(window).height() - $(document).scrollTop() < 50) {
            loadNextPage($(document).scrollTop());
        }
        for (i in urls) {
            if ($(document).scrollTop() < urls[i][0]) {
                //history.pushState(urls[i-1], '', urls[i-1][1]);
                if (urls[i - 1]) {
                    history.replaceState(urls[i - 1], '', urls[i - 1][1]);
                }
                break;
            }
        }
    });
    
    var count = 10;
    
    var loadNextPage = function(scrollTop) {
    	
        if ($(".nextPageBtn").hasClass('loading')) {
            return false;
        }
        
        var url = $(".nextPageBtn").attr("href");
        $(".nextPageBtn").addClass('loading');
        
        console.log("url1:"+url);
        var str = "&start=5";

        //url = url + "&start="+count;
        url = url + count;
        console.log("url2:"+url);
        //alert(url);

        $.get(url, function(d) {
        	count+=10;
            $(".articles .nextPageBtn").remove();
            var sections = $($(d).find(".articles").html());
            //sections.data("url", url);
  
            sections.appendTo('.articles');
            $(".image").width(imgWidth);
            $(".image").height(imgHeight);
            $(".image").each(function(i, e) {
                if ($(this).data("width") / $(this).data("height") > 3 / 2) {
                    $(this).addClass('h100');
                }
            });
            $(".one-images a").css('min-height', imgHeight + 20).css("padding-right", imgWidth + 10);
            urls.push([scrollTop, url]);
            history.pushState([scrollTop, url], '', url);
            //myScroll.refresh();
            $('img').unbind().load(function() {
                if ($(this).width() / $(this).height() > 3 / 2) {
                    $(this).closest('.image').addClass('h100');
                }
                $(this).addClass('show');
            });
        });
        
        
        //定义全局变量
        var category = null;
        
        //获取类别
        function getCategory(cate){
        	//this.category = $('#category').val();
        	this.category = cate;
        	alert(category);
        }
       // $.get("");
//        $.getScript('//connect.facebook.net/en_US/sdk/xfbml.ad.js?_=" + new Date().getTime() + "#xfbml=1&version=v2.5&appId=508207026019625', function() {
//            FB.init({
//                appId: '508207026019625',
//                xfbml: true,
//                version: 'v2.6' // or v2.0, v2.1, v2.2, v2.3
//            });
//            FB.Event.subscribe('ad.loaded', function(placementId) {
//                $(".facebookAd").not(".on").each(function() {
//                    if ($(this).find("h2").text() != "") {
//                        $(this).addClass('on');
//                        $(this).children('div').css("opacity", 0);
//                        $(this).find("a").attr("target", "_blank");
//                    }
//                });
//            });
//            FB.Event.subscribe('ad.error', function(errorCode, errorMessage, placementId) {
//                console.log('Audience Network error (' + errorCode + ') ' + errorMessage);
//            });
//        });
    }
})