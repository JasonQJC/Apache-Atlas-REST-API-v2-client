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
 * JsonAtlasTypeDefHeader
 */


public class JsonAtlasTypeDefHeader {
  @JsonProperty("category")
  private JsonTypeCategory category = null;

  @JsonProperty("guid")
  private String guid = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("serviceType")
  private String serviceType = null;

  public JsonAtlasTypeDefHeader category(JsonTypeCategory category) {
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @Schema(description = "")
  public JsonTypeCategory getCategory() {
    return category;
  }

  public void setCategory(JsonTypeCategory category) {
    this.category = category;
  }

  public JsonAtlasTypeDefHeader guid(String guid) {
    this.guid = guid;
    return this;
  }

   /**
   * Get guid
   * @return guid
  **/
  @Schema(description = "")
  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public JsonAtlasTypeDefHeader name(String name) {
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

  public JsonAtlasTypeDefHeader serviceType(String serviceType) {
    this.serviceType = serviceType;
    return this;
  }

   /**
   * Get serviceType
   * @return serviceType
  **/
  @Schema(description = "")
  public String getServiceType() {
    return serviceType;
  }

  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonAtlasTypeDefHeader jsonAtlasTypeDefHeader = (JsonAtlasTypeDefHeader) o;
    return Objects.equals(this.category, jsonAtlasTypeDefHeader.category) &&
        Objects.equals(this.guid, jsonAtlasTypeDefHeader.guid) &&
        Objects.equals(this.name, jsonAtlasTypeDefHeader.name) &&
        Objects.equals(this.serviceType, jsonAtlasTypeDefHeader.serviceType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, guid, name, serviceType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonAtlasTypeDefHeader {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    serviceType: ").append(toIndentedString(serviceType)).append("\n");
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