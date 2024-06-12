package model.entity;

import java.time.LocalDateTime;

public class FavoritesEntity {
	private String user_id;
	private String sys_id;
	private String question;
	private String answer;
	private String keyword;
	private LocalDateTime saved_at;
	
	public FavoritesEntity() {
	}
	
	public FavoritesEntity(String user_id, String sys_id, String question, String answer, String keyword,
			LocalDateTime saved_at) {
		this.user_id = user_id;
		this.sys_id = sys_id;
		this.question = question;
		this.answer = answer;
		this.keyword = keyword;
		this.saved_at = saved_at;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSys_id() {
		return sys_id;
	}

	public void setSys_id(String sys_id) {
		this.sys_id = sys_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public LocalDateTime getSaved_at() {
		return saved_at;
	}

	public void setSaved_at(LocalDateTime saved_at) {
		this.saved_at = saved_at;
	}
	
	
}
