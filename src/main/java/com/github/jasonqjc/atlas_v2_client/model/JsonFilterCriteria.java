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
 * JsonFilterCriteria
 */


public class JsonFilterCriteria {
  @JsonProperty("attributeName")
  private String attributeName = null;

  @JsonProperty("attributeValue")
  private String attributeValue = null;

  @JsonProperty("condition")
  private JsonCondition condition = null;

  @JsonProperty("criterion")
  private List<JsonFilterCriteria> criterion = null;

  @JsonProperty("operator")
  private JsonOperator operator = null;

  public JsonFilterCriteria attributeName(String attributeName) {
    this.attributeName = attributeName;
    return this;
  }

   /**
   * Get attributeName
   * @return attributeName
  **/
  @Schema(description = "")
  public String getAttributeName() {
    return attributeName;
  }

  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }

  public JsonFilterCriteria attributeValue(String attributeValue) {
    this.attributeValue = attributeValue;
    return this;
  }

   /**
   * Get attributeValue
   * @return attributeValue
  **/
  @Schema(description = "")
  public String getAttributeValue() {
    return attributeValue;
  }

  public void setAttributeValue(String attributeValue) {
    this.attributeValue = attributeValue;
  }

  public JsonFilterCriteria condition(JsonCondition condition) {
    this.condition = condition;
    return this;
  }

   /**
   * Get condition
   * @return condition
  **/
  @Schema(description = "")
  public JsonCondition getCondition() {
    return condition;
  }

  public void setCondition(JsonCondition condition) {
    this.condition = condition;
  }

  public JsonFilterCriteria criterion(List<JsonFilterCriteria> criterion) {
    this.criterion = criterion;
    return this;
  }

  public JsonFilterCriteria addCriterionItem(JsonFilterCriteria criterionItem) {
    if (this.criterion == null) {
      this.criterion = new ArrayList<JsonFilterCriteria>();
    }
    this.criterion.add(criterionItem);
    return this;
  }

   /**
   * Get criterion
   * @return criterion
  **/
  @Schema(description = "")
  public List<JsonFilterCriteria> getCriterion() {
    return criterion;
  }

  public void setCriterion(List<JsonFilterCriteria> criterion) {
    this.criterion = criterion;
  }

  public JsonFilterCriteria operator(JsonOperator operator) {
    this.operator = operator;
    return this;
  }

   /**
   * Get operator
   * @return operator
  **/
  @Schema(description = "")
  public JsonOperator getOperator() {
    return operator;
  }

  public void setOperator(JsonOperator operator) {
    this.operator = operator;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonFilterCriteria jsonFilterCriteria = (JsonFilterCriteria) o;
    return Objects.equals(this.attributeName, jsonFilterCriteria.attributeName) &&
        Objects.equals(this.attributeValue, jsonFilterCriteria.attributeValue) &&
        Objects.equals(this.condition, jsonFilterCriteria.condition) &&
        Objects.equals(this.criterion, jsonFilterCriteria.criterion) &&
        Objects.equals(this.operator, jsonFilterCriteria.operator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeName, attributeValue, condition, criterion, operator);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonFilterCriteria {\n");
    
    sb.append("    attributeName: ").append(toIndentedString(attributeName)).append("\n");
    sb.append("    attributeValue: ").append(toIndentedString(attributeValue)).append("\n");
    sb.append("    condition: ").append(toIndentedString(condition)).append("\n");
    sb.append("    criterion: ").append(toIndentedString(criterion)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
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
