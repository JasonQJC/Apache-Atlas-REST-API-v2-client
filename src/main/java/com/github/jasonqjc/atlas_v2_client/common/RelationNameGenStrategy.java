package com.github.jasonqjc.atlas_v2_client.common;

public class RelationNameGenStrategy {
	
	public static final String JOIN_STR = "_";
	
	public static String gen(String typeName1,String typeName2) {
		if(typeName1.compareTo(typeName2) <= 0) {
			return typeName1 + JOIN_STR + typeName2;
		} else {
			return typeName2 + JOIN_STR + typeName1;
		}
	}
	
}
