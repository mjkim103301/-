package com.ssafy.happyhouse.dto;

public class PageNavigation {
	private int currentPage;
	private int startPageNumber;
	private int endPageNumber;
	private int pageInterval;
	private int totalPageCount;

	public PageNavigation(int currentPage, int pageInterval, int totalPageCount) {
		this.currentPage = currentPage;
		this.pageInterval = pageInterval;
		startPageNumber = (currentPage - 1) / pageInterval * pageInterval + 1;
		endPageNumber = startPageNumber + pageInterval - 1;

		if(totalPageCount < endPageNumber)
			endPageNumber = totalPageCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setStartPageNumber(int startPageNumber) {
		this.startPageNumber = startPageNumber;
	}

	public void setEndPageNumber(int endPageNumber) {
		this.endPageNumber = endPageNumber;
	}

	public void setPageInterval(int pageInterval) {
		this.pageInterval = pageInterval;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getStartPageNumber() {
		return startPageNumber;
	}

	public int getEndPageNumber() {
		return endPageNumber;
	}

	public int getPageInterval() {
		return pageInterval;
	}
}
