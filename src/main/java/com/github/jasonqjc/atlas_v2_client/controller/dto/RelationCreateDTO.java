package com.github.jasonqjc.atlas_v2_client.controller.dto;

import javax.validation.constraints.NotNull;

import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasObjectId;
import com.github.jasonqjc.atlas_v2_client.model.JsonPropagateTags;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "创建实体关系用DTO")
public class RelationCreateDTO {
	@NotNull
	private JsonAtlasObjectId end1;
	@NotNull
	private JsonAtlasObjectId end2;
	@NotNull
	private JsonPropagateTags propagateTags = JsonPropagateTags.NONE;
}