package com.github.jasonqjc.atlas_v2_client.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasLineageInfo;

/**
 * API tests for LineageRestApi
 */
@SpringBootTest
public class LineageRestApiTest {

	@Autowired
    private LineageRestApi api;

    /**
     * Returns lineage info about entity.
     *
     * Returns lineage info about entity.  In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  attr:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName and attrValue should be unique across entities, eg. qualifiedName
     */
    @Test
    public void getLineageByUniqueAttributeTest() {
        String typeName = "LoadProcess";
        Integer depth = 3;
        String direction = "BOTH";
        api.getLineageByUniqueAttribute(typeName, depth, direction);
//        System.out.println(response);
        
    }

    /**
     *
     * Returns lineage info about entity.  
     * In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  attr:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName and attrValue should be unique across entities, eg. qualifiedName
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getLineageByUniqueAttributeTestQueryMap() {
        String typeName = "loadLogsMonthly";
        LineageRestApi.GetLineageByUniqueAttributeQueryParams queryParams = new LineageRestApi.GetLineageByUniqueAttributeQueryParams()
            .depth(null)
            .direction(null);
        queryParams.put("attr:qualifiedName", "xxx");
        api.getLineageByUniqueAttribute(typeName, queryParams);
    }
    /**
     * Returns lineage info about entity.
     *
     */
    @Test
    public void getLineageGraphTest() {
        String guid = "6651d056-da45-41d6-bcc7-11819d6b55d4";
        Integer depth = null;
        String direction = null;
        JsonAtlasLineageInfo response = api.getLineageGraph(guid, depth, direction);
        System.out.println(response);
    }

    /**
     * Returns lineage info about entity.
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getLineageGraphTestQueryMap() {
        String guid = null;
        LineageRestApi.GetLineageGraphQueryParams queryParams = new LineageRestApi.GetLineageGraphQueryParams()
            .depth(null)
            .direction(null);
        // JsonAtlasLineageInfo response = api.getLineageGraph(guid, queryParams);

    // TODO: test validations
    }
}
