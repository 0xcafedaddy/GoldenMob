package com.mkit.website.test;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.search.SearchHit;
import org.springframework.data.domain.Page;

public class GetRelatedPage {

	public static Page<TopicJson> queryRelated(Page page, String keywords,
			List<String> excludeIdList, String[] topicFields, String category) {
		return queryRelated(page, "content", keywords, topicFields,
				new String[] {}, excludeIdList, category);
	}

	private static Page<TopicJson> queryRelated(Page page, String fieldName,
			String keywords, String[] includeFields, String[] excludeFields,
			List<String> excludeIdList, String category) {
		SearchHit[] hits = null;
		List<TopicJson> resultList = new ArrayList<TopicJson>();
		hits = getHitForRelated(page.getPageSize(), keywords, includeFields,
				excludeFields, excludeIdList, category);
		ContentFilterUtil.getTopicList(hits, resultList, 1);

		Page<TopicJson> resultPage = preparePage(page, resultList);
		return resultPage;
	}

	private static Page<TopicJson> preparePage(Page page,
			List<TopicJson> topicList) {
		// 设置当前页为1，条数
		Page<TopicJson> indexQueryPage = PageUtils.getPageInstance(topicList
				.size());

		indexQueryPage.setObjItems(topicList);
		indexQueryPage.setItems(topicList);
		indexQueryPage.setCurPage(page.getCurPage());
		indexQueryPage.setPageSize(page.getPageSize());
		// indexQueryPage.setCurPage(page.getCurPage());
		// indexQueryPage初始化已经设置了total值，为何还要重新设置？
		// indexQueryPage.setTotal(CommonConstants.MAX_TOPIC_COUNT_OF_LIST);
		// inpage.setColCount(columnCount);

		return indexQueryPage;
	}

}
