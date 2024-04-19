package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	
	private int startPage;
	private int endPage;
	
	// 이전버튼, 다음버튼
	private boolean prev, next;
	
	//전체 데이터개수
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		// endPage = 2 / 10.0 = 0.2 => 1 * 10 -> 10  ====> 1 2 3 4 5 6 7 8 9 10 이렇게 표시
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0)) * 10;
		
		// endPage가 100이면 시작페이지는 91 ===> 91 92 ... 98 99 100
		this.startPage = endPage - 9; 
		
		//실제 끝
		// (82.0 * 1.0 / 10) -> 8.2 -> ceil -> 9
		int realEnd = (int)(Math.ceil((total *1.0) / cri.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd; //리얼엔드값을 endpage에 넣음
		}
		
		//이전과 다음버튼을 표시할지 안할지
		// 두개에는 불리언 값 들어감 true, false
		this.prev = this.startPage > 1; 
		this.next = this.endPage < realEnd;
	}
}
