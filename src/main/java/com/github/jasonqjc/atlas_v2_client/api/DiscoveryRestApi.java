package com.github.jasonqjc.atlas_v2_client.api;

import java.util.HashMap;
import java.util.List;

import com.github.jasonqjc.atlas_v2_client.ApiClient;
import com.github.jasonqjc.atlas_v2_client.EncodingUtils;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasQuickSearchResult;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasSearchResult;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasSuggestionsResult;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasUserSavedSearch;
import com.github.jasonqjc.atlas_v2_client.model.JsonQuickSearchParameters;
import com.github.jasonqjc.atlas_v2_client.model.JsonSearchParameters;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@SuppressWarnings("serial")
public interface DiscoveryRestApi extends ApiClient.Api {

  /**
   * 
   * 
   * @param body  (optional)
   * @return JsonAtlasUserSavedSearch
   */
  @RequestLine("POST /v2/search/saved")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasUserSavedSearch addSavedSearch(JsonAtlasUserSavedSearch body);
  /**
   * 
   * 
   * @param guid Name of the saved search (required)
   */
  @RequestLine("DELETE /v2/search/saved/{guid}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteSavedSearch(@Param("guid") String guid);
  /**
   * Attribute based search for entities satisfying the search parameters.
   * Attribute based search for entities satisfying the search parameters
   * @param guid Guid identifying saved search (required)
   * @return JsonAtlasSearchResult
   */
  @RequestLine("GET /v2/search/saved/execute/guid/{guid}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasSearchResult executeSavedSearchByGuid(@Param("guid") String guid);
  /**
   * Attribute based search for entities satisfying the search parameters.
   * Attribute based search for entities satisfying the search parameters
   * @param name name of saved-search (required)
   * @param user saved-search owner (optional)
   * @return JsonAtlasSearchResult
   */
  @RequestLine("GET /v2/search/saved/execute/{name}?user={user}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasSearchResult executeSavedSearchByName(@Param("name") String name, @Param("user") String user);

  /**
   * Attribute based search for entities satisfying the search parameters.
   * Attribute based search for entities satisfying the search parameters
   * Note, this is equivalent to the other <code>executeSavedSearchByName</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link ExecuteSavedSearchByNameQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param name name of saved-search (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>user - saved-search owner (optional)</li>
   *   </ul>
   * @return JsonAtlasSearchResult

   */
  @RequestLine("GET /v2/search/saved/execute/{name}?user={user}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  JsonAtlasSearchResult executeSavedSearchByName(@Param("name") String name, @QueryMap ExecuteSavedSearchByNameQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>executeSavedSearchByName</code> method in a fluent style.
   */
  public static class ExecuteSavedSearchByNameQueryParams extends HashMap<String, Object> {
    public ExecuteSavedSearchByNameQueryParams user(final String value) {
      put("user", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * 
   * 
   * @param name Name of the saved search (required)
   * @param user User for whom the search is retrieved (optional)
   * @return JsonAtlasUserSavedSearch
   */
  @RequestLine("GET /v2/search/saved/{name}?user={user}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasUserSavedSearch getSavedSearch(@Param("name") String name, @Param("user") String user);

  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getSavedSearch</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetSavedSearchQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param name Name of the saved search (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>user - User for whom the search is retrieved (optional)</li>
   *   </ul>
   * @return JsonAtlasUserSavedSearch

   */
  @RequestLine("GET /v2/search/saved/{name}?user={user}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  JsonAtlasUserSavedSearch getSavedSearch(@Param("name") String name, @QueryMap GetSavedSearchQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getSavedSearch</code> method in a fluent style.
   */
  public static class GetSavedSearchQueryParams extends HashMap<String, Object> {
    public GetSavedSearchQueryParams user(final String value) {
      put("user", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * 
   * 
   * @param user User for whom the search is retrieved (optional)
   * @return List&lt;JsonAtlasUserSavedSearch&gt;
   */
  @RequestLine("GET /v2/search/saved?user={user}")
  @Headers({
      "Accept: application/json",
  })
  List<JsonAtlasUserSavedSearch> getSavedSearches(@Param("user") String user);

  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getSavedSearches</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetSavedSearchesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>user - User for whom the search is retrieved (optional)</li>
   *   </ul>
   * @return List&lt;JsonAtlasUserSavedSearch&gt;

   */
  @RequestLine("GET /v2/search/saved?user={user}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<JsonAtlasUserSavedSearch> getSavedSearches(@QueryMap GetSavedSearchesQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getSavedSearches</code> method in a fluent style.
   */
  public static class GetSavedSearchesQueryParams extends HashMap<String, Object> {
    public GetSavedSearchesQueryParams user(final String value) {
      put("user", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * 
   * 
   * @param fieldName  (optional)
   * @param prefixString  (optional)
   * @return JsonAtlasSuggestionsResult
   */
  @RequestLine("GET /v2/search/suggestions?fieldName={fieldName}&prefixString={prefixString}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasSuggestionsResult getSuggestions(@Param("fieldName") String fieldName, @Param("prefixString") String prefixString);

  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getSuggestions</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetSuggestionsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>fieldName -  (optional)</li>
   *   <li>prefixString -  (optional)</li>
   *   </ul>
   * @return JsonAtlasSuggestionsResult

   */
  @RequestLine("GET /v2/search/suggestions?fieldName={fieldName}&prefixString={prefixString}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  JsonAtlasSuggestionsResult getSuggestions(@QueryMap GetSuggestionsQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getSuggestions</code> method in a fluent style.
   */
  public static class GetSuggestionsQueryParams extends HashMap<String, Object> {
    public GetSuggestionsQueryParams fieldName(final String value) {
      put("fieldName", EncodingUtils.encode(value));
      return this;
    }
    public GetSuggestionsQueryParams prefixString(final String value) {
      put("prefixString", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Attribute based search for entities satisfying the search parameters.
   * Attribute based search for entities satisfying the search parameters
   * @param excludeDeletedEntities  (optional)
   * @param limit  (optional)
   * @param offset  (optional)
   * @param query  (optional)
   * @param typeName  (optional)
   * @return JsonAtlasQuickSearchResult
   */
  @RequestLine("GET /v2/search/quick?excludeDeletedEntities={excludeDeletedEntities}&limit={limit}&offset={offset}&query={query}&typeName={typeName}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasQuickSearchResult quickSearch(@Param("excludeDeletedEntities") Boolean excludeDeletedEntities, @Param("limit") Integer limit, @Param("offset") Integer offset, @Param("query") String query, @Param("typeName") String typeName);

  /**
   * Attribute based search for entities satisfying the search parameters.
   * Attribute based search for entities satisfying the search parameters
   * Note, this is equivalent to the other <code>quickSearch</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link QuickSearchQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>excludeDeletedEntities -  (optional)</li>
   *   <li>limit -  (optional)</li>
   *   <li>offset -  (optional)</li>
   *   <li>query -  (optional)</li>
   *   <li>typeName -  (optional)</li>
   *   </ul>
   * @return JsonAtlasQuickSearchResult

   */
  @RequestLine("GET /v2/search/quick?excludeDeletedEntities={excludeDeletedEntities}&limit={limit}&offset={offset}&query={query}&typeName={typeName}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  JsonAtlasQuickSearchResult quickSearch(@QueryMap QuickSearchQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>quickSearch</code> method in a fluent style.
   */
  public static class QuickSearchQueryParams extends HashMap<String, Object> {
    public QuickSearchQueryParams excludeDeletedEntities(final Boolean value) {
      put("excludeDeletedEntities", EncodingUtils.encode(value));
      return this;
    }
    public QuickSearchQueryParams limit(final Integer value) {
      put("limit", EncodingUtils.encode(value));
      return this;
    }
    public QuickSearchQueryParams offset(final Integer value) {
      put("offset", EncodingUtils.encode(value));
      return this;
    }
    public QuickSearchQueryParams query(final String value) {
      put("query", EncodingUtils.encode(value));
      return this;
    }
    public QuickSearchQueryParams typeName(final String value) {
      put("typeName", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Attribute based search for entities satisfying the search parameters.
   * Attribute based search for entities satisfying the search parameters
   * @param body  (optional)
   * @return JsonAtlasQuickSearchResult
   */
  @RequestLine("POST /v2/search/quick")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasQuickSearchResult quickSearch2(JsonQuickSearchParameters body);
  /**
   * Relationship search to search for related entities satisfying the search parameters.
   * Relationship search to search for related entities satisfying the search parameters
   * @param attributes set of attributes in search result. (optional)
   * @param excludeDeletedEntities  (optional)
   * @param guid Attribute name (optional)
   * @param limit limit the result set to only include the specified number of entries (optional)
   * @param offset start offset of the result set (useful for pagination) (optional)
   * @param relation relationName (optional)
   * @param sortBy sort the result using this attribute name, default value is &#x27;name&#x27; (optional)
   * @param sortOrder sorting order (optional)
   * @return JsonAtlasSearchResult
   */
  @RequestLine("GET /v2/search/relationship?attributes={attributes}&excludeDeletedEntities={excludeDeletedEntities}&guid={guid}&limit={limit}&offset={offset}&relation={relation}&sortBy={sortBy}&sortOrder={sortOrder}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasSearchResult searchRelatedEntities(@Param("attributes") List<String> attributes, @Param("excludeDeletedEntities") Boolean excludeDeletedEntities, @Param("guid") String guid, @Param("limit") Integer limit, @Param("offset") Integer offset, @Param("relation") String relation, @Param("sortBy") String sortBy, @Param("sortOrder") String sortOrder);

  /**
   * Relationship search to search for related entities satisfying the search parameters.
   * Relationship search to search for related entities satisfying the search parameters
   * Note, this is equivalent to the other <code>searchRelatedEntities</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchRelatedEntitiesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>attributes - set of attributes in search result. (optional)</li>
   *   <li>excludeDeletedEntities -  (optional)</li>
   *   <li>guid - Attribute name (optional)</li>
   *   <li>limit - limit the result set to only include the specified number of entries (optional)</li>
   *   <li>offset - start offset of the result set (useful for pagination) (optional)</li>
   *   <li>relation - relationName (optional)</li>
   *   <li>sortBy - sort the result using this attribute name, default value is &#x27;name&#x27; (optional)</li>
   *   <li>sortOrder - sorting order (optional)</li>
   *   </ul>
   * @return JsonAtlasSearchResult

   */
  @RequestLine("GET /v2/search/relationship?attributes={attributes}&excludeDeletedEntities={excludeDeletedEntities}&guid={guid}&limit={limit}&offset={offset}&relation={relation}&sortBy={sortBy}&sortOrder={sortOrder}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  JsonAtlasSearchResult searchRelatedEntities(@QueryMap SearchRelatedEntitiesQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>searchRelatedEntities</code> method in a fluent style.
   */
  public static class SearchRelatedEntitiesQueryParams extends HashMap<String, Object> {
    public SearchRelatedEntitiesQueryParams attributes(final List<String> value) {
      put("attributes", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public SearchRelatedEntitiesQueryParams excludeDeletedEntities(final Boolean value) {
      put("excludeDeletedEntities", EncodingUtils.encode(value));
      return this;
    }
    public SearchRelatedEntitiesQueryParams guid(final String value) {
      put("guid", EncodingUtils.encode(value));
      return this;
    }
    public SearchRelatedEntitiesQueryParams limit(final Integer value) {
      put("limit", EncodingUtils.encode(value));
      return this;
    }
    public SearchRelatedEntitiesQueryParams offset(final Integer value) {
      put("offset", EncodingUtils.encode(value));
      return this;
    }
    public SearchRelatedEntitiesQueryParams relation(final String value) {
      put("relation", EncodingUtils.encode(value));
      return this;
    }
    public SearchRelatedEntitiesQueryParams sortBy(final String value) {
      put("sortBy", EncodingUtils.encode(value));
      return this;
    }
    public SearchRelatedEntitiesQueryParams sortOrder(final String value) {
      put("sortOrder", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Retrieve data for the specified attribute search query.
   * Retrieve data for the specified attribute search query
   * @param attrName Attribute name (optional)
   * @param attrValuePrefix Attibute value to search on (optional)
   * @param limit limit the result set to only include the specified number of entries (optional)
   * @param offset start offset of the result set (useful for pagination) (optional)
   * @param typeName limit the result to only entities of specified type or its sub-types (optional)
   * @return JsonAtlasSearchResult
   */
  @RequestLine("GET /v2/search/attribute?attrName={attrName}&attrValuePrefix={attrValuePrefix}&limit={limit}&offset={offset}&typeName={typeName}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasSearchResult searchUsingAttribute(@Param("attrName") String attrName, @Param("attrValuePrefix") String attrValuePrefix, @Param("limit") Integer limit, @Param("offset") Integer offset, @Param("typeName") String typeName);

  /**
   * Retrieve data for the specified attribute search query.
   * Retrieve data for the specified attribute search query
   * Note, this is equivalent to the other <code>searchUsingAttribute</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchUsingAttributeQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>attrName - Attribute name (optional)</li>
   *   <li>attrValuePrefix - Attibute value to search on (optional)</li>
   *   <li>limit - limit the result set to only include the specified number of entries (optional)</li>
   *   <li>offset - start offset of the result set (useful for pagination) (optional)</li>
   *   <li>typeName - limit the result to only entities of specified type or its sub-types (optional)</li>
   *   </ul>
   * @return JsonAtlasSearchResult

   */
  @RequestLine("GET /v2/search/attribute?attrName={attrName}&attrValuePrefix={attrValuePrefix}&limit={limit}&offset={offset}&typeName={typeName}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  JsonAtlasSearchResult searchUsingAttribute(@QueryMap SearchUsingAttributeQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>searchUsingAttribute</code> method in a fluent style.
   */
  public static class SearchUsingAttributeQueryParams extends HashMap<String, Object> {
    public SearchUsingAttributeQueryParams attrName(final String value) {
      put("attrName", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingAttributeQueryParams attrValuePrefix(final String value) {
      put("attrValuePrefix", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingAttributeQueryParams limit(final Integer value) {
      put("limit", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingAttributeQueryParams offset(final Integer value) {
      put("offset", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingAttributeQueryParams typeName(final String value) {
      put("typeName", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Retrieve data for the specified fulltext query.
   * Retrieve data for the specified fulltext query
   * @param classification limit the result to only entities tagged with the given classification or or its sub-types (optional)
   * @param excludeDeletedEntities  (optional)
   * @param limit limit the result set to only include the specified number of entries (optional)
   * @param offset start offset of the result set (useful for pagination) (optional)
   * @param query Fulltext query (optional)
   * @param sortBy  (optional)
   * @param sortOrder  (optional)
   * @param typeName limit the result to only entities of specified type or its sub-types (optional)
   * @return JsonAtlasSearchResult
   */
  @RequestLine("GET /v2/search/basic?classification={classification}&excludeDeletedEntities={excludeDeletedEntities}&limit={limit}&offset={offset}&query={query}&sortBy={sortBy}&sortOrder={sortOrder}&typeName={typeName}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasSearchResult searchUsingBasic(@Param("classification") String classification, @Param("excludeDeletedEntities") Boolean excludeDeletedEntities, @Param("limit") Integer limit, @Param("offset") Integer offset, @Param("query") String query, @Param("sortBy") String sortBy, @Param("sortOrder") String sortOrder, @Param("typeName") String typeName);

  /**
   * Retrieve data for the specified fulltext query.
   * Retrieve data for the specified fulltext query
   * Note, this is equivalent to the other <code>searchUsingBasic</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchUsingBasicQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>classification - limit the result to only entities tagged with the given classification or or its sub-types (optional)</li>
   *   <li>excludeDeletedEntities -  (optional)</li>
   *   <li>limit - limit the result set to only include the specified number of entries (optional)</li>
   *   <li>offset - start offset of the result set (useful for pagination) (optional)</li>
   *   <li>query - Fulltext query (optional)</li>
   *   <li>sortBy -  (optional)</li>
   *   <li>sortOrder -  (optional)</li>
   *   <li>typeName - limit the result to only entities of specified type or its sub-types (optional)</li>
   *   </ul>
   * @return JsonAtlasSearchResult

   */
  @RequestLine("GET /v2/search/basic")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  JsonAtlasSearchResult searchUsingBasic(@QueryMap SearchUsingBasicQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>searchUsingBasic</code> method in a fluent style.
   */
  public static class SearchUsingBasicQueryParams extends HashMap<String, Object> {
    public SearchUsingBasicQueryParams classification(final String value) {
      put("classification", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingBasicQueryParams excludeDeletedEntities(final Boolean value) {
      put("excludeDeletedEntities", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingBasicQueryParams limit(final Integer value) {
      put("limit", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingBasicQueryParams offset(final Integer value) {
      put("offset", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingBasicQueryParams query(final String value) {
      put("query", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingBasicQueryParams sortBy(final String value) {
      put("sortBy", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingBasicQueryParams sortOrder(final String value) {
      put("sortOrder", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingBasicQueryParams typeName(final String value) {
      put("typeName", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingBasicQueryParams termName(final String value) {
    	put("termName", EncodingUtils.encode(value));
    	return this;
    }
    public SearchUsingBasicQueryParams includeClassificationAttributes(final Boolean value) {
    	put("includeClassificationAttributes", EncodingUtils.encode(value));
    	return this;
    }
    public SearchUsingBasicQueryParams includeSubClassifications(final Boolean value) {
    	put("includeSubClassifications", EncodingUtils.encode(value));
    	return this;
    }
    public SearchUsingBasicQueryParams includeSubTypes(final Boolean value) {
    	put("includeSubTypes", EncodingUtils.encode(value));
    	return this;
    }
    
  }
  /**
   * Retrieve data for the specified DSL.
   * Retrieve data for the specified DSL
   * @param classification limit the result to only entities tagged with the given classification or or its sub-types (optional)
   * @param limit limit the result set to only include the specified number of entries (optional)
   * @param offset start offset of the result set (useful for pagination) (optional)
   * @param query DSL query (optional)
   * @param typeName limit the result to only entities of specified type or its sub-types (optional)
   * @return JsonAtlasSearchResult
   */
  @RequestLine("GET /v2/search/dsl?classification={classification}&limit={limit}&offset={offset}&query={query}&typeName={typeName}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasSearchResult searchUsingDSL(@Param("classification") String classification, @Param("limit") Integer limit, @Param("offset") Integer offset, @Param("query") String query, @Param("typeName") String typeName);

  /**
   * Retrieve data for the specified DSL.
   * Retrieve data for the specified DSL
   * Note, this is equivalent to the other <code>searchUsingDSL</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchUsingDSLQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>classification - limit the result to only entities tagged with the given classification or or its sub-types (optional)</li>
   *   <li>limit - limit the result set to only include the specified number of entries (optional)</li>
   *   <li>offset - start offset of the result set (useful for pagination) (optional)</li>
   *   <li>query - DSL query (optional)</li>
   *   <li>typeName - limit the result to only entities of specified type or its sub-types (optional)</li>
   *   </ul>
   * @return JsonAtlasSearchResult

   */
  @RequestLine("GET /v2/search/dsl?classification={classification}&limit={limit}&offset={offset}&query={query}&typeName={typeName}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  JsonAtlasSearchResult searchUsingDSL(@QueryMap SearchUsingDSLQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>searchUsingDSL</code> method in a fluent style.
   */
  public static class SearchUsingDSLQueryParams extends HashMap<String, Object> {
    public SearchUsingDSLQueryParams classification(final String value) {
      put("classification", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingDSLQueryParams limit(final Integer value) {
      put("limit", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingDSLQueryParams offset(final Integer value) {
      put("offset", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingDSLQueryParams query(final String value) {
      put("query", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingDSLQueryParams typeName(final String value) {
      put("typeName", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Retrieve data for the specified fulltext query.
   * Retrieve data for the specified fulltext query
   * @param excludeDeletedEntities  (optional)
   * @param limit limit the result set to only include the specified number of entries (optional)
   * @param offset start offset of the result set (useful for pagination) (optional)
   * @param query Fulltext query (optional)
   * @return JsonAtlasSearchResult
   */
  @RequestLine("GET /v2/search/fulltext?excludeDeletedEntities={excludeDeletedEntities}&limit={limit}&offset={offset}&query={query}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasSearchResult searchUsingFullText(@Param("excludeDeletedEntities") Boolean excludeDeletedEntities, @Param("limit") Integer limit, @Param("offset") Integer offset, @Param("query") String query);

  /**
   * Retrieve data for the specified fulltext query.
   * Retrieve data for the specified fulltext query
   * Note, this is equivalent to the other <code>searchUsingFullText</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchUsingFullTextQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>excludeDeletedEntities -  (optional)</li>
   *   <li>limit - limit the result set to only include the specified number of entries (optional)</li>
   *   <li>offset - start offset of the result set (useful for pagination) (optional)</li>
   *   <li>query - Fulltext query (optional)</li>
   *   </ul>
   * @return JsonAtlasSearchResult

   */
  @RequestLine("GET /v2/search/fulltext?excludeDeletedEntities={excludeDeletedEntities}&limit={limit}&offset={offset}&query={query}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  JsonAtlasSearchResult searchUsingFullText(@QueryMap SearchUsingFullTextQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>searchUsingFullText</code> method in a fluent style.
   */
  public static class SearchUsingFullTextQueryParams extends HashMap<String, Object> {
    public SearchUsingFullTextQueryParams excludeDeletedEntities(final Boolean value) {
      put("excludeDeletedEntities", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingFullTextQueryParams limit(final Integer value) {
      put("limit", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingFullTextQueryParams offset(final Integer value) {
      put("offset", EncodingUtils.encode(value));
      return this;
    }
    public SearchUsingFullTextQueryParams query(final String value) {
      put("query", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Attribute based search for entities satisfying the search parameters.
   * Attribute based search for entities satisfying the search parameters
   * @param body Search parameters (optional)
   * @return JsonAtlasSearchResult
   */
  @RequestLine("POST /v2/search/basic")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasSearchResult searchWithParameters(JsonSearchParameters body);
  /**
   * 
   * 
   * @param body  (optional)
   * @return JsonAtlasUserSavedSearch
   */
  @RequestLine("PUT /v2/search/saved")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasUserSavedSearch updateSavedSearch(JsonAtlasUserSavedSearch body);
}
