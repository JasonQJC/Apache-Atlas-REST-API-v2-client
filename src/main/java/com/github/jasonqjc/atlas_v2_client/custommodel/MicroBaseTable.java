package com.github.jasonqjc.atlas_v2_client.custommodel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MicroBaseTable extends BaseType {
	private String tableName;
	private String tableCode;
	private String tableDescribe;
	private String tableType;
	private String loadTaskPath;
}
