package com.github.jasonqjc.atlas_v2_client.api;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.github.jasonqjc.atlas_v2_client.ApiClient;
import com.github.jasonqjc.atlas_v2_client.api.EntityRestApi;
import com.github.jasonqjc.atlas_v2_client.api.UILoginApi;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasClassification;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntitiesWithExtInfo;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityHeader;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityWithExtInfo;
import com.github.jasonqjc.atlas_v2_client.model.JsonClassificationAssociateRequest;
import com.github.jasonqjc.atlas_v2_client.model.JsonEntityMutationResponse;

import feign.Response;

/**
 * API tests for EntityRestApi
 */
public class EntityRestApiTest {

    private EntityRestApi api;

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
        		.buildClient(EntityRestApi.class);
    }

    /**
     * Bulk API to associate a tag to multiple entities.
     *
     * Bulk API to associate a tag to multiple entities
     */
    @Test
    public void addClassificationTest() {
        JsonClassificationAssociateRequest body = null;
        // api.addClassification(body);

        // TODO: test validations
    }

    /**
     * Adds classifications to an existing entity represented by a guid.
     *
     * Adds classifications to an existing entity represented by a guid.
     */
    @Test
    public void addClassificationsTest() {
        String guid = null;
        List<JsonAtlasClassification> body = null;
        // api.addClassifications(guid, body);

        // TODO: test validations
    }

    /**
     * Adds classification to the entity identified by its type and unique attributes.
     *
     * Adds classification to the entity identified by its type and unique attributes.
     */
    @Test
    public void addClassificationsByUniqueAttributeTest() {
        String typeName = null;
        List<JsonAtlasClassification> body = null;
        // api.addClassificationsByUniqueAttribute(typeName, body);

        // TODO: test validations
    }

    /**
     * add given labels to a given entity.
     *
     * add given labels to a given entity
     */
    @Test
    public void addLabelsTest() {
        String guid = null;
        // api.addLabels(guid);

        // TODO: test validations
    }

    /**
     * 
     *
     * 
     */
    @Test
    public void addLabels_0Test() {
        String typeName = null;
        List<String> body = null;
        // api.addLabels_0(typeName, body);

        // TODO: test validations
    }

    /**
     * 
     *
     * 
     */
    @Test
    public void addOrUpdateBusinessAttributesTest() {
        String guid = null;
        Boolean isOverwrite = null;
        // api.addOrUpdateBusinessAttributes(guid, isOverwrite);

        // TODO: test validations
    }

    /**
     * 
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void addOrUpdateBusinessAttributesTestQueryMap() {
        String guid = null;
        EntityRestApi.AddOrUpdateBusinessAttributesQueryParams queryParams = new EntityRestApi.AddOrUpdateBusinessAttributesQueryParams()
            .isOverwrite(null);
        // api.addOrUpdateBusinessAttributes(guid, queryParams);

    // TODO: test validations
    }
    /**
     * 
     *
     * 
     */
    @Test
    public void addOrUpdateBusinessAttributes_0Test() {
        String bmName = null;
        String guid = null;
        // api.addOrUpdateBusinessAttributes_0(bmName, guid);

        // TODO: test validations
    }

    /**
     * Create new entity or update existing entity in Atlas.
     *
     * Create new entity or update existing entity in Atlas. Existing entity is matched using its unique guid if supplied or by its unique attributes eg: qualifiedName
     */
    @Test
    public void createOrUpdateTest() {
        JsonAtlasEntityWithExtInfo body = null;
        // JsonEntityMutationResponse response = api.createOrUpdate(body);

        // TODO: test validations
    }

    /**
     * Bulk API to create new entities or updates existing entities in Atlas.
     *
     * Bulk API to create new entities or updates existing entities in Atlas. Existing entity is matched using its unique guid if supplied or by its unique attributes eg: qualifiedName
     */
    @Test
    public void createOrUpdate_0Test() {
        JsonAtlasEntitiesWithExtInfo body = null;
        // JsonEntityMutationResponse response = api.createOrUpdate_0(body);

        // TODO: test validations
    }

    /**
     * Delete an entity identified by its GUID.
     *
     * Delete an entity identified by its GUID.
     */
    @Test
    public void deleteByGuidTest() {
        String guid = "474b5061-3e61-42db-8154-9ab7025da198";
        JsonEntityMutationResponse response = api.deleteByGuid(guid);
        String guid2 = "b630069d-b42c-4c01-9e96-6f4c9fe83ce6";
        JsonEntityMutationResponse response2 = api.deleteByGuid(guid2);

    }

    /**
     * Bulk API to delete list of entities identified by its GUIDs.
     *
     * Bulk API to delete list of entities identified by its GUIDs
     */
    @Test
    public void deleteByGuidsTest() {
        List<String> guid = null;
        // JsonEntityMutationResponse response = api.deleteByGuids(guid);

        // TODO: test validations
    }

    /**
     * Bulk API to delete list of entities identified by its GUIDs.
     *
     * Bulk API to delete list of entities identified by its GUIDs
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void deleteByGuidsTestQueryMap() {
        EntityRestApi.DeleteByGuidsQueryParams queryParams = new EntityRestApi.DeleteByGuidsQueryParams()
            .guid(null);
        // JsonEntityMutationResponse response = api.deleteByGuids(queryParams);

    // TODO: test validations
    }
    /**
     * Delete an entity identified by its type and unique attributes.
     *
     * Delete an entity identified by its type and unique attributes.  In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  attr:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName and attrValue should be unique across entities, eg. qualifiedName  The REST request would look something like this  DELETE /v2/entity/uniqueAttribute/type/aType?attr:aTypeAttribute&#x3D;someValue
     */
    @Test
    public void deleteByUniqueAttributeTest() {
        String typeName = "View_v1";
        Map<String,String> uniqueAttributes = new HashMap<>();
        uniqueAttributes.put("attr:qualifiedName", "customer_dim_view");
        JsonEntityMutationResponse response = api.deleteByUniqueAttribute(typeName,uniqueAttributes);
        System.out.println(response);
    }

    /**
     * Deletes a given classification from an existing entity represented by a guid.
     *
     * Deletes a given classification from an existing entity represented by a guid.
     */
    @Test
    public void deleteClassificationTest() {
        String classificationName = null;
        String guid = null;
        String associatedEntityGuid = null;
        // api.deleteClassification(classificationName, guid, associatedEntityGuid);

        // TODO: test validations
    }

    /**
     * Deletes a given classification from an existing entity represented by a guid.
     *
     * Deletes a given classification from an existing entity represented by a guid.
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void deleteClassificationTestQueryMap() {
        String classificationName = null;
        String guid = null;
        EntityRestApi.DeleteClassificationQueryParams queryParams = new EntityRestApi.DeleteClassificationQueryParams()
            .associatedEntityGuid(null);
        // api.deleteClassification(classificationName, guid, queryParams);

    // TODO: test validations
    }
    /**
     * Deletes a given classification from an entity identified by its type and unique attributes.
     *
     * Deletes a given classification from an entity identified by its type and unique attributes.
     */
    @Test
    public void deleteClassificationByUniqueAttributeTest() {
        String classificationName = "JdbcAccess_v1";
        String typeName = "customer_dim_view";
        api.deleteClassificationByUniqueAttribute(classificationName, typeName);
    }

    /**
     * 
     *
     * 
     */
    @Test
    public void getAuditEventsTest() {
        String guid = null;
        String auditAction = null;
        Integer count = null;
        String startKey = null;
        // List<JsonEntityAuditEventV2> response = api.getAuditEvents(guid, auditAction, count, startKey);

        // TODO: test validations
    }

    /**
     * 
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getAuditEventsTestQueryMap() {
        String guid = null;
        EntityRestApi.GetAuditEventsQueryParams queryParams = new EntityRestApi.GetAuditEventsQueryParams()
            .auditAction(null)
            .count(null)
            .startKey(null);
        // List<JsonEntityAuditEventV2> response = api.getAuditEvents(guid, queryParams);

    // TODO: test validations
    }
    /**
     * Bulk API to retrieve list of entities identified by its GUIDs.
     *
     * Bulk API to retrieve list of entities identified by its GUIDs.
     */
    @Test
    public void getByGuidsTest() {
        List<String> guid = null;
        Boolean ignoreRelationships = null;
        Boolean minExtInfo = null;
        // JsonAtlasEntitiesWithExtInfo response = api.getByGuids(guid, ignoreRelationships, minExtInfo);

        // TODO: test validations
    }

    /**
     * Bulk API to retrieve list of entities identified by its GUIDs.
     *
     * Bulk API to retrieve list of entities identified by its GUIDs.
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getByGuidsTestQueryMap() {
        EntityRestApi.GetByGuidsQueryParams queryParams = new EntityRestApi.GetByGuidsQueryParams()
            .guid(null)
            .ignoreRelationships(null)
            .minExtInfo(null);
        // JsonAtlasEntitiesWithExtInfo response = api.getByGuids(queryParams);

    // TODO: test validations
    }
    /**
     * Fetch complete definition of an entity given its GUID.
     *
     * Fetch complete definition of an entity given its GUID.
     */
    @Test
    public void getByIdTest() {
        String guid = null;
        Boolean ignoreRelationships = null;
        Boolean minExtInfo = null;
        // JsonAtlasEntityWithExtInfo response = api.getById(guid, ignoreRelationships, minExtInfo);

        // TODO: test validations
    }

    /**
     * Fetch complete definition of an entity given its GUID.
     *
     * Fetch complete definition of an entity given its GUID.
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getByIdTestQueryMap() {
        String guid = "6651d056-da45-41d6-bcc7-11819d6b55d4";
        EntityRestApi.GetByIdQueryParams queryParams = new EntityRestApi.GetByIdQueryParams()
            .ignoreRelationships(null)
            .minExtInfo(null);
         JsonAtlasEntityWithExtInfo response = api.getById(guid, queryParams);
         System.out.println(response);
    }
    /**
     * Fetch complete definition of an entity given its type and unique attribute.
     *
     * Fetch complete definition of an entity given its type and unique attribute.  In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  attr:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName and attrValue should be unique across entities, eg. qualifiedName  The REST request would look something like this  GET /v2/entity/uniqueAttribute/type/aType?attr:aTypeAttribute&#x3D;someValue
     */
    @Test
    public void getByUniqueAttributesTest() {
        String typeName = "LoadProcess";
        Boolean ignoreRelationships = true;
        Boolean minExtInfo = true;
        JsonAtlasEntityWithExtInfo response = api.getByUniqueAttributes(typeName, ignoreRelationships, minExtInfo);
        System.out.println(response);
    }

    /**
     * Fetch complete definition of an entity given its type and unique attribute.
     *
     * Fetch complete definition of an entity given its type and unique attribute.  In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  attr:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName and attrValue should be unique across entities, eg. qualifiedName  The REST request would look something like this  GET /v2/entity/uniqueAttribute/type/aType?attr:aTypeAttribute&#x3D;someValue
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getByUniqueAttributesTestQueryMap() {
        String typeName = "View_v1";
        EntityRestApi.GetByUniqueAttributesQueryParams queryParams = new EntityRestApi.GetByUniqueAttributesQueryParams()
            .ignoreRelationships(true)
            .minExtInfo(true);
         JsonAtlasEntityWithExtInfo response = api.getByUniqueAttributes(typeName, queryParams);
         System.out.println(response);
    }
    /**
     * Gets the list of classifications for a given entity represented by a guid.
     *
     * Gets the list of classifications for a given entity represented by a guid.
     */
    @Test
    public void getClassificationTest() {
        String classificationName = null;
        String guid = null;
        // JsonAtlasClassification response = api.getClassification(classificationName, guid);

        // TODO: test validations
    }

    /**
     * Gets the list of classifications for a given entity represented by a guid.
     *
     * Gets the list of classifications for a given entity represented by a guid.
     */
    @Test
    public void getClassificationsTest() {
        String guid = null;
        // JsonAtlasClassifications response = api.getClassifications(guid);

        // TODO: test validations
    }

    /**
     * Bulk API to retrieve list of entities identified by its unique attributes.
     *
     * Bulk API to retrieve list of entities identified by its unique attributes.  In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  typeName&#x3D;&lt;typeName&gt;&amp;attr_1:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;&amp;attr_2:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;&amp;attr_3:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName should be an unique attribute for the given entity-type  The REST request would look something like this  GET /v2/entity/bulk/uniqueAttribute/type/hive_db?attr_0:qualifiedName&#x3D;db1@cl1&amp;attr_2:qualifiedName&#x3D;db2@cl1
     */
    @Test
    public void getEntitiesByUniqueAttributesTest() {
        String typeName = null;
        Boolean ignoreRelationships = null;
        Boolean minExtInfo = null;
        // JsonAtlasEntitiesWithExtInfo response = api.getEntitiesByUniqueAttributes(typeName, ignoreRelationships, minExtInfo);

        // TODO: test validations
    }

    /**
     * Bulk API to retrieve list of entities identified by its unique attributes.
     *
     * Bulk API to retrieve list of entities identified by its unique attributes.  In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  typeName&#x3D;&lt;typeName&gt;&amp;attr_1:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;&amp;attr_2:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;&amp;attr_3:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName should be an unique attribute for the given entity-type  The REST request would look something like this  GET /v2/entity/bulk/uniqueAttribute/type/hive_db?attr_0:qualifiedName&#x3D;db1@cl1&amp;attr_2:qualifiedName&#x3D;db2@cl1
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getEntitiesByUniqueAttributesTestQueryMap() {
        String typeName = null;
        EntityRestApi.GetEntitiesByUniqueAttributesQueryParams queryParams = new EntityRestApi.GetEntitiesByUniqueAttributesQueryParams()
            .ignoreRelationships(null)
            .minExtInfo(null);
        // JsonAtlasEntitiesWithExtInfo response = api.getEntitiesByUniqueAttributes(typeName, queryParams);

    // TODO: test validations
    }
    /**
     * Fetch AtlasEntityHeader given its type and unique attribute.
     *
     * Fetch AtlasEntityHeader given its type and unique attribute.  In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  attr:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName and attrValue should be unique across entities, eg. qualifiedName  The REST request would look something like this  GET /v2/entity/uniqueAttribute/type/aType/header?attr:aTypeAttribute&#x3D;someValue
     */
    @Test
    public void getEntityHeaderByUniqueAttributesTest() {
        String typeName = "View_v1";
         JsonAtlasEntityHeader response = api.getEntityHeaderByUniqueAttributes(typeName,null);
         System.out.println(response);
    }

    /**
     * 
     *
     * 
     */
    @Test
    public void getEntityHeadersTest() {
        Long tagUpdateStartTime = null;
        // api.getEntityHeaders(tagUpdateStartTime);

        // TODO: test validations
    }

    /**
     * 
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void getEntityHeadersTestQueryMap() {
        EntityRestApi.GetEntityHeadersQueryParams queryParams = new EntityRestApi.GetEntityHeadersQueryParams()
            .tagUpdateStartTime(null);
        // api.getEntityHeaders(queryParams);

    // TODO: test validations
    }
    /**
     * Get entity header given its GUID.
     *
     * Get entity header given its GUID.
     */
    @Test
    public void getHeaderByIdTest() {
        String guid = null;
        // JsonAtlasEntityHeader response = api.getHeaderById(guid);

        // TODO: test validations
    }

    /**
     * Upload the file for creating Business Metadata in BULK.
     *
     * Upload the file for creating Business Metadata in BULK
     */
    @Test
    public void importBMAttributesTest() {
        File fileDetail = null;
        File uploadedInputStream = null;
        // JsonBulkImportResponse response = api.importBMAttributes(fileDetail, uploadedInputStream);

        // TODO: test validations
    }

    /**
     * Entity Partial Update - Add/Update entity attribute identified by its GUID.
     *
     * Entity Partial Update - Add/Update entity attribute identified by its GUID. Supports only uprimitive attribute type and entity references. does not support updation of complex types like arrays, maps Null updates are not possible
     */
    @Test
    public void partialUpdateEntityAttrByGuidTest() {
        String guid = null;
        String name = null;
        // JsonEntityMutationResponse response = api.partialUpdateEntityAttrByGuid(guid, name);

        // TODO: test validations
    }

    /**
     * Entity Partial Update - Add/Update entity attribute identified by its GUID.
     *
     * Entity Partial Update - Add/Update entity attribute identified by its GUID. Supports only uprimitive attribute type and entity references. does not support updation of complex types like arrays, maps Null updates are not possible
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void partialUpdateEntityAttrByGuidTestQueryMap() {
        String guid = null;
        EntityRestApi.PartialUpdateEntityAttrByGuidQueryParams queryParams = new EntityRestApi.PartialUpdateEntityAttrByGuidQueryParams()
            .name(null);
        // JsonEntityMutationResponse response = api.partialUpdateEntityAttrByGuid(guid, queryParams);

    // TODO: test validations
    }
    /**
     * Entity Partial Update - Allows a subset of attributes to be updated on an entity which is identified by its type and unique attribute  eg: Referenceable.
     *
     * Entity Partial Update - Allows a subset of attributes to be updated on an entity which is identified by its type and unique attribute  eg: Referenceable.qualifiedName. Null updates are not possible  In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  attr:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName and attrValue should be unique across entities, eg. qualifiedName  The REST request would look something like this  PUT /v2/entity/uniqueAttribute/type/aType?attr:aTypeAttribute&#x3D;someValue
     */
    @Test
    public void partialUpdateEntityByUniqueAttrsTest() {
        String typeName = null;
        JsonAtlasEntityWithExtInfo body = null;
        // JsonEntityMutationResponse response = api.partialUpdateEntityByUniqueAttrs(typeName, body);

        // TODO: test validations
    }

    /**
     * Get the sample Template for uploading/creating bulk BusinessMetaData.
     *
     * Get the sample Template for uploading/creating bulk BusinessMetaData
     */
    @Test
    public void produceTemplateTest() {
        // api.produceTemplate();

        // TODO: test validations
    }

    /**
     * 
     *
     * 
     */
    @Test
    public void removeBusinessAttributesTest() {
        String guid = null;
        // api.removeBusinessAttributes(guid);

        // TODO: test validations
    }

    /**
     * 
     *
     * 
     */
    @Test
    public void removeBusinessAttributes_0Test() {
        String bmName = null;
        String guid = null;
        // api.removeBusinessAttributes_0(bmName, guid);

        // TODO: test validations
    }

    /**
     * delete given labels to a given entity.
     *
     * delete given labels to a given entity
     */
    @Test
    public void removeLabelsTest() {
        String guid = null;
        // api.removeLabels(guid);

        // TODO: test validations
    }

    /**
     * 
     *
     * 
     */
    @Test
    public void removeLabels_0Test() {
        String typeName = null;
        List<String> body = null;
        // api.removeLabels_0(typeName, body);

        // TODO: test validations
    }

    /**
     * 
     *
     * 
     */
    @Test
    public void setClassificationsTest() {
        // api.setClassifications();

        // TODO: test validations
    }

    /**
     * Set labels to a given entity.
     *
     * Set labels to a given entity
     */
    @Test
    public void setLabelsTest() {
        String guid = null;
        // api.setLabels(guid);

        // TODO: test validations
    }

    /**
     * 
     *
     * 
     */
    @Test
    public void setLabels_0Test() {
        String typeName = null;
        List<String> body = null;
        // api.setLabels_0(typeName, body);

        // TODO: test validations
    }

    /**
     * Updates classifications to an existing entity represented by a guid.
     *
     * Updates classifications to an existing entity represented by a guid.
     */
    @Test
    public void updateClassificationsTest() {
        String guid = null;
        List<JsonAtlasClassification> body = null;
        // api.updateClassifications(guid, body);

        // TODO: test validations
    }

    /**
     * Updates classification on an entity identified by its type and unique attributes.
     *
     * Updates classification on an entity identified by its type and unique attributes.
     */
    @Test
    public void updateClassificationsByUniqueAttributeTest() {
        String typeName = null;
        List<JsonAtlasClassification> body = null;
        // api.updateClassificationsByUniqueAttribute(typeName, body);

        // TODO: test validations
    }

}
