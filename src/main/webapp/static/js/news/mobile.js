function removeClass(obj, cls) {
    var c = ' ' + obj.className;
    var exp = new RegExp(' ' + cls, 'g');
    obj.className = c.replace(exp, '').replace(/^ /g, '');
}

function addClass(obj, cls) {
    var c = ' ' + obj.className;
    var exp = new RegExp(' ' + cls, 'g');
    obj.className = (c.replace(exp, '') + ' ' + cls).replace(/^ /g, '');
}

function hasClass(obj, cls) {
    var c = obj.classList;
    for (i in c) {
        if (cls == c[i]) {
            return true;
            break;
        }
    }
    return false;
}
Date.prototype.Format = function(fmt) {
        var theDate = this;
        var o = {
            "M+": theDate.getMonth() + 1, //月份
            "d+": theDate.getDate(), //日
            "h+": theDate.getHours(), //小时
            "m+": theDate.getMinutes(), //分
            "s+": theDate.getSeconds(), //秒
            "q+": Math.floor((theDate.getMonth() + 3) / 3), //季度
            "S": theDate.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (theDate.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
    //夜间模式
function setMode(flag) {
    if (["0", "1", 0, 1].indexOf(flag) < 0) return;
    flag = parseInt(flag);
    var cls = {
        0: "Day",
        1: "Night"
    };
    var b = document.querySelector("body");
    var cn = ' ' + b.className;
    b.className = (cn.replace(/ \w+Mode/g, '') + ' ' + cls[flag] + 'Mode').replace(/^ /g, '');
}
//字体大小
function setFont(flag) {
    if (["s", "m", "l", "xl"].indexOf(flag) < 0) return;
    var b = document.querySelector("body");
    var cn = ' ' + b.className;
    b.className = (cn.replace(/ font-\w+/g, '') + ' font-' + flag).replace(/^ /g, '');
}

function loadedImg(url, token) {
    var ctr = document.querySelector("." + token);
    var image = new Image();
    image.src = url;
    var imgComplete = function() {
        removeClass(ctr, "loading");
        ctr.innerHTML = "";
        ctr.appendChild(image);
        ctr.style["min-height"] = '0px';
        if (hasClass(ctr, "video")) {
            addClass(ctr, "hasVideo");
            var _leftPos = (ctr.offsetWidth - image.width) / 2;
            ctr.innerHTML = ctr.innerHTML + '\
            <video\
            poster="' + image.src + '"\
            style="left: ' + _leftPos + 'px; height:' + image.height + 'px;width: ' + image.width + 'px;"\
            width="' + image.width + '"\
            loop="loop"\
            muted="">\
            <source src="' + data.video + '"></source>\
            </video>\
            <span class="pause"></span>\
            <span class="overlay"></span>\
            <span class="play"></span>';
            var _video = ctr.querySelector("video");
            if (data.local_video) {
                _video.innerHTML = '<source src="' + data.local_video + '"></source>' + _video.innerHTML;
            }
            addClass(ctr, "paused");
            _video.addEventListener('timeupdate', function(d) {
                removeClass(ctr, "loadingVideo");
                addClass(ctr, "loadedVideo");
            }, false);
            ctr.querySelector(".overlay").onclick = function() {
                if (hasClass(ctr, "paused")) {
                    return;
                }
                if (hasClass(ctr, "pausing")) {
                    removeClass(ctr, "pausing");
                } else {
                    addClass(ctr, "pausing");
                }
            }
            ctr.querySelector(".pause").onclick = function() {
                addClass(ctr, "paused");
                removeClass(ctr, "pausing");
                _video.pause();
            }
            ctr.querySelector(".play").onclick = function() {
                removeClass(ctr, "paused");
                removeClass(ctr, "pausing");
                _video.play();
                addClass(ctr, "loadingVideo");
                removeClass(ctr, "loadedVideo");
            }
        }
    }
    if (!image.complete) {
        image.onload = function() {
            imgComplete();
        }
    } else {
        imgComplete();
    }
}
if ((data.subscribed === true || data.subscribed === false) && data.type == "article" && OS != "WEB") {
    addClass(document.querySelector("body"), "hasSubBar");
}
var players = [];

function onYouTubeIframeAPIReady() {
    for (i in data.youtube) {
        if (i == 0) {
            players[i] = new YT.Player('youtube_' + i, {
                height: document.getElementById("youtube_" + i).offsetHeight,
                width: document.getElementById("youtube_" + i).offsetWidth,
                videoId: data.youtube[i],
                events: {
                    'onReady': onPlayerReady,
                }
            });
        } else {
            players[i] = new YT.Player('youtube_' + i, {
                height: document.getElementById("youtube_" + i).offsetHeight,
                width: document.getElementById("youtube_" + i).offsetWidth,
                videoId: data.youtube[i]
            });
        }
    }
}

function onPlayerReady(event) {
    event.target.playVideo();
}

function pauseYoutube() {
    var res;
    for (i in players) {
        res = players[i].pauseVideo();
    }
    return res;
}

function playYoutube() {
    if (players[0]) {
        return players[0].playVideo();
    }
}

function loadData() {
    if (data.type == "joke" || data.type == "video" || data.type == "galary") {
        document.querySelector("title").innerHTML = data.content;
        data.related_images = data.top_images;
        for (i in data.related_images) {
            if (data.type == "joke") {
                data.content += "<a class=\"image\"></a>";
            }
        }
        if (data.type == "video" && data.video) {
            data.content += "<a class=\"video\"></a>";
        }
    }
    if (data.title) {
        document.querySelector("title").innerHTML = data.title;
    }
    addClass(document.querySelector(".nodata"), "hidden");
    removeClass(document.querySelector("header"), "hidden");
    removeClass(document.querySelector("article"), "hidden");
    removeClass(document.querySelector("footer"), "hidden");
    document.querySelector("header h1").innerHTML = data.title;
    var date = data.published_at || data.pubdate;
    if (!date) {
        addClass(document.querySelector("header .article-info .time"), "hidden");
    }
    if (!data.source) {
        addClass(document.querySelector("header .article-info .source"), "hidden");
    }
    if (!data.source_url) {
        addClass(document.querySelector("header .article-info .original"), "hidden");
    }
    if (date || data.source || data.source_url) {} else {
        addClass(document.querySelector("header .article-info"), "hidden");
    }
    if (!data.title) {
        addClass(document.querySelector("header h1"), "hidden");
    }
    if (date) {
        if (OS == "WEB") {
            document.querySelector("header .article-info .time").innerHTML = new Date(date).Format('MM-dd hh:mm');
        } else {
            document.querySelector("header .article-info .time").innerHTML = date;
        }
    }
    document.querySelector("header .article-info .source").innerHTML = data.source || data.site_name;
    document.querySelector("header .article-info .original").setAttribute("href", data.source_url || data.url);
    if (data.key_words) {
        for (i in data.key_words) {
            var exp = new RegExp('(\\\W)(' + data.key_words[i] + ')(\\\W)', 'g');
            data.content = data.content.replace(exp, '$1<a class="keyword">$2</a>$3');
        }
    }
    document.querySelector("article").innerHTML = data.content;
    if (data.youtube) {
        var tag = document.createElement('script');
        tag.src = "https://www.youtube.com/iframe_api";
        var firstScriptTag = document.getElementsByTagName('script')[0];
        firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
        var players = [];
        for (i in data.youtube) {
            players.push('');
            if (!document.querySelectorAll("youtube")[i]) {
                document.querySelector("article").innerHTML += "<a class=\"youtube\"></a>";
            }
            if (data.youtube.length == 1 && window.screen.width <= 768) {
                addClass(document.querySelector(".youtube"), 'onlyVideo');
                document.querySelector("body").innerHTML = '<div class="onlyVideoHidden"></div>' + document.querySelector("body").innerHTML;
            }
        }
        var youtubes = document.querySelectorAll('.youtube');
        for (var i = 0; i < youtubes.length; i++) {
            if (!data.youtube) {
                continue;
            }
            var style = document.body.currentStyle || document.defaultView.getComputedStyle(document.body, '');
            var youtubeWidth = document.querySelector("article").offsetWidth - 2 * parseInt(style.fontSize);
            if (youtubeWidth > 768) {
                youtubeWidth = 768;
            }
            var youtubeHeight = youtubeWidth * 9 / 16 + 50;
            if (data.youtube.length == 1 && window.screen.width <= 768) {
                youtubeWidth = Math.max(document.querySelector("article").offsetWidth, window.screen.width, document.body.clientWidth);
                if (youtubeWidth > 768) {
                    youtubeWidth = 768;
                }
                youtubeHeight = youtubeWidth * 9 / 16 + 50;
                if (document.querySelectorAll("nav").length > 0) {
                    addClass(document.querySelector(".youtube"), 'hasNav');
                    addClass(document.querySelector(".onlyVideoHidden"), 'hasNav');
                }
                document.querySelector(".onlyVideoHidden").style.height = youtubeHeight + "px";
            }
            //youtubes[i].innerHTML = '<iframe id="youtube_' + i + '" width="' + youtubeWidth + '" height="' + youtubeHeight + '" src="https://www.youtube.com/embed/' + data.youtube[i] + '?theme=light&autoplay=1&enablejsapi=1" frameborder="0" allowfullscreen></iframe>';
            youtubes[i].innerHTML = '<div id="youtube_' + i + '" width="' + youtubeWidth + '" height="' + youtubeHeight + '" style="height:' + youtubeHeight + 'px; width:' + youtubeWidth + 'px;"></div>';
        }
    }
    if (data.type == "galary") {
        data.related_images = data.top_images;
        for (i in data.related_images) {
            if (!document.querySelectorAll("image")[i]) {
                document.querySelector("article").innerHTML += "<a class=\"image\"></a>";
            }
        }
    }
    var style = document.body.currentStyle || document.defaultView.getComputedStyle(document.body, '');
    if (data.content.length > 2000 && document.querySelector("article").offsetHeight > 80 * parseInt(style.fontSize)) {
        addClass(document.querySelector("article"), "longArticle");
        document.querySelector("article").style.height = 70 * parseInt(style.fontSize) + 'px';
        if (hasClass(document.body, 'Hindi')) {
            document.querySelector("article").innerHTML = document.querySelector("article").innerHTML + '<a class="showAllNews">आगे पढ़ें</a>';
        } else {
            document.querySelector("article").innerHTML = document.querySelector("article").innerHTML + '<a class="showAllNews">Continue Reading</a>';
        }
    }
    if (document.querySelector(".showAllNews")) {
        document.querySelector(".showAllNews").onclick = function() {
            var offsetTop = this.offsetTop;
            removeClass(document.querySelector("article"), "longArticle");
            document.querySelector("article").style.height = 'auto';
            try {
                if (OS == "iOS") {
                    connectWebViewJavascriptBridge(function(bridge) {
                        bridge.callHandler("showAllNews", {
                            "offsetTop": offsetTop
                        }, null);
                    });
                } else if (OS == "Android") {
                    AndroidImgHandler.showAllNews(offsetTop); // 查看图片
                } else {
                    console.log("Need In App");
                }
            } catch (e) {
                console.error('Environment Error: Need in App');
            };
        }
    }
    var images = document.querySelectorAll('.image');
    for (var i = 0; i < images.length; i++) {
        if (!data.related_images[i]) {
            continue;
        }
        var h = images[i].offsetWidth * data.related_images[i].height / data.related_images[i].width;
        var rh = data.related_images[i].height;
        if (!h && !rh) {
            var h = images[i].offsetWidth * 9 / 16;
        }
        if (h < rh) {
            images[i].style["min-height"] = h + 'px';
        } else {
            images[i].style["min-height"] = rh + 'px';
        }
        switch (LOADIMG) {
            case "NONE":
                images[i].setAttribute("data-id", i);
                addClass(images[i], 'none');
                removeClass(images[i], 'thumb');
                break;
            case "OFFLINE":
                data.related_images[i].thumb = data.related_images[i].thumb ? data.related_images[i].thumb : data.related_images[i].url;
                images[i].style["min-height"] = rh + 'px';
                loadingImg(images[i], data.related_images[i].thumb, i);
                images[i].setAttribute("data-id", i);
                removeClass(images[i], 'thumb');
                removeClass(images[i], 'none');
                break;
            case "THUMB":
                data.related_images[i].thumb = data.related_images[i].thumb ? data.related_images[i].thumb : data.related_images[i].url;
                images[i].style["min-height"] = rh + 'px';
                loadingImg(images[i], data.related_images[i].thumb, i);
                images[i].setAttribute("data-id", i);
                addClass(images[i], 'thumb');
                removeClass(images[i], 'none');
                break;
            case "ORIGIN":
            default:
                loadingImg(images[i], data.related_images[i].origin, i);
                images[i].setAttribute("data-id", i);
                removeClass(images[i], 'thumb');
                removeClass(images[i], 'none');
                break;
        }
        images[i].onclick = function() {
            var _id = this.getAttribute("data-id");
            if (hasClass(this, "none") || hasClass(this, "thumb")) {
                loadingImg(this, data.related_images[_id].origin, _id, true);
                removeClass(this, 'thumb');
                removeClass(this, 'none');
                return false;
            } else {
                var imageHref = this.getAttribute("href");
                try {
                    if (OS == "iOS") {
                        connectWebViewJavascriptBridge(function(bridge) {
                            bridge.callHandler("clickImage", {
                                "imageIndex": _id
                            }, null);
                        });
                    } else if (OS == "Android") {
                        AndroidImgHandler.clickImageFromWebview(_id); // 查看图片
                    } else {
                        console.log("Need In App");
                    }
                    return false;
                } catch (e) {
                    console.log(_id);
                    console.error('Environment Error: Need in App');
                };
            }
        }
    }
    var video = document.querySelector('.video');
    if (video && data.related_images[0]) {
        var h = video.offsetWidth * data.related_images[0].height / data.related_images[0].width;
        var rh = data.related_images[0].height;
        if (!h && !rh) {
            var h = video.offsetWidth * 9 / 16;
        }
        if (h < rh) {
            video.style["min-height"] = h + 'px';
        } else {
            video.style["min-height"] = rh + 'px';
        }
        loadingImg(video, data.related_images[0].origin, 0);
        video.setAttribute("data-id", 0);
    }

    function s10() {
        var data = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"];
        var result = "";
        for (var i = 0; i < 10; i++) {
            var r = Math.floor(Math.random() * 62); //取得0-62间的随机数，目的是以此当下标取数组data里的值！
            result += data[r]; //输出20次随机数的同时，让rrr加20次，就是20位的随机字符串了。
        }
        return result;
    }

    function loadingImg(ctr, url, i, an) {
        addClass(ctr, "loading");
        if (an) {
            addClass(ctr, "an");
        }
        var token = 'pic_' + new Date().getTime() + s10();
        addClass(ctr, token);
        try {
            if (OS == 'iOS') {
                connectWebViewJavascriptBridge(function(bridge) {
                    bridge.callHandler("loadImage", {
                        "imageUrl": url,
                        "token": token
                    }, null);
                });
            } else if (OS == "Android") {
                AndroidImgHandler.loadImage(url, token); // 查看图片
            } else {
                loadedImg(url, token);
            }
            return false;
        } catch (e) {
            console.error('Environment Error: Need in App');
        };
    }
    var downloadUrl = "https://app.appsflyer.com/com.newsdog.lite?pid=Portal&c=keywords&af_r=http://newsdog.today/a/downloads/";
    if (location.href.match(/from=/)) {
        downloadUrl = "https://app.appsflyer.com/com.newsdog.lite?pid=Share&c=keywords&af_r=http://newsdog.today/a/downloads/";
    }
    var keywords = document.querySelectorAll('.keyword');
    if (OS == "WEB") {
        for (var i = 0; i < keywords.length; i++) {
            keywords[i].href = downloadUrl;
            keywords[i].target = "_blank";
        }
    } else {
        for (var i = 0; i < keywords.length; i++) {
            keywords[i].onclick = function() {
                var _keyword = this.innerHTML;
                if (OS == "iOS") {
                    connectWebViewJavascriptBridge(function(bridge) {
                        bridge.callHandler("searchKeyword", {
                            "keyword": _keyword
                        }, null);
                    });
                    return false;
                } else if (OS == "Android") {
                    AndroidImgHandler.clickKeyword(_keyword); // 关键字 搜索
                    return false;
                }
            }
        }
    }
    /*for(var i = 0; i<keywords.length;i++){
        if(OS == "WEB"){
            keywords[i].href = downloadUrl; 
        }else{
            keywords[i].onclick = function(){
                console.log(this.innerHTML);
                var _keyword = this.innerHTML;

                if(OS == "iOS"){
                    connectWebViewJavascriptBridge(function(bridge) {
                        bridge.callHandler("searchKeyword", {"keyword":_keyword}, null);
                    });
                }else if(OS == "Android"){
                    AndroidImgHandler.clickKeyword(_keyword);  // 关键字 搜索
                }else{
                    location.href = downloadUrl;
                }

            }
            return false;
        }

    }*/
    var original = document.querySelector(".original");
    original.onclick = function() {
        var _href = this.getAttribute("href");
        try {
            if (OS == "iOS") {
                connectWebViewJavascriptBridge(function(bridge) {
                    bridge.callHandler("clickURL", {
                        "url": _href
                    }, null);
                });
            } else if (OS == "Android") {
                AndroidImgHandler.clickNewsSource(_href); // 查看源
            } else {
                location.href = _href;
            }
            return false;
        } catch (e) {
            console.error('Environment Error: Need in App');
        };
        return false;
    }
}

function noData() {
    removeClass(document.querySelector(".nodata"), "hidden");
    addClass(document.querySelector("header"), "hidden");
    addClass(document.querySelector("article"), "hidden");
    addClass(document.querySelector("footer"), "hidden");
    document.querySelector(".nodata").onclick = function() {
        try {
            if (OS == "Android") {
                if (AndroidImgHandler.clickNoDataImg()) {
                    addClass(document.querySelector(".nodata"), "hidden");
                }
            } else if (OS == "iOS") {}
            return false;
        } catch (e) {
            console.error('Environment Error: Need in App');
        };
        return false;
    }
}
if (hasData) {
    loadData();
} else {
    noData();
}
var url = "http://m.onelink.me/ed2d56a0";
if (navigator.userAgent.match(/Android/)) {
    var url = "https://app.appsflyer.com/com.newsdog.lite?pid=Portal&c=Detail&af_r=http://newsdog.today/a/downloads/";
}
if (location.href.match(/from=/)) {
    var url = "https://app.appsflyer.com/com.newsdog.lite?pid=Share&c=Detail&af_r=http://newsdog.today/a/downloads/";
}
if (OS == "WEB") {
    document.querySelector(".app_download").href = url;
}
//iOS 需要的部分
function connectWebViewJavascriptBridge(callback) {
    if (window.WebViewJavascriptBridge) {
        callback(WebViewJavascriptBridge);
    } else {
        document.addEventListener('WebViewJavascriptBridgeReady', function() {
            callback(WebViewJavascriptBridge);
        }, false);
    }
}
connectWebViewJavascriptBridge(function(bridge) {
    bridge.init(function(message, responseCallback) {
        if (message.type == "font") {
            setFont(message.value);
        } else if (message.type == "color") {
            setMode(message.value);
        } else if (message.type == "imageUrl") {
            loadedImg(message.imageUrlValue, message.tokenValue);
        }
        if (responseCallback) {
            responseCallback();
        }
    })
})