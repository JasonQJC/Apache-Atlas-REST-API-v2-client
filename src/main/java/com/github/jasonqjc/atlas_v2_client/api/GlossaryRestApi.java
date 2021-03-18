package com.github.jasonqjc.atlas_v2_client.api;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.jasonqjc.atlas_v2_client.ApiClient;
import com.github.jasonqjc.atlas_v2_client.EncodingUtils;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasGlossary;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasGlossaryCategory;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasGlossaryExtInfo;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasGlossaryTerm;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelatedCategoryHeader;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelatedObjectId;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasRelatedTermHeader;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@SuppressWarnings("serial")
public interface GlossaryRestApi extends ApiClient.Api {

  /**
   * Assign the given term to the provided list of entity headers.
   * Assign the given term to the provided list of entity headers
   * @param termGuid Glossary term GUID (required)
   * @param body Related Entity IDs to which the term has to be associated (optional)
   */
  @RequestLine("POST /v2/glossary/terms/{termGuid}/assignedEntities")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void assignTermToEntities(@Param("termGuid") String termGuid, List<JsonAtlasRelatedObjectId> body);
  /**
   * Create a glossary.
   * Create a glossary
   * @param body Glossary definition, terms &amp; categories can be anchored to a glossary
using the anchor attribute when creating the Term/Category (optional)
   * @return JsonAtlasGlossary
   */
  @RequestLine("POST /v2/glossary")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasGlossary createGlossary(JsonAtlasGlossary body);
  /**
   * Create glossary category in bulk.
   * Create glossary category in bulk
   * @param body glossary category definitions (optional)
   * @return List&lt;JsonAtlasGlossaryCategory&gt;
   */
  @RequestLine("POST /v2/glossary/categories")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  List<JsonAtlasGlossaryCategory> createGlossaryCategories(List<JsonAtlasGlossaryCategory> body);
  /**
   * Create glossary category.
   * Create glossary category
   * @param body glossary category definition, a category must be anchored to a Glossary when creating
Optionally, terms belonging to the category and the hierarchy can also be defined during creation (optional)
   * @return JsonAtlasGlossaryCategory
   */
  @RequestLine("POST /v2/glossary/category")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasGlossaryCategory createGlossaryCategory(JsonAtlasGlossaryCategory body);
  /**
   * Create a glossary term.
   * Create a glossary term
   * @param body Glossary term definition, a term must be anchored to a Glossary at the time of creation
optionally it can be categorized as well (optional)
   * @return JsonAtlasGlossaryTerm
   */
  @RequestLine("POST /v2/glossary/term")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasGlossaryTerm createGlossaryTerm(JsonAtlasGlossaryTerm body);
  /**
   * Create glossary terms in bulk.
   * Create glossary terms in bulk
   * @param body glossary term definitions (optional)
   * @return List&lt;JsonAtlasGlossaryTerm&gt;
   */
  @RequestLine("POST /v2/glossary/terms")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  List<JsonAtlasGlossaryTerm> createGlossaryTerms(List<JsonAtlasGlossaryTerm> body);
  /**
   * Delete a glossary.
   * Delete a glossary
   * @param glossaryGuid unique identifier for glossary (required)
   */
  @RequestLine("DELETE /v2/glossary/{glossaryGuid}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteGlossary(@Param("glossaryGuid") String glossaryGuid);
  /**
   * Delete a glossary category.
   * Delete a glossary category
   * @param categoryGuid unique identifier for glossary category (required)
   */
  @RequestLine("DELETE /v2/glossary/category/{categoryGuid}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteGlossaryCategory(@Param("categoryGuid") String categoryGuid);
  /**
   * Delete a glossary term.
   * Delete a glossary term
   * @param termGuid unique identifier for glossary term (required)
   */
  @RequestLine("DELETE /v2/glossary/term/{termGuid}")
  @Headers({
      "Content-Type: application/json",
      "Accept: */*",
  })
  void deleteGlossaryTerm(@Param("termGuid") String termGuid);
  /**
   * Remove the term assignment for the given list of entity headers.
   * Remove the term assignment for the given list of entity headers
   * @param termGuid Glossary term GUID (required)
   * @param body List of related entity IDs from which the term has to be dissociated (optional)
   */
  @RequestLine("PUT /v2/glossary/terms/{termGuid}/assignedEntities")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void disassociateTermAssignmentFromEntities(@Param("termGuid") String termGuid, List<JsonAtlasRelatedObjectId> body);
  /**
   * Get all terms associated with the specific category.
   * Get all terms associated with the specific category
   * @param categoryGuid unique identifier for glossary category (required)
   * @param limit page size - by default there is no paging (optional, default to -1)
   * @param offset offset for pagination purpose (optional, default to 0)
   * @param sort ASC (default) or DESC (optional, default to ASC)
   * @return List&lt;JsonAtlasRelatedTermHeader&gt;
   */
  @RequestLine("GET /v2/glossary/category/{categoryGuid}/terms?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Accept: application/json",
  })
  List<JsonAtlasRelatedTermHeader> getCategoryTerms(@Param("categoryGuid") String categoryGuid, @Param("limit") String limit, @Param("offset") String offset, @Param("sort") String sort);

  /**
   * Get all terms associated with the specific category.
   * Get all terms associated with the specific category
   * Note, this is equivalent to the other <code>getCategoryTerms</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetCategoryTermsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param categoryGuid unique identifier for glossary category (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>limit - page size - by default there is no paging (optional, default to -1)</li>
   *   <li>offset - offset for pagination purpose (optional, default to 0)</li>
   *   <li>sort - ASC (default) or DESC (optional, default to ASC)</li>
   *   </ul>
   * @return List&lt;JsonAtlasRelatedTermHeader&gt;

   */
  @RequestLine("GET /v2/glossary/category/{categoryGuid}/terms?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<JsonAtlasRelatedTermHeader> getCategoryTerms(@Param("categoryGuid") String categoryGuid, @QueryMap GetCategoryTermsQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getCategoryTerms</code> method in a fluent style.
   */
  public static class GetCategoryTermsQueryParams extends HashMap<String, Object> {
    public GetCategoryTermsQueryParams limit(final String value) {
      put("limit", EncodingUtils.encode(value));
      return this;
    }
    public GetCategoryTermsQueryParams offset(final String value) {
      put("offset", EncodingUtils.encode(value));
      return this;
    }
    public GetCategoryTermsQueryParams sort(final String value) {
      put("sort", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Get a specific Glossary.
   * Get a specific Glossary
   * @param glossaryGuid unique glossary identifier (required)
   * @return JsonAtlasGlossaryExtInfo
   */
  @RequestLine("GET /v2/glossary/{glossaryGuid}/detailed")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasGlossaryExtInfo getDetailedGlossary(@Param("glossaryGuid") String glossaryGuid);
  /**
   * Get all entity headers assigned with the specified term.
   * Get all entity headers assigned with the specified term
   * @param termGuid GUID of the term (required)
   * @param limit page size - by default there is no paging (optional, default to -1)
   * @param offset offset for pagination purpose (optional, default to 0)
   * @param sort ASC (default) or DESC (optional, default to ASC)
   * @return List&lt;JsonAtlasRelatedObjectId&gt;
   */
  @RequestLine("GET /v2/glossary/terms/{termGuid}/assignedEntities?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Accept: application/json",
  })
  List<JsonAtlasRelatedObjectId> getEntitiesAssignedWithTerm(@Param("termGuid") String termGuid, @Param("limit") String limit, @Param("offset") String offset, @Param("sort") String sort);

  /**
   * Get all entity headers assigned with the specified term.
   * Get all entity headers assigned with the specified term
   * Note, this is equivalent to the other <code>getEntitiesAssignedWithTerm</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetEntitiesAssignedWithTermQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param termGuid GUID of the term (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>limit - page size - by default there is no paging (optional, default to -1)</li>
   *   <li>offset - offset for pagination purpose (optional, default to 0)</li>
   *   <li>sort - ASC (default) or DESC (optional, default to ASC)</li>
   *   </ul>
   * @return List&lt;JsonAtlasRelatedObjectId&gt;

   */
  @RequestLine("GET /v2/glossary/terms/{termGuid}/assignedEntities?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<JsonAtlasRelatedObjectId> getEntitiesAssignedWithTerm(@Param("termGuid") String termGuid, @QueryMap GetEntitiesAssignedWithTermQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getEntitiesAssignedWithTerm</code> method in a fluent style.
   */
  public static class GetEntitiesAssignedWithTermQueryParams extends HashMap<String, Object> {
    public GetEntitiesAssignedWithTermQueryParams limit(final String value) {
      put("limit", EncodingUtils.encode(value));
      return this;
    }
    public GetEntitiesAssignedWithTermQueryParams offset(final String value) {
      put("offset", EncodingUtils.encode(value));
      return this;
    }
    public GetEntitiesAssignedWithTermQueryParams sort(final String value) {
      put("sort", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Retrieve all glossaries registered with Atlas.
   * Retrieve all glossaries registered with Atlas
   * @param limit page size - by default there is no paging (optional, default to -1)
   * @param offset offset for pagination purpose (optional, default to 0)
   * @param sort Sort order, ASC (default) or DESC (optional, default to ASC)
   * @return List&lt;JsonAtlasGlossary&gt;
   */
  @RequestLine("GET /v2/glossary?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Accept: application/json",
  })
  List<JsonAtlasGlossary> getGlossaries(@Param("limit") String limit, @Param("offset") String offset, @Param("sort") String sort);

  /**
   * Retrieve all glossaries registered with Atlas.
   * Retrieve all glossaries registered with Atlas
   * Note, this is equivalent to the other <code>getGlossaries</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetGlossariesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>limit - page size - by default there is no paging (optional, default to -1)</li>
   *   <li>offset - offset for pagination purpose (optional, default to 0)</li>
   *   <li>sort - Sort order, ASC (default) or DESC (optional, default to ASC)</li>
   *   </ul>
   * @return List&lt;JsonAtlasGlossary&gt;

   */
  @RequestLine("GET /v2/glossary?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<JsonAtlasGlossary> getGlossaries(@QueryMap GetGlossariesQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getGlossaries</code> method in a fluent style.
   */
  public static class GetGlossariesQueryParams extends HashMap<String, Object> {
    public GetGlossariesQueryParams limit(final String value) {
      put("limit", EncodingUtils.encode(value));
      return this;
    }
    public GetGlossariesQueryParams offset(final String value) {
      put("offset", EncodingUtils.encode(value));
      return this;
    }
    public GetGlossariesQueryParams sort(final String value) {
      put("sort", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Get a specific Glossary.
   * Get a specific Glossary
   * @param glossaryGuid unique glossary identifier (required)
   * @return JsonAtlasGlossary
   */
  @RequestLine("GET /v2/glossary/{glossaryGuid}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasGlossary getGlossary(@Param("glossaryGuid") String glossaryGuid);
  /**
   * Get the categories belonging to a specific glossary.
   * Get the categories belonging to a specific glossary
   * @param glossaryGuid unique identifier for glossary term (required)
   * @param limit page size - by default there is no paging (optional, default to -1)
   * @param offset offset for pagination purpose (optional, default to 0)
   * @param sort ASC (default) or DESC (optional, default to ASC)
   * @return List&lt;JsonAtlasGlossaryCategory&gt;
   */
  @RequestLine("GET /v2/glossary/{glossaryGuid}/categories?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Accept: application/json",
  })
  List<JsonAtlasGlossaryCategory> getGlossaryCategories(@Param("glossaryGuid") String glossaryGuid, @Param("limit") String limit, @Param("offset") String offset, @Param("sort") String sort);

  /**
   * Get the categories belonging to a specific glossary.
   * Get the categories belonging to a specific glossary
   * Note, this is equivalent to the other <code>getGlossaryCategories</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetGlossaryCategoriesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param glossaryGuid unique identifier for glossary term (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>limit - page size - by default there is no paging (optional, default to -1)</li>
   *   <li>offset - offset for pagination purpose (optional, default to 0)</li>
   *   <li>sort - ASC (default) or DESC (optional, default to ASC)</li>
   *   </ul>
   * @return List&lt;JsonAtlasGlossaryCategory&gt;

   */
  @RequestLine("GET /v2/glossary/{glossaryGuid}/categories?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<JsonAtlasGlossaryCategory> getGlossaryCategories(@Param("glossaryGuid") String glossaryGuid, @QueryMap GetGlossaryCategoriesQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getGlossaryCategories</code> method in a fluent style.
   */
  public static class GetGlossaryCategoriesQueryParams extends HashMap<String, Object> {
    public GetGlossaryCategoriesQueryParams limit(final String value) {
      put("limit", EncodingUtils.encode(value));
      return this;
    }
    public GetGlossaryCategoriesQueryParams offset(final String value) {
      put("offset", EncodingUtils.encode(value));
      return this;
    }
    public GetGlossaryCategoriesQueryParams sort(final String value) {
      put("sort", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Get the categories belonging to a specific glossary.
   * Get the categories belonging to a specific glossary
   * @param glossaryGuid unique identifier for glossary term (required)
   * @param limit page size - by default there is no paging (optional, default to -1)
   * @param offset offset for pagination purpose (optional, default to 0)
   * @param sort ASC (default) or DESC (optional, default to ASC)
   * @return List&lt;JsonAtlasRelatedCategoryHeader&gt;
   */
  @RequestLine("GET /v2/glossary/{glossaryGuid}/categories/headers?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Accept: application/json",
  })
  List<JsonAtlasRelatedCategoryHeader> getGlossaryCategoriesHeaders(@Param("glossaryGuid") String glossaryGuid, @Param("limit") String limit, @Param("offset") String offset, @Param("sort") String sort);

  /**
   * Get the categories belonging to a specific glossary.
   * Get the categories belonging to a specific glossary
   * Note, this is equivalent to the other <code>getGlossaryCategoriesHeaders</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetGlossaryCategoriesHeadersQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param glossaryGuid unique identifier for glossary term (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>limit - page size - by default there is no paging (optional, default to -1)</li>
   *   <li>offset - offset for pagination purpose (optional, default to 0)</li>
   *   <li>sort - ASC (default) or DESC (optional, default to ASC)</li>
   *   </ul>
   * @return List&lt;JsonAtlasRelatedCategoryHeader&gt;

   */
  @RequestLine("GET /v2/glossary/{glossaryGuid}/categories/headers?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<JsonAtlasRelatedCategoryHeader> getGlossaryCategoriesHeaders(@Param("glossaryGuid") String glossaryGuid, @QueryMap GetGlossaryCategoriesHeadersQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getGlossaryCategoriesHeaders</code> method in a fluent style.
   */
  public static class GetGlossaryCategoriesHeadersQueryParams extends HashMap<String, Object> {
    public GetGlossaryCategoriesHeadersQueryParams limit(final String value) {
      put("limit", EncodingUtils.encode(value));
      return this;
    }
    public GetGlossaryCategoriesHeadersQueryParams offset(final String value) {
      put("offset", EncodingUtils.encode(value));
      return this;
    }
    public GetGlossaryCategoriesHeadersQueryParams sort(final String value) {
      put("sort", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Get specific glossary category.
   * Get specific glossary category
   * @param categoryGuid unique identifier for glossary category (required)
   * @return JsonAtlasGlossaryCategory
   */
  @RequestLine("GET /v2/glossary/category/{categoryGuid}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasGlossaryCategory getGlossaryCategory(@Param("categoryGuid") String categoryGuid);
  /**
   * Get specific glossary term.
   * Get specific glossary term
   * @param termGuid unique identifier for glossary term (required)
   * @return JsonAtlasGlossaryTerm
   */
  @RequestLine("GET /v2/glossary/term/{termGuid}")
  @Headers({
      "Accept: application/json",
  })
  JsonAtlasGlossaryTerm getGlossaryTerm(@Param("termGuid") String termGuid);
  /**
   * Get term headers belonging to a specific glossary.
   * Get term headers belonging to a specific glossary
   * @param glossaryGuid unique identifier for glossary (required)
   * @param limit page size - by default there is no paging (optional, default to -1)
   * @param offset starting offset for loading terms (optional, default to 0)
   * @param sort ASC(default) or DESC (optional, default to ASC)
   * @return List&lt;JsonAtlasRelatedTermHeader&gt;
   */
  @RequestLine("GET /v2/glossary/{glossaryGuid}/terms/headers?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Accept: application/json",
  })
  List<JsonAtlasRelatedTermHeader> getGlossaryTermHeaders(@Param("glossaryGuid") String glossaryGuid, @Param("limit") String limit, @Param("offset") String offset, @Param("sort") String sort);

  /**
   * Get term headers belonging to a specific glossary.
   * Get term headers belonging to a specific glossary
   * Note, this is equivalent to the other <code>getGlossaryTermHeaders</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetGlossaryTermHeadersQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param glossaryGuid unique identifier for glossary (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>limit - page size - by default there is no paging (optional, default to -1)</li>
   *   <li>offset - starting offset for loading terms (optional, default to 0)</li>
   *   <li>sort - ASC(default) or DESC (optional, default to ASC)</li>
   *   </ul>
   * @return List&lt;JsonAtlasRelatedTermHeader&gt;

   */
  @RequestLine("GET /v2/glossary/{glossaryGuid}/terms/headers?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<JsonAtlasRelatedTermHeader> getGlossaryTermHeaders(@Param("glossaryGuid") String glossaryGuid, @QueryMap GetGlossaryTermHeadersQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getGlossaryTermHeaders</code> method in a fluent style.
   */
  public static class GetGlossaryTermHeadersQueryParams extends HashMap<String, Object> {
    public GetGlossaryTermHeadersQueryParams limit(final String value) {
      put("limit", EncodingUtils.encode(value));
      return this;
    }
    public GetGlossaryTermHeadersQueryParams offset(final String value) {
      put("offset", EncodingUtils.encode(value));
      return this;
    }
    public GetGlossaryTermHeadersQueryParams sort(final String value) {
      put("sort", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Get terms belonging to a specific glossary.
   * Get terms belonging to a specific glossary
   * @param glossaryGuid unique identifier for glossary (required)
   * @param limit page size - by default there is no paging (optional, default to -1)
   * @param offset starting offset for loading terms (optional, default to 0)
   * @param sort ASC(default) or DESC (optional, default to ASC)
   * @return List&lt;JsonAtlasGlossaryTerm&gt;
   */
  @RequestLine("GET /v2/glossary/{glossaryGuid}/terms?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Accept: application/json",
  })
  List<JsonAtlasGlossaryTerm> getGlossaryTerms(@Param("glossaryGuid") String glossaryGuid, @Param("limit") String limit, @Param("offset") String offset, @Param("sort") String sort);

  /**
   * Get terms belonging to a specific glossary.
   * Get terms belonging to a specific glossary
   * Note, this is equivalent to the other <code>getGlossaryTerms</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetGlossaryTermsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param glossaryGuid unique identifier for glossary (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>limit - page size - by default there is no paging (optional, default to -1)</li>
   *   <li>offset - starting offset for loading terms (optional, default to 0)</li>
   *   <li>sort - ASC(default) or DESC (optional, default to ASC)</li>
   *   </ul>
   * @return List&lt;JsonAtlasGlossaryTerm&gt;

   */
  @RequestLine("GET /v2/glossary/{glossaryGuid}/terms?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<JsonAtlasGlossaryTerm> getGlossaryTerms(@Param("glossaryGuid") String glossaryGuid, @QueryMap GetGlossaryTermsQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getGlossaryTerms</code> method in a fluent style.
   */
  public static class GetGlossaryTermsQueryParams extends HashMap<String, Object> {
    public GetGlossaryTermsQueryParams limit(final String value) {
      put("limit", EncodingUtils.encode(value));
      return this;
    }
    public GetGlossaryTermsQueryParams offset(final String value) {
      put("offset", EncodingUtils.encode(value));
      return this;
    }
    public GetGlossaryTermsQueryParams sort(final String value) {
      put("sort", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Get all related categories (parent and children).
   * Get all related categories (parent and children)
   * @param categoryGuid unique identifier for glossary category (required)
   * @param limit page size - by default there is no paging (optional, default to -1)
   * @param offset offset for pagination purpose (optional, default to 0)
   * @param sort ASC (default) or DESC (optional, default to ASC)
   * @return Map&lt;String, List&lt;JsonAtlasRelatedCategoryHeader&gt;&gt;
   */
  @RequestLine("GET /v2/glossary/category/{categoryGuid}/related?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Accept: application/json",
  })
  Map<String, List<JsonAtlasRelatedCategoryHeader>> getRelatedCategories(@Param("categoryGuid") String categoryGuid, @Param("limit") String limit, @Param("offset") String offset, @Param("sort") String sort);

  /**
   * Get all related categories (parent and children).
   * Get all related categories (parent and children)
   * Note, this is equivalent to the other <code>getRelatedCategories</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetRelatedCategoriesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param categoryGuid unique identifier for glossary category (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>limit - page size - by default there is no paging (optional, default to -1)</li>
   *   <li>offset - offset for pagination purpose (optional, default to 0)</li>
   *   <li>sort - ASC (default) or DESC (optional, default to ASC)</li>
   *   </ul>
   * @return Map&lt;String, List&lt;JsonAtlasRelatedCategoryHeader&gt;&gt;

   */
  @RequestLine("GET /v2/glossary/category/{categoryGuid}/related?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  Map<String, List<JsonAtlasRelatedCategoryHeader>> getRelatedCategories(@Param("categoryGuid") String categoryGuid, @QueryMap GetRelatedCategoriesQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getRelatedCategories</code> method in a fluent style.
   */
  public static class GetRelatedCategoriesQueryParams extends HashMap<String, Object> {
    public GetRelatedCategoriesQueryParams limit(final String value) {
      put("limit", EncodingUtils.encode(value));
      return this;
    }
    public GetRelatedCategoriesQueryParams offset(final String value) {
      put("offset", EncodingUtils.encode(value));
      return this;
    }
    public GetRelatedCategoriesQueryParams sort(final String value) {
      put("sort", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Get all related terms for a specific term.
   * Get all related terms for a specific term
   * @param termGuid unique identifier for glossary term (required)
   * @param limit page size - by default there is no paging (optional, default to -1)
   * @param offset offset for pagination purpose (optional, default to 0)
   * @param sort ASC (default) or DESC (optional, default to ASC)
   * @return Map&lt;String, List&lt;JsonAtlasRelatedTermHeader&gt;&gt;
   */
  @RequestLine("GET /v2/glossary/terms/{termGuid}/related?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Accept: application/json",
  })
  Map<String, List<JsonAtlasRelatedTermHeader>> getRelatedTerms(@Param("termGuid") String termGuid, @Param("limit") String limit, @Param("offset") String offset, @Param("sort") String sort);

  /**
   * Get all related terms for a specific term.
   * Get all related terms for a specific term
   * Note, this is equivalent to the other <code>getRelatedTerms</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetRelatedTermsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param termGuid unique identifier for glossary term (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>limit - page size - by default there is no paging (optional, default to -1)</li>
   *   <li>offset - offset for pagination purpose (optional, default to 0)</li>
   *   <li>sort - ASC (default) or DESC (optional, default to ASC)</li>
   *   </ul>
   * @return Map&lt;String, List&lt;JsonAtlasRelatedTermHeader&gt;&gt;

   */
  @RequestLine("GET /v2/glossary/terms/{termGuid}/related?limit={limit}&offset={offset}&sort={sort}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  Map<String, List<JsonAtlasRelatedTermHeader>> getRelatedTerms(@Param("termGuid") String termGuid, @QueryMap GetRelatedTermsQueryParams queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getRelatedTerms</code> method in a fluent style.
   */
  public static class GetRelatedTermsQueryParams extends HashMap<String, Object> {
    public GetRelatedTermsQueryParams limit(final String value) {
      put("limit", EncodingUtils.encode(value));
      return this;
    }
    public GetRelatedTermsQueryParams offset(final String value) {
      put("offset", EncodingUtils.encode(value));
      return this;
    }
    public GetRelatedTermsQueryParams sort(final String value) {
      put("sort", EncodingUtils.encode(value));
      return this;
    }
  }
  /**
   * Upload glossary file for creating AtlasGlossaryTerms in bulk.
   * Upload glossary file for creating AtlasGlossaryTerms in bulk
   * @param fileDetail  (optional)
   * @param inputStream  (optional)
   * @return List&lt;JsonAtlasGlossaryTerm&gt;
   */
  @RequestLine("POST /v2/glossary/import")
  @Headers({
      "Content-Type: multipart/form-data",
      "Accept: application/json",
  })
  List<JsonAtlasGlossaryTerm> importGlossaryData(@Param("fileDetail") File fileDetail, @Param("inputStream") File inputStream);
  /**
   * Partially update the glossary.
   * Partially update the glossary
   * @param glossaryGuid unique identifier for glossary term (required)
   * @param body Map containing keys as attribute names and values as corresponding attribute values (optional)
   * @return JsonAtlasGlossary
   */
  @RequestLine("PUT /v2/glossary/{glossaryGuid}/partial")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasGlossary partialUpdateGlossary(@Param("glossaryGuid") String glossaryGuid, Map<String, String> body);
  /**
   * Partially update the glossary category.
   * Partially update the glossary category
   * @param categoryGuid unique identifier for glossary term (required)
   * @param body Map containing keys as attribute names and values as corresponding attribute values (optional)
   * @return JsonAtlasGlossaryCategory
   */
  @RequestLine("PUT /v2/glossary/category/{categoryGuid}/partial")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasGlossaryCategory partialUpdateGlossaryCategory(@Param("categoryGuid") String categoryGuid, Map<String, String> body);
  /**
   * Partially update the glossary term.
   * Partially update the glossary term
   * @param termGuid unique identifier for glossary term (required)
   * @param body Map containing keys as attribute names and values as corresponding attribute values (optional)
   * @return JsonAtlasGlossaryTerm
   */
  @RequestLine("PUT /v2/glossary/term/{termGuid}/partial")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasGlossaryTerm partialUpdateGlossaryTerm(@Param("termGuid") String termGuid, Map<String, String> body);
  /**
   * Get sample template for uploading/creating bulk AtlasGlossaryTerm.
   * Get sample template for uploading/creating bulk AtlasGlossaryTerm
   */
  @RequestLine("GET /v2/glossary/import/template")
  @Headers({
      "Accept: */*",
  })
  void produceTemplate2();
  /**
   * Remove the term assignment for the given list of entity headers.
   * Remove the term assignment for the given list of entity headers
   * @param termGuid Glossary term GUID (required)
   * @param body List of related entity IDs from which the term has to be dissociated (optional)
   */
  @RequestLine("DELETE /v2/glossary/terms/{termGuid}/assignedEntities")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: */*",
  })
  void removeTermAssignmentFromEntities(@Param("termGuid") String termGuid, List<JsonAtlasRelatedObjectId> body);
  /**
   * Update the given glossary.
   * Update the given glossary
   * @param glossaryGuid unique identifier for glossary (required)
   * @param body Updated glossary definition (optional)
   * @return JsonAtlasGlossary
   */
  @RequestLine("PUT /v2/glossary/{glossaryGuid}")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasGlossary updateGlossary(@Param("glossaryGuid") String glossaryGuid, JsonAtlasGlossary body);
  /**
   * Update the given glossary category.
   * Update the given glossary category
   * @param categoryGuid unique identifier for glossary category (required)
   * @param body updated glossary category (optional)
   * @return JsonAtlasGlossaryCategory
   */
  @RequestLine("PUT /v2/glossary/category/{categoryGuid}")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasGlossaryCategory updateGlossaryCategory(@Param("categoryGuid") String categoryGuid, JsonAtlasGlossaryCategory body);
  /**
   * Update the given glossary term.
   * Update the given glossary term
   * @param termGuid unique identifier for glossary term (required)
   * @param body updated glossary term (optional)
   * @return JsonAtlasGlossaryTerm
   */
  @RequestLine("PUT /v2/glossary/term/{termGuid}")
  @Headers({
      "Content-Type: application/json;charset=UTF-8",
      "Accept: application/json",
  })
  JsonAtlasGlossaryTerm updateGlossaryTerm(@Param("termGuid") String termGuid, JsonAtlasGlossaryTerm body);
}
