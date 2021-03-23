package com.github.jasonqjc.atlas_v2_client.api;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationship;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipWithExtInfo;

/**
 * API tests for RelationshipRestApi
 */
@SpringBootTest
public class RelationshipRestApiTest {
	
	@Autowired
    private RelationshipRestApi api;

    /**
     * Create a new relationship between entities.
     *
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
     */
    @Test
    public void getById2Test() {
        String guid = "8ee97417-4bec-477c-9252-051d93e54ddb";
        Boolean extendedInfo = null;
        JsonAtlasRelationshipWithExtInfo response = api.getById2(guid, extendedInfo);
        System.out.println(response);
    }

    /**
     * Get relationship information between entities using guid.
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getById2TestQueryMap() {
        String guid = "305cdd07-c855-4572-812f-1cfc9c8b7e73";
        RelationshipRestApi.GetById2QueryParams queryParams = new RelationshipRestApi.GetById2QueryParams()
            .extendedInfo(null);
         JsonAtlasRelationshipWithExtInfo response = api.getById2(guid, queryParams);
         System.out.println(response);
    }
    /**
     * Update an existing relationship between entities.
     *
     */
    @Test
    public void updateTest() {
        JsonAtlasRelationship body = null;
        // JsonAtlasRelationship response = api.update(body);

        // TODO: test validations
    }

}
