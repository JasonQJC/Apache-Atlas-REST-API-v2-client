package com.github.jasonqjc.atlas_v2_client.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasonqjc.atlas_v2_client.ApiClient;
import com.github.jasonqjc.atlas_v2_client.api.DiscoveryRestApi;
import com.github.jasonqjc.atlas_v2_client.api.EntityRestApi;
import com.github.jasonqjc.atlas_v2_client.api.RelationshipRestApi;
import com.github.jasonqjc.atlas_v2_client.api.TypesRestApi;
import com.github.jasonqjc.atlas_v2_client.api.UILoginApi;
import com.github.jasonqjc.atlas_v2_client.api.EntityRestApi.GetByIdQueryParams;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasBaseTypeDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntitiesWithExtInfo;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntity;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityHeader;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityWithExtInfo;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasObjectId;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationship;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipEndDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasSearchResult;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasTypesDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonCardinality;
import com.github.jasonqjc.atlas_v2_client.model.JsonEntityMutationResponse;
import com.github.jasonqjc.atlas_v2_client.model.JsonPropagateTags;
import com.github.jasonqjc.atlas_v2_client.model.JsonRelationshipCategory;
import com.github.jasonqjc.atlas_v2_client.model.JsonStatus;
import com.github.jasonqjc.atlas_v2_client.model.JsonStatusAtlasRelationship;
import com.github.jasonqjc.atlas_v2_client.model.JsonTypeCategory;

import feign.Response;

public class NeededTestCase {

    private TypesRestApi typeRestApi;
    private EntityRestApi entityRestApi;
    private RelationshipRestApi relationshipRestApi;
    private DiscoveryRestApi discoveryRestApi;

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
        typeRestApi = apiClient
        		.buildClient(TypesRestApi.class);
        entityRestApi = apiClient
        		.buildClient(EntityRestApi.class);
        relationshipRestApi = apiClient
        		.buildClient(RelationshipRestApi.class);
        discoveryRestApi = apiClient
        		.buildClient(DiscoveryRestApi.class);
    }
    
    /**
     * 
     * 创建新类型 pass
     * 
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
        JsonAtlasTypesDef response = typeRestApi.createAtlasTypeDefs(body);
        
        System.out.println(response);
    }
	
    /**
     * 创建实体 pass
     * @throws JsonProcessingException 
     */
    @Test
    public void createOrUpdateTest() throws JsonProcessingException {
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
        entity.version(BigDecimal.valueOf(12346));
        entity.attributes(new HashMap<String,Object>() {{
        	put("name","qjc33");
        	put("description","description");
        	put("qualifiedName","dddd3");
        	put("owner","owner");
        }});
        entity.typeName("Table");
        System.out.println(new ObjectMapper().writeValueAsString(body));
        JsonEntityMutationResponse response = entityRestApi.createOrUpdate(body);
        System.out.println(response.getMutatedEntities());
        List<JsonAtlasEntityHeader> list = response.getMutatedEntities().get("CREATE");
        System.out.println(list.get(0).getGuid());
    }
    
    /**
     * 创建新类型(关系) pass
     */
    @Test
    public void createAtlasTypeDefsTest2() {
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
        .name("relation_ship_name")
        .description("relation_ship_desc")
        .typeVersion("1.0");
        relationshipDef.attributeDefs(new ArrayList<>());
        relationshipDef.relationshipCategory(JsonRelationshipCategory.AGGREGATION);
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
        	isContainer(true);
        	cardinality(JsonCardinality.SET);
        	isLegacyAttribute(false);
        }});
        JsonAtlasTypesDef response = typeRestApi.createAtlasTypeDefs(body);
        
        System.out.println(response);
    }
    
    /**
     *  创建关系类型 pass
     */
    @Test
    public void createAtlasTypeDefsTest3() {
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
    
    /**
     * 创建实体之间的关系
     */
    @Test
    public void createRelationshipTest() {
        JsonAtlasRelationship body = new JsonAtlasRelationship();
        body.createTime(BigDecimal.valueOf(new Date().getTime()));
        body.updateTime(BigDecimal.valueOf(new Date().getTime()));
        body.end1(new JsonAtlasObjectId().guid(null).typeName(null).uniqueAttributes(null));
        body.end2(new JsonAtlasObjectId().guid(null).typeName(null).uniqueAttributes(null));
        body.propagateTags(JsonPropagateTags.NONE);
        body.provenanceType(BigDecimal.valueOf(123456));
        body.status(JsonStatusAtlasRelationship.ACTIVE);
        body.version(BigDecimal.valueOf(1.0));
        body.typeName("typeName");
        JsonAtlasRelationship response = relationshipRestApi.create(body);

        System.out.println(response);
    }
    
    /**
     * 创建血缘关系
     */
    @Test
    public void createLineageTest() {
    	JsonAtlasEntitiesWithExtInfo body = new JsonAtlasEntitiesWithExtInfo();
    	List<JsonAtlasEntity> entities = new ArrayList<JsonAtlasEntity>();
    	JsonAtlasEntity jsonAtlasEntity = new JsonAtlasEntity();
    	jsonAtlasEntity.typeName("typeName");
    	Map<String, Object> attributes = new HashMap<String, Object>(){{
			put("owner", "dengye");
			put("createTime", "2020-05-07T10:32:21.0Z");
			put("updateTime", "");
			put("qualifiedName", "people@process@mysql://192.168.1.1:3306");
			put("name", "peopleProcess");
			put("description", "people Process");
			put("comment", "test people Process");
			put("contact_info", "jdbc");
			put("type", "Table");
			put("queryText", "create table as select ");
			put("queryPlan", "plan");
			put("queryId", "id");
			put("queryGraph", "graph");
			put("inputs", new ArrayList() {{
				add(new JsonAtlasObjectId().guid("").typeName(""));
			}});
			put("outputs", new ArrayList() {{
				add(new JsonAtlasObjectId().guid("").typeName(""));
			}});
    	}};
		jsonAtlasEntity.attributes(attributes);
		entities.add(jsonAtlasEntity);
		body.entities(entities);
        JsonEntityMutationResponse response = entityRestApi.createOrUpdate_3(body);

        System.out.println(response);
    }
    
    /**
     * 通过名称查询类型
     */
    @Test
    public void getTypeDefByNameTest() {
        String name = "LoadProcess";
        JsonAtlasBaseTypeDef response = typeRestApi.getTypeDefByName(name);
        System.out.println(ToStringBuilder.reflectionToString(response,ToStringStyle.JSON_STYLE));
    }
    
    /**
     * 查询实体
     */
    @Test
    public void getEntityTest() {
    	JsonAtlasSearchResult searchUsingDSL = discoveryRestApi.searchUsingDSL(null, 10, 0, "where name=\"customer_dim\"", "Table");
    	List<JsonAtlasEntityHeader> entities = searchUsingDSL.getEntities();
    	System.out.println(entities.get(0));
    }
    
    @Test
    public void getEntityTest2() {
    	//loadSalesDaily (LoadProcess)
    	JsonAtlasEntityWithExtInfo byId = entityRestApi.getById("48e269e0-401e-4c24-8ff6-c18124ab2808", new GetByIdQueryParams());
    	System.out.println(ToStringBuilder.reflectionToString(byId));
    }
    
    /**
     * 删除实体
     */
    @Test
    public void deleteEntityTest() {
//    	discoveryRestApi.searchRelatedEntities(null, null, null, null, null, "", null, null);
//    	JsonAtlasRelationshipDef relationshipDefByName = typeRestApi.getRelationshipDefByName("father_and_son");
//    	System.out.println(relationshipDefByName);
    	JsonAtlasSearchResult searchUsingDSL = discoveryRestApi.searchUsingDSL(null, 100, 0, "where name like 'Entity*' or name like 'QJC*'", "Table");
    	List<String> collect = searchUsingDSL.getEntities().stream().map(item -> item.getGuid()).collect(Collectors.toList());
		System.out.println(collect);
    	JsonEntityMutationResponse deleteByGuids = entityRestApi.deleteByGuids(collect);
    	System.out.println(deleteByGuids);
    }
    
}
