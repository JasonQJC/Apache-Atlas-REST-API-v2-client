package com.github.jasonqjc.atlas_v2_client.service;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.jasonqjc.atlas_v2_client.api.EntityRestApi;
import com.github.jasonqjc.atlas_v2_client.api.TypesRestApi;
import com.github.jasonqjc.atlas_v2_client.controller.ApiController.EntityUpdateDTO;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasAttributeDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntity;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityWithExtInfo;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasStruct;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasTypesDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonCardinality;
import com.github.jasonqjc.atlas_v2_client.model.JsonEntityMutationResponse;
import com.github.jasonqjc.atlas_v2_client.model.JsonTypeCategory;
import com.github.jasonqjc.atlas_v2_client.pojo.CreateTypePojo;

@Component
public class ApiService {
	
	@Autowired
	private TypesRestApi typeRestApi;
	@Autowired
	private EntityRestApi entityRestApi;
	
	public JsonAtlasTypesDef createEntityType(CreateTypePojo params) {
		BigDecimal nowUnixTime = BigDecimal.valueOf(new Date().getTime());
		JsonAtlasTypesDef body = new JsonAtlasTypesDef();
		addBaseEntityDef(params.getTypeName(),params.getSuperType(),params.getDesc(),params.getAttributeDefs(),nowUnixTime, body);
		return typeRestApi.createAtlasTypeDefs(body);
	}
	
	private void addBaseEntityDef(String typeName,String superType,String desc,List<JsonAtlasAttributeDef> attributeDefs,BigDecimal nowUnixTime, JsonAtlasTypesDef body) {
		if(StringUtils.isBlank(superType)) {
			attributeDefs = new ArrayList<>();
			attributeDefs.add(new JsonAtlasAttributeDef().name("createTime").typeName("string").cardinality(JsonCardinality.SINGLE));
			attributeDefs.add(new JsonAtlasAttributeDef().name("createUser").typeName("string").cardinality(JsonCardinality.SINGLE));
			attributeDefs.add(new JsonAtlasAttributeDef().name("modifyTime").typeName("string").cardinality(JsonCardinality.SINGLE));
			attributeDefs.add(new JsonAtlasAttributeDef().name("modifyUser").typeName("string").cardinality(JsonCardinality.SINGLE));
			body.addEntityDefsItem(typeDefBaseType(typeName,desc,"DataSet",nowUnixTime,attributeDefs));
		} else {
			body.addEntityDefsItem(typeDefBaseType(typeName,desc,superType,nowUnixTime,attributeDefs));
		}
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

	public JsonEntityMutationResponse createOrUpdateEntity(EntityUpdateDTO entityUpdateDTO) throws ClassNotFoundException {
		Map<String, Object> attrMap = getPermitedAttrMap(entityUpdateDTO);
		BigDecimal nowUnixTime = BigDecimal.valueOf(new Date().getTime());
		JsonAtlasEntityWithExtInfo body = new JsonAtlasEntityWithExtInfo();
        JsonAtlasEntity entity = new JsonAtlasEntity();
        body.entity(entity);
        if(StringUtils.isNotBlank(entityUpdateDTO.getGuid()) || entityUpdateDTO.getAttributes().get("qualifiedName") != null) {
        	entity.setCreateTime(nowUnixTime);
        }
        entity.setTypeName(entityUpdateDTO.getTypeName());
        entity.setAttributes(attrMap);
		entity.setUpdateTime(nowUnixTime);
        entity.customAttributes(entityUpdateDTO.getCustomAttributes());
        JsonEntityMutationResponse response = entityRestApi.createOrUpdate(body);
//        List<JsonAtlasEntityHeader> list = response.getMutatedEntities().get("CREATE");
        return response;
	}

	private Map<String, Object> getPermitedAttrMap(EntityUpdateDTO entityUpdateDTO) throws ClassNotFoundException {
		Class<?> clas = Class.forName("com.github.jasonqjc.atlas_v2_client.custommodel." + entityUpdateDTO.getTypeName());
		Map<String, Object> attributes = entityUpdateDTO.getAttributes();
		Map<String, Object> result = new HashMap<>();
    	Field[] allFields = FieldUtils.getAllFields(clas);
    	for (Field field : allFields) {
			if (attributes.containsKey(field.getName())) {
				result.put(field.getName(), attributes.get(field.getName()));
			}
		}
    	for (String key : JsonAtlasStruct.NEEDED_ATTRIBUTES) {
			if(attributes.get(key) != null) {
				result.put(key, attributes.get(key));
			}
		}
		return result;
	}
	
}
