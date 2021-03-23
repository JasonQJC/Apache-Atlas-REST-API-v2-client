package com.github.jasonqjc.atlas_v2_client.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.jasonqjc.atlas_v2_client.ApiClient;
import com.github.jasonqjc.atlas_v2_client.api.DiscoveryRestApi;
import com.github.jasonqjc.atlas_v2_client.api.EntityRestApi;
import com.github.jasonqjc.atlas_v2_client.api.GlossaryRestApi;
import com.github.jasonqjc.atlas_v2_client.api.LineageRestApi;
import com.github.jasonqjc.atlas_v2_client.api.RelationshipRestApi;
import com.github.jasonqjc.atlas_v2_client.api.TypesRestApi;
import com.github.jasonqjc.atlas_v2_client.api.UILoginApi;

@Configuration
public class AtlasRestApiConf {
	
	@Autowired
	private ApiClient apiClient;
	
	@Bean
	public UILoginApi loginApi() {
		return apiClient.buildClient(UILoginApi.class);
	}
	
	@Bean
	public TypesRestApi typesRestApi() {
		return apiClient.buildClient(TypesRestApi.class);
	}
	
	@Bean
	public EntityRestApi entityRestApi() {
		return apiClient.buildClient(EntityRestApi.class);
	}
	
	@Bean
	public RelationshipRestApi relationshipRestApi() {
		return apiClient.buildClient(RelationshipRestApi.class);
	}
	
	@Bean
	public DiscoveryRestApi discoveryRestApi() {
		return apiClient.buildClient(DiscoveryRestApi.class);
	}
	
	@Bean
	public GlossaryRestApi glossaryRestApi() {
		return apiClient.buildClient(GlossaryRestApi.class);
	}
	
	@Bean
	public LineageRestApi lineageRestApi() {
		return apiClient.buildClient(LineageRestApi.class);
	}

}

