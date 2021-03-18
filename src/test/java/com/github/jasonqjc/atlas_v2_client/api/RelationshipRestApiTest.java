package com.github.jasonqjc.atlas_v2_client.api;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.github.jasonqjc.atlas_v2_client.ApiClient;
import com.github.jasonqjc.atlas_v2_client.api.RelationshipRestApi;
import com.github.jasonqjc.atlas_v2_client.api.UILoginApi;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationship;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipWithExtInfo;

import feign.Response;

/**
 * API tests for RelationshipRestApi
 */
public class RelationshipRestApiTest {

    private RelationshipRestApi api;

    @Before
    public void setup() {
    	ApiClient loginClient = new ApiClient();
    	loginClient.setBasePath("http://192.168.44.132:21000/");
    	Response response = loginClient.buildClient(UILoginApi.class).login();
    	Collection<String> collection = response.headers().get("Set-Cookie");
    	String cookieString = collection.iterator().next();
    	String string = cookieString.split(";")[0];
    	
        ApiClient apiClient = new ApiClient();
        apiClient.getFeignBuilder().requestInterceptor(r -> {
        	r.header("Cookie", string);
        });
		api = apiClient
        		.buildClient(RelationshipRestApi.class);
    }

    /**
     * Create a new relationship between entities.
     *
     * Create a new relationship between entities.
     */
    @Test
    public void createTest() {
        JsonAtlasRelationship body = null;
        // JsonAtlasRelationship response = api.create(body);

        // TODO: test validations
    }

    /**
     * Delete a relationship between entities using guid.
     *
     * Delete a relationship between entities using guid.
     */
    @Test
    public void deleteByIdTest() {
        String guid = null;
        // api.deleteById(guid);

        // TODO: test validations
    }

    /**
     * Get relationship information between entities using guid.
     *
     * Get relationship information between entities using guid.
     */
    @Test
    public void getById2Test() {
        String guid = "a36e8d5f-c7ca-43a8-82eb-364de554113f";
        Boolean extendedInfo = null;
        JsonAtlasRelationshipWithExtInfo response = api.getById2(guid, extendedInfo);
        System.out.println(response);
    }

    /**
     * Get relationship information between entities using guid.
     *
     * Get relationship information between entities using guid.
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getById2TestQueryMap() {
        String guid = "a36e8d5f-c7ca-43a8-82eb-364de554113f";
        RelationshipRestApi.GetById2QueryParams queryParams = new RelationshipRestApi.GetById2QueryParams()
            .extendedInfo(null);
         JsonAtlasRelationshipWithExtInfo response = api.getById2(guid, queryParams);
         System.out.println(response);
    }
    /**
     * Update an existing relationship between entities.
     *
     * Update an existing relationship between entities.
     */
    @Test
    public void updateTest() {
        JsonAtlasRelationship body = null;
        // JsonAtlasRelationship response = api.update(body);

        // TODO: test validations
    }

}
