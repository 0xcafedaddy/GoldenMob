/************************************************
@description:ContentFilterUtil.java是用来过滤文章内容
，在返回客户端之前，进行相应的转换。
@author:shishansong
@date:2016年6月21日 下午3:34:43
@version:1.0 
*************************************************/
package com.mkit.website.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.search.SearchHit;


/***
 * 解析查询出来的内容
 * @author yang
 *
 */


public class ContentFilterUtil {
	public static String getSpecialDomain(String domain,String author) {
		if (domain.indexOf("goldenlauncher")>=0 ||domain.indexOf("goldenmob")>=0){
			domain = author;
			return domain;
		}
		
		if(!StringUtils.isBlank(domain)){
			String[] domainArr = domain.split("\\.");
			String domainFirStr = domainArr[0];
			domain = domainFirStr;
		}
		return domain;
	}



	public static String getFirstImgUrl(String label,String domain) {
		String regexImg = "http:\\/\\/.*?.jpg";
		if ("broadwayworld.com".equals(domain)){
			regexImg = "https:\\/\\/.*?.webp";
		}
			
		
		Matcher matcher = Pattern.compile(regexImg).matcher(label);
		String firstImgUrl="";
	    while (matcher.find()) { 
	    	firstImgUrl = matcher.group();
	    	break;
	    } 
	    return firstImgUrl;
	}
	public static String getImageDataStr(String label) {
		String DATA_REG = "data:image.*?=";
		Matcher matcher = Pattern.compile(DATA_REG).matcher(label);
		String dataStr="";
	    while (matcher.find()) { 
	    	dataStr = matcher.group();
	    	break;
	    } 
	    return dataStr;
	}

	public static String getFastImageUrl(String imageUrl, String domain,String content) {
		
		
		if ("dailyhunt.in".equals(domain)){
			return imageUrl.replace("800x480", "180x160");
		}else if ("perfectskincareforyou.com".equals(domain)){
			return imageUrl.replace("1024x683", "300x200");
		}else if ("omnighana.com".equals(domain)){
			return imageUrl.replace("640x330", "272x125");
		}else if ("cricketcountry.com".equals(domain)){
			String smallImg = imageUrl.replace(".jpg", "-320x180.jpg");
			if (content.indexOf(smallImg)<0){
				smallImg = imageUrl.replace(".jpg", "-300x169.jpg");
			}
			if (content.indexOf(smallImg)>=0){
				return smallImg;
			}
			
			
			if (imageUrl.indexOf("data:image/gif")>=0){
				smallImg = getFirstImgUrl(content,domain);
				if (content.indexOf(smallImg)>=0){
					return smallImg;
				}
			}
			
		}else if ("broadwayworld.com".equals(domain)){
			if (imageUrl.indexOf("data:image")>=0){
				imageUrl = getFirstImgUrl(content,domain);
			}
		}else if ("thebetterindia.com".equals(domain)){
			String smallImg = imageUrl.replace(".jpg", "-300x225.jpg");
			if (content.indexOf(smallImg)>=0){
				return smallImg;
			}
		}
		else if ("broadwayworld.com".equals(domain)){
			if (imageUrl.indexOf("data:image")>=0){
				imageUrl = getFirstImgUrl(content,domain);
			}
		}
		
		
		else if ("deccanchronicle.com".equals(domain)){
			String smallImg = imageUrl.replace("Medi.jpeg", ".jpeg");
			if (content.indexOf(smallImg)>=0){
				return smallImg;
			}
		}
		else if ("chitramala.in".equals(domain)){
			String smallImg = imageUrl.replace(".jpg", "-300x182.jpg");
			if (content.indexOf(smallImg)>=0){
				return smallImg;
			}
		}
		else if ("missmalini.com".equals(domain)){
			String smallImg = imageUrl.replace(".jpg", "-300x242.jpg");
			if (content.indexOf(smallImg)>=0){
				return smallImg;
			}
		}
		else if ("brideeveryday.com".equals(domain)){
			String smallImg = imageUrl.replace(".jpg", "-300x200.jpg");
			//if (content.indexOf(smallImg)>=0){有特殊字符编码的问题，有的编码，有的没有编码，暂时放过这个条件。
				if (smallImg.indexOf("//")==0){
					smallImg = "http:"+smallImg;
				}
				return smallImg;
			//}
		}
		return imageUrl;
		
	}
	public static String replaceImgOfContent(String domain,String content){
		if ("cricketcountry.com".equals(domain)){
			if (content.indexOf("data:image/gif")>=0){
				String smallImg = getFirstImgUrl(content,domain);
				String dataStr = getImageDataStr(content);
				content = content.replaceFirst(dataStr, smallImg);
			}
			
		}if ("broadwayworld.com".equals(domain)){
			if (content.indexOf("data:image")>=0){
				String smallImg = getFirstImgUrl(content,domain);
				String dataStr = getImageDataStr(content);
				content = content.replaceFirst(dataStr, smallImg);
			}
			
		}
		else if ("brideeveryday.com".equals(domain)){
			
			if (content.indexOf("src=\"//")>=0){
				content = content.replace("src=\"//", "src=\"http://");
			}
		}
		return content;
	}


	public static String getDomainName(String url) throws URISyntaxException {
	    URI uri = new URI(url);
	    String domain = uri.getHost();
	    return domain.startsWith("www.") ? domain.substring(4) : domain;
	}
	public static void getTopicList(SearchHit[] hits,
			List<TopicJson> resultList,Integer bid) {
		//判重准备
		int hitCount = hits.length;
		//Map<String,String> titleMap = new HashMap<String,String>(hitCount);
		//Map<String,String> urlMap = new HashMap<String,String>(hitCount);
		//Map<String,String> contentMap = new HashMap<String,String>(hitCount);
		//三个map似乎没有，判重之后没有后续工作
		final String FLAG_EXIST = "1";
		for (int i = 0; i < hitCount; i++) {
        	TopicJson topic = new TopicJson();
            SearchHit hit = hits[i];
//
//            Map<String, Object> hitSource = hit.getSource();
//            String title = CommonUtils.getString(hitSource.get("title"));
//            //====排重
//            /*if (FLAG_EXIST.equals(titleMap.get(title))){
//            	continue;
//            }else{
//            	titleMap.put(title, FLAG_EXIST);
//            }*/
//            
//            String url = CommonUtils.getString(hitSource.get("url"));
//           /* if (FLAG_EXIST.equals(urlMap.get(url))){
//            	continue;
//            }else{
//            	urlMap.put(url, FLAG_EXIST);
//            }*/
//            
//            String domain = CommonUtils.getString(hitSource.get("domain"));
//            Map content = (Map) hitSource.get("content");
//
//            String tcontent = CommonUtils.getString(content.get("tcontent"));//getString(hit.getSource().get("content.tcontent"));
//            System.out.println("--------------------------------------uuid is:"+CommonUtils.getString(hitSource.get("uuid")));
//            tcontent = ContentFilterUtil.replaceImgOfContent(domain,tcontent);
//           /* if (FLAG_EXIST.equals(contentMap.get(tcontent))){
//            	continue;
//            }else{
//            	contentMap.put(tcontent, FLAG_EXIST);
//            }*/
//            //======
            
           
           // List<Map> imageList = (ArrayList) content.get("image");
            
            
//            List<ImportImage> imgList = new ArrayList();
//            for (Map image : imageList) {
//                String imageH = CommonUtils.getString(image.get("h"));
//                String imageW = CommonUtils.getString(image.get("w"));
//                String imageUrl = CommonUtils.getString(image.get("url"));
//                
//                imageUrl = ContentFilterUtil.getFastImageUrl(imageUrl,domain,tcontent);
//                
//                
//                
//            	ImportImage importImage = new ImportImage();
//                importImage.setUrl(imageUrl);
//                importImage.setH(imageH);
//                importImage.setW(imageW);
//                imgList.add(importImage);
//			}
//            
//
//            String id = CommonUtils.getString(hitSource.get("id"));
//            String keywords = CommonUtils.getString(hitSource.get("keywords"));
//            String userId = CommonUtils.getString(hitSource.get("user_id"));
//            String addTime = CommonUtils.getString(hitSource.get("add_time"));
//            //String category = CommonUtils.getString(hitSource.get("category"));
//            String author = CommonUtils.getString(hitSource.get("author"));
//            
//            String uuid = CommonUtils.getString(hitSource.get("uuid"));
//            Integer imageCount = CommonUtils.getInt(hitSource.get("image_count"));
//            String max3Hash = CommonUtils.getString(hitSource.get("max3hash"));
//            String appCategory = CommonUtils.getString(hitSource.get("app_category"));
//            TopicCount topicActCount = TopicCountUtil.getTopicCountNoSetRedis(uuid);
//    		TopicContent topicContent =new TopicContent();
//    		topicContent.setImage(imgList);
//    		topicContent.setTcontent(tcontent);
//    		
//    		topic.setContent(topicContent.toJson());
//
//    		
//    		domain = ContentFilterUtil.getSpecialDomain(domain,author);//sss added 0615
//    		
//    		topic.setDomain(domain);
//
//    		topic.setImageCount(imageCount);
//    		topic.setUuid(uuid);
//    		topic.setCid(bid.toString());
//    		topic.setMax3Hash(max3Hash);
//    		topic.setCategory(appCategory);
//    		topic.setAppCategory(appCategory);
//    		//包含id,nick，face,name的一个实体
//    		UserShortJson userShortJson = new UserShortJson();
//    		userShortJson.setId(userId);
//            topic.setUinfo(userShortJson);
//            topic.setTid(id);
//            topic.setTitle(title);
//            
//            topic.setUrl(url);
//            //topic.setSource(getSourceFromUrl(url));
//            topic.setKeywords(keywords);
//            topic.setAtime(addTime);
//            topic.setAuthor(author);
//            topic.setTaCount(topicActCount.toJson());
            
           /* BarJson binfo = new BarJson();
            binfo.setName("hellokitty");
            binfo.setId("0");
            topic.setBinfo(binfo);*/
            
            //topic.setCategory(category);
            
            //topicMap.put("title", title);
            //topicMap.put("content", content);
            //topicMap.put("url", url);
            //topicMap.put("keywords", keywords);
          //System.out.println("content:"+topic.getContent());
            
            resultList.add(topic);
            //System.out.println(hitSource);
        }
	}
}
