package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Criteria {

	private int pageNum; //몇페이지 1, 2, 3
	private int amount; //몇페이지당 몇개 보여주는
	
	public Criteria() {
		this(1,10);
	}
	
	
	// 2, 10 -> 2페이지에 있는 10개 보겠다 11~20
	// 3, 15 -> 3페이지에 있는 15개 보겠다 46~60
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
