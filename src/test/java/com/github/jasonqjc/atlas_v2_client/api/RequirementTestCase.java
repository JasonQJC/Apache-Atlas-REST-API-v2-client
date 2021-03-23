package com.github.jasonqjc.atlas_v2_client.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasAttributeDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipEndDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasTypesDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonCardinality;
import com.github.jasonqjc.atlas_v2_client.model.JsonPropagateTags;
import com.github.jasonqjc.atlas_v2_client.model.JsonRelationshipCategory;
import com.github.jasonqjc.atlas_v2_client.model.JsonTypeCategory;

@SpringBootTest
public class RequirementTestCase {

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
    	//创建类型(已创建
    	JsonAtlasTypesDef createType = createType();
    	System.out.println(createType);
    	//创建关系类型(已创建
    	JsonAtlasTypesDef createRelationType = createRelationType();
    	System.out.println(createRelationType);
    }

	private JsonAtlasTypesDef createRelationType() {
		BigDecimal nowUnixTime = BigDecimal.valueOf(new Date().getTime());
		JsonAtlasTypesDef body = new JsonAtlasTypesDef();
		
		JsonAtlasRelationshipDef relationshipDef = new JsonAtlasRelationshipDef();
		
		relationshipDef.name("BaseRelation").category(JsonTypeCategory.RELATIONSHIP)
		.createTime(nowUnixTime).createdBy("qjc")
		.description("基础关系").updateTime(nowUnixTime).updatedBy("qjc");
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


	private JsonAtlasTypesDef createType() {
		BigDecimal nowUnixTime = BigDecimal.valueOf(new Date().getTime());
		JsonAtlasTypesDef body = new JsonAtlasTypesDef();
		body.businessMetadataDefs(new ArrayList<>());
        body.classificationDefs(new ArrayList<>());
        body.enumDefs(new ArrayList<>());
        body.relationshipDefs(new ArrayList<>());
        body.structDefs(new ArrayList<>());
		
		//创建基础类型
		body.addEntityDefsItem(typeDefBaseType(nowUnixTime));
		//创建微观表类型(父类
		body.addEntityDefsItem(typeDefMicroTable(nowUnixTime));
		//创建微观原始表类型(子类
		body.addEntityDefsItem(typeDefMicroOriginalTable(nowUnixTime));
		//创建微观物理表类型(子类
		body.addEntityDefsItem(typeDefMicroPhyTable(nowUnixTime));
		//创建微观表列
		body.addEntityDefsItem(typeDefMicroColumn(nowUnixTime));
		
		return typeRestApi.createAtlasTypeDefs(body);
	}


	private JsonAtlasEntityDef typeDefMicroColumn(BigDecimal nowUnixTime) {
		JsonAtlasEntityDef entityDef = new JsonAtlasEntityDef();
		
		entityDef.addSuperTypesItem("BaseType")
		.name("MicroColumn").category(JsonTypeCategory.ENTITY)
		.createTime(nowUnixTime).createdBy("qjc")
		.description("微观表列").updateTime(nowUnixTime).updatedBy("qjc");
		
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().typeName("string").name("colCName").description("字段中文名").cardinality(JsonCardinality.SINGLE));
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().typeName("string").name("colEName").description("字段英文名").cardinality(JsonCardinality.SINGLE));
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().typeName("string").name("colDataType").description("字段类型").cardinality(JsonCardinality.SINGLE));
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().typeName("string").name("colComments").description("字段解释").cardinality(JsonCardinality.SINGLE));
		
		return entityDef;
	}


	private JsonAtlasEntityDef typeDefMicroPhyTable(BigDecimal nowUnixTime) {
		JsonAtlasEntityDef entityDef = new JsonAtlasEntityDef();
		
		entityDef.addSuperTypesItem("MicroTable")
		.name("MicroPhyTable").category(JsonTypeCategory.ENTITY)
		.createTime(nowUnixTime).createdBy("qjc")
		.description("微观物理表").updateTime(nowUnixTime).updatedBy("qjc");
		
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().typeName("string").name("version").description("版本号").cardinality(JsonCardinality.SINGLE));
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().typeName("string").name("type").description("物理表类型:一维标准,二维不定长,二维定长").cardinality(JsonCardinality.SINGLE));
		
		return entityDef;
	}


	private JsonAtlasEntityDef typeDefMicroOriginalTable(BigDecimal nowUnixTime) {
		JsonAtlasEntityDef entityDef = new JsonAtlasEntityDef();
		
		entityDef.addSuperTypesItem("MicroTable")
		.name("MicroOriginalTable").category(JsonTypeCategory.ENTITY)
		.createTime(nowUnixTime).createdBy("qjc")
		.description("微观原始表").updateTime(nowUnixTime).updatedBy("qjc");
		
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().name("version").typeName("string").description("版本号").cardinality(JsonCardinality.SINGLE));
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().name("year").typeName("string").description("年份").cardinality(JsonCardinality.SINGLE));
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().name("htmlBy").typeName("string").description("html模板文件地址").cardinality(JsonCardinality.SINGLE));
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().name("sourceType").typeName("string").description("数据来源类型,一套表爬取,网络爬取,文件上传等").cardinality(JsonCardinality.SINGLE));
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().name("dataSource").typeName("string").description("数据实际来源，根据业务：一套表、七人普、四经普、农业一套表、部门数据等").cardinality(JsonCardinality.SINGLE));
		
		return entityDef;
	}


	private JsonAtlasEntityDef typeDefMicroTable(BigDecimal nowUnixTime) {
		JsonAtlasEntityDef entityDef = new JsonAtlasEntityDef();
		
		entityDef.addSuperTypesItem("BaseType")
		.name("MicroTable").category(JsonTypeCategory.ENTITY)
		.createTime(nowUnixTime).createdBy("qjc")
		.description("微观表").updateTime(nowUnixTime).updatedBy("qjc");
		
		
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().name("tableName").typeName("string").description("表名").cardinality(JsonCardinality.SINGLE).isUnique(true));
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().name("tableCode").typeName("string").description("表号").cardinality(JsonCardinality.SINGLE));
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().name("tableDescribe").typeName("string").description("表描述").cardinality(JsonCardinality.SINGLE));
		
		
		return entityDef;
	}


	private JsonAtlasEntityDef typeDefBaseType(BigDecimal nowUnixTime) {
		JsonAtlasEntityDef entityDef = new JsonAtlasEntityDef();
		
		entityDef.name("BaseType");
		entityDef.category(JsonTypeCategory.ENTITY);
		entityDef.createTime(nowUnixTime);
		entityDef.createdBy("qjc");
		entityDef.description("基础类型");
		entityDef.updateTime(nowUnixTime);
		entityDef.updatedBy("qjc");
		entityDef.addSubTypesItem("DataSet");
		
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().name("createTime").typeName("string").cardinality(JsonCardinality.SINGLE));
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().name("createUser").typeName("string").cardinality(JsonCardinality.SINGLE));
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().name("modifyTime").typeName("string").cardinality(JsonCardinality.SINGLE));
		entityDef.addAttributeDefsItem(new JsonAtlasAttributeDef().name("modifyUser").typeName("string").cardinality(JsonCardinality.SINGLE));
		return entityDef;
	}
    
}
