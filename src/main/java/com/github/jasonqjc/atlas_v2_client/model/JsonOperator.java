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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Supported search operations Logical comparision operators can only be used with numbers or dates IN, LIKE, startsWith, endsWith, CONTAINS can only be used with strings or text
 */
public enum JsonOperator {
  LT("LT"),
  GT("GT"),
  LTE("LTE"),
  GTE("GTE"),
  EQ("EQ"),
  NEQ("NEQ"),
  IN("IN"),
  LIKE("LIKE"),
  STARTS_WITH("STARTS_WITH"),
  ENDS_WITH("ENDS_WITH"),
  CONTAINS("CONTAINS"),
  NOT_CONTAINS("NOT_CONTAINS"),
  CONTAINS_ANY("CONTAINS_ANY"),
  CONTAINS_ALL("CONTAINS_ALL"),
  IS_NULL("IS_NULL"),
  NOT_NULL("NOT_NULL");

  private String value;

  JsonOperator(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static JsonOperator fromValue(String text) {
    for (JsonOperator b : JsonOperator.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
