package com.silurongchuang.common.util.es;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

/**
 * 通过用户id获取公司名称
 */
public class EsUtils {

    @Autowired
    private static RestHighLevelClient restHighLevelClient;

    public static String getCompanyName(String userId) throws IOException {
        String companyName = "";
        SearchRequest searchRequest1 = new SearchRequest(EsDataConfig.INDEX_NAME_UN_SENSITIVE);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        MatchQueryBuilder matchQueryBuilder1 = QueryBuilders.matchQuery("_id", userId);
        searchSourceBuilder.query(matchQueryBuilder1);

        searchRequest1.source(searchSourceBuilder);
        SearchResponse search1 = restHighLevelClient.search(searchRequest1, RequestOptions.DEFAULT);

        if (search1.getHits().getHits().length != 0 && search1.getHits().getHits() != null) {
            for (SearchHit hit : search1.getHits().getHits()) {
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                String compId = hit.getId();
                companyName = (String) sourceAsMap.get("company");
                System.out.println(companyName);
            }
        }
        System.out.println(companyName);
        return companyName;
    }
}
