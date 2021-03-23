package com.github.jasonqjc.atlas_v2_client.custommodel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MacroRpt extends BaseType {
	private String bgqType;
	private String rptName;
	private String rptCode;
}
