package com.github.jasonqjc.atlas_v2_client.api;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.jasonqjc.atlas_v2_client.controller.ApiController.EntityUpdateDTO;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasAttributeDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasObjectId;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationship;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipEndDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasStruct;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasTypeDefHeader;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasTypesDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonCardinality;
import com.github.jasonqjc.atlas_v2_client.model.JsonPropagateTags;
import com.github.jasonqjc.atlas_v2_client.model.JsonRelationshipCategory;
import com.github.jasonqjc.atlas_v2_client.model.JsonStatusAtlasRelationship;
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
	@Autowired
    ApiService apiService;
	

    @Test
    public void test() throws ClassNotFoundException {
//    	JsonAtlasTypesDef createBaseType = createBaseType();
//    	System.out.println(createBaseType);
//    	JsonAtlasTypesDef createSubType = createSubType();
//    	System.out.println(createSubType);
//    	JsonAtlasTypesDef createRelationType = createRelationType();
//    	System.out.println(createRelationType);
//    	generateSomeEntity();
    	generateRelation();
    }
    
    private JsonAtlasTypesDef generateRelation() {
        Set<String> joinedRelationStrings = getDistinctComparedJoinedStrings();
        BigDecimal nowUnixTime = BigDecimal.valueOf(new Date().getTime());
        JsonAtlasTypesDef body = new JsonAtlasTypesDef();
        joinedRelationStrings.forEach(relationString -> {
        	String[] split = relationString.split(JOIN_STR);
        	String relationEnd1 = split[0];
        	String relationEnd2 = split[0];
        	JsonAtlasRelationshipDef relationshipDef = new JsonAtlasRelationshipDef();
        	body.addRelationshipDefsItem(relationshipDef);
        	relationshipDef.name(JOIN_STR).category(JsonTypeCategory.RELATIONSHIP)
    		.createTime(nowUnixTime).createdBy("vicson")
    		.description(JOIN_STR).updateTime(nowUnixTime).updatedBy("vicson");
    		relationshipDef.relationshipCategory(JsonRelationshipCategory.ASSOCIATION);
    		relationshipDef.propagateTags(JsonPropagateTags.BOTH);
    		relationshipDef.endDef1(new JsonAtlasRelationshipEndDef()
    				.cardinality(JsonCardinality.SET)
    				.description(relationEnd1)
    				.isContainer(false)
    				.isLegacyAttribute(false)
    				.name("related_"+relationEnd1)
    				.type(relationEnd1));
    		relationshipDef.endDef2(new JsonAtlasRelationshipEndDef()
    				.cardinality(JsonCardinality.SET)
    				.description(relationEnd2)
    				.isContainer(false)
    				.isLegacyAttribute(false)
    				.name("related_"+relationEnd2)
    				.type(relationEnd2));
        });
		return typeRestApi.createAtlasTypeDefs(body);
	}

	private Set<String> getDistinctComparedJoinedStrings() {
		Set<String> set = new HashSet<>();
		set.add(getComparedJoinedString("MicroOriginalTable","Item"));
		set.add(getComparedJoinedString("MicroOriginalTable","MicroPhyTable"));
		set.add(getComparedJoinedString("MicroPhyTable","MicroOriginalTable"));
		set.add(getComparedJoinedString("MicroBaseTable","Item"));
		set.add(getComparedJoinedString("MicroBaseTable","MicroColumn"));
		set.add(getComparedJoinedString("MicroTask","Item"));
		set.add(getComparedJoinedString("MicroTask","MicroTaskTable"));
		set.add(getComparedJoinedString("MicroTask","MicroProcess"));
		set.add(getComparedJoinedString("MicroTaskTable","MicroTask"));
		set.add(getComparedJoinedString("MicroColumn","MicroPhyTable"));
		set.add(getComparedJoinedString("MicroColumn","MicroTaskTable"));
		set.add(getComparedJoinedString("MicroColumn","MicroColumn"));
		set.add(getComparedJoinedString("Item","Item"));
		set.add(getComparedJoinedString("Item","MicroTask"));
		set.add(getComparedJoinedString("Item","MacroRpt"));
		set.add(getComparedJoinedString("Item","Publish"));
		set.add(getComparedJoinedString("Item","BiItemTable"));
		set.add(getComparedJoinedString("Item","Article"));
		set.add(getComparedJoinedString("Publish","Item"));
		set.add(getComparedJoinedString("Publish","Publish"));
		set.add(getComparedJoinedString("PublishObj","Publish"));
		set.add(getComparedJoinedString("Article","Item"));
		set.add(getComparedJoinedString("Article","ArticleObj"));
		set.add(getComparedJoinedString("ArticleObj","Article"));
		set.add(getComparedJoinedString("MicroPhyTableLog","MicroOriginalTable"));
		set.add(getComparedJoinedString("MicroPhyTableYTB","MicroOriginalTable"));
		set.add(getComparedJoinedString("MacroRpt","Item"));
		set.add(getComparedJoinedString("MacroRpt","MacroRptTemplate"));
		set.add(getComparedJoinedString("MacroRptTemplate","MacroRpt"));
		set.add(getComparedJoinedString("MacroRptTemplate","MacroRptTemplateCell"));
		set.add(getComparedJoinedString("MacroRptTemplate","MacroRptObj"));
		set.add(getComparedJoinedString("MacroRptTemplateCell","MacroRptTemplate"));
		set.add(getComparedJoinedString("MacroRptTemplateObj","MacroRptTemplate"));
		set.add(getComparedJoinedString("MacroRptTemplateObjCell","MacroRptTemplateObj"));
		set.add(getComparedJoinedString("MacroRptTemplateObjCell","MacroData"));
		set.add(getComparedJoinedString("MacroData","MacroRptTemplateObjCell"));
		return set;
	}

	static final String JOIN_STR = "_";
	private String getComparedJoinedString(String string, String string2) {
		if(string.compareTo(string2) <= 0) {
			return string + JOIN_STR + string2;
		} else {
			return string2 + JOIN_STR + string;
		}
	}

	private void generateSomeEntity() throws ClassNotFoundException {
    	Map<String,String> map = new HashMap<>();
    	map.put("supertype", "VBaseType");
        List<JsonAtlasTypeDefHeader> response = typeRestApi.getTypeDefHeaders(map);
        for (JsonAtlasTypeDefHeader typeDefHeader : response) {
			if(!typeDefHeader.getName().startsWith("VBase")) {
				EntityUpdateDTO entityUpdateDTO = new EntityUpdateDTO();
				entityUpdateDTO.setTypeName(typeDefHeader.getName());
				Field[] allFields = FieldUtils.getAllFields(Class.forName("com.github.jasonqjc.atlas_v2_client.custommodel."+typeDefHeader.getName()));
				Map<String, Object> attributes = new HashMap<>();
				entityUpdateDTO.setAttributes(attributes);
				for (Field field : allFields) {
					attributes.put(field.getName(), "v_" + field.getName());
				}
				String randomAlphabetic = RandomStringUtils.randomAlphabetic(5);
				for (String needAttr : JsonAtlasStruct.NEEDED_ATTRIBUTES) {
					if(StringUtils.equalsAny(needAttr, "name","qualifiedName")) {
						attributes.put(needAttr, typeDefHeader.getName() + "_" + randomAlphabetic);
					} else {
						attributes.put(needAttr, "v_" + needAttr);
					}
				}
				apiService.createOrUpdateEntity(entityUpdateDTO);
			}
		}
	}

    /**
     * 测试添加实体
     */
    @Test
    public void test3() throws ClassNotFoundException {
    	EntityUpdateDTO entityUpdateDTO = new EntityUpdateDTO();
    	entityUpdateDTO.setTypeName("VBaseTable");
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
    	attributes.put("name", "VBaseTable_003");
    	attributes.put("description", "description");
    	attributes.put("owner", "owner");
    	attributes.put("qualifiedName", "VBaseTable_003");
    	
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
    
    /**
     * 测试添加关系
     */
    @Test
    public void test4() {
    	JsonAtlasRelationship body = new JsonAtlasRelationship();
    	BigDecimal nowUnixTime = BigDecimal.valueOf(new Date().getTime());
		body.createTime(nowUnixTime);
        body.updateTime(nowUnixTime);
        //VBaseTable_002
        body.end1(new JsonAtlasObjectId().guid("4e895ec0-219e-4b93-9813-6af064ca0697").typeName("VBaseTable"));
        //VBaseTable_003
        body.end2(new JsonAtlasObjectId().guid("dba230b5-e7dc-484e-a4a6-58e237b9578c").typeName("VBaseTable"));
        body.propagateTags(JsonPropagateTags.NONE);
        body.status(JsonStatusAtlasRelationship.ACTIVE);
        body.setCreatedBy("vicson");
        body.setUpdatedBy("vicson");
        body.typeName("VBaseRelation");
    	JsonAtlasRelationship response = relationshipRestApi.create(body);
    	System.out.println(response);
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
				.type("VBaseType"));
		relationshipDef.endDef2(new JsonAtlasRelationshipEndDef()
				.cardinality(JsonCardinality.SET)
				.description("any")
				.isContainer(false)
				.isLegacyAttribute(false)
				.name("end2")
				.type("VBaseType"));
		
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
				typeDefBaseType("MicroColumn","微观表列","VBaseColumn",nowUnixTime,
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
		attributeDefs.add(new JsonAtlasAttributeDef().name("createTime").isOptional(true).typeName("string").cardinality(JsonCardinality.SINGLE));
		attributeDefs.add(new JsonAtlasAttributeDef().name("createUser").isOptional(true).typeName("string").cardinality(JsonCardinality.SINGLE));
		attributeDefs.add(new JsonAtlasAttributeDef().name("modifyTime").isOptional(true).typeName("string").cardinality(JsonCardinality.SINGLE));
		attributeDefs.add(new JsonAtlasAttributeDef().name("modifyUser").isOptional(true).typeName("string").cardinality(JsonCardinality.SINGLE));
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
