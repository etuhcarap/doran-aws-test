package io.sparta.doranawstest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse {
	private Long id;
	private String title;
	private String content;
}
