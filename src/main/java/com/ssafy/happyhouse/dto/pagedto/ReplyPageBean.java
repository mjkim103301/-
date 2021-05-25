package com.ssafy.happyhouse.dto.pagedto;

import io.swagger.annotations.Api;

@Api(value = "댓글 페이징 Dto")
public class ReplyPageBean {
	/** 현재 페이지 번호 */
	private int pageNo;

	private int articleId;

	/** 댓글 한 페이지에 보여주 content 개수 */
	private static int replyInterval = 15;
	/** 댓글 페이지의 시작 댓글 번호 **/
	private int startReplyId = 1;

	public ReplyPageBean() {}

	public ReplyPageBean(int articleId, int pageNo ) {
		this.articleId = articleId;
		this.pageNo = pageNo;
	}

	public int getStartReplyId() {
		return (pageNo - 1) * replyInterval;
	}

	public void setStartReplyId(int startReplyId) {
		this.startReplyId = startReplyId;
	}
	private void setPageNo(String pageNo) {
		try {
			this.pageNo = Integer.parseInt(pageNo);
		} catch (Exception e) {
			this.pageNo = 1;
		}
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public static int getReplyInterval() {
		return replyInterval;
	}

	public static void setReplyInterval(int replyInterval) {
		ReplyPageBean.replyInterval = replyInterval;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
}
