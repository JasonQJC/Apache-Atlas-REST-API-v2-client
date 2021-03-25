package com.github.jasonqjc.atlas_v2_client.custommodel;

import com.github.jasonqjc.atlas_v2_client.custommodel.base.VBaseType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PubTemplateObj extends VBaseType {
	private String pubTemplateObjName;
	private String pubTemplateObjCode;
	private String bgq;
	private String articleObjPath;
}
