package com.github.jasonqjc.atlas_v2_client.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Before;
import org.junit.Test;

import com.github.jasonqjc.atlas_v2_client.ApiClient;
import com.github.jasonqjc.atlas_v2_client.api.TypesRestApi;
import com.github.jasonqjc.atlas_v2_client.api.UILoginApi;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasBaseTypeDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasTypesDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonTypeCategory;

import feign.Response;

/**
 * API tests for TypesRestApi
 */
public class TypesRestApiTest {

    private TypesRestApi api;

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
        		.buildClient(TypesRestApi.class);
    }

    /**
     * Bulk create APIs for all atlas type definitions, only new definitions will be created.
     *
     * Bulk create APIs for all atlas type definitions, only new definitions will be created. Any changes to the existing definitions will be discarded
     */
    @Test
    public void createAtlasTypeDefsTest() {
        JsonAtlasTypesDef body = new JsonAtlasTypesDef();
        body.businessMetadataDefs(new ArrayList<>());
        body.classificationDefs(new ArrayList<>());
        body.enumDefs(new ArrayList<>());
        body.relationshipDefs(new ArrayList<>());
        body.structDefs(new ArrayList<>());
        List<JsonAtlasEntityDef> entityDefs = new ArrayList<>();
        body.entityDefs(entityDefs);
        JsonAtlasEntityDef jsonAtlasStructDef = new JsonAtlasEntityDef();
        entityDefs.add(jsonAtlasStructDef);
        jsonAtlasStructDef.category(JsonTypeCategory.ENTITY);
        jsonAtlasStructDef.name("test_db2");
        jsonAtlasStructDef.addSuperTypesItem("DataSet");
        jsonAtlasStructDef.typeVersion("1.0");
        jsonAtlasStructDef.version(BigDecimal.valueOf(1));
        System.out.println(ReflectionToStringBuilder.toString(body,ToStringStyle.JSON_STYLE));
        JsonAtlasTypesDef response = api.createAtlasTypeDefs(body);
        
        System.out.println(response);
    }

    /**
     * Delete API for type identified by its name.
     *
     * Delete API for type identified by its name.
     */
    @Test
    public void deleteAtlasTypeByNameTest() {
        String typeName = "juhe";
         api.deleteAtlasTypeByName(typeName);

    }

    /**
     * Bulk delete API for all types.
     *
     * Bulk delete API for all types
     */
    @Test
    public void deleteAtlasTypeDefsTest() {
        JsonAtlasTypesDef body = null;
        // api.deleteAtlasTypeDefs(body);

        // TODO: test validations
    }

    /**
     * Bulk retrieval API for retrieving all type definitions in Atlas.
     *
     * Bulk retrieval API for retrieving all type definitions in Atlas
     */
    @Test
    public void getAllTypeDefsTest() {
        JsonAtlasTypesDef response = api.getAllTypeDefs(null);
        System.out.println(ToStringBuilder.reflectionToString(response, ToStringStyle.JSON_STYLE));
        // TODO: test validations
    }

    /**
     * Get the businessMetadata definition for the given guid.
     *
     * Get the businessMetadata definition for the given guid
     */
    @Test
    public void getBusinessMetadataDefByGuidTest() {
        String guid = null;
        // JsonAtlasBusinessMetadataDef response = api.getBusinessMetadataDefByGuid(guid);

        // TODO: test validations
    }

    /**
     * Get the businessMetadata definition by it&#x27;s name (unique).
     *
     * Get the businessMetadata definition by it&#x27;s name (unique)
     */
    @Test
    public void getBusinessMetadataDefByNameTest() {
        String name = null;
        // JsonAtlasBusinessMetadataDef response = api.getBusinessMetadataDefByName(name);

        // TODO: test validations
    }

    /**
     * Get the classification definition for the given guid.
     *
     * Get the classification definition for the given guid
     */
    @Test
    public void getClassificationDefByGuidTest() {
        String guid = null;
        // JsonAtlasClassificationDef response = api.getClassificationDefByGuid(guid);

        // TODO: test validations
    }

    /**
     * Get the classification definition by it&#x27;s name (unique).
     *
     * Get the classification definition by it&#x27;s name (unique)
     */
    @Test
    public void getClassificationDefByNameTest() {
        String name = null;
        // JsonAtlasClassificationDef response = api.getClassificationDefByName(name);

        // TODO: test validations
    }

    /**
     * Get the Entity definition for the given guid.
     *
     * Get the Entity definition for the given guid
     */
    @Test
    public void getEntityDefByGuidTest() {
        String guid = "a36e8d5f-c7ca-43a8-82eb-364de554113f";
        JsonAtlasEntityDef response = api.getEntityDefByGuid(guid);
        System.out.println(response);
    }

    /**
     * Get the entity definition by it&#x27;s name (unique).
     *
     * Get the entity definition by it&#x27;s name (unique)
     */
    @Test
    public void getEntityDefByNameTest() {
        String name = "dataset_process_inputs";
        JsonAtlasEntityDef response = api.getEntityDefByName(name);
        System.out.println(response);
    }

    /**
     * Get the enum definition for the given guid.
     *
     * Get the enum definition for the given guid
     */
    @Test
    public void getEnumDefByGuidTest() {
        String guid = null;
        // JsonAtlasEnumDef response = api.getEnumDefByGuid(guid);

        // TODO: test validations
    }

    /**
     * Get the enum definition by it&#x27;s name (unique).
     *
     * Get the enum definition by it&#x27;s name (unique)
     */
    @Test
    public void getEnumDefByNameTest() {
        String name = null;
        // JsonAtlasEnumDef response = api.getEnumDefByName(name);

        // TODO: test validations
    }

    /**
     * Get the relationship definition for the given guid.
     *
     * Get the relationship definition for the given guid
     */
    @Test
    public void getRelationshipDefByGuidTest() {
        String guid = "648d26d4-4600-419f-b2af-503ecafd3e48";
        JsonAtlasRelationshipDef response = api.getRelationshipDefByGuid(guid);
        System.out.println(response);
    }

    /**
     * Get the relationship definition by it&#x27;s name (unique).
     *
     * Get the relationship definition by it&#x27;s name (unique)
     */
    @Test
    public void getRelationshipDefByNameTest() {
        String name = "dataset_process_inputs";
        JsonAtlasRelationshipDef response = api.getRelationshipDefByName(name);
        System.out.println(response);
    }

    /**
     * Get the struct definition for the given guid.
     *
     * Get the struct definition for the given guid
     */
    @Test
    public void getStructDefByGuidTest() {
        String guid = null;
        // JsonAtlasStructDef response = api.getStructDefByGuid(guid);

        // TODO: test validations
    }

    /**
     * Get the struct definition by it&#x27;s name (unique).
     *
     * Get the struct definition by it&#x27;s name (unique)
     */
    @Test
    public void getStructDefByNameTest() {
        String name = null;
        // JsonAtlasStructDef response = api.getStructDefByName(name);

        // TODO: test validations
    }

    /**
     * 
     *
     * 
     */
    @Test
    public void getTypeDefByGuidTest() {
        String guid = "648d26d4-4600-419f-b2af-503ecafd3e48";
        JsonAtlasBaseTypeDef response = api.getTypeDefByGuid(guid);
        System.out.println(response);
    }

    /**
     * Get type definition by it&#x27;s name.
     *
     * Get type definition by it&#x27;s name
     */
    @Test
    public void getTypeDefByNameTest() {
        String name = "dataset_process_inputs";
        JsonAtlasBaseTypeDef response = api.getTypeDefByName(name);
        System.out.println(ToStringBuilder.reflectionToString(response,ToStringStyle.JSON_STYLE));
        // TODO: test validations
    }

    /**
     * Bulk retrieval API for all type definitions returned as a list of minimal information header.
     *
     * Bulk retrieval API for all type definitions returned as a list of minimal information header
     */
    @Test
    public void getTypeDefHeadersTest() {
        // List<JsonAtlasTypeDefHeader> response = api.getTypeDefHeaders();

        // TODO: test validations
    }

    /**
     * Bulk update API for all types, changes detected in the type definitions would be persisted.
     *
     * Bulk update API for all types, changes detected in the type definitions would be persisted
     */
    @Test
    public void updateAtlasTypeDefsTest() {
        JsonAtlasTypesDef body = null;
        // JsonAtlasTypesDef response = api.updateAtlasTypeDefs(body);

        // TODO: test validations
    }

}
