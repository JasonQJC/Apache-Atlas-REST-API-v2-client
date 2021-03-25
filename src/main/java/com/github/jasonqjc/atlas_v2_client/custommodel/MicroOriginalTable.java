package com.github.jasonqjc.atlas_v2_client.custommodel;

import com.github.jasonqjc.atlas_v2_client.custommodel.base.VBaseType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MicroOriginalTable extends VBaseType {
	private String tableName;
	private String ytbTaskName;
	private String reportType;
	private String tableCode;
	private String tableDescribe;
	private String version;
	private String year;
	private String htmlBy;
	private String sourceType;
	private String dataSource;
	private String fieldList;
	private String operationList;
}
