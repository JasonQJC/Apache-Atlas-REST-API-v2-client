package com.github.jasonqjc.atlas_v2_client.custommodel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Publish extends BaseType {
	private String articleName;
	private String articleCode;
	private String bgqType;
	private String articlePath;
}
