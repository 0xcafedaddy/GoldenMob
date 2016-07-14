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
                <li ><a href="/">For you</a></li>
                <li ><a href="/entertainment/">Entertainment</a></li>
                <!--<li><a href="/videos/">Videos</a></li>
                <li><a href="/photos/">Photos</a></li>
                <li><a href="/gifs/">Gifs</a></li>-->
                <li ><a href="/cricket/">Cricket</a></li>
                <li ><a href="/politics/">Politics</a></li>
                <li ><a href="/technology/">Technology</a></li>
                <li ><a href="/health/">Health</a></li>
                <li ><a href="/lifestyle/">Lifestyle</a></li>
                <li ><a href="/sports/">Sports</a></li>
                <li ><a href="/education/">Education</a></li>
                <li ><a href="/business/">Business</a></li>
                <li ><a href="/national/">National</a></li>
                <li ><a href="/world/">World</a></li>
                <li ><a href="/auto/">Auto</a></li>
            </ul>
        </div>



        <header class="hidden">
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
        <article class="hidden">
            
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
        
        
        <script type="text/javascript">
        	var LOADIMG = 'ORIGIN'; // NONE | THUMB | ORIGIN | OFFLINE
        	var OS = 'WEB'; //Android | iOS
        	var hasData = true; //true | false
           
           var data = {"liked": false, "related_images": [{"origin": "http://image.newsdog.today/origin_c1fb99f3514e7cc0509cb018022b9156", "source": "http://www.tollywood.net/Newspics/Lavanya-turns-psychiatrist.jpg", "thumb_height": 294, "thumb": "http://image.newsdog.today/thumb_c1fb99f3514e7cc0509cb018022b9156", "thumb_width": 200, "width": 250, "height": 368}], "favored": false, "shared_count": null, "source_url": "http://www.tollywood.net/news/Lavanya-turns-psychiatrist?fromNewsdog=1", "published_at": "2016-07-10 18:30:00", "like_count": 3, "related_articles": [{"top_images": [{"origin": "http://image.newsdog.today/origin_04a60f3b9a5f6d7c84122fd66c1b6adf", "source": "http://static.dnaindia.com/sites/default/files/styles/half/public/2016/07/10/480577-454009-453701-shubhangi.jpg?itok=pch3zTlm", "thumb_height": 113, "thumb": "http://image.newsdog.today/thumb_04a60f3b9a5f6d7c84122fd66c1b6adf", "thumb_width": 200, "width": 600, "height": 338}], "type": "article", "id": "5782483f76f3df51a54ed179", "title": "Sanskari no more: Shubhangi Atre aka Angoori bhabi to do 'Great Grand Masti' with Aasif on 'Bhabi Ji Ghar Par Hai'"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_2c2889d4864da2f52c9a47342a094cce", "source": "http://media2.intoday.in/indiatoday/images/stories/647_071016054931.jpg", "thumb_height": 125, "thumb": "http://image.newsdog.today/thumb_2c2889d4864da2f52c9a47342a094cce", "thumb_width": 200, "width": 600, "height": 375}], "type": "article", "id": "57824a8476f3df4a8e4edadf", "title": "Vijay 60: Ilayathalapathy Vijay not playing dual roles in the upcoming film"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_e8dca60a5718db21c563eea40cde6420", "source": "http://www.hindustantimes.com/rf/image_size_640x362/HT/p2/2016/07/10/Pictures/jm4-3241-nef_329ff61e-4690-11e6-8e05-c384b245cd95.jpg", "thumb_height": 113, "thumb": "http://image.newsdog.today/thumb_e8dca60a5718db21c563eea40cde6420", "thumb_width": 200, "width": 600, "height": 339}], "type": "article", "id": "5782540476f3df97ba4ed3e5", "title": "Second time unlucky: 9 Hollywood sequels that got panned by critics"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_03ab9f59cbd282239e46c693e9c22b35", "source": "http://images.afternoonvoice.com/2016/07/xNoel-Neill-dies-at-95-AV.jpg.pagespeed.ic.fRSlxbuagA.jpg", "thumb_height": 113, "thumb": "http://image.newsdog.today/thumb_03ab9f59cbd282239e46c693e9c22b35", "thumb_width": 200, "width": 530, "height": 300}], "type": "article", "id": "5782546e76f3dfbade4ed0e6", "title": "First actress to play Superman\u2019s girlfriend, Noel Neill, dies at 95"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_d49370180b73f7181ff04c8203375388", "source": "http://data1.ibtimes.co.in/cache-img-0-450/en/full/573103/1468161477_deepika-padukone-kangana-ranaut.jpg", "thumb_height": 138, "thumb": "http://image.newsdog.today/thumb_d49370180b73f7181ff04c8203375388", "thumb_width": 200, "width": 600, "height": 414}], "type": "article", "id": "57825e7b12907123a1985b16", "title": "Did Kangana Ranaut try to replace Deepika Padukone in Sanjay Leela Bhansali's upcoming movie?"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_6d231fb88f3742c575e28e474d1690b2", "source": "http://i2.wp.com/www.galaxyreporter.com/wp-content/uploads/2016/07/Deepika-Padukones-next-bollywood-film-and-it-will-be-hat-trick.jpg?resize=652%2C477", "thumb_height": 146, "thumb": "http://image.newsdog.today/thumb_6d231fb88f3742c575e28e474d1690b2", "thumb_width": 200, "width": 600, "height": 439}], "type": "article", "id": "57825f7376f3dfe9464ed4af", "title": "Deepika Padukone's next bollywood film and it will be hat-trick"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_2dac656ec8f6dad4e38754ef92c46ba8", "source": "http://cos.h-cdn.co/assets/16/27/480x240/landscape-1468163881-harry-potter-goblet-of-fire.jpg", "thumb_height": 100, "thumb": "http://image.newsdog.today/thumb_2dac656ec8f6dad4e38754ef92c46ba8", "thumb_width": 200, "width": 480, "height": 240}], "type": "article", "id": "578267eb76f3df2a304ed4ab", "title": "9 Terrible Twists That Ruined Perfectly Good Movies"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_b7bec827adb61faadc67939eab85999d", "source": "http://i0.wp.com/filmdhamaka.in/wp-content/uploads/2016/07/Pradeep-Machiraju-Debut-As-Hero.jpg?resize=600%2C600", "thumb_height": 200, "thumb": "http://image.newsdog.today/thumb_b7bec827adb61faadc67939eab85999d", "thumb_width": 200, "width": 600, "height": 600}], "type": "article", "id": "578270df12907128d0985a75", "title": "Pradeep Machiraju Debut As Hero"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_269c55c90e1f7900d446e24f3527f642", "source": "http://cdn.kollytalk.com/wp-content/uploads/2016/07/Surbhi-Jyotis-Ishqbaaaz-connection.jpg", "thumb_height": 168, "thumb": "http://image.newsdog.today/thumb_269c55c90e1f7900d446e24f3527f642", "thumb_width": 200, "width": 250, "height": 210}], "type": "article", "id": "5782714376f3dfd9ef4ed186", "title": "Surbhi Jyoti's 'Ishqbaaaz' connection"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_ebdd8268189a91e50e1af82abdb15c97", "source": "http://www.asianage.com/sites/default/files/images/EMMA WATSON (3).jpg", "thumb_height": 133, "thumb": "http://image.newsdog.today/thumb_ebdd8268189a91e50e1af82abdb15c97", "thumb_width": 200, "width": 430, "height": 287}], "type": "article", "id": "5782835812907125a4986008", "title": "Emma Watson meets her older self"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_d00091106557287077129617dec38b91", "source": "http://dekhnews.com/wp-content/uploads/2016/07/Baahubali-1st-anniversary-celebration-Why-Katappa-killed-Bahubali-continues-to-haunt-even-a-year-after-its-release.jpg", "thumb_height": 126, "thumb": "http://image.newsdog.today/thumb_d00091106557287077129617dec38b91", "thumb_width": 200, "width": 600, "height": 378}], "type": "article", "id": "578285721290713aa698593f", "title": "Making Video! 'Baahubali' 1st Anniversary, Why Katappa killed Bahubali Continues?"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_2dd2cb0fb6199c8acbd1e13ec5d6d952", "source": "http://www.thehansindia.com/assets/7362_Nishikant_Kamath.jpg", "thumb_height": 129, "thumb": "http://image.newsdog.today/thumb_2dd2cb0fb6199c8acbd1e13ec5d6d952", "thumb_width": 200, "width": 600, "height": 388}], "type": "article", "id": "578299b91290714c9a9861f4", "title": "Nishikant extends support to Great Grand Masti"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_d56192c697c684d32426c1dcbd41004f", "source": "http://www.greatandhra.com/newphotos5/IndianClicks_Ficus_Entertainment_Janatha_Garage_Movie_GA_650x400_07082016_11468007370.jpg", "thumb_height": 123, "thumb": "http://image.newsdog.today/thumb_d56192c697c684d32426c1dcbd41004f", "thumb_width": 200, "width": 600, "height": 369}], "type": "article", "id": "5782a44f76f3df7edb4ed912", "title": "Janatha Garage overseas by FICUS"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_895d63ef96cf31817664d518e527076f", "source": "http://www.thehansindia.com/assets/4087_Vimala_Raman.jpg", "thumb_height": 138, "thumb": "http://image.newsdog.today/thumb_895d63ef96cf31817664d518e527076f", "thumb_width": 200, "width": 600, "height": 413}], "type": "article", "id": "5782a82c12907143fa985b03", "title": "Vimala\u2019s long cherished wish comes true"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_e87e843e3eb3749c165023404d1045ee", "source": "http://media.newindianexpress.com/Sai.jpg/2016/07/10/article3522864.ece/alternates/w620/Sai.jpg", "thumb_height": 113, "thumb": "http://image.newsdog.today/thumb_e87e843e3eb3749c165023404d1045ee", "thumb_width": 200, "width": 600, "height": 339}], "type": "article", "id": "5782dc6376f3df40104ed0f7", "title": "Sai kumar's Aadi returns to the fold"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_99af6085ab600516abf36035ea6ae92d", "source": "http://dc-cdn.s3-ap-southeast-1.amazonaws.com/dc-Cover-u28lqnb6uouuu9hffscom50l20-20160710232846.Medi.jpeg", "thumb_height": 112, "thumb": "http://image.newsdog.today/thumb_99af6085ab600516abf36035ea6ae92d", "thumb_width": 200, "width": 600, "height": 336}], "type": "article", "id": "5782f962129071033f985b48", "title": "Atharvaa turns super stylish"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_e4fda606872b450d6733dd22482dfc10", "source": "http://static.dnaindia.com/sites/default/files/styles/half/public/2016/07/10/480613-sakshi.jpg?itok=Yo0gmhhk", "thumb_height": 113, "thumb": "http://image.newsdog.today/thumb_e4fda606872b450d6733dd22482dfc10", "thumb_width": 200, "width": 600, "height": 338}], "type": "article", "id": "57830102129071158d985bc1", "title": "My father gave me tips on how to conduct an interrogation: Sakshi Tanwar on turning cop in '24' season 2"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_626653e33825610239ea39b8b69cbf29", "source": "http://img.theweek.in/content/dam/week/news/entertainment/2016/july/images/ranveer-singh-vaani-kapoor-kiss.jpg.image.975.568.jpg", "thumb_height": 117, "thumb": "http://image.newsdog.today/thumb_626653e33825610239ea39b8b69cbf29", "thumb_width": 200, "width": 600, "height": 350}], "type": "article", "id": "5783121b76f3df54fa4ed059", "title": "Ranveer kisses Vaani Kapoor on new poster of Befikre"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_60d5ec0bd9c3243777afb6c7f466151d", "source": "http://fitnhit.com/wp-content/uploads/2016/07/bahu.jpg", "thumb_height": 106, "thumb": "http://image.newsdog.today/thumb_60d5ec0bd9c3243777afb6c7f466151d", "thumb_width": 200, "width": 600, "height": 317}], "type": "article", "id": "5783144112907170b698601b", "title": "Watch Baahubali - The Conclusion Making Video Here: S.S Rajamouli, Rana, Prabhas"}, {"top_images": [{"origin": "http://image.newsdog.today/origin_4bcc797834d4bcea1be2f320729d5f5d", "source": "http://static.sify.com/cms/image/qfbjBKieigahc.jpg", "thumb_height": 133, "thumb": "http://image.newsdog.today/thumb_4bcc797834d4bcea1be2f320729d5f5d", "thumb_width": 200, "width": 600, "height": 400}], "type": "article", "id": "57831b981290715a65985a83", "title": "STR \u2018s new film, AAA begins with a pooja"}], "id": "57831cbe76f3df54fa4ed8c7", "op_recommend": false, "bigger": null, "top_images": [{"origin": "http://image.newsdog.today/origin_c1fb99f3514e7cc0509cb018022b9156", "source": "http://www.tollywood.net/Newspics/Lavanya-turns-psychiatrist.jpg", "thumb_height": 294, "thumb": "http://image.newsdog.today/thumb_c1fb99f3514e7cc0509cb018022b9156", "thumb_width": 200, "width": 250, "height": 368}], "subscribed": null, "title": "Lavanya turns psychiatrist", "seq_id": 33645440, "share_url": "http://www.newsdogshare.com/a/article/57831cbe76f3df54fa4ed8c7/", "site_url": "www.tollywood.net", "content": "<a class=\"image\"></a>\n<p>Actress Lavanya Tripathi who has delighted the audiences in traditional\u00a0 and girl next door roles, is going to play very challenging role in her upcoming untitled flick under the direction of CV Kumar in which actor Sundeep Kishan is playing the lead role. Recently she revealed her character and said that she would be seen in the role of psychiatrist and\u00a0 her look would be very stylish.\u00a0 She has done lot of research to play this character and met number of Psychiatrist. She is very excited to be part of this project.<br><br>Earlier makers tried to approach Tapsee for this role but she did not sign the movie\u00a0 due to date issue and finally makers roped her. It is a sci-fi thriller\u00a0 Tamil movie. It is also expected to be simultaneously made in Telugu. Studio Green is bankrolling this upcoming saga.</p>\n", "source": "tollywood.net", "key_words": ["Kishan"], "comments_count": 0, "media": {}, "has_commented": false, "is_hot": 0, "type": "article"};
           
            /*web code start*/
            document.querySelector(".bar .close_btn").onclick = function(){
                document.querySelector(".bar").className = "hidden";
            }
            for(i in data.related_articles){
                document.querySelector(".related_articles_header").className = "related_articles_header";
                var img = "url(http://static.newsdog.today/images/related_article_default_img.png)";
                if(data.related_articles[i].top_images && data.related_articles[i].top_images[0] && data.related_articles[i].top_images[0].thumb){
                    var imgClass = "";
                    var th = data.related_articles[i].top_images[0].thumb_height;
                    var tw = data.related_articles[i].top_images[0].thumb_width;
                    if(tw/th > 10/7){
                        imgClass = "h100";
                    }
                    img = "url("+data.related_articles[i].top_images[0].thumb + '), '+img;
                }
                if(window.screen.width>640){
                    var url = '/a/'+data.related_articles[i].type+'/'+data.related_articles[i].id+'/';
                }else{
                    var url = 'https://app.appsflyer.com/com.newsdog.lite?pid=Portal&c=Related&af_r=http://newsdog.today/a/downloads/';
                    if (location.href.match(/from=/)) {
                        url = "https://app.appsflyer.com/com.newsdog.lite?pid=Share&c=Related&af_r=http://newsdog.today/a/downloads/";
                    }

                }
                document.querySelector(".related_articles").innerHTML += '<li><a href="'+url+'" target="_blank"><span class="related_articles_img '+imgClass+'" style="background-image:'+img+';" /></span><span class="related_articles_text">'+data.related_articles[i].title+'</span><span class="related_articles_tag"></span></a></li>'; 
            }
            /*web code end*/
        	</script>
        	
        <script type="text/javascript" src="http://static.newsdog.today/javascripts/mobile.js"></script>
       
    </body>
</html>
