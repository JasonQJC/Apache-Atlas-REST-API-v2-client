package com.github.jasonqjc.atlas_v2_client.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasBaseTypeDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasBusinessMetadataDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasClassificationDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEnumDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasStructDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasTypeDefHeader;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasTypesDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonTypeCategory;

/**
 * API tests for TypesRestApi
 */
@SpringBootTest
public class TypesRestApiTest {

	@Autowired
    private TypesRestApi api;

    /**
     * Bulk create APIs for all atlas type definitions, only new definitions will be created. 
     * Any changes to the existing definitions will be discarded
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
     */
    @Test
    public void deleteAtlasTypeByNameTest() {
//        String typeName2 = "MicroOriginalTable";
//        String typeName3 = "MicroPhyTable";
//        String typeName4 = "MicroTable";
        String typeName5 = "BaseType";
        api.deleteAtlasTypeByName(typeName5);
        
//        JsonAtlasBaseTypeDef typeDefByName = api.getTypeDefByName("BaseType");
//        System.out.println(typeDefByName);
//        JsonAtlasBaseTypeDef typeDefByGuid = api.getTypeDefByGuid("13c89a6e-f2cb-4033-a9b7-832a39658d96");
//        System.out.println(typeDefByGuid);
        
    }

    /**
     * Bulk delete API for all types.
     *
     */
    @Test
    public void deleteAtlasTypeDefsTest() {
        JsonAtlasTypesDef body = new JsonAtlasTypesDef();
        JsonAtlasEntityDef entityDef = new JsonAtlasEntityDef();
        body.addEntityDefsItem(entityDef);
        
		entityDef.name("BaseType");
		
        api.deleteAtlasTypeDefs(body);
    }

    /**
     * Bulk retrieval API for retrieving all type definitions in Atlas.
     *
     */
    @Test
    public void getAllTypeDefsTest() {
    	Map<String,String> map = new HashMap<String, String>();
//    	map.put("typeName", "View");
//    	map.put("excludeInternalTypesAndReference", "false");
    	
//    	map.put("name", "PII_v1");
//    	map.put("excludeInternalTypesAndReference", "true");
    	
//    	map.put("excludeInternalTypesAndReference", "true");
//    	map.put("type", JsonTypeCategory.ENTITY.getValue());
//    	map.put("name", "process_dataset_outputs");
//    	map.put("serviceType", "atlas_core");
    	map.put("excludeInternalTypesAndReference", "false");
    	map.put("type", JsonTypeCategory.RELATIONSHIP.getValue());
    	map.put("servicetype", "atlas_core");
        JsonAtlasTypesDef response = api.getAllTypeDefs(map);
        System.out.println(response.getRelationshipDefs().get(0));
    }

    /**
     * Get the businessMetadata definition for the given guid.
     *
     */
    @Test
    public void getBusinessMetadataDefByGuidTest() {
        String guid = "51a77df8-61fa-4ce9-9a0a-610fed60bff8";
        JsonAtlasBusinessMetadataDef response = api.getBusinessMetadataDefByGuid(guid);
        System.out.println(response);
    }

    /**
     * Get the businessMetadata definition by it&#x27;s name (unique).
     *
     */
    @Test
    public void getBusinessMetadataDefByNameTest() {
        String name = "test_businessMetadata";
        JsonAtlasBusinessMetadataDef response = api.getBusinessMetadataDefByName(name);
        System.out.println(response);
    }

    /**
     * Get the classification definition for the given guid.
     *
     */
    @Test
    public void getClassificationDefByGuidTest() {
        String guid = "4298c0cb-4c62-4b9b-9acb-512f98d50442";
        JsonAtlasClassificationDef response = api.getClassificationDefByGuid(guid);
        System.out.println(response);
    }

    /**
     * Get the classification definition by it&#x27;s name (unique).
     *
     */
    @Test
    public void getClassificationDefByNameTest() {
        String name = "PII_v1";
        JsonAtlasClassificationDef response = api.getClassificationDefByName(name);
        System.out.println(response);
    }

    /**
     * Get the Entity definition for the given guid.
     *
     */
    @Test
    public void getEntityDefByGuidTest() {
        String guid = "8ee97417-4bec-477c-9252-051d93e54ddb";
        JsonAtlasEntityDef response = api.getEntityDefByGuid(guid);
        System.out.println(response);
    }

    /**
     * Get the entity definition by it&#x27;s name (unique).
     *
     */
    @Test
    public void getEntityDefByNameTest() {
        String name = "Process";
        JsonAtlasEntityDef response = api.getEntityDefByName(name);
        System.out.println(response);
    }

    /**
     * Get the enum definition for the given guid.
     *
     */
    @Test
    public void getEnumDefByGuidTest() {
        String guid = "dd0e60c5-31e4-4257-9e75-72e30e3e2c5e";
        JsonAtlasEnumDef response = api.getEnumDefByGuid(guid);
        System.out.println(response);
    }

    /**
     * Get the enum definition by it&#x27;s name (unique).
     *
     */
    @Test
    public void getEnumDefByNameTest() {
        String name = "file_action";
        JsonAtlasEnumDef response = api.getEnumDefByName(name);
        System.out.println(response);
    }

    /**
     * Get the relationship definition for the given guid.
     *
     */
    @Test
    public void getRelationshipDefByGuidTest() {
        String guid = "02f83994-8c48-43fa-9c6d-3c887468f613";
        JsonAtlasRelationshipDef response = api.getRelationshipDefByGuid(guid);
        System.out.println(response);
    }

    /**
     * Get the relationship definition by it&#x27;s name (unique).
     *
     */
    @Test
    public void getRelationshipDefByNameTest() {
        String name = "process_dataset_outputs";
        JsonAtlasRelationshipDef response = api.getRelationshipDefByName(name);
        System.out.println(response);
    }

    /**
     * Get the struct definition for the given guid.
     *
     */
    @Test
    public void getStructDefByGuidTest() {
        String guid = "8bb928db-cf20-4549-9c5c-d958ffed149b";
        JsonAtlasStructDef response = api.getStructDefByGuid(guid);
        System.out.println(response);
    }

    /**
     * Get the struct definition by it&#x27;s name (unique).
     *
     */
    @Test
    public void getStructDefByNameTest() {
        String name = "aws_tag";
        JsonAtlasStructDef response = api.getStructDefByName(name);
        System.out.println(response);
    }

    @Test
    public void getTypeDefByGuidTest() {
        String guid = "648d26d4-4600-419f-b2af-503ecafd3e48";
        JsonAtlasBaseTypeDef response = api.getTypeDefByGuid(guid);
        System.out.println(response);
    }

    /**
     * Get type definition by it&#x27;s name.
     */
    @Test
    public void getTypeDefByNameTest() {
        String name = "Table_Columns";
        JsonAtlasBaseTypeDef response = api.getTypeDefByName(name);
        System.out.println(response);
    }

    /**
     * Bulk retrieval API for all type definitions returned as a list of minimal information header.
     *
     */
    @Test
    public void getTypeDefHeadersTest() {
    	Map<String,String> map = new HashMap<>();
//    	map.put("name", "dataset_process_inputs");
//    	map.put("typeName", "LoadProcess");
////    	map.put("name", "LoadProcess");
    	
    	map.put("excludeInternalTypesAndReference", "false");
    	map.put("type", JsonTypeCategory.RELATIONSHIP.getValue());
    	map.put("servicetype", "atlas_core");
    	
        List<JsonAtlasTypeDefHeader> response = api.getTypeDefHeaders(map);
        System.out.println(response);
    }

    /**
     * Bulk update API for all types, changes detected in the type definitions would be persisted.
     *
     */
    @Test
    public void updateAtlasTypeDefsTest() {
        JsonAtlasTypesDef body = new JsonAtlasTypesDef();
        JsonAtlasEntityDef entityDef = new JsonAtlasEntityDef();
        body.addEntityDefsItem(entityDef);
        entityDef.name("BaseType");
        entityDef.category(JsonTypeCategory.ENTITY);
        entityDef.attributeDefs(new ArrayList<>());
        JsonAtlasTypesDef response = api.updateAtlasTypeDefs(body);
        System.out.println(response);
    }

}
