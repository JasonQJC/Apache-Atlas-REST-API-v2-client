package com.github.jasonqjc.atlas_v2_client.controller.dto;

import java.util.Map;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel(description = "创建/更新实体使用的DTO")
@Builder
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class EntityUpdateDTO {
	private String guid;
	@NotBlank
	private String typeName;
	// User-defined properties
	private Map<String, String> customAttributes;
	// Technical properties
	private Map<String, Object> attributes;

}