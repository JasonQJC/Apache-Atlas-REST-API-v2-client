package com.github.jasonqjc.atlas_v2_client.conf;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.jasonqjc.atlas_v2_client.ApiClient;
import com.github.jasonqjc.atlas_v2_client.auth.HttpBasicAuth;

@Configuration
public class ApiClientConf {

	@Value("${atlas.apiBasePath}")
	private String atlasApiBasePath;
	@Value("${atlas.username}")
	private String username;
	@Value("${atlas.password}")
	private String password;
	
	
	@Bean
	public ApiClient apiClient() {
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(atlasApiBasePath);
//		String encodeToString = Base64.getEncoder().encodeToString(new String(username+":"+password).getBytes());
//		apiClient.getFeignBuilder().requestInterceptor(r -> {
//			r.header("Authorization", "Basic " + encodeToString);
//		});
		HttpBasicAuth httpBasicAuth = new HttpBasicAuth();
		httpBasicAuth.setCredentials(username, password);
		apiClient.getFeignBuilder().requestInterceptor(httpBasicAuth);
		return apiClient;
	}
	
}
