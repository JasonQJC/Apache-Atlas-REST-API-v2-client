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

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
/**
 * class that captures details of an enum-element.
 */
@Schema(description = "class that captures details of an enum-element.")

public class JsonAtlasEnumElementDef {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("ordinal")
  private BigDecimal ordinal = null;

  @JsonProperty("value")
  private String value = null;

  public JsonAtlasEnumElementDef description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @Schema(description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public JsonAtlasEnumElementDef ordinal(BigDecimal ordinal) {
    this.ordinal = ordinal;
    return this;
  }

   /**
   * Get ordinal
   * @return ordinal
  **/
  @Schema(description = "")
  public BigDecimal getOrdinal() {
    return ordinal;
  }

  public void setOrdinal(BigDecimal ordinal) {
    this.ordinal = ordinal;
  }

  public JsonAtlasEnumElementDef value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @Schema(description = "")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonAtlasEnumElementDef jsonAtlasEnumElementDef = (JsonAtlasEnumElementDef) o;
    return Objects.equals(this.description, jsonAtlasEnumElementDef.description) &&
        Objects.equals(this.ordinal, jsonAtlasEnumElementDef.ordinal) &&
        Objects.equals(this.value, jsonAtlasEnumElementDef.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, ordinal, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonAtlasEnumElementDef {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    ordinal: ").append(toIndentedString(ordinal)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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