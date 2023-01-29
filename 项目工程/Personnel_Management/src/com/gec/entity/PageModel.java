package com.gec.entity;

//分页模型
public class PageModel {
	// 上一页
	private int prePage;
	// 下一页
	private int nextPage;
	// 总页数
	private int pages;
	// 总记录条数
	private int total;
	// 当前页
	private int pageIndex;
	// 查询起始位置
	private int index;
	// 每页显示记录条数
	private int nums = 4;

	// 获取上一页 合理化判断
	public int getPrePage() {
		int item = pageIndex - 1;
		// 判断是否小于等于0
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

	// 获取下一页 合理化判断
	public int getNextPage() {
		int item = pageIndex + 1;
		// 判断是否超过最大值
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

	// 总页数
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

	// 查询起始位置 3 0 0+3 0+2*3
	public int getIndex() {
		// 【当前页码-1】乘以 每页显示条数
		index = (getPageIndex() - 1) * getNums();
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	// 每页显示条数
	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	// 用于构建分页对像
	public PageModel(int pageIndex, int total) {
		super();
		this.total = total;
		this.pageIndex = pageIndex;
		// 初始化总页数 【总记录条数+（每页显示条数-1）】除以 每页显示条数
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
