package com.github.jasonqjc.atlas_v2_client.custommodel;

import com.github.jasonqjc.atlas_v2_client.custommodel.base.VBaseType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MicroBaseTable extends VBaseType {
	private String tableName;
	private String tableCode;
	private String tableDescribe;
	private String loadTaskPath;
	private String tableType;
}
