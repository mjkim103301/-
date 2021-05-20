package com.ssafy.happyhouse.dto;

public class ArticleDto {
	private int articleNo;
	private String userId;
	private String subject;
	private String content;
	private String registerTime;
	private int hit;

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
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

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GuestBookDto [articleNo=").append(articleNo).append(", userId=").append(userId)
				.append(", subject=").append(subject).append(", content=").append(content).append(", regtime=")
				.append(registerTime).append("]");
		return builder.toString();
	}

}
