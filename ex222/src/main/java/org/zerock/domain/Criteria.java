package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//페이징 처리 클래스
@Setter
@Getter
@ToString
public class Criteria {

	private int pageNum; // 몇페이지 1, 2, 3
	private int amount; // 몇페이지당 몇개 보여주는

	private String type; // 검색 종류 : T(title), C(content), W(writer)
	private String keyword; // 검색 단어

	// 기본값이 1페이지의 10개의 글
	public Criteria() {
		this(1, 10);
	}

	// 2, 10 -> 2페이지 10개 보겠다 11~20
	// 3, 15 -> 3페이지 15개 보겠다 46~60
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	//type -> TCW 	T|C|W
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
}
