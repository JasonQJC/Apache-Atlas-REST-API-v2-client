package com.github.jasonqjc.atlas_v2_client.custommodel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MicroTaskTable extends VBaseType {
	private String isInputOrOutput;
	private String tableName;
	private String tableCode;
	private String tabledescribe;
}
