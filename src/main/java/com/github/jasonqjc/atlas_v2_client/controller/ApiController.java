package com.github.jasonqjc.atlas_v2_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.jasonqjc.atlas_v2_client.controller.dto.CreateTypePojo;
import com.github.jasonqjc.atlas_v2_client.controller.dto.EntityUpdateDTO;
import com.github.jasonqjc.atlas_v2_client.controller.dto.RelationCreateDTO;
import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasTypesDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonEntityMutationResponse;
import com.github.jasonqjc.atlas_v2_client.service.ApiService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Validated
public class ApiController {

	@Autowired
	private ApiService apiService;

	@ApiOperation(value = "创建类型")
	@PostMapping("/createEntityType")
	public JsonAtlasTypesDef createEntityType(@RequestBody CreateTypePojo params) {
		return apiService.createEntityType(params);
	}
	
	@ApiOperation(value = "创建/更新实体")
	@PostMapping("/createOrUpdateEntity")
	public JsonEntityMutationResponse createOrUpdateEntity(@RequestBody EntityUpdateDTO entityUpdateDTO) throws ClassNotFoundException {
		return apiService.createOrUpdateEntity(entityUpdateDTO);
	}
	
	@ApiOperation(value = "创建关系")
	@PostMapping("/createRelation")
	public void createRelation(@RequestBody RelationCreateDTO relationCreateDTO) {
		apiService.createRelation(relationCreateDTO);
	}
	
}
