package com.github.jasonqjc.atlas_v2_client.custommodel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MicroOriginalTable extends VBaseType {
	private String tableName;
	private String tableCode;
	private String tableDescribe;
	private String year;
	private String htmlBy;
	private String sourceType;
	private String dataSource;
}
