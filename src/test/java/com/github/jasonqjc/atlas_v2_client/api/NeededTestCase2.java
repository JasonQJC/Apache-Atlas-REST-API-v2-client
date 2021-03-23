package com.github.jasonqjc.atlas_v2_client.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntity;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityHeader;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityWithExtInfo;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasObjectId;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationship;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipEndDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasTypesDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonCardinality;
import com.github.jasonqjc.atlas_v2_client.model.JsonEntityMutationResponse;
import com.github.jasonqjc.atlas_v2_client.model.JsonPropagateTags;
import com.github.jasonqjc.atlas_v2_client.model.JsonRelationshipCategory;
import com.github.jasonqjc.atlas_v2_client.model.JsonStatus;
import com.github.jasonqjc.atlas_v2_client.model.JsonStatusAtlasRelationship;
import com.github.jasonqjc.atlas_v2_client.model.JsonTypeCategory;

@SpringBootTest
public class NeededTestCase2 {

	@Autowired
    private TypesRestApi typeRestApi;
	@Autowired
    private EntityRestApi entityRestApi;
	@Autowired
    private RelationshipRestApi relationshipRestApi;
	@Autowired
    private DiscoveryRestApi discoveryRestApi;

    //类型 使用Table
    //新增数结构枝叶 = 增删改 实体 + 维护关系
    //关系 使用son father
    @Test
    public void finalTest() {
    	//创建关系类型
//    	createRelationType();
    	//创建实体
    	String guidA = createEntity("Entity-A");
    	String guidAA = createEntity("Entity-A-A");
		addRelation(guidA,guidAA);
    	String guidAB = createEntity("Entity-A-B");
    	addRelation(guidA,guidAB);
    	String guidAAA = createEntity("Entity-A-A-A");
    	addRelation(guidAA,guidAAA);
    	String guidAAB = createEntity("Entity-A-A-B");
    	addRelation(guidAA,guidAAB);
    	String guidABA = createEntity("Entity-A-B-A");
    	addRelation(guidAB,guidABA);
    	String guidABB = createEntity("Entity-A-B-B");
    	addRelation(guidAB,guidABB);
    	
    }
    
    /**
     * 创建一个血缘(数据走向)类型
     */
    @Test
    public void createLineageType() {
    	JsonAtlasTypesDef body = new JsonAtlasTypesDef();
    	JsonAtlasEntityDef entityDefsItem = new JsonAtlasEntityDef();
    	entityDefsItem.category(JsonTypeCategory.ENTITY);
    	entityDefsItem.createTime(BigDecimal.valueOf(new Date().getTime()));
    	entityDefsItem.createdBy("qjc");
    	entityDefsItem.description("血缘测试类型");
    	entityDefsItem.name("juhe");
    	entityDefsItem.typeVersion("1.0");
    	entityDefsItem.updateTime(BigDecimal.valueOf(new Date().getTime()));
    	entityDefsItem.updatedBy("qjc");
    	entityDefsItem.version(BigDecimal.valueOf(1.0));
		body.addEntityDefsItem(entityDefsItem);
		JsonAtlasTypesDef createAtlasTypeDefs = typeRestApi.createAtlasTypeDefs(body);
		System.out.println(createAtlasTypeDefs);
    }
    
    /**
     * 创建血缘类型的具体对象(Entity)
     */
    @Test
    public void createLineageTypeEntity() {
    	JsonAtlasEntityWithExtInfo body = new JsonAtlasEntityWithExtInfo();
    	JsonAtlasEntity entity = new JsonAtlasEntity();
    	Map<String, Object> attributes = new HashMap<String, Object>();
		entity.createdBy("qjc");
		entity.createTime(BigDecimal.valueOf(new Date().getTime()));
		entity.updatedBy("qjc");
		entity.updateTime(BigDecimal.valueOf(new Date().getTime()));
		entity.status(JsonStatus.ACTIVE);
		entity.version(BigDecimal.valueOf(2)).isIncomplete(true);
		entity.typeName("juhe");
		entity.setAttributes(new HashMap<String,Object>() {{
        	put("name","aKindOfjuhe");
        	put("displayName","aKindOfjuhe");
        	put("description","description");
        	put("qualifiedName","aKindOfjuhe");
        	put("owner","owner1");
        }});
		
//		String inputGuid = "758d9b71-54f8-4a47-bda0-81e5d7e6fa1b";
//    	String inputTypeName = "Table";
//    	String outputGuid = "3ddce57f-b7d8-462d-80ae-8ce7d8438bc6";
//    	String outTypeName = "Table";
//		JsonAtlasObjectId inputEntity = new JsonAtlasObjectId();
//    	inputEntity.typeName(inputTypeName);
//    	inputEntity.guid(inputGuid);
//		List<JsonAtlasObjectId> inputsList = new ArrayList<>();
//		inputsList.add(inputEntity);
//		
//		
//		JsonAtlasObjectId outEntity = new JsonAtlasObjectId();
//		outEntity.typeName(outTypeName);
//		outEntity.guid(outputGuid);
//		List<JsonAtlasObjectId> outputsList = new ArrayList<>();
//		outputsList.add(outEntity);
//		JsonAtlasObjectId outEntity2 = new JsonAtlasObjectId();
//		outEntity2.typeName("Table");
//		outEntity2.guid("1bb7e059-a409-44e6-a61d-eb9e9ad38244");
//		outputsList.add(outEntity2);
//		
//		attributes.put("inputs", inputsList);
//		attributes.put("outputs", outputsList);
//		
//		attributes.put("owner", "qjc");
//		attributes.put("createTime", new Date().getTime());
//		attributes.put("updateTime", new Date().getTime());
//		attributes.put("qualifiedName", "aKindOfjuhe");
//		attributes.put("name", "aKindOfjuhe");
//		attributes.put("description", "description");
//		attributes.put("comment", "comment");
//		attributes.put("contact_info", "jdbc");
//		attributes.put("type", "juhe");
//		attributes.put("queryText", "queryText");
//		attributes.put("queryPlan", "plan");
//		attributes.put("queryId", "id");
//		attributes.put("queryGraph", "graph");
//		
//		attributes.put("propagate", true);
		
		body.setEntity(entity);
		JsonEntityMutationResponse createOrUpdate = entityRestApi.createOrUpdate(body);
		System.out.println(createOrUpdate.getMutatedEntities());
    }
    
    @Test
    public void createLineageTest() {
    	
    	String entityGuid = "e67805b5-9b42-4304-aa72-5cbca5aaf4a4";
		String entityTypeName = "Table";
		
    	String inputGuid = "758d9b71-54f8-4a47-bda0-81e5d7e6fa1b";
    	String inputTypeName = "Table";
    	String outputGuid = "3ddce57f-b7d8-462d-80ae-8ce7d8438bc6";
    	String outTypeName = "Table";
    	JsonAtlasEntityWithExtInfo body = new JsonAtlasEntityWithExtInfo();
    	JsonAtlasEntity entity = new JsonAtlasEntity();
    	Map<String, Object> attributes = new HashMap<String, Object>();
    	
    	JsonAtlasObjectId inputEntity = new JsonAtlasObjectId();
    	inputEntity.typeName(inputTypeName);
    	inputEntity.guid(inputGuid);
		List<JsonAtlasObjectId> inputsList = new ArrayList<>();
		inputsList.add(inputEntity);
		
		
		JsonAtlasObjectId outEntity = new JsonAtlasObjectId();
		outEntity.typeName(outTypeName);
		outEntity.guid(outputGuid);
		List<JsonAtlasObjectId> outputsList = new ArrayList<>();
		outputsList.add(outEntity);
		JsonAtlasObjectId outEntity2 = new JsonAtlasObjectId();
		outEntity2.typeName("Table");
		outEntity2.guid("1bb7e059-a409-44e6-a61d-eb9e9ad38244");
		outputsList.add(outEntity2);
		
		attributes.put("father", inputsList);
		attributes.put("son", outputsList);
		
		attributes.put("owner", "owner");
		attributes.put("createTime", new Date().getTime());
		attributes.put("updateTime", new Date().getTime());
		attributes.put("qualifiedName", "Entity-A-B");
		attributes.put("name", "Entity-A-B");
		attributes.put("description", "description");
		attributes.put("comment", "comment");
		attributes.put("contact_info", "jdbc");
		attributes.put("type", "Table");
		attributes.put("queryText", "queryText");
		attributes.put("queryPlan", "plan");
		attributes.put("queryId", "id");
		attributes.put("queryGraph", "graph");
		
		attributes.put("propagate", true);
		
		
		
		entity.attributes(attributes);
		entity.guid(entityGuid);
		entity.typeName(entityTypeName);
		body.setEntity(entity);
		entityRestApi.createOrUpdate(body);
    }

	private void addRelation(String guid1, String guid2) {
		JsonAtlasRelationship body = new JsonAtlasRelationship();
        body.createTime(BigDecimal.valueOf(new Date().getTime()));
        body.updateTime(BigDecimal.valueOf(new Date().getTime()));
        body.end1(new JsonAtlasObjectId().guid(guid2).typeName("Table"));
        body.end2(new JsonAtlasObjectId().guid(guid1).typeName("Table"));
        body.propagateTags(JsonPropagateTags.NONE);
        body.provenanceType(BigDecimal.valueOf(123456));
        body.status(JsonStatusAtlasRelationship.ACTIVE);
        body.version(BigDecimal.valueOf(1.0));
        body.typeName("father_and_son");
        JsonAtlasRelationship response = relationshipRestApi.create(body);

        System.out.println(response);
	}

	private void createRelationType() {
		JsonAtlasTypesDef body = new JsonAtlasTypesDef();
        body.businessMetadataDefs(new ArrayList<>());
        body.classificationDefs(new ArrayList<>());
        body.enumDefs(new ArrayList<>());
        List<JsonAtlasRelationshipDef> relationshipDefs = new ArrayList<>();
        JsonAtlasRelationshipDef relationshipDef = new JsonAtlasRelationshipDef();
		relationshipDefs.add(relationshipDef);
		body.relationshipDefs(relationshipDefs);
        body.structDefs(new ArrayList<>());
        body.entityDefs(new ArrayList<>());
        
        relationshipDef.category(JsonTypeCategory.RELATIONSHIP)
        .createdBy("createBy").updatedBy("updatedBy")
        .createTime(BigDecimal.valueOf(new Date().getTime()))
        .updateTime(BigDecimal.valueOf(new Date().getTime()))
        .version(BigDecimal.valueOf(1.0))
        .name("father_and_son")
        .description("tree")
        .typeVersion("1.0");
        relationshipDef.attributeDefs(new ArrayList<>());
        relationshipDef.relationshipCategory(JsonRelationshipCategory.ASSOCIATION);
        relationshipDef.propagateTags(JsonPropagateTags.NONE);
        
        relationshipDef.endDef1(new JsonAtlasRelationshipEndDef() {{
        	setType("Table");
        	setName("father");
        	isContainer(false);
        	cardinality(JsonCardinality.SINGLE);
        	isLegacyAttribute(false);
        }});
        relationshipDef.endDef2(new JsonAtlasRelationshipEndDef() {{
        	setType("Table");
        	setName("son");
        	isContainer(false);
        	cardinality(JsonCardinality.SET);
        	isLegacyAttribute(false);
        }});
        JsonAtlasTypesDef response = typeRestApi.createAtlasTypeDefs(body);
        
        System.out.println(response);
        
	}

	private String createEntity(String entityName) {
        JsonAtlasEntityWithExtInfo body = new JsonAtlasEntityWithExtInfo();
        JsonAtlasEntity entity = new JsonAtlasEntity();
        body.entity(entity);
        entity.businessAttributes(new HashMap<String,Object>());
        entity.classifications(new ArrayList<>());
        entity.isIncomplete(true);
        entity.labels(new ArrayList<>());
        entity.meanings(new ArrayList<>());
        entity.provenanceType(BigDecimal.valueOf(12345));
        entity.proxy(true);
        entity.status(JsonStatus.ACTIVE);
        entity.updateTime(BigDecimal.valueOf(new Date().getTime()));
        entity.version(BigDecimal.valueOf(12345));
        entity.attributes(new HashMap<String,Object>() {{
        	put("name",entityName);
        	put("description","description");
        	put("qualifiedName",entityName);
        	put("owner","owner");
        }});
        entity.typeName("Table");
        JsonEntityMutationResponse response = entityRestApi.createOrUpdate(body);
        List<JsonAtlasEntityHeader> list = response.getMutatedEntities().get("CREATE");
        System.out.println(list.get(0).getGuid());
        return list.get(0).getGuid();
	}
    
}
