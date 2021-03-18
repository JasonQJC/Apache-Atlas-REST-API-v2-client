package com.github.jasonqjc.atlas_v2_client.api;

import com.github.jasonqjc.atlas_v2_client.ApiClient;

import feign.Body;
import feign.Headers;
import feign.RequestLine;
import feign.Response;

public interface UILoginApi extends ApiClient.Api {

	@RequestLine("POST /j_spring_security_check")
	@Headers({ "Content-Type: application/x-www-form-urlencoded; charset=UTF-8", "Accept: */*", })
	@Body(value = "j_username=admin&j_password=admin")
	Response login();

}
