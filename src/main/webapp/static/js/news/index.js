$(function() {
    $.ajaxSetup({
        cache: true
    });
    
    var url = "https://itunes.apple.com/us/app/daily-masala/id1124754706?mt=8";
    if (navigator.userAgent.match(/Android/)) {
    	//设置不显示头
    	var url = "https://play.google.com/store/apps/details?id=com.masala.susyimes.holga";
    }
    $("body").append($('<div class="bar">\
    <div class="close_btn">\
    </div>\
    <div class="icon">\
    </div>\
    <div class="text">\
    <h6>\
    DailyMasala\
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

        url = url + count;

        $.get(url, function(d) {
        	count+=10;
            $(".articles .nextPageBtn").remove();
            var sections = $($(d).find(".articles").html());
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
            $('img').unbind().load(function() {
                if ($(this).width() / $(this).height() > 3 / 2) {
                    $(this).closest('.image').addClass('h100');
                }
                $(this).addClass('show');
            });
        });
        
    }
})