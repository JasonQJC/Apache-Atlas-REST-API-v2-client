package com.github.jasonqjc.atlas_v2_client.api;

import java.util.List;
import java.util.Map;

import com.github.jasonqjc.atlas_v2_client.ApiClient;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasBaseTypeDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasBusinessMetadataDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasClassificationDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEnumDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasStructDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasTypeDefHeader;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasTypesDef;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

public interface TypesRestApi extends ApiClient.Api {

  /**
   * Bulk create APIs for all atlas type definitions, only new definitions will be created.
   * Bulk create APIs for all atlas type definitions, only new definitions will be created. Any changes to the existing definitions will be discarded
   * @param body A composite wrapper object with corresponding lists of the type definition (optional)
   * @return JsonAtlasTypesDef
   */
  @RequestLine("POST /v2/types/typedefs")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  JsonAtlasTypesDef createAtlasTypeDefs(JsonAtlasTypesDef body);
  /**
   * Delete API for type identified by its name.
   * Delete API for type identified by its name.
   * @param typeName Name of the type to be deleted. (required)
   */
  @RequestLine("DELETE /v2/types/typedef/name/{typeName}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteAtlasTypeByName(@Param("typeName") String typeName);
  /**
   * Bulk delete API for all types.
   * Bulk delete API for all types
   * @param body A composite object that captures all types to be deleted (optional)
   */
  @RequestLine("DELETE /v2/types/typedefs")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void deleteAtlasTypeDefs(JsonAtlasTypesDef body);
  /**
   * Bulk retrieval API for retrieving all type definitions in Atlas.
   * Bulk retrieval API for retrieving all type definitions in Atlas
   * prams参数
   * @param params
   * 已知参数
   * type:JsonTypeCategory 类型的类别 entity,struct等
   * excludeInternalTypesAndReferences:boolean 排除内部类型
   * 可能均来自与 JsonAtlasBaseTypeDef
   * @return JsonAtlasTypesDef
   */
  @RequestLine("GET /v2/types/typedefs")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasTypesDef getAllTypeDefs(@QueryMap Map<String, String> params);
  /**
   * Get the businessMetadata definition for the given guid.
   * Get the businessMetadata definition for the given guid
   * @param guid businessMetadata guid (required)
   * @return JsonAtlasBusinessMetadataDef
   */
  @RequestLine("GET /v2/types/businessmetadatadef/guid/{guid}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasBusinessMetadataDef getBusinessMetadataDefByGuid(@Param("guid") String guid);
  /**
   * Get the businessMetadata definition by it&#x27;s name (unique).
   * Get the businessMetadata definition by it&#x27;s name (unique)
   * @param name businessMetadata name (required)
   * @return JsonAtlasBusinessMetadataDef
   */
  @RequestLine("GET /v2/types/businessmetadatadef/name/{name}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasBusinessMetadataDef getBusinessMetadataDefByName(@Param("name") String name);
  /**
   * Get the classification definition for the given guid.
   * Get the classification definition for the given guid
   * @param guid classification guid (required)
   * @return JsonAtlasClassificationDef
   */
  @RequestLine("GET /v2/types/classificationdef/guid/{guid}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasClassificationDef getClassificationDefByGuid(@Param("guid") String guid);
  /**
   * Get the classification definition by it&#x27;s name (unique).
   * Get the classification definition by it&#x27;s name (unique)
   * @param name classification name (required)
   * @return JsonAtlasClassificationDef
   */
  @RequestLine("GET /v2/types/classificationdef/name/{name}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasClassificationDef getClassificationDefByName(@Param("name") String name);
  /**
   * Get the Entity definition for the given guid.
   * Get the Entity definition for the given guid
   * @param guid entity guid (required)
   * @return JsonAtlasEntityDef
   */
  @RequestLine("GET /v2/types/entitydef/guid/{guid}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasEntityDef getEntityDefByGuid(@Param("guid") String guid);
  /**
   * Get the entity definition by it&#x27;s name (unique).
   * Get the entity definition by it&#x27;s name (unique)
   * @param name entity name (required), _ALL_ENTITY_TYPES 代表所有类型
   * @return JsonAtlasEntityDef
   */
  @RequestLine("GET /v2/types/entitydef/name/{name}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasEntityDef getEntityDefByName(@Param("name") String name);
  /**
   * Get the enum definition for the given guid.
   * Get the enum definition for the given guid
   * @param guid enum guid (required)
   * @return JsonAtlasEnumDef
   */
  @RequestLine("GET /v2/types/enumdef/guid/{guid}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasEnumDef getEnumDefByGuid(@Param("guid") String guid);
  /**
   * Get the enum definition by it&#x27;s name (unique).
   * Get the enum definition by it&#x27;s name (unique)
   * @param name enum name (required)
   * @return JsonAtlasEnumDef
   */
  @RequestLine("GET /v2/types/enumdef/name/{name}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasEnumDef getEnumDefByName(@Param("name") String name);
  /**
   * Get the relationship definition for the given guid.
   * Get the relationship definition for the given guid
   * @param guid relationship guid (required)
   * @return JsonAtlasRelationshipDef
   */
  @RequestLine("GET /v2/types/relationshipdef/guid/{guid}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasRelationshipDef getRelationshipDefByGuid(@Param("guid") String guid);
  /**
   * Get the relationship definition by it&#x27;s name (unique).
   * Get the relationship definition by it&#x27;s name (unique)
   * @param name relationship name (required)
   * @return JsonAtlasRelationshipDef
   */
  @RequestLine("GET /v2/types/relationshipdef/name/{name}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasRelationshipDef getRelationshipDefByName(@Param("name") String name);
  /**
   * Get the struct definition for the given guid.
   * Get the struct definition for the given guid
   * @param guid struct guid (required)
   * @return JsonAtlasStructDef
   */
  @RequestLine("GET /v2/types/structdef/guid/{guid}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasStructDef getStructDefByGuid(@Param("guid") String guid);
  /**
   * Get the struct definition by it&#x27;s name (unique).
   * Get the struct definition by it&#x27;s name (unique)
   * @param name struct name (required)
   * @return JsonAtlasStructDef
   */
  @RequestLine("GET /v2/types/structdef/name/{name}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasStructDef getStructDefByName(@Param("name") String name);
  /**
   * 
   * 
   * @param guid GUID of the type (required)
   * @return JsonAtlasBaseTypeDef
   */
  @RequestLine("GET /v2/types/typedef/guid/{guid}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasBaseTypeDef getTypeDefByGuid(@Param("guid") String guid);
  /**
   * Get type definition by it&#x27;s name.
   * Get type definition by it&#x27;s name
   * @param name Type name (required)
   * @return JsonAtlasBaseTypeDef
   */
  @RequestLine("GET /v2/types/typedef/name/{name}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasBaseTypeDef getTypeDefByName(@Param("name") String name);
  
  /**
   * Bulk retrieval API for all type definitions returned as a list of minimal information header.
   * prams参数
   * @param params
   * 已知参数
   * type:JsonTypeCategory 类型的类别 entity,struct等
   * excludeInternalTypesAndReferences:boolean 排除内部类型
   * 可能均来自与 JsonAtlasBaseTypeDef
   * @return List&lt;JsonAtlasTypeDefHeader&gt;
   */
  @RequestLine("GET /v2/types/typedefs/headers")
  @Headers({
      "Accept: application/json",
  })
  List<JsonAtlasTypeDefHeader> getTypeDefHeaders(@QueryMap Map<String, String> params);
  
  /**
   * Bulk update API for all types, changes detected in the type definitions would be persisted.
   * Bulk update API for all types, changes detected in the type definitions would be persisted
   * @param body A composite object that captures all type definition changes (optional)
   * @return JsonAtlasTypesDef
   */
  @RequestLine("PUT /v2/types/typedefs")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasTypesDef updateAtlasTypeDefs(JsonAtlasTypesDef body);
}
