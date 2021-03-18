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
 * AtlasRelationshipDef is a TypeDef that defines a relationship. <p> As with other typeDefs the AtlasRelationshipDef has a name. Once created the RelationshipDef has a guid. The name and the guid are the 2 ways that the RelationshipDef is identified. <p> RelationshipDefs have 2 ends, each of which specify cardinality, an EntityDef type name and name and optionally whether the end is a container. <p> RelationshipDefs can have AttributeDefs - though only primitive types are allowed. <br> RelationshipDefs have a relationshipCategory specifying the UML type of relationship required <br> RelationshipDefs also have a PropogateTag - indicating which way tags could flow over the relationships. <p> The way EntityDefs and RelationshipDefs are intended to be used is that EntityDefs will define AttributeDefs these AttributeDefs will not specify an EntityDef type name as their types. <p> RelationshipDefs introduce new attributes to the entity instances. For example <p> EntityDef A might have attributes attr1,attr2,attr3 <br> EntityDef B might have attributes attr4,attr5,attr6 <br> RelationshipDef AtoB might define 2 ends <br>  <pre>    end1:  type A, name attr7    end2:  type B, name attr8  </pre>  <p> When an instance of EntityDef A is created, it will have attributes attr1,attr2,attr3,attr7 <br> When an instance of EntityDef B is created, it will have attributes attr4,attr5,attr6,attr8 <p> In this way relationshipDefs can be authored separately from entityDefs and can inject relationship attributes into the entity instances
 * <br/><br/>
 * AtlasRelationshipDef是定义关系的TypeDef。 <p>与其他typeDef一样，AtlasRelationshipDef也有一个名称。创建后，RelationshipDef具有一个GUID。名称和GUID是识别RelationshipDef的2种方法。 <p> RelationshipDefs有2个端点，每个端点指定基数，一个EntityDef类型名称和名称，以及该端点是否为容器（可选）。 <p> RelationshipDefs可以具有AttributeDefs-尽管仅允许原始类型。 <br> RelationshipDefs具有一个RelationshipCategory，用于指定所需的UML关系类型。<br> RelationshipDefs还具有PropogateTag-指示标签可以在关系上流动的方式。 <p>打算使用EntityDefs和RelationshipDefs的方式是EntityDefs将定义AttributeDefs，这些AttributeDefs将不指定EntityDef类型名称作为其类型。 <p> RelationshipDefs向实体实例引入了新的属性。例如，<p> EntityDef A可能具有属性attr1，attr2，attr3 <br> <br> EntityDef B可能具有属性attr4，attr5，attr6 <br> RelationshipDef AtoB可能定义了2个端点<br> <pre> end1：类型A，名称为attr7 end2：类型B，名称为attr8 </ pre> <p>创建EntityDef A的实例时，它将具有属性attr1，attr2，attr3，attr7 <br>创建EntityDef B的实例时，它将具有属性attr4，attr5，attr6，attr8 <p>通过这种方式，可以与EntityDefs分开编写relationshipDef，并将关系属性注入到实体实例
 */
@Schema(description = "AtlasRelationshipDef is a TypeDef that defines a relationship. <p> As with other typeDefs the AtlasRelationshipDef has a name. Once created the RelationshipDef has a guid. The name and the guid are the 2 ways that the RelationshipDef is identified. <p> RelationshipDefs have 2 ends, each of which specify cardinality, an EntityDef type name and name and optionally whether the end is a container. <p> RelationshipDefs can have AttributeDefs - though only primitive types are allowed. <br> RelationshipDefs have a relationshipCategory specifying the UML type of relationship required <br> RelationshipDefs also have a PropogateTag - indicating which way tags could flow over the relationships. <p> The way EntityDefs and RelationshipDefs are intended to be used is that EntityDefs will define AttributeDefs these AttributeDefs will not specify an EntityDef type name as their types. <p> RelationshipDefs introduce new attributes to the entity instances. For example <p> EntityDef A might have attributes attr1,attr2,attr3 <br> EntityDef B might have attributes attr4,attr5,attr6 <br> RelationshipDef AtoB might define 2 ends <br>  <pre>    end1:  type A, name attr7    end2:  type B, name attr8  </pre>  <p> When an instance of EntityDef A is created, it will have attributes attr1,attr2,attr3,attr7 <br> When an instance of EntityDef B is created, it will have attributes attr4,attr5,attr6,attr8 <p> In this way relationshipDefs can be authored separately from entityDefs and can inject relationship attributes into the entity instances")

public class JsonAtlasRelationshipDef extends JsonAtlasStructDef {
  @JsonProperty("endDef1")
  private JsonAtlasRelationshipEndDef endDef1 = null;

  @JsonProperty("endDef2")
  private JsonAtlasRelationshipEndDef endDef2 = null;

  @JsonProperty("propagateTags")
  private JsonPropagateTags propagateTags = null;

  @JsonProperty("relationshipCategory")
  private JsonRelationshipCategory relationshipCategory = null;

  @JsonProperty("relationshipLabel")
  private String relationshipLabel = null;

  public JsonAtlasRelationshipDef endDef1(JsonAtlasRelationshipEndDef endDef1) {
    this.endDef1 = endDef1;
    return this;
  }

   /**
   * Get endDef1
   * @return endDef1
  **/
  @Schema(description = "")
  public JsonAtlasRelationshipEndDef getEndDef1() {
    return endDef1;
  }

  public void setEndDef1(JsonAtlasRelationshipEndDef endDef1) {
    this.endDef1 = endDef1;
  }

  public JsonAtlasRelationshipDef endDef2(JsonAtlasRelationshipEndDef endDef2) {
    this.endDef2 = endDef2;
    return this;
  }

   /**
   * Get endDef2
   * @return endDef2
  **/
  @Schema(description = "")
  public JsonAtlasRelationshipEndDef getEndDef2() {
    return endDef2;
  }

  public void setEndDef2(JsonAtlasRelationshipEndDef endDef2) {
    this.endDef2 = endDef2;
  }

  public JsonAtlasRelationshipDef propagateTags(JsonPropagateTags propagateTags) {
    this.propagateTags = propagateTags;
    return this;
  }

   /**
   * Get propagateTags
   * @return propagateTags
  **/
  @Schema(description = "")
  public JsonPropagateTags getPropagateTags() {
    return propagateTags;
  }

  public void setPropagateTags(JsonPropagateTags propagateTags) {
    this.propagateTags = propagateTags;
  }

  public JsonAtlasRelationshipDef relationshipCategory(JsonRelationshipCategory relationshipCategory) {
    this.relationshipCategory = relationshipCategory;
    return this;
  }

   /**
   * Get relationshipCategory
   * @return relationshipCategory
  **/
  @Schema(description = "")
  public JsonRelationshipCategory getRelationshipCategory() {
    return relationshipCategory;
  }

  public void setRelationshipCategory(JsonRelationshipCategory relationshipCategory) {
    this.relationshipCategory = relationshipCategory;
  }

  public JsonAtlasRelationshipDef relationshipLabel(String relationshipLabel) {
    this.relationshipLabel = relationshipLabel;
    return this;
  }

   /**
   * Get relationshipLabel
   * @return relationshipLabel
  **/
  @Schema(description = "")
  public String getRelationshipLabel() {
    return relationshipLabel;
  }

  public void setRelationshipLabel(String relationshipLabel) {
    this.relationshipLabel = relationshipLabel;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonAtlasRelationshipDef jsonAtlasRelationshipDef = (JsonAtlasRelationshipDef) o;
    return Objects.equals(this.endDef1, jsonAtlasRelationshipDef.endDef1) &&
        Objects.equals(this.endDef2, jsonAtlasRelationshipDef.endDef2) &&
        Objects.equals(this.propagateTags, jsonAtlasRelationshipDef.propagateTags) &&
        Objects.equals(this.relationshipCategory, jsonAtlasRelationshipDef.relationshipCategory) &&
        Objects.equals(this.relationshipLabel, jsonAtlasRelationshipDef.relationshipLabel) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endDef1, endDef2, propagateTags, relationshipCategory, relationshipLabel, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonAtlasRelationshipDef {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    endDef1: ").append(toIndentedString(endDef1)).append("\n");
    sb.append("    endDef2: ").append(toIndentedString(endDef2)).append("\n");
    sb.append("    propagateTags: ").append(toIndentedString(propagateTags)).append("\n");
    sb.append("    relationshipCategory: ").append(toIndentedString(relationshipCategory)).append("\n");
    sb.append("    relationshipLabel: ").append(toIndentedString(relationshipLabel)).append("\n");
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