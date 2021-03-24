package com.github.jasonqjc.atlas_v2_client.custommodel;

import com.github.jasonqjc.atlas_v2_client.custommodel.base.VBaseType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Item extends VBaseType {
	private String itemName;
	private String type;
	private String isTopItem;
}
