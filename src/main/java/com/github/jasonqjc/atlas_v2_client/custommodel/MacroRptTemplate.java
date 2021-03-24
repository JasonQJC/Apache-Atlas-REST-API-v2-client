package com.github.jasonqjc.atlas_v2_client.custommodel;

import com.github.jasonqjc.atlas_v2_client.custommodel.base.VBaseType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MacroRptTemplate extends VBaseType {
	private String startTime;
	private String endTime;
	private String templateName;
	private String templateDescribe;
}
