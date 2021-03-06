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
 * JsonAtlasGlossaryCategory
 */


public class JsonAtlasGlossaryCategory extends JsonAtlasGlossaryBaseObject {
  @JsonProperty("anchor")
  private JsonAtlasGlossaryHeader anchor = null;

  @JsonProperty("childrenCategories")
  private List<JsonAtlasRelatedCategoryHeader> childrenCategories = null;

  @JsonProperty("parentCategory")
  private JsonAtlasRelatedCategoryHeader parentCategory = null;

  @JsonProperty("terms")
  private List<JsonAtlasRelatedTermHeader> terms = null;

  public JsonAtlasGlossaryCategory anchor(JsonAtlasGlossaryHeader anchor) {
    this.anchor = anchor;
    return this;
  }

   /**
   * Get anchor
   * @return anchor
  **/
  @Schema(description = "")
  public JsonAtlasGlossaryHeader getAnchor() {
    return anchor;
  }

  public void setAnchor(JsonAtlasGlossaryHeader anchor) {
    this.anchor = anchor;
  }

  public JsonAtlasGlossaryCategory childrenCategories(List<JsonAtlasRelatedCategoryHeader> childrenCategories) {
    this.childrenCategories = childrenCategories;
    return this;
  }

  public JsonAtlasGlossaryCategory addChildrenCategoriesItem(JsonAtlasRelatedCategoryHeader childrenCategoriesItem) {
    if (this.childrenCategories == null) {
      this.childrenCategories = new ArrayList<JsonAtlasRelatedCategoryHeader>();
    }
    this.childrenCategories.add(childrenCategoriesItem);
    return this;
  }

   /**
   * Get childrenCategories
   * @return childrenCategories
  **/
  @Schema(description = "")
  public List<JsonAtlasRelatedCategoryHeader> getChildrenCategories() {
    return childrenCategories;
  }

  public void setChildrenCategories(List<JsonAtlasRelatedCategoryHeader> childrenCategories) {
    this.childrenCategories = childrenCategories;
  }

  public JsonAtlasGlossaryCategory parentCategory(JsonAtlasRelatedCategoryHeader parentCategory) {
    this.parentCategory = parentCategory;
    return this;
  }

   /**
   * Get parentCategory
   * @return parentCategory
  **/
  @Schema(description = "")
  public JsonAtlasRelatedCategoryHeader getParentCategory() {
    return parentCategory;
  }

  public void setParentCategory(JsonAtlasRelatedCategoryHeader parentCategory) {
    this.parentCategory = parentCategory;
  }

  public JsonAtlasGlossaryCategory terms(List<JsonAtlasRelatedTermHeader> terms) {
    this.terms = terms;
    return this;
  }

  public JsonAtlasGlossaryCategory addTermsItem(JsonAtlasRelatedTermHeader termsItem) {
    if (this.terms == null) {
      this.terms = new ArrayList<JsonAtlasRelatedTermHeader>();
    }
    this.terms.add(termsItem);
    return this;
  }

   /**
   * Get terms
   * @return terms
  **/
  @Schema(description = "")
  public List<JsonAtlasRelatedTermHeader> getTerms() {
    return terms;
  }

  public void setTerms(List<JsonAtlasRelatedTermHeader> terms) {
    this.terms = terms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonAtlasGlossaryCategory jsonAtlasGlossaryCategory = (JsonAtlasGlossaryCategory) o;
    return Objects.equals(this.anchor, jsonAtlasGlossaryCategory.anchor) &&
        Objects.equals(this.childrenCategories, jsonAtlasGlossaryCategory.childrenCategories) &&
        Objects.equals(this.parentCategory, jsonAtlasGlossaryCategory.parentCategory) &&
        Objects.equals(this.terms, jsonAtlasGlossaryCategory.terms) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(anchor, childrenCategories, parentCategory, terms, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonAtlasGlossaryCategory {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    anchor: ").append(toIndentedString(anchor)).append("\n");
    sb.append("    childrenCategories: ").append(toIndentedString(childrenCategories)).append("\n");
    sb.append("    parentCategory: ").append(toIndentedString(parentCategory)).append("\n");
    sb.append("    terms: ").append(toIndentedString(terms)).append("\n");
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
