package com.github.jasonqjc.atlas_v2_client.api;

import com.github.jasonqjc.atlas_v2_client.ApiClient;

import feign.Headers;
import feign.RequestLine;
import feign.Response;

public interface AdminApi extends ApiClient.Api {

	@RequestLine("POST /j_spring_security_check")
	@Headers({ "Content-Type: application/json;charset=UTF-8", "Accept: */*", })
	Response export();
	
}
