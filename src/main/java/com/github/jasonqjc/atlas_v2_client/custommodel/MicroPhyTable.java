package com.github.jasonqjc.atlas_v2_client.custommodel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MicroPhyTable extends BaseType {
	private String tableName;
	private String version;
	private String type;
	private String tableDescribe;
}
