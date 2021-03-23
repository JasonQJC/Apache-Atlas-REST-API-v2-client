package com.github.jasonqjc.atlas_v2_client.custommodel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MacroData extends VBaseType {
	private String value;
	private String time;
}
