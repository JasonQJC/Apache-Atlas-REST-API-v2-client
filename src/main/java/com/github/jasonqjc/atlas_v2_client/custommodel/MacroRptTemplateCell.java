package com.github.jasonqjc.atlas_v2_client.custommodel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MacroRptTemplateCell extends BaseType {
	private String x;
	private String y;
	private String bgqType;
}
