package com.tsinghuait.st0717.hospitalsystem.dto;

public class PageFairy {
    private int nextpage; //��һҳ������
    private int priorPage;//����ҳ����ʾ����
    private int rowsCount;//��¼������
    private int pageCount;//һҳ��ʾ������
    private int page;
    public static int numberpage=2;//һҳ��ʾ����
	public int getNextpage() {
		return nextpage;
	}
	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPriorPage() {
		return priorPage;
	}
	public void setPriorPage(int priorPage) {
		this.priorPage = priorPage;
	}
	public int getRowsCount() {
		return rowsCount;
	}
	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}
}
