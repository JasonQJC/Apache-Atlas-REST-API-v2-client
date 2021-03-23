package com.github.jasonqjc.atlas_v2_client.custommodel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ArticleObj extends BaseType {
	private String artName;
	private String artCode;
	private String bgq;
	private String content;
}
