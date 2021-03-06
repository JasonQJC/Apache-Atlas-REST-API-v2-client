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
 * JsonTimeZone
 */


public class JsonTimeZone {
  @JsonProperty("DSTSavings")
  private Integer dsTSavings = null;

  @JsonProperty("ID")
  private String ID = null;

  @JsonProperty("availableIDs")
  private List<String> availableIDs = null;

  @JsonProperty("default")
  private JsonTimeZone _default = null;

  @JsonProperty("displayName")
  private String displayName = null;

  @JsonProperty("rawOffset")
  private Integer rawOffset = null;

  public JsonTimeZone dsTSavings(Integer dsTSavings) {
    this.dsTSavings = dsTSavings;
    return this;
  }

   /**
   * Get dsTSavings
   * @return dsTSavings
  **/
  @Schema(description = "")
  public Integer getDsTSavings() {
    return dsTSavings;
  }

  public void setDsTSavings(Integer dsTSavings) {
    this.dsTSavings = dsTSavings;
  }

  public JsonTimeZone ID(String ID) {
    this.ID = ID;
    return this;
  }

   /**
   * Get ID
   * @return ID
  **/
  @Schema(description = "")
  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public JsonTimeZone availableIDs(List<String> availableIDs) {
    this.availableIDs = availableIDs;
    return this;
  }

  public JsonTimeZone addAvailableIDsItem(String availableIDsItem) {
    if (this.availableIDs == null) {
      this.availableIDs = new ArrayList<String>();
    }
    this.availableIDs.add(availableIDsItem);
    return this;
  }

   /**
   * Get availableIDs
   * @return availableIDs
  **/
  @Schema(description = "")
  public List<String> getAvailableIDs() {
    return availableIDs;
  }

  public void setAvailableIDs(List<String> availableIDs) {
    this.availableIDs = availableIDs;
  }

  public JsonTimeZone _default(JsonTimeZone _default) {
    this._default = _default;
    return this;
  }

   /**
   * Get _default
   * @return _default
  **/
  @Schema(description = "")
  public JsonTimeZone getDefault() {
    return _default;
  }

  public void setDefault(JsonTimeZone _default) {
    this._default = _default;
  }

  public JsonTimeZone displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @Schema(description = "")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public JsonTimeZone rawOffset(Integer rawOffset) {
    this.rawOffset = rawOffset;
    return this;
  }

   /**
   * Get rawOffset
   * @return rawOffset
  **/
  @Schema(description = "")
  public Integer getRawOffset() {
    return rawOffset;
  }

  public void setRawOffset(Integer rawOffset) {
    this.rawOffset = rawOffset;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonTimeZone jsonTimeZone = (JsonTimeZone) o;
    return Objects.equals(this.dsTSavings, jsonTimeZone.dsTSavings) &&
        Objects.equals(this.ID, jsonTimeZone.ID) &&
        Objects.equals(this.availableIDs, jsonTimeZone.availableIDs) &&
        Objects.equals(this._default, jsonTimeZone._default) &&
        Objects.equals(this.displayName, jsonTimeZone.displayName) &&
        Objects.equals(this.rawOffset, jsonTimeZone.rawOffset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dsTSavings, ID, availableIDs, _default, displayName, rawOffset);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonTimeZone {\n");
    
    sb.append("    dsTSavings: ").append(toIndentedString(dsTSavings)).append("\n");
    sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
    sb.append("    availableIDs: ").append(toIndentedString(availableIDs)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    rawOffset: ").append(toIndentedString(rawOffset)).append("\n");
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
