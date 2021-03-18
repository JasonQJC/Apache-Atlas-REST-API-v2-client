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
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
/**
 * JsonQuickSearchParameters
 */


public class JsonQuickSearchParameters {
  @JsonProperty("attributes")
  private List<String> attributes = null;

  @JsonProperty("entityFilters")
  private JsonFilterCriteria entityFilters = null;

  @JsonProperty("excludeDeletedEntities")
  private Boolean excludeDeletedEntities = null;

  @JsonProperty("includeSubTypes")
  private Boolean includeSubTypes = null;

  @JsonProperty("limit")
  private Integer limit = null;

  @JsonProperty("offset")
  private Integer offset = null;

  @JsonProperty("query")
  private String query = null;

  @JsonProperty("typeName")
  private String typeName = null;

  public JsonQuickSearchParameters attributes(List<String> attributes) {
    this.attributes = attributes;
    return this;
  }

  public JsonQuickSearchParameters addAttributesItem(String attributesItem) {
    if (this.attributes == null) {
      this.attributes = new ArrayList<String>();
    }
    this.attributes.add(attributesItem);
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @Schema(description = "")
  public List<String> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<String> attributes) {
    this.attributes = attributes;
  }

  public JsonQuickSearchParameters entityFilters(JsonFilterCriteria entityFilters) {
    this.entityFilters = entityFilters;
    return this;
  }

   /**
   * Get entityFilters
   * @return entityFilters
  **/
  @Schema(description = "")
  public JsonFilterCriteria getEntityFilters() {
    return entityFilters;
  }

  public void setEntityFilters(JsonFilterCriteria entityFilters) {
    this.entityFilters = entityFilters;
  }

  public JsonQuickSearchParameters excludeDeletedEntities(Boolean excludeDeletedEntities) {
    this.excludeDeletedEntities = excludeDeletedEntities;
    return this;
  }

   /**
   * Get excludeDeletedEntities
   * @return excludeDeletedEntities
  **/
  @Schema(description = "")
  public Boolean isExcludeDeletedEntities() {
    return excludeDeletedEntities;
  }

  public void setExcludeDeletedEntities(Boolean excludeDeletedEntities) {
    this.excludeDeletedEntities = excludeDeletedEntities;
  }

  public JsonQuickSearchParameters includeSubTypes(Boolean includeSubTypes) {
    this.includeSubTypes = includeSubTypes;
    return this;
  }

   /**
   * Get includeSubTypes
   * @return includeSubTypes
  **/
  @Schema(description = "")
  public Boolean isIncludeSubTypes() {
    return includeSubTypes;
  }

  public void setIncludeSubTypes(Boolean includeSubTypes) {
    this.includeSubTypes = includeSubTypes;
  }

  public JsonQuickSearchParameters limit(Integer limit) {
    this.limit = limit;
    return this;
  }

   /**
   * Get limit
   * @return limit
  **/
  @Schema(description = "")
  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public JsonQuickSearchParameters offset(Integer offset) {
    this.offset = offset;
    return this;
  }

   /**
   * Get offset
   * @return offset
  **/
  @Schema(description = "")
  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public JsonQuickSearchParameters query(String query) {
    this.query = query;
    return this;
  }

   /**
   * Get query
   * @return query
  **/
  @Schema(description = "")
  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public JsonQuickSearchParameters typeName(String typeName) {
    this.typeName = typeName;
    return this;
  }

   /**
   * Get typeName
   * @return typeName
  **/
  @Schema(description = "")
  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonQuickSearchParameters jsonQuickSearchParameters = (JsonQuickSearchParameters) o;
    return Objects.equals(this.attributes, jsonQuickSearchParameters.attributes) &&
        Objects.equals(this.entityFilters, jsonQuickSearchParameters.entityFilters) &&
        Objects.equals(this.excludeDeletedEntities, jsonQuickSearchParameters.excludeDeletedEntities) &&
        Objects.equals(this.includeSubTypes, jsonQuickSearchParameters.includeSubTypes) &&
        Objects.equals(this.limit, jsonQuickSearchParameters.limit) &&
        Objects.equals(this.offset, jsonQuickSearchParameters.offset) &&
        Objects.equals(this.query, jsonQuickSearchParameters.query) &&
        Objects.equals(this.typeName, jsonQuickSearchParameters.typeName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributes, entityFilters, excludeDeletedEntities, includeSubTypes, limit, offset, query, typeName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonQuickSearchParameters {\n");
    
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    entityFilters: ").append(toIndentedString(entityFilters)).append("\n");
    sb.append("    excludeDeletedEntities: ").append(toIndentedString(excludeDeletedEntities)).append("\n");
    sb.append("    includeSubTypes: ").append(toIndentedString(includeSubTypes)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    typeName: ").append(toIndentedString(typeName)).append("\n");
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
