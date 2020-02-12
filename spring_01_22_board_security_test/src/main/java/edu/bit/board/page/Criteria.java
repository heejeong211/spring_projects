package edu.bit.board.page;

public class Criteria { //���� 4�� ���� Ŭ����, �Խñۿ� ���� �� ���� Ŭ������
	
	private int page; //������ �������� �����ϴ� ����
	private int perPageNum; //�������� ������ �Խñۼ�
	
	private int startNum; //���۹�ȣ-�ش� �������� �����ϴ� �Խñ��� ��ȣ(1�� ������ 1~10���� �Խñ� �����ִ� ��)
	private int endNum; //����ȣ
	
	//default ������
	public Criteria() { //���� default �����ڷ� �⺻ ��ü ������ �ʱⰪ�� �����Ѵ�. (1������, 10����)
		this.page = 1; //����ڰ� �������� ������ �⺻ 1 //���ͷ� ���
		this.perPageNum = 10; //�������� �⺻ 10���� ����ϵ��� ����
	}
	
	//�Խñ� �ѷ��ִ� ��
	public int getStartNum() { //startNum�� �����
    	
    	if(page == 1)
    		startNum = 1;
    	else{
    		startNum = getEndNum() - perPageNum +1 ;
    	}
    	System.out.println("���۹�ȣ" + startNum);
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		endNum  =  page * getPerPageNum();
		//endNum  = getStartNum() + getPerPageNum();		
		System.out.println("�����ȣ" + endNum);
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}    
    
    // limit �������� ���� �κп� �ʿ��� ���� ��ȯ(mybatis���� ���)
    public int getPageStart(){
        return (this.page -1) * this.perPageNum;
		// RowBounds �� �Ű������� ���� �����ϴ� �޼ҵ�
		// RouwBounds �� start index�� 0���� �����ϹǷ�
		// 1������ : 1-1 * 10 = 0 ->>
		// 2������ : 2-1 * 10 = 10 ->>
    }
    
    // getter setter
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        if ( page <= 0 ){
            // �������� 1���������������� 0���� �۰ų� �������� ��� ������ ù��° �������� �����ǵ��� ���ش�.
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
