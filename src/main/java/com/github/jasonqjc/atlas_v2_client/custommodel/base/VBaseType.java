package com.github.jasonqjc.atlas_v2_client.custommodel.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class VBaseType {
	protected String createTime;
	protected String createUser;
	protected String modifyTime;
	protected String modifyUser;
}
