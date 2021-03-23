package com.github.jasonqjc.atlas_v2_client.api;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.github.jasonqjc.atlas_v2_client.ApiClient;
import com.github.jasonqjc.atlas_v2_client.EncodingUtils;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasClassification;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasClassifications;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntitiesWithExtInfo;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityHeader;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasEntityWithExtInfo;
import com.github.jasonqjc.atlas_v2_client.model.JsonBulkImportResponse;
import com.github.jasonqjc.atlas_v2_client.model.JsonClassificationAssociateRequest;
import com.github.jasonqjc.atlas_v2_client.model.JsonEntityAuditEventV2;
import com.github.jasonqjc.atlas_v2_client.model.JsonEntityMutationResponse;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@SuppressWarnings("serial")
public interface EntityRestApi extends ApiClient.Api {

  /**
   * Bulk API to associate a tag to multiple entities.
   * @param body  (optional)
   */
  @RequestLine("POST /v2/entity/bulk/classification")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void addClassification(JsonClassificationAssociateRequest body);
  /**
   * Adds classifications to an existing entity represented by a guid.
   * @param guid globally unique identifier for the entity (required)
   * @param body  (optional)
   */
  @RequestLine("POST /v2/entity/guid/{guid}/classifications")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void addClassifications(@Param("guid") String guid, List<JsonAtlasClassification> body);
  /**
   * Adds classification to the entity identified by its type and unique attributes.
   * @param typeName  (required)
   * @param body  (optional)
   */
  @RequestLine("POST /v2/entity/uniqueAttribute/type/{typeName}/classifications")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void addClassificationsByUniqueAttribute(@Param("typeName") String typeName, List<JsonAtlasClassification> body, @QueryMap Map<String,String> attributes);
  /**
   * add given labels to a given entity.
   * @param guid - Unique entity identifier (required)
   */
  @RequestLine("PUT /v2/entity/guid/{guid}/labels")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void addLabels(@Param("guid") String guid, @QueryMap Map<String,String> attrs);
  /**
   * 
   * 
   * @param typeName  (required)
   * @param body  (optional)
   */
  @RequestLine("PUT /v2/entity/uniqueAttribute/type/{typeName}/labels")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void addLabels_1(@Param("typeName") String typeName, List<String> body);
  /**
   * 
   * 
   * @param guid  (required)
   * @param isOverwrite  (optional, default to false)
   */
  @RequestLine("POST /v2/entity/guid/{guid}/businessmetadata?isOverwrite={isOverwrite}")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void addOrUpdateBusinessAttributes(@Param("guid") String guid, @Param("isOverwrite") Boolean isOverwrite);

  /**
   * 
   * 
   * Note, this is equivalent to the other <code>addOrUpdateBusinessAttributes</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link AddOrUpdateBusinessAttributesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param guid  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>isOverwrite -  (optional, default to false)</li>
   *   </ul>

   */
  @RequestLine("POST /v2/entity/guid/{guid}/businessmetadata?isOverwrite={isOverwrite}")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
  })
  void addOrUpdateBusinessAttributes(@Param("guid") String guid, @QueryMap AddOrUpdateBusinessAttributesQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>addOrUpdateBusinessAttributes</code> method in a fluent style.
   */
  public static class AddOrUpdateBusinessAttributesQueryParams extends HashMap<String, Object> {
    public AddOrUpdateBusinessAttributesQueryParams isOverwrite(final Boolean value) {
      put("isOverwrite", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * 
   * 
   * @param bmName  (required)
   * @param guid  (required)
   */
  @RequestLine("POST /v2/entity/guid/{guid}/businessmetadata/{bmName}")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void addOrUpdateBusinessAttributes_2(@Param("bmName") String bmName, @Param("guid") String guid);
  /**
   * Create new entity or update existing entity in Atlas. 
   * Existing entity is matched using its unique guid if supplied or by its unique attributes eg: qualifiedName
   * 创建或更新一个已存在于Atlas中的实体
   * 已存在的实体通过可能传入了的唯一的guid或者唯一的属性,如qualifiedName来匹配
   * @param body  (optional)
   * @return JsonEntityMutationResponse
   */
  @RequestLine("POST /v2/entity")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  JsonEntityMutationResponse createOrUpdate(JsonAtlasEntityWithExtInfo body);
  /**
   * Bulk API to create new entities or updates existing entities in Atlas. 
   * Existing entity is matched using its unique guid if supplied or by its unique attributes eg: qualifiedName
   * @param body  (optional)
   * @return JsonEntityMutationResponse
   */
  @RequestLine("POST /v2/entity/bulk")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonEntityMutationResponse createOrUpdateBulk(JsonAtlasEntitiesWithExtInfo body);
  /**
   * Delete an entity identified by its GUID.
   * @param guid GUID for the entity (required)
   * @return JsonEntityMutationResponse
   */
  @RequestLine("DELETE /v2/entity/guid/{guid}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  JsonEntityMutationResponse deleteByGuid(@Param("guid") String guid);
  /**
   * Bulk API to delete list of entities identified by its GUIDs.
   * @param guid  (optional)
   * @return JsonEntityMutationResponse
   */
  @RequestLine("DELETE /v2/entity/bulk?guid={guid}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  JsonEntityMutationResponse deleteByGuids(@Param("guid") List<String> guid);

  /**
   * Bulk API to delete list of entities identified by its GUIDs.
   * Note, this is equivalent to the other <code>deleteByGuids</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link DeleteByGuidsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>guid -  (optional)</li>
   *   </ul>
   * @return JsonEntityMutationResponse

   */
  @RequestLine("DELETE /v2/entity/bulk?guid={guid}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  JsonEntityMutationResponse deleteByGuids(@QueryMap DeleteByGuidsQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>deleteByGuids</code> method in a fluent style.
   */
  public static class DeleteByGuidsQueryParams extends HashMap<String, Object> {
    public DeleteByGuidsQueryParams guid(final List<String> value) {
      put("guid", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }
  /**
   * Delete an entity identified by its type and unique attributes.  
   * In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  attr:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName and attrValue should be unique across entities, eg. qualifiedName  The REST request would look something like this  DELETE /v2/entity/uniqueAttribute/type/aType?attr:aTypeAttribute&#x3D;someValue
   * @param typeName - entity type to be deleted (required)
   * @return JsonEntityMutationResponse
   */
  @RequestLine("DELETE /v2/entity/uniqueAttribute/type/{typeName}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  JsonEntityMutationResponse deleteByUniqueAttribute(@Param("typeName") String typeName,@QueryMap Map<String, String> uniqueAttributes);
  /**
   * Deletes a given classification from an existing entity represented by a guid.
   * @param classificationName name of the classifcation (required)
   * @param guid globally unique identifier for the entity (required)
   * @param associatedEntityGuid  (optional)
   */
  @RequestLine("DELETE /v2/entity/guid/{guid}/classification/{classificationName}?associatedEntityGuid={associatedEntityGuid}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteClassification(@Param("classificationName") String classificationName, @Param("guid") String guid, @Param("associatedEntityGuid") String associatedEntityGuid);

  /**
   * Deletes a given classification from an existing entity represented by a guid.
   * Note, this is equivalent to the other <code>deleteClassification</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link DeleteClassificationQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param classificationName name of the classifcation (required)
   * @param guid globally unique identifier for the entity (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>associatedEntityGuid -  (optional)</li>
   *   </ul>

   */
  @RequestLine("DELETE /v2/entity/guid/{guid}/classification/{classificationName}?associatedEntityGuid={associatedEntityGuid}")
  @Headers({
      "Content-Type: application/json",
  })
  void deleteClassification(@Param("classificationName") String classificationName, @Param("guid") String guid, @QueryMap DeleteClassificationQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>deleteClassification</code> method in a fluent style.
   */
  public static class DeleteClassificationQueryParams extends HashMap<String, Object> {
    public DeleteClassificationQueryParams associatedEntityGuid(final String value) {
      put("associatedEntityGuid", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Deletes a given classification from an entity identified by its type and unique attributes.
   * @param classificationName name of the classification (required)
   * @param typeName  (required)
   */
  @RequestLine("DELETE /v2/entity/uniqueAttribute/type/{typeName}/classification/{classificationName}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteClassificationByUniqueAttribute(@Param("classificationName") String classificationName, @Param("typeName") String typeName);
  /**
   * 
   * 
   * @param guid  (required)
   * @param auditAction  (optional)
   * @param count  (optional, default to 100)
   * @param startKey  (optional)
   * @return List&lt;JsonEntityAuditEventV2&gt;
   */
  @RequestLine("GET /v2/entity/{guid}/audit?auditAction={auditAction}&count={count}&startKey={startKey}")
  @Headers({
      "Accept: application/json",
  })
  List<JsonEntityAuditEventV2> getAuditEvents(@Param("guid") String guid, @Param("auditAction") String auditAction, @Param("count") Integer count, @Param("startKey") String startKey);

  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAuditEvents</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAuditEventsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param guid  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>auditAction -  (optional)</li>
   *   <li>count -  (optional, default to 100)</li>
   *   <li>startKey -  (optional)</li>
   *   </ul>
   * @return List&lt;JsonEntityAuditEventV2&gt;

   */
  @RequestLine("GET /v2/entity/{guid}/audit?auditAction={auditAction}&count={count}&startKey={startKey}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<JsonEntityAuditEventV2> getAuditEvents(@Param("guid") String guid, @QueryMap GetAuditEventsQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getAuditEvents</code> method in a fluent style.
   */
  public static class GetAuditEventsQueryParams extends HashMap<String, Object> {
    public GetAuditEventsQueryParams auditAction(final String value) {
      put("auditAction", EncodingUtils.encode(value));
      return this;
    }
    public GetAuditEventsQueryParams count(final Integer value) {
      put("count", EncodingUtils.encode(value));
      return this;
    }
    public GetAuditEventsQueryParams startKey(final String value) {
      put("startKey", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Bulk API to retrieve list of entities identified by its GUIDs.
   * Bulk API to retrieve list of entities identified by its GUIDs.
   * @param guid  (optional)
   * @param ignoreRelationships  (optional, default to false)
   * @param minExtInfo  (optional, default to false)
   * @return JsonAtlasEntitiesWithExtInfo
   */
  @RequestLine("GET /v2/entity/bulk?guid={guid}&ignoreRelationships={ignoreRelationships}&minExtInfo={minExtInfo}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasEntitiesWithExtInfo getByGuids(@Param("guid") List<String> guid, @Param("ignoreRelationships") Boolean ignoreRelationships, @Param("minExtInfo") Boolean minExtInfo);

  /**
   * Bulk API to retrieve list of entities identified by its GUIDs.
   * Bulk API to retrieve list of entities identified by its GUIDs.
   * Note, this is equivalent to the other <code>getByGuids</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetByGuidsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>guid -  (optional)</li>
   *   <li>ignoreRelationships -  (optional, default to false)</li>
   *   <li>minExtInfo -  (optional, default to false)</li>
   *   </ul>
   * @return JsonAtlasEntitiesWithExtInfo

   */
  @RequestLine("GET /v2/entity/bulk?guid={guid}&ignoreRelationships={ignoreRelationships}&minExtInfo={minExtInfo}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  JsonAtlasEntitiesWithExtInfo getByGuids(@QueryMap GetByGuidsQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getByGuids</code> method in a fluent style.
   */
  public static class GetByGuidsQueryParams extends HashMap<String, Object> {
    public GetByGuidsQueryParams guid(final List<String> value) {
      put("guid", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetByGuidsQueryParams ignoreRelationships(final Boolean value) {
      put("ignoreRelationships", EncodingUtils.encode(value));
      return this;
    }
    public GetByGuidsQueryParams minExtInfo(final Boolean value) {
      put("minExtInfo", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Fetch complete definition of an entity given its GUID.
   * Fetch complete definition of an entity given its GUID.
   * @param guid GUID for the entity (required)
   * @param ignoreRelationships  (optional, default to false)
   * @param minExtInfo  (optional, default to false)
   * @return JsonAtlasEntityWithExtInfo
   */
  @RequestLine("GET /v2/entity/guid/{guid}?ignoreRelationships={ignoreRelationships}&minExtInfo={minExtInfo}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasEntityWithExtInfo getById(@Param("guid") String guid, @Param("ignoreRelationships") Boolean ignoreRelationships, @Param("minExtInfo") Boolean minExtInfo);

  /**
   * Fetch complete definition of an entity given its GUID.
   * Fetch complete definition of an entity given its GUID.
   * Note, this is equivalent to the other <code>getById</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetByIdQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param guid GUID for the entity (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>ignoreRelationships -  (optional, default to false)</li>
   *   <li>minExtInfo -  (optional, default to false)</li>
   *   </ul>
   * @return JsonAtlasEntityWithExtInfo

   */
  @RequestLine("GET /v2/entity/guid/{guid}?ignoreRelationships={ignoreRelationships}&minExtInfo={minExtInfo}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  JsonAtlasEntityWithExtInfo getById(@Param("guid") String guid, @QueryMap GetByIdQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getById</code> method in a fluent style.
   */
  public static class GetByIdQueryParams extends HashMap<String, Object> {
    public GetByIdQueryParams ignoreRelationships(final Boolean value) {
      put("ignoreRelationships", EncodingUtils.encode(value));
      return this;
    }
    public GetByIdQueryParams minExtInfo(final Boolean value) {
      put("minExtInfo", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Fetch complete definition of an entity given its type and unique attribute.
   * Fetch complete definition of an entity given its type and unique attribute.  In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  attr:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName and attrValue should be unique across entities, eg. qualifiedName  The REST request would look something like this  GET /v2/entity/uniqueAttribute/type/aType?attr:aTypeAttribute&#x3D;someValue
   * @param typeName  (required)
   * @param ignoreRelationships  (optional, default to false)
   * @param minExtInfo  (optional, default to false)
   * @return JsonAtlasEntityWithExtInfo
   */
  @RequestLine("GET /v2/entity/uniqueAttribute/type/{typeName}?ignoreRelationships={ignoreRelationships}&minExtInfo={minExtInfo}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasEntityWithExtInfo getByUniqueAttributes(@Param("typeName") String typeName, @Param("ignoreRelationships") Boolean ignoreRelationships, @Param("minExtInfo") Boolean minExtInfo);

  /**
   * Fetch complete definition of an entity given its type and unique attribute.
   * Fetch complete definition of an entity given its type and unique attribute.  In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  attr:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName and attrValue should be unique across entities, eg. qualifiedName  The REST request would look something like this  GET /v2/entity/uniqueAttribute/type/aType?attr:aTypeAttribute&#x3D;someValue
   * Note, this is equivalent to the other <code>getByUniqueAttributes</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetByUniqueAttributesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param typeName  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>ignoreRelationships -  (optional, default to false)</li>
   *   <li>minExtInfo -  (optional, default to false)</li>
   *   </ul>
   * @return JsonAtlasEntityWithExtInfo

   */
  @RequestLine("GET /v2/entity/uniqueAttribute/type/{typeName}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  JsonAtlasEntityWithExtInfo getByUniqueAttributes(@Param("typeName") String typeName, @QueryMap GetByUniqueAttributesQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getByUniqueAttributes</code> method in a fluent style.
   */
  public static class GetByUniqueAttributesQueryParams extends HashMap<String, Object> {
    public GetByUniqueAttributesQueryParams ignoreRelationships(final Boolean value) {
      put("ignoreRelationships", EncodingUtils.encode(value));
      return this;
    }
    public GetByUniqueAttributesQueryParams minExtInfo(final Boolean value) {
      put("minExtInfo", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Gets the list of classifications for a given entity represented by a guid.
   * Gets the list of classifications for a given entity represented by a guid.
   * @param classificationName  (required)
   * @param guid globally unique identifier for the entity (required)
   * @return JsonAtlasClassification
   */
  @RequestLine("GET /v2/entity/guid/{guid}/classification/{classificationName}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasClassification getClassification(@Param("classificationName") String classificationName, @Param("guid") String guid);
  /**
   * Gets the list of classifications for a given entity represented by a guid.
   * Gets the list of classifications for a given entity represented by a guid.
   * @param guid globally unique identifier for the entity (required)
   * @return JsonAtlasClassifications
   */
  @RequestLine("GET /v2/entity/guid/{guid}/classifications")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasClassifications getClassifications(@Param("guid") String guid);
  /**
   * Bulk API to retrieve list of entities identified by its unique attributes.
   * Bulk API to retrieve list of entities identified by its unique attributes.  In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  typeName&#x3D;&lt;typeName&gt;&amp;attr_1:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;&amp;attr_2:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;&amp;attr_3:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName should be an unique attribute for the given entity-type  The REST request would look something like this  GET /v2/entity/bulk/uniqueAttribute/type/hive_db?attr_0:qualifiedName&#x3D;db1@cl1&amp;attr_2:qualifiedName&#x3D;db2@cl1
   * @param typeName  (required)
   * @param ignoreRelationships  (optional, default to false)
   * @param minExtInfo  (optional, default to false)
   * @return JsonAtlasEntitiesWithExtInfo
   */
  @RequestLine("GET /v2/entity/bulk/uniqueAttribute/type/{typeName}?ignoreRelationships={ignoreRelationships}&minExtInfo={minExtInfo}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasEntitiesWithExtInfo getEntitiesByUniqueAttributes(@Param("typeName") String typeName, @Param("ignoreRelationships") Boolean ignoreRelationships, @Param("minExtInfo") Boolean minExtInfo);

  /**
   * Bulk API to retrieve list of entities identified by its unique attributes.
   * Bulk API to retrieve list of entities identified by its unique attributes.  In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  typeName&#x3D;&lt;typeName&gt;&amp;attr_1:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;&amp;attr_2:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;&amp;attr_3:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName should be an unique attribute for the given entity-type  The REST request would look something like this  GET /v2/entity/bulk/uniqueAttribute/type/hive_db?attr_0:qualifiedName&#x3D;db1@cl1&amp;attr_2:qualifiedName&#x3D;db2@cl1
   * Note, this is equivalent to the other <code>getEntitiesByUniqueAttributes</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetEntitiesByUniqueAttributesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param typeName  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>ignoreRelationships -  (optional, default to false)</li>
   *   <li>minExtInfo -  (optional, default to false)</li>
   *   </ul>
   * @return JsonAtlasEntitiesWithExtInfo

   */
  @RequestLine("GET /v2/entity/bulk/uniqueAttribute/type/{typeName}?ignoreRelationships={ignoreRelationships}&minExtInfo={minExtInfo}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  JsonAtlasEntitiesWithExtInfo getEntitiesByUniqueAttributes(@Param("typeName") String typeName, @QueryMap GetEntitiesByUniqueAttributesQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getEntitiesByUniqueAttributes</code> method in a fluent style.
   */
  public static class GetEntitiesByUniqueAttributesQueryParams extends HashMap<String, Object> {
    public GetEntitiesByUniqueAttributesQueryParams ignoreRelationships(final Boolean value) {
      put("ignoreRelationships", EncodingUtils.encode(value));
      return this;
    }
    public GetEntitiesByUniqueAttributesQueryParams minExtInfo(final Boolean value) {
      put("minExtInfo", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Fetch AtlasEntityHeader given its type and unique attribute.
   * Fetch AtlasEntityHeader given its type and unique attribute.  In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  attr:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName and attrValue should be unique across entities, eg. qualifiedName  The REST request would look something like this  GET /v2/entity/uniqueAttribute/type/aType/header?attr:aTypeAttribute&#x3D;someValue
   * @param typeName  (required)
   * @return JsonAtlasEntityHeader
   */
  @RequestLine("GET /v2/entity/uniqueAttribute/type/{typeName}/header")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasEntityHeader getEntityHeaderByUniqueAttributes(@Param("typeName") String typeName, @QueryMap Map<String, String> attrs);
  /**
   * 
   * 
   * @param tagUpdateStartTime  (optional)
   */
  @RequestLine("GET /v2/entity/bulk/headers?tagUpdateStartTime={tagUpdateStartTime}")
  @Headers({
      "Accept: */*",
  })
  void getEntityHeaders(@Param("tagUpdateStartTime") Long tagUpdateStartTime);

  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getEntityHeaders</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetEntityHeadersQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>tagUpdateStartTime -  (optional)</li>
   *   </ul>

   */
  @RequestLine("GET /v2/entity/bulk/headers?tagUpdateStartTime={tagUpdateStartTime}")
  @Headers({
      "Content-Type: */*",
  })
  void getEntityHeaders(@QueryMap Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getEntityHeaders</code> method in a fluent style.
   */
  public static class GetEntityHeadersQueryParams extends HashMap<String, Object> {
    public GetEntityHeadersQueryParams tagUpdateStartTime(final Long value) {
      put("tagUpdateStartTime", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Get entity header given its GUID.
   * Get entity header given its GUID.
   * @param guid GUID for the entity (required)
   * @return JsonAtlasEntityHeader
   */
  @RequestLine("GET /v2/entity/guid/{guid}/header")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasEntityHeader getHeaderById(@Param("guid") String guid);
  /**
   * Upload the file for creating Business Metadata in BULK.
   * Upload the file for creating Business Metadata in BULK
   * @param fileDetail  (optional)
   * @param uploadedInputStream  (optional)
   * @return JsonBulkImportResponse
   */
  @RequestLine("POST /v2/entity/businessmetadata/import")
  @Headers({
      "Content-Type: multipart/form-data",
      "Accept: application/json",
  })
  JsonBulkImportResponse importBMAttributes(@Param("fileDetail") File fileDetail, @Param("uploadedInputStream") File uploadedInputStream);
  /**
   * Entity Partial Update - Add/Update entity attribute identified by its GUID.
   * Entity Partial Update - Add/Update entity attribute identified by its GUID. Supports only uprimitive attribute type and entity references. does not support updation of complex types like arrays, maps Null updates are not possible
   * @param guid  (required)
   * @param name  (optional)
   * @return JsonEntityMutationResponse
   */
  @RequestLine("PUT /v2/entity/guid/{guid}?name={name}")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonEntityMutationResponse partialUpdateEntityAttrByGuid(@Param("guid") String guid, @Param("name") String name);

  /**
   * Entity Partial Update - Add/Update entity attribute identified by its GUID.
   * Entity Partial Update - Add/Update entity attribute identified by its GUID. Supports only uprimitive attribute type and entity references. does not support updation of complex types like arrays, maps Null updates are not possible
   * Note, this is equivalent to the other <code>partialUpdateEntityAttrByGuid</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link PartialUpdateEntityAttrByGuidQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param guid  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>name -  (optional)</li>
   *   </ul>
   * @return JsonEntityMutationResponse

   */
  @RequestLine("PUT /v2/entity/guid/{guid}?name={name}")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonEntityMutationResponse partialUpdateEntityAttrByGuid(@Param("guid") String guid, @QueryMap Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>partialUpdateEntityAttrByGuid</code> method in a fluent style.
   */
  public static class PartialUpdateEntityAttrByGuidQueryParams extends HashMap<String, Object> {
    public PartialUpdateEntityAttrByGuidQueryParams name(final String value) {
      put("name", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Entity Partial Update - Allows a subset of attributes to be updated on an entity which is identified by its type and unique attribute  eg: Referenceable.
   * Entity Partial Update - Allows a subset of attributes to be updated on an entity which is identified by its type and unique attribute  eg: Referenceable.qualifiedName. Null updates are not possible  In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  attr:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName and attrValue should be unique across entities, eg. qualifiedName  The REST request would look something like this  PUT /v2/entity/uniqueAttribute/type/aType?attr:aTypeAttribute&#x3D;someValue
   * @param typeName  (required)
   * @param body  (optional)
   * @return JsonEntityMutationResponse
   */
  @RequestLine("PUT /v2/entity/uniqueAttribute/type/{typeName}")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonEntityMutationResponse partialUpdateEntityByUniqueAttrs(@Param("typeName") String typeName, JsonAtlasEntityWithExtInfo body, @QueryMap Map<String,String> uniqueAttributes);
  /**
   * Get the sample Template for uploading/creating bulk BusinessMetaData.
   * Get the sample Template for uploading/creating bulk BusinessMetaData
   */
  @RequestLine("GET /v2/entity/businessmetadata/import/template")
  @Headers({
      "Accept: */*",
  })
  void produceTemplate();
  /**
   * 
   * 
   * @param guid  (required)
   */
  @RequestLine("DELETE /v2/entity/guid/{guid}/businessmetadata")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void removeBusinessAttributes(@Param("guid") String guid);
  /**
   * 
   * 
   * @param bmName  (required)
   * @param guid  (required)
   */
  @RequestLine("DELETE /v2/entity/guid/{guid}/businessmetadata/{bmName}")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void removeBusinessAttributes_4(@Param("bmName") String bmName, @Param("guid") String guid);
  /**
   * delete given labels to a given entity.
   * delete given labels to a given entity
   * @param guid - Unique entity identifier (required)
   */
  @RequestLine("DELETE /v2/entity/guid/{guid}/labels")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void removeLabels(@Param("guid") String guid);
  /**
   * 
   * 
   * @param typeName  (required)
   * @param body  (optional)
   */
  @RequestLine("DELETE /v2/entity/uniqueAttribute/type/{typeName}/labels")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void removeLabels_5(@Param("typeName") String typeName, Set<String> labels,@QueryMap Map<String, String> attrs);
  /**
   * 
   * 
   */
  @RequestLine("POST /v2/entity/bulk/setClassifications")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void setClassifications();
  /**
   * Set labels to a given entity.
   * Set labels to a given entity
   * @param guid - Unique entity identifier (required)
   */
  @RequestLine("POST /v2/entity/guid/{guid}/labels")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void setLabels(@Param("guid") String guid, Set<String> labels);
  /**
   * 
   * 
   * @param typeName  (required)
   * @param body  (optional)
   */
  @RequestLine("POST /v2/entity/uniqueAttribute/type/{typeName}/labels")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void setLabels_6(@Param("typeName") String typeName, List<String> body,@QueryMap Map<String, String> attrs);
  /**
   * Updates classifications to an existing entity represented by a guid.
   * Updates classifications to an existing entity represented by a guid.
   * @param guid globally unique identifier for the entity (required)
   * @param body  (optional)
   */
  @RequestLine("PUT /v2/entity/guid/{guid}/classifications")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void updateClassifications(@Param("guid") String guid, List<JsonAtlasClassification> body);
  /**
   * Updates classification on an entity identified by its type and unique attributes.
   * Updates classification on an entity identified by its type and unique attributes.
   * @param typeName  (required)
   * @param body  (optional)
   */
  @RequestLine("PUT /v2/entity/uniqueAttribute/type/{typeName}/classifications")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void updateClassificationsByUniqueAttribute(@Param("typeName") String typeName, List<JsonAtlasClassification> body);
}
