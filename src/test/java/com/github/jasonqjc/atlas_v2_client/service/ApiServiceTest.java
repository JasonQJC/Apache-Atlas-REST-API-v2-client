package com.github.jasonqjc.atlas_v2_client.service;

import java.util.Date;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasonqjc.atlas_v2_client.controller.dto.EntityUpdateDTO;
import com.github.jasonqjc.atlas_v2_client.controller.dto.EntityUpdateDTO.EntityUpdateDTOBuilder;
import com.github.jasonqjc.atlas_v2_client.custommodel.Item;

class ApiServiceTest {

	@Autowired
	ApiService apiService;
	
	@Test
	void testCreateEntityType() {
		apiService.createEntityType(null);
	}

	@Test
	void testCreateOrUpdateEntity() throws ClassNotFoundException {
		ObjectMapper oMapper = new ObjectMapper();
		String nowUnixTime = new Date().getTime()+"";
		Item item = Item.builder()
				.createTime(nowUnixTime)
				.createUser("qjc")
				.modifyTime(nowUnixTime)
				.modifyUser("qjc")
				.build();
		Map<String, Object> map = oMapper.convertValue(item, new TypeReference<Map<String, Object>>() {});
		EntityUpdateDTO dto = EntityUpdateDTO.builder().typeName("Item")
			.attributes(map).build();
		
		apiService.createOrUpdateEntity(dto);
	}

	@Test
	void testCreateRelation() {
		apiService.createRelation(null);
	}

}
