package com.github.jasonqjc.atlas_v2_client.conf;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.jasonqjc.atlas_v2_client.ApiClient;
import com.github.jasonqjc.atlas_v2_client.api.UILoginApi;

import feign.Response;

@Configuration
public class ApiClientConf {

	@Value("${atlas.basePath}")
	private String atlasBasePath;
	@Value("${atlas.apiBasePath}")
	private String atlasApiBasePath;
	
	@Bean
	public ApiClient apiClient() {
		ApiClient apiClient = new ApiClient();
		initLoginCookie(apiClient);
		apiClient.setBasePath(atlasApiBasePath);
		return apiClient;
	}
	
	private void initLoginCookie(ApiClient apiClient) {
		apiClient.setBasePath(atlasBasePath);
		UILoginApi loginApi = apiClient.buildClient(UILoginApi.class);
		Response response = loginApi.login();
		Collection<String> collection = response.headers().get("Set-Cookie");
		String cookieString = collection.iterator().next();
		String loginCookie = cookieString.split(";")[0];
		apiClient.getFeignBuilder().requestInterceptor(r -> {
        	r.header("Cookie", loginCookie);
        });
	}
	
}
