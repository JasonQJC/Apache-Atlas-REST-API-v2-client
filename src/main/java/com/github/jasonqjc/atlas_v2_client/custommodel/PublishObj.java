package com.github.jasonqjc.atlas_v2_client.custommodel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PublishObj extends VBaseType {
	private String articleName;
	private String articleCode;
	private String bgq;
	private String articleObjPath;
}
