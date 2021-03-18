package com.github.jasonqjc.atlas_v2_client.api;

import java.util.HashMap;
import java.util.Map;

import com.github.jasonqjc.atlas_v2_client.ApiClient;
import com.github.jasonqjc.atlas_v2_client.EncodingUtils;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasLineageInfo;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@SuppressWarnings("serial")
public interface LineageRestApi extends ApiClient.Api {

  /**
   * Returns lineage info about entity.<br/>
   * 返回实体的血缘信息 <br/>
   * In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  attr:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName and attrValue should be unique across entities, eg. qualifiedName
   * @param typeName - typeName of entity (required)
   * @param depth - number of hops for lineage (optional, default to 3)
   * @param direction - input, output or both (optional, default to BOTH)
   */
  @RequestLine("GET /v2/lineage/uniqueAttribute/type/{typeName}?depth={depth}&direction={direction}")
  @Headers({
      "Accept: */*",
  })
  void getLineageByUniqueAttribute(@Param("typeName") String typeName, @Param("depth") Integer depth, @Param("direction") String direction);

  /**
   * Returns lineage info about entity.
   * Returns lineage info about entity.  In addition to the typeName path parameter, attribute key-value pair(s) can be provided in the following format  attr:&lt;attrName&gt;&#x3D;&lt;attrValue&gt;  NOTE: The attrName and attrValue should be unique across entities, eg. qualifiedName
   * Note, this is equivalent to the other <code>getLineageByUniqueAttribute</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetLineageByUniqueAttributeQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param typeName - typeName of entity (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>depth - - number of hops for lineage (optional, default to 3)</li>
   *   <li>direction - - input, output or both (optional, default to BOTH)</li>
   *   </ul>

   */
  @RequestLine("GET /v2/lineage/uniqueAttribute/type/{typeName}")
  @Headers({
      "Content-Type: */*",
  })
  void getLineageByUniqueAttribute(@Param("typeName") String typeName,@QueryMap Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getLineageByUniqueAttribute</code> method in a fluent style.
   */
  public static class GetLineageByUniqueAttributeQueryParams extends HashMap<String, Object> {
    public GetLineageByUniqueAttributeQueryParams depth(final Integer value) {
      put("depth", EncodingUtils.encode(value));
      return this;
    }
    public GetLineageByUniqueAttributeQueryParams direction(final String value) {
      put("direction", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Returns lineage info about entity.
   * Returns lineage info about entity.
   * @param guid - unique entity id (required)
   * @param depth - number of hops for lineage (optional, default to 3)
   * @param direction - input, output or both (optional, default to BOTH)
   * @return JsonAtlasLineageInfo
   */
  @RequestLine("GET /v2/lineage/{guid}?depth={depth}&direction={direction}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasLineageInfo getLineageGraph(@Param("guid") String guid, @Param("depth") Integer depth, @Param("direction") String direction);

  /**
   * Returns lineage info about entity.
   * Returns lineage info about entity.
   * Note, this is equivalent to the other <code>getLineageGraph</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetLineageGraphQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param guid - unique entity id (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>depth - - number of hops for lineage (optional, default to 3)</li>
   *   <li>direction - - input, output or both (optional, default to BOTH)</li>
   *   </ul>
   * @return JsonAtlasLineageInfo

   */
  @RequestLine("GET /v2/lineage/{guid}?depth={depth}&direction={direction}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  JsonAtlasLineageInfo getLineageGraph(@Param("guid") String guid, @QueryMap Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getLineageGraph</code> method in a fluent style.
   */
  public static class GetLineageGraphQueryParams extends HashMap<String, Object> {
    public GetLineageGraphQueryParams depth(final Integer value) {
      put("depth", EncodingUtils.encode(value));
      return this;
    }
    public GetLineageGraphQueryParams direction(final String value) {
      put("direction", EncodingUtils.encode(value));
      return this;
    }
  }
}
