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