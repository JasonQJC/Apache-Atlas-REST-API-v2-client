package com.github.jasonqjc.atlas_v2_client.controller;

import java.util.Map;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.jasonqjc.atlas_v2_client.model.JsonAtlasTypesDef;
import com.github.jasonqjc.atlas_v2_client.model.JsonEntityMutationResponse;
import com.github.jasonqjc.atlas_v2_client.pojo.CreateTypePojo;
import com.github.jasonqjc.atlas_v2_client.service.ApiService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.Data;

@RestController
@RequestMapping("/api")
@Validated
public class ApiController {

	private ApiService apiService;

	@PostMapping("/createEntityType")
	public JsonAtlasTypesDef createEntityType(@RequestBody CreateTypePojo params) {
		return apiService.createEntityType(params);
	}
	
	@PostMapping("/createOrUpdateEntity")
	public JsonEntityMutationResponse createOrUpdateEntity(@RequestBody EntityUpdateDTO entityUpdateDTO) throws ClassNotFoundException {
		return apiService.createOrUpdateEntity(entityUpdateDTO);
	}
	
	@Data
	public static class EntityUpdateDTO {
		private String guid;
		@NotBlank
		private String typeName;
		private Map<String, String> customAttributes;
		private Map<String, Object> attributes;
		
	}
}
