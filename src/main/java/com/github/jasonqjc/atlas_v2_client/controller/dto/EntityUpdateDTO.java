package com.github.jasonqjc.atlas_v2_client.controller.dto;

import java.util.Map;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class EntityUpdateDTO {
	private String guid;
	@NotBlank
	private String typeName;
	// User-defined properties
	private Map<String, String> customAttributes;
	// Technical properties
	private Map<String, Object> attributes;

}