package com.github.jasonqjc.atlas_v2_client.pojo;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasAttributeDef;

import lombok.Data;

@Data
public class CreateTypePojo {
	
	@NotBlank
	private String typeName;
	private String superType;
	private String desc;
	private List<JsonAtlasAttributeDef> attributeDefs;
	
}
