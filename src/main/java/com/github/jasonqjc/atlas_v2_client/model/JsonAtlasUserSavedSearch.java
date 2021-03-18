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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
/**
 * JsonAtlasUserSavedSearch
 */


public class JsonAtlasUserSavedSearch extends JsonAtlasBaseModelObject {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("ownerName")
  private String ownerName = null;

  @JsonProperty("searchParameters")
  private JsonSearchParameters searchParameters = null;

  @JsonProperty("searchType")
  private JsonSavedSearchType searchType = null;

  @JsonProperty("uiParameters")
  private String uiParameters = null;

  public JsonAtlasUserSavedSearch name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public JsonAtlasUserSavedSearch ownerName(String ownerName) {
    this.ownerName = ownerName;
    return this;
  }

   /**
   * Get ownerName
   * @return ownerName
  **/
  @Schema(description = "")
  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public JsonAtlasUserSavedSearch searchParameters(JsonSearchParameters searchParameters) {
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

  public JsonAtlasUserSavedSearch searchType(JsonSavedSearchType searchType) {
    this.searchType = searchType;
    return this;
  }

   /**
   * Get searchType
   * @return searchType
  **/
  @Schema(description = "")
  public JsonSavedSearchType getSearchType() {
    return searchType;
  }

  public void setSearchType(JsonSavedSearchType searchType) {
    this.searchType = searchType;
  }

  public JsonAtlasUserSavedSearch uiParameters(String uiParameters) {
    this.uiParameters = uiParameters;
    return this;
  }

   /**
   * Get uiParameters
   * @return uiParameters
  **/
  @Schema(description = "")
  public String getUiParameters() {
    return uiParameters;
  }

  public void setUiParameters(String uiParameters) {
    this.uiParameters = uiParameters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonAtlasUserSavedSearch jsonAtlasUserSavedSearch = (JsonAtlasUserSavedSearch) o;
    return Objects.equals(this.name, jsonAtlasUserSavedSearch.name) &&
        Objects.equals(this.ownerName, jsonAtlasUserSavedSearch.ownerName) &&
        Objects.equals(this.searchParameters, jsonAtlasUserSavedSearch.searchParameters) &&
        Objects.equals(this.searchType, jsonAtlasUserSavedSearch.searchType) &&
        Objects.equals(this.uiParameters, jsonAtlasUserSavedSearch.uiParameters) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, ownerName, searchParameters, searchType, uiParameters, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonAtlasUserSavedSearch {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ownerName: ").append(toIndentedString(ownerName)).append("\n");
    sb.append("    searchParameters: ").append(toIndentedString(searchParameters)).append("\n");
    sb.append("    searchType: ").append(toIndentedString(searchType)).append("\n");
    sb.append("    uiParameters: ").append(toIndentedString(uiParameters)).append("\n");
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
