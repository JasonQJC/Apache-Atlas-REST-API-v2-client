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
 * JsonImportInfo
 */


public class JsonImportInfo {
  @JsonProperty("childObjectName")
  private String childObjectName = null;

  @JsonProperty("importStatus")
  private JsonImportStatus importStatus = null;

  @JsonProperty("parentObjectName")
  private String parentObjectName = null;

  @JsonProperty("remarks")
  private String remarks = null;

  public JsonImportInfo childObjectName(String childObjectName) {
    this.childObjectName = childObjectName;
    return this;
  }

   /**
   * Get childObjectName
   * @return childObjectName
  **/
  @Schema(description = "")
  public String getChildObjectName() {
    return childObjectName;
  }

  public void setChildObjectName(String childObjectName) {
    this.childObjectName = childObjectName;
  }

  public JsonImportInfo importStatus(JsonImportStatus importStatus) {
    this.importStatus = importStatus;
    return this;
  }

   /**
   * Get importStatus
   * @return importStatus
  **/
  @Schema(description = "")
  public JsonImportStatus getImportStatus() {
    return importStatus;
  }

  public void setImportStatus(JsonImportStatus importStatus) {
    this.importStatus = importStatus;
  }

  public JsonImportInfo parentObjectName(String parentObjectName) {
    this.parentObjectName = parentObjectName;
    return this;
  }

   /**
   * Get parentObjectName
   * @return parentObjectName
  **/
  @Schema(description = "")
  public String getParentObjectName() {
    return parentObjectName;
  }

  public void setParentObjectName(String parentObjectName) {
    this.parentObjectName = parentObjectName;
  }

  public JsonImportInfo remarks(String remarks) {
    this.remarks = remarks;
    return this;
  }

   /**
   * Get remarks
   * @return remarks
  **/
  @Schema(description = "")
  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonImportInfo jsonImportInfo = (JsonImportInfo) o;
    return Objects.equals(this.childObjectName, jsonImportInfo.childObjectName) &&
        Objects.equals(this.importStatus, jsonImportInfo.importStatus) &&
        Objects.equals(this.parentObjectName, jsonImportInfo.parentObjectName) &&
        Objects.equals(this.remarks, jsonImportInfo.remarks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(childObjectName, importStatus, parentObjectName, remarks);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonImportInfo {\n");
    
    sb.append("    childObjectName: ").append(toIndentedString(childObjectName)).append("\n");
    sb.append("    importStatus: ").append(toIndentedString(importStatus)).append("\n");
    sb.append("    parentObjectName: ").append(toIndentedString(parentObjectName)).append("\n");
    sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
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