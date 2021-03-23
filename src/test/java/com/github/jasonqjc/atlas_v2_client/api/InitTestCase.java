package com.github.jasonqjc.atlas_v2_client.api;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.jasonqjc.atlas_v2_client.controller.ApiController.EntityUpdateDTO;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasAttributeDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipEndDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasTypesDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonCardinality;
import com.github.jasonqjc.atlas_v2_client.model.JsonPropagateTags;
import com.github.jasonqjc.atlas_v2_client.model.JsonRelationshipCategory;
import com.github.jasonqjc.atlas_v2_client.model.JsonTypeCategory;
import com.github.jasonqjc.atlas_v2_client.service.ApiService;

@SpringBootTest
public class InitTestCase {

	@Autowired
    private TypesRestApi typeRestApi;
	@Autowired
    private EntityRestApi entityRestApi;
	@Autowired
    private RelationshipRestApi relationshipRestApi;
	@Autowired
    private DiscoveryRestApi discoveryRestApi;

    @Test
    public void test() {
//    	JsonAtlasTypesDef createBaseType = createBaseType();
//    	System.out.println(createBaseType);
//    	JsonAtlasTypesDef createSubType = createSubType();
//    	System.out.println(createSubType);
//    	JsonAtlasTypesDef createRelationType = createRelationType();
//    	System.out.println(createRelationType);
    	
    }
    
    @Test
    public void test2() throws ClassNotFoundException {
    	Class<?> clas = Class.forName("com.github.jasonqjc.atlas_v2_client.custommodel."+"Item");
    	Field[] declaredFields = clas.getDeclaredFields();
    	Map<String,Object> map = new HashMap<>();
    	map.put("aa", "dasdas");
    	map.put("itemName", "itemName");
    	map.put("createTime", "createTime");
    	Map<String,Object> result = new HashMap<>();
    	for (Field field : declaredFields) {
			if(map.containsKey(field.getName())) {
				result.put(field.getName(),map.get(field.getName()));
			}
		}
    	Class<?> superclass = clas.getSuperclass();
    	if(superclass != null) {
    		Field[] declaredFields2 = superclass.getDeclaredFields();
    		for (Field field : declaredFields2) {
    			if(map.containsKey(field.getName())) {
    				result.put(field.getName(),map.get(field.getName()));
    			}
    		}
    	}
    	System.out.println(result);
    }

    @Autowired
    ApiService apiService;
    
    @Test
    public void test3() throws ClassNotFoundException {
    	EntityUpdateDTO entityUpdateDTO = new EntityUpdateDTO();
    	entityUpdateDTO.setTypeName("MicroPhyTable");
    	Map<String, String> customAttributes = new HashMap<>();
    	customAttributes.put("tableName", "tableName1");
    	customAttributes.put("version", "version1");
    	customAttributes.put("type", "type1");
    	customAttributes.put("tableDescribe", "tableDescribe1");
    	customAttributes.put("createTime", "createTime1");
    	customAttributes.put("createUser", "createUser1");
    	customAttributes.put("modifyTime", "modifyTime1");
    	customAttributes.put("modifyUser", "modifyUser1");
    	entityUpdateDTO.setCustomAttributes(customAttributes);
    	
    	Map<String, Object> attributes = new HashMap<>();
    	attributes.put("userDescription", "userDescription");
    	attributes.put("displayName", "displayName");
    	attributes.put("name", "MicroPhyTable_002");
    	attributes.put("description", "description");
    	attributes.put("owner", "owner");
    	attributes.put("qualifiedName", "MicroPhyTable_002");
    	
    	attributes.put("tableName", "tableName");
    	attributes.put("version", "version");
    	attributes.put("type", "type");
    	attributes.put("tableDescribe", "tableDescribe");
    	attributes.put("createTime", "createTime");
    	attributes.put("createUser", "createUser");
    	attributes.put("modifyTime", "modifyTime");
    	attributes.put("modifyUser", "modifyUser");
    	
		entityUpdateDTO.setAttributes(attributes);
		
		apiService.createOrUpdateEntity(entityUpdateDTO);
    }

    private JsonAtlasTypesDef createRelationType() {
		BigDecimal nowUnixTime = BigDecimal.valueOf(new Date().getTime());
		JsonAtlasTypesDef body = new JsonAtlasTypesDef();
		
		JsonAtlasRelationshipDef relationshipDef = new JsonAtlasRelationshipDef();
		
		relationshipDef.name("VBaseRelation").category(JsonTypeCategory.RELATIONSHIP)
		.createTime(nowUnixTime).createdBy("vicson")
		.description("基础关系").updateTime(nowUnixTime).updatedBy("vicson");
		relationshipDef.relationshipCategory(JsonRelationshipCategory.ASSOCIATION);
		relationshipDef.propagateTags(JsonPropagateTags.NONE);
		
		relationshipDef.endDef1(new JsonAtlasRelationshipEndDef()
				.cardinality(JsonCardinality.SET)
				.description("any")
				.isContainer(false)
				.isLegacyAttribute(false)
				.name("end1")
				.type("BaseType"));
		relationshipDef.endDef2(new JsonAtlasRelationshipEndDef()
				.cardinality(JsonCardinality.SET)
				.description("any")
				.isContainer(false)
				.isLegacyAttribute(false)
				.name("end2")
				.type("BaseType"));
		
		body.addRelationshipDefsItem(relationshipDef);
		
		return typeRestApi.createAtlasTypeDefs(body); 
	}
    

	private JsonAtlasTypesDef createSubType() {
		BigDecimal nowUnixTime = BigDecimal.valueOf(new Date().getTime());
		JsonAtlasTypesDef body = new JsonAtlasTypesDef();
		
		body.addEntityDefsItem(
				typeDefBaseType("MicroOriginalTable","微观原始表","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("tableName","tableCode","tableDescribe","year","htmlBy","sourceType","dataSource")));
		body.addEntityDefsItem(
				typeDefBaseType("MicroPhyTable","微观物理表","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("tableName","version","type","tableDescribe")));
		body.addEntityDefsItem(
				typeDefBaseType("MicroBaseTable","微观聚合表、主题表、目录表","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("tableName","tableCode","tableDescribe","tableType","loadTaskPath")));
		body.addEntityDefsItem(
				typeDefBaseType("MicroProcess","微观处理过程","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("processPath","processType")));
		body.addEntityDefsItem(
				typeDefBaseType("MicroTask","微观任务","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("taskName","taskCode","taskCycle","IPO")));
		body.addEntityDefsItem(
				typeDefBaseType("MicroTaskTable","微观任务表","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("isInputOrOutput","tableName","tableCode","tabledescribe")));
		body.addEntityDefsItem(
				typeDefBaseType("MicroColumn","微观表列","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("colCName","colEName","colDataType","sort","colComments")));
		body.addEntityDefsItem(
				typeDefBaseType("Item","数据资产主题","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("itemName","type","isTopItem")));
		body.addEntityDefsItem(
				typeDefBaseType("Publish","发布模板","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("articleName","articleCode","bgqType","articlePath")));
		body.addEntityDefsItem(
				typeDefBaseType("PublishObj","发布实例","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("articleName","articleCode","bgq","articleObjPath")));
		body.addEntityDefsItem(
				typeDefBaseType("ArticleObj","文章实例","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("artName","artCode","bgq","content")));
		body.addEntityDefsItem(
				typeDefBaseType("MacroRpt","宏观报表","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("bgqType","rptName","rptCode")));
		body.addEntityDefsItem(
				typeDefBaseType("MacroRptTemplate","宏观报表模板","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("startTime","endTime","templateName","templateDescribe")));
		body.addEntityDefsItem(
				typeDefBaseType("MacroRptTemplateCell","宏观报表模板单元格","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("x","y","bgqType")));
		body.addEntityDefsItem(
				typeDefBaseType("MacroRptTemplateObj","宏报模板实例","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("bgq")));
		body.addEntityDefsItem(
				typeDefBaseType("MacroRptTemplateObjCell","宏观报表模板实例单元格","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("x","y")));
		body.addEntityDefsItem(
				typeDefBaseType("MacroData","宏观数据","VBaseType",nowUnixTime,
						createSimpleAttributeDefs("value","time")));
		return typeRestApi.createAtlasTypeDefs(body);
	}


	private List<JsonAtlasAttributeDef> createSimpleAttributeDefs(String... attrNames) {
		List<JsonAtlasAttributeDef> attributeDefs = new ArrayList<>();
		for (String name : attrNames) {
			attributeDefs.add(new JsonAtlasAttributeDef().name(name).typeName("string")
					.cardinality(JsonCardinality.SINGLE));
		}
		return attributeDefs;
	}


	private JsonAtlasTypesDef createBaseType() {
		BigDecimal nowUnixTime = BigDecimal.valueOf(new Date().getTime());
		JsonAtlasTypesDef body = new JsonAtlasTypesDef();
		
		//创建VBaseTable 属性createTime createUser modifyTime modifyUser,父类 DataSet
    	//创建其他类型 父类VBaseTable
    	//创建VBaseColumn 父类 DataSet
		addBaseEntityDef(nowUnixTime, body);
		//创建VBaseProcess 父类 Process,暂时不需要
		//addBaseRelationDef(nowUnixTime, body);
		
		return typeRestApi.createAtlasTypeDefs(body);
	}

	private void addBaseEntityDef(BigDecimal nowUnixTime, JsonAtlasTypesDef body) {
		List<JsonAtlasAttributeDef> attributeDefs = new ArrayList<>();
		attributeDefs.add(new JsonAtlasAttributeDef().name("createTime").typeName("string").cardinality(JsonCardinality.SINGLE));
		attributeDefs.add(new JsonAtlasAttributeDef().name("createUser").typeName("string").cardinality(JsonCardinality.SINGLE));
		attributeDefs.add(new JsonAtlasAttributeDef().name("modifyTime").typeName("string").cardinality(JsonCardinality.SINGLE));
		attributeDefs.add(new JsonAtlasAttributeDef().name("modifyUser").typeName("string").cardinality(JsonCardinality.SINGLE));
		body.addEntityDefsItem(typeDefBaseType("VBaseType","基础类型","DataSet",nowUnixTime,attributeDefs));
		body.addEntityDefsItem(typeDefBaseType("VBaseColumn","基础类型","VBaseType",nowUnixTime));
		body.addEntityDefsItem(typeDefBaseType("VBaseTable","基础类型","VBaseType",nowUnixTime));
	}

	private JsonAtlasEntityDef typeDefBaseType(String typeName,String desc,String superType,BigDecimal nowUnixTime) {
		return this.typeDefBaseType(typeName, desc, superType, nowUnixTime, null);
	}
	
	private JsonAtlasEntityDef typeDefBaseType(String typeName,String desc,String superType,BigDecimal nowUnixTime, List<JsonAtlasAttributeDef> attributeDefs) {
		JsonAtlasEntityDef entityDef = new JsonAtlasEntityDef();
		entityDef.name(typeName);
		entityDef.category(JsonTypeCategory.ENTITY);
		entityDef.createTime(nowUnixTime);
		entityDef.createdBy("vicson");
		entityDef.description(desc);
		entityDef.updateTime(nowUnixTime);
		entityDef.updatedBy("vicson");
		entityDef.addSuperTypesItem(superType);
		if(attributeDefs != null && attributeDefs.size() > 0) {
			entityDef.addAttributeDefsItem(attributeDefs);
		}
		return entityDef;
	}
    
}
