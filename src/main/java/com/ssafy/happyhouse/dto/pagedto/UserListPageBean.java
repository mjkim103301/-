package com.ssafy.happyhouse.dto.pagedto;

/** UI 화면 페이지에 대한 정보를 표시하는 클래스 */
public class UserListPageBean {
	/** 검색 조건 */
	private String key;
	/** 검색 단어 */
	private String word;
	/** 현재 페이지 번호 */
	private int pageNo;

	/** 한 페이지에 보여주 content 개수 */
	private static int userListInterval = 10;
	/** 페이지의 시작 게시글 번호 **/
	private int startUserId = 1;

	public UserListPageBean() {	}
	public UserListPageBean(String key, String word, int pageNo) {
		setKey(key);
		setWord(word);
		setPageNo(pageNo);
	}
	public UserListPageBean(String key, String word, String pageNo) {
		setKey(key);
		setWord(word);
		setPageNo(pageNo);
	}
	
	//스프링에서는 1 빼야함-0번부터 시작
	//1번부터 시작하게 함
	public int getStartUserId() {
		return (pageNo - 1) * userListInterval;
	}
	public void setStartUserId(int startUserId) {
		this.startUserId = startUserId;
	}
	private void setPageNo(String pageNo) {
		try {
			this.pageNo = Integer.parseInt(pageNo);
		} catch (Exception e) {
			this.pageNo = 1;
		}
	}
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public static int getUserListInterval() {
		return userListInterval;
	}

	public static void setUserListInterval(int userListInterval) {
		UserListPageBean.userListInterval = userListInterval;
	}


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ArticlePageBean{");
		sb.append("key='").append(key).append('\'');
		sb.append(", word='").append(word).append('\'');
		sb.append(", pageNo=").append(pageNo);
		sb.append(", articleInterval=").append(userListInterval);
		sb.append(", startArticleId=").append(startUserId);
		sb.append('}');
		return sb.toString();
	}
}
