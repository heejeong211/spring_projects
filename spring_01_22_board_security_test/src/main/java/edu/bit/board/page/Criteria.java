package edu.bit.board.page;

public class Criteria { //변수 4개 들어가는 클래스, 게시글에 대한 건 여기 클래스에
	
	private int page; //보여줄 페이지를 저장하는 변수
	private int perPageNum; //페이지당 보여줄 게시글수
	
	private int startNum; //시작번호-해당 페이지를 시작하는 게시글의 번호(1번 누르면 1~10까지 게시글 보여주는 것)
	private int endNum; //끝번호
	
	//default 생성자
	public Criteria() { //최초 default 생성자로 기본 객체 생성시 초기값을 지정한다. (1페이지, 10개씩)
		this.page = 1; //사용자가 세팅하지 않으면 기본 1 //리터럴 상수
		this.perPageNum = 10; //페이지당 기본 10개씩 출력하도록 세팅
	}
	
	//게시글 뿌려주는 거
	public int getStartNum() { //startNum을 계산함
    	
    	if(page == 1)
    		startNum = 1;
    	else{
    		startNum = getEndNum() - perPageNum +1 ;
    	}
    	System.out.println("시작번호" + startNum);
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		endNum  =  page * getPerPageNum();
		//endNum  = getStartNum() + getPerPageNum();		
		System.out.println("엔드번호" + endNum);
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}    
    
    // limit 구문에서 시작 부분에 필요한 값을 반환(mybatis에서 사용)
    public int getPageStart(){
        return (this.page -1) * this.perPageNum;
		// RowBounds 의 매개변수의 값을 설정하는 메소드
		// RouwBounds 의 start index는 0부터 시작하므로
		// 1페이지 : 1-1 * 10 = 0 ->>
		// 2페이지 : 2-1 * 10 = 10 ->>
    }
    
    // getter setter
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        if ( page <= 0 ){
            // 페이지는 1페이지부터임으로 0보다 작거나 같은값일 경우 무조건 첫번째 페이지로 설정되도록 해준다.
            this.page = 1;
        }else{
            this.page = page;
        }
    }
    public int getPerPageNum() {
         
        return perPageNum;
    }
    
    public void setPerPageNum(int perPageNum) {
        if ( perPageNum <= 0 || perPageNum > 100 ) {
            this.perPageNum = 10;
        }else {
            this.perPageNum = perPageNum;
        }
    }
 
    @Override
    public String toString() {
        return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
    }
}
