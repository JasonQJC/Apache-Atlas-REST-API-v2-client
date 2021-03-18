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
 * JsonAtlasSuggestionsResult
 */


public class JsonAtlasSuggestionsResult {
  @JsonProperty("fieldName")
  private String fieldName = null;

  @JsonProperty("prefixString")
  private String prefixString = null;

  @JsonProperty("suggestions")
  private List<String> suggestions = null;

  public JsonAtlasSuggestionsResult fieldName(String fieldName) {
    this.fieldName = fieldName;
    return this;
  }

   /**
   * Get fieldName
   * @return fieldName
  **/
  @Schema(description = "")
  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public JsonAtlasSuggestionsResult prefixString(String prefixString) {
    this.prefixString = prefixString;
    return this;
  }

   /**
   * Get prefixString
   * @return prefixString
  **/
  @Schema(description = "")
  public String getPrefixString() {
    return prefixString;
  }

  public void setPrefixString(String prefixString) {
    this.prefixString = prefixString;
  }

  public JsonAtlasSuggestionsResult suggestions(List<String> suggestions) {
    this.suggestions = suggestions;
    return this;
  }

  public JsonAtlasSuggestionsResult addSuggestionsItem(String suggestionsItem) {
    if (this.suggestions == null) {
      this.suggestions = new ArrayList<String>();
    }
    this.suggestions.add(suggestionsItem);
    return this;
  }

   /**
   * Get suggestions
   * @return suggestions
  **/
  @Schema(description = "")
  public List<String> getSuggestions() {
    return suggestions;
  }

  public void setSuggestions(List<String> suggestions) {
    this.suggestions = suggestions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonAtlasSuggestionsResult jsonAtlasSuggestionsResult = (JsonAtlasSuggestionsResult) o;
    return Objects.equals(this.fieldName, jsonAtlasSuggestionsResult.fieldName) &&
        Objects.equals(this.prefixString, jsonAtlasSuggestionsResult.prefixString) &&
        Objects.equals(this.suggestions, jsonAtlasSuggestionsResult.suggestions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldName, prefixString, suggestions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonAtlasSuggestionsResult {\n");
    
    sb.append("    fieldName: ").append(toIndentedString(fieldName)).append("\n");
    sb.append("    prefixString: ").append(toIndentedString(prefixString)).append("\n");
    sb.append("    suggestions: ").append(toIndentedString(suggestions)).append("\n");
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