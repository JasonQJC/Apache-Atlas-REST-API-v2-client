package com.github.jasonqjc.atlas_v2_client.custommodel;

import com.github.jasonqjc.atlas_v2_client.custommodel.base.VBaseType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Publish extends VBaseType {
	private String articleName;
	private String articleCode;
	private String bgqType;
	private String articlePath;
}
