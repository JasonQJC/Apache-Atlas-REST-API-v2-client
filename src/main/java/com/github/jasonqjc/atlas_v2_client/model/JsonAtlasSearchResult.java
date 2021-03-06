/*
 * Atlas REST API
 * Atlas exposes a variety of REST endpoints to work with types, entities, lineage and data discovery.
 *
 * OpenAPI spec version: 3.0.0-SNAPSHOT
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.github.jasonqjc.atlas_v2_client.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
/**
 * JsonAtlasSearchResult
 */


public class JsonAtlasSearchResult {
  @JsonProperty("approximateCount")
  private Long approximateCount = null;

  @JsonProperty("attributes")
  private JsonAttributeSearchResult attributes = null;

  @JsonProperty("classification")
  private String classification = null;

  @JsonProperty("entities")
  private List<JsonAtlasEntityHeader> entities = null;

  @JsonProperty("fullTextResult")
  private List<JsonAtlasFullTextResult> fullTextResult = null;

  @JsonProperty("queryText")
  private String queryText = null;

  @JsonProperty("queryType")
  private JsonAtlasQueryType queryType = null;

  @JsonProperty("referredEntities")
  private Map<String, JsonAtlasEntityHeader> referredEntities = null;

  @JsonProperty("searchParameters")
  private JsonSearchParameters searchParameters = null;

  @JsonProperty("type")
  private String type = null;

  public JsonAtlasSearchResult approximateCount(Long approximateCount) {
    this.approximateCount = approximateCount;
    return this;
  }

   /**
   * Get approximateCount
   * @return approximateCount
  **/
  @Schema(description = "")
  public Long getApproximateCount() {
    return approximateCount;
  }

  public void setApproximateCount(Long approximateCount) {
    this.approximateCount = approximateCount;
  }

  public JsonAtlasSearchResult attributes(JsonAttributeSearchResult attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @Schema(description = "")
  public JsonAttributeSearchResult getAttributes() {
    return attributes;
  }

  public void setAttributes(JsonAttributeSearchResult attributes) {
    this.attributes = attributes;
  }

  public JsonAtlasSearchResult classification(String classification) {
    this.classification = classification;
    return this;
  }

   /**
   * Get classification
   * @return classification
  **/
  @Schema(description = "")
  public String getClassification() {
    return classification;
  }

  public void setClassification(String classification) {
    this.classification = classification;
  }

  public JsonAtlasSearchResult entities(List<JsonAtlasEntityHeader> entities) {
    this.entities = entities;
    return this;
  }

  public JsonAtlasSearchResult addEntitiesItem(JsonAtlasEntityHeader entitiesItem) {
    if (this.entities == null) {
      this.entities = new ArrayList<JsonAtlasEntityHeader>();
    }
    this.entities.add(entitiesItem);
    return this;
  }

   /**
   * Get entities
   * @return entities
  **/
  @Schema(description = "")
  public List<JsonAtlasEntityHeader> getEntities() {
    return entities;
  }

  public void setEntities(List<JsonAtlasEntityHeader> entities) {
    this.entities = entities;
  }

  public JsonAtlasSearchResult fullTextResult(List<JsonAtlasFullTextResult> fullTextResult) {
    this.fullTextResult = fullTextResult;
    return this;
  }

  public JsonAtlasSearchResult addFullTextResultItem(JsonAtlasFullTextResult fullTextResultItem) {
    if (this.fullTextResult == null) {
      this.fullTextResult = new ArrayList<JsonAtlasFullTextResult>();
    }
    this.fullTextResult.add(fullTextResultItem);
    return this;
  }

   /**
   * Get fullTextResult
   * @return fullTextResult
  **/
  @Schema(description = "")
  public List<JsonAtlasFullTextResult> getFullTextResult() {
    return fullTextResult;
  }

  public void setFullTextResult(List<JsonAtlasFullTextResult> fullTextResult) {
    this.fullTextResult = fullTextResult;
  }

  public JsonAtlasSearchResult queryText(String queryText) {
    this.queryText = queryText;
    return this;
  }

   /**
   * Get queryText
   * @return queryText
  **/
  @Schema(description = "")
  public String getQueryText() {
    return queryText;
  }

  public void setQueryText(String queryText) {
    this.queryText = queryText;
  }

  public JsonAtlasSearchResult queryType(JsonAtlasQueryType queryType) {
    this.queryType = queryType;
    return this;
  }

   /**
   * Get queryType
   * @return queryType
  **/
  @Schema(description = "")
  public JsonAtlasQueryType getQueryType() {
    return queryType;
  }

  public void setQueryType(JsonAtlasQueryType queryType) {
    this.queryType = queryType;
  }

  public JsonAtlasSearchResult referredEntities(Map<String, JsonAtlasEntityHeader> referredEntities) {
    this.referredEntities = referredEntities;
    return this;
  }

  public JsonAtlasSearchResult putReferredEntitiesItem(String key, JsonAtlasEntityHeader referredEntitiesItem) {
    if (this.referredEntities == null) {
      this.referredEntities = new HashMap<String, JsonAtlasEntityHeader>();
    }
    this.referredEntities.put(key, referredEntitiesItem);
    return this;
  }

   /**
   * Get referredEntities
   * @return referredEntities
  **/
  @Schema(description = "")
  public Map<String, JsonAtlasEntityHeader> getReferredEntities() {
    return referredEntities;
  }

  public void setReferredEntities(Map<String, JsonAtlasEntityHeader> referredEntities) {
    this.referredEntities = referredEntities;
  }

  public JsonAtlasSearchResult searchParameters(JsonSearchParameters searchParameters) {
    this.searchParameters = searchParameters;
    return this;
  }

   /**
   * Get searchParameters
   * @return searchParameters
  **/
  @Schema(description = "")
  public JsonSearchParameters getSearchParameters() {
    return searchParameters;
  }

  public void setSearchParameters(JsonSearchParameters searchParameters) {
    this.searchParameters = searchParameters;
  }

  public JsonAtlasSearchResult type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @Schema(description = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonAtlasSearchResult jsonAtlasSearchResult = (JsonAtlasSearchResult) o;
    return Objects.equals(this.approximateCount, jsonAtlasSearchResult.approximateCount) &&
        Objects.equals(this.attributes, jsonAtlasSearchResult.attributes) &&
        Objects.equals(this.classification, jsonAtlasSearchResult.classification) &&
        Objects.equals(this.entities, jsonAtlasSearchResult.entities) &&
        Objects.equals(this.fullTextResult, jsonAtlasSearchResult.fullTextResult) &&
        Objects.equals(this.queryText, jsonAtlasSearchResult.queryText) &&
        Objects.equals(this.queryType, jsonAtlasSearchResult.queryType) &&
        Objects.equals(this.referredEntities, jsonAtlasSearchResult.referredEntities) &&
        Objects.equals(this.searchParameters, jsonAtlasSearchResult.searchParameters) &&
        Objects.equals(this.type, jsonAtlasSearchResult.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(approximateCount, attributes, classification, entities, fullTextResult, queryText, queryType, referredEntities, searchParameters, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonAtlasSearchResult {\n");
    
    sb.append("    approximateCount: ").append(toIndentedString(approximateCount)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    classification: ").append(toIndentedString(classification)).append("\n");
    sb.append("    entities: ").append(toIndentedString(entities)).append("\n");
    sb.append("    fullTextResult: ").append(toIndentedString(fullTextResult)).append("\n");
    sb.append("    queryText: ").append(toIndentedString(queryText)).append("\n");
    sb.append("    queryType: ").append(toIndentedString(queryType)).append("\n");
    sb.append("    referredEntities: ").append(toIndentedString(referredEntities)).append("\n");
    sb.append("    searchParameters: ").append(toIndentedString(searchParameters)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
