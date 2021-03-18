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
 * Gets or Sets json_AtlasTermAssignmentStatus
 */
public enum JsonAtlasTermAssignmentStatus {
  DISCOVERED("DISCOVERED"),
  PROPOSED("PROPOSED"),
  IMPORTED("IMPORTED"),
  VALIDATED("VALIDATED"),
  DEPRECATED("DEPRECATED"),
  OBSOLETE("OBSOLETE"),
  OTHER("OTHER");

  private String value;

  JsonAtlasTermAssignmentStatus(String value) {
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
  public static JsonAtlasTermAssignmentStatus fromValue(String text) {
    for (JsonAtlasTermAssignmentStatus b : JsonAtlasTermAssignmentStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}