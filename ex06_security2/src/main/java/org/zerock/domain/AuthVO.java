package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthVO {
	private String userid;
	private String auth;
}