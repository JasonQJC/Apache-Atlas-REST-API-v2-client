package com.github.jasonqjc.atlas_v2_client.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${atlas.username}")
	private String username;
	@Value("${atlas.password}")
	private String password;
	@Value("${atlas.basePath}")
	private String atlasBasePath;
	@Value("${atlas.apiBasePath}")
	private String atlasApiBasePath;
	
	@Autowired
	private ApiClient apiClient;
	
	@Bean
	public UILoginApi loginApi() {
		apiClient.setBasePath(atlasBasePath);
		return apiClient.buildClient(UILoginApi.class);
	}
	
	@Bean
	public TypesRestApi typesRestApi() {
		apiClient.setBasePath(atlasApiBasePath);
		return apiClient.buildClient(TypesRestApi.class);
	}
	
	@Bean
	public EntityRestApi entityRestApi() {
		apiClient.setBasePath(atlasApiBasePath);
		return apiClient.buildClient(EntityRestApi.class);
	}
	
	@Bean
	public RelationshipRestApi relationshipRestApi() {
		apiClient.setBasePath(atlasApiBasePath);
		return apiClient.buildClient(RelationshipRestApi.class);
	}
	
	@Bean
	public DiscoveryRestApi discoveryRestApi() {
		apiClient.setBasePath(atlasApiBasePath);
		return apiClient.buildClient(DiscoveryRestApi.class);
	}
	
	@Bean
	public GlossaryRestApi glossaryRestApi() {
		apiClient.setBasePath(atlasApiBasePath);
		return apiClient.buildClient(GlossaryRestApi.class);
	}
	
	@Bean
	public LineageRestApi lineageRestApi() {
		apiClient.setBasePath(atlasApiBasePath);
		return apiClient.buildClient(LineageRestApi.class);
	}

}

