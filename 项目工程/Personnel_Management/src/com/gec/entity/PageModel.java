package com.gec.entity;

//��ҳģ��
public class PageModel {
	// ��һҳ
	private int prePage;
	// ��һҳ
	private int nextPage;
	// ��ҳ��
	private int pages;
	// �ܼ�¼����
	private int total;
	// ��ǰҳ
	private int pageIndex;
	// ��ѯ��ʼλ��
	private int index;
	// ÿҳ��ʾ��¼����
	private int nums = 4;

	// ��ȡ��һҳ �����ж�
	public int getPrePage() {
		int item = pageIndex - 1;
		// �ж��Ƿ�С�ڵ���0
		if (item <= 0) {
			prePage = 1;
		} else {
			prePage = item;
		}
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	// ��ȡ��һҳ �����ж�
	public int getNextPage() {
		int item = pageIndex + 1;
		// �ж��Ƿ񳬹����ֵ
		if (item > getPages()) {
			nextPage = getPages();
		} else {
			nextPage = item;
		}
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	// ��ҳ��
	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	// ��ѯ��ʼλ�� 3 0 0+3 0+2*3
	public int getIndex() {
		// ����ǰҳ��-1������ ÿҳ��ʾ����
		index = (getPageIndex() - 1) * getNums();
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	// ÿҳ��ʾ����
	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	// ���ڹ�����ҳ����
	public PageModel(int pageIndex, int total) {
		super();
		this.total = total;
		this.pageIndex = pageIndex;
		// ��ʼ����ҳ�� ���ܼ�¼����+��ÿҳ��ʾ����-1�������� ÿҳ��ʾ����
		this.pages = (total + getNums() - 1) / getNums();
	}	

	public PageModel() {
		super();
	}

	@Override
	public String toString() {
		return "PageModel [prePage=" + prePage + ", nextPage=" + nextPage + ", pages=" + pages + ", total=" + total
				+ ", pageIndex=" + pageIndex + ", index=" + index + ", nums=" + nums + "]";
	}

}
