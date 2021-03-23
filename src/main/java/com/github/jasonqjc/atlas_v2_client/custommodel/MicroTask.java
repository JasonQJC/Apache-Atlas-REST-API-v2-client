package com.github.jasonqjc.atlas_v2_client.custommodel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MicroTask extends VBaseType {
	private String taskName;
	private String taskCode;
	private String taskCycle;
	private String IPO;
}
