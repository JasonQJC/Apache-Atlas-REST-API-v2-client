package com.github.jasonqjc.atlas_v2_client.custommodel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MicroColumn extends VBaseType {
	private String colCName;
	private String colEName;
	private String colDataType;
	private String sort;
	private String colComments;
}
