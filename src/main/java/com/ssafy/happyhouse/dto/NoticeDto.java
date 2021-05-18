package com.ssafy.happyhouse.dto;

public class NoticeDto {
	private int articleNo;
	private String userId;
	private String subject;
	private String content;
	private String regtime;
	private int hits;

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GuestBookDto [articleNo=").append(articleNo).append(", userId=").append(userId)
				.append(", subject=").append(subject).append(", content=").append(content).append(", regtime=")
				.append(regtime).append("]");
		return builder.toString();
	}

}
