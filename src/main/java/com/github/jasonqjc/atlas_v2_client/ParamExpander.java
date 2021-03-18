package com.github.jasonqjc.atlas_v2_client;

import java.text.DateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.util.StdDateFormat;

import feign.Param;

/**
 * Param Expander to convert {@link Date} to RFC3339
 */
public class ParamExpander implements Param.Expander {

//  private static final DateFormat dateformat = new RFC3339DateFormat();
  private static final DateFormat dateformat = new StdDateFormat();

  @Override
  public String expand(Object value) {
    if (value instanceof Date) {
      return dateformat.format(value);
    }
    return value.toString();
  }
}
