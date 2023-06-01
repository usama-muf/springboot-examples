package com.usama.productservicequery.query.api.querys;

import lombok.Getter;

@Getter
public class GetProductByNameQuery {

	private String name;

	public GetProductByNameQuery(String name) {
		this.name = name;
	}

	public GetProductByNameQuery() {
	}

}
