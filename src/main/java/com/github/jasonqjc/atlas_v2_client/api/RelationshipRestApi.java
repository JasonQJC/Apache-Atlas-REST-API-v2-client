package com.github.jasonqjc.atlas_v2_client.api;

import java.util.HashMap;

import com.github.jasonqjc.atlas_v2_client.ApiClient;
import com.github.jasonqjc.atlas_v2_client.EncodingUtils;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationship;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelationshipWithExtInfo;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@SuppressWarnings("serial")
public interface RelationshipRestApi extends ApiClient.Api {

  /**
   * Create a new relationship between entities.
   * @param body  (optional)
   * @return JsonAtlasRelationship
   */
  @RequestLine("POST /v2/relationship")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasRelationship create(JsonAtlasRelationship body);
  /**
   * Delete a relationship between entities using guid.
   * @param guid  (required)
   */
  @RequestLine("DELETE /v2/relationship/guid/{guid}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteById(@Param("guid") String guid);
  /**
   * Get relationship information between entities using guid.
   * @param guid  (required)
   * @param extendedInfo  (optional, default to false)
   * @return JsonAtlasRelationshipWithExtInfo
   */
  @RequestLine("GET /v2/relationship/guid/{guid}?extendedInfo={extendedInfo}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasRelationshipWithExtInfo getById2(@Param("guid") String guid, @Param("extendedInfo") Boolean extendedInfo);

  /**
   * Get relationship information between entities using guid.
   * Note, this is equivalent to the other <code>getById2</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetById2QueryParams} class that allows for
   * building up this map in a fluent style.
   * @param guid  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>extendedInfo -  (optional, default to false)</li>
   *   </ul>
   * @return JsonAtlasRelationshipWithExtInfo

   */
  @RequestLine("GET /v2/relationship/guid/{guid}?extendedInfo={extendedInfo}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  JsonAtlasRelationshipWithExtInfo getById2(@Param("guid") String guid, @QueryMap GetById2QueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getById2</code> method in a fluent style.
   */
  public static class GetById2QueryParams extends HashMap<String, Object> {
    public GetById2QueryParams extendedInfo(final Boolean value) {
      put("extendedInfo", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Update an existing relationship between entities.
   * @param body  (optional)
   * @return JsonAtlasRelationship
   */
  @RequestLine("PUT /v2/relationship")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasRelationship update(JsonAtlasRelationship body);
}
