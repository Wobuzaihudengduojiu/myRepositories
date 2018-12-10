package com.zzti.share.dto;

import java.util.List;

public class PaperQuestion {

	private int queId;
	private	String title;
	private List<Option> option;
	private	String answer;
	private	int score;
	private int type;
	public int getQueId() {
		return queId;
	}
	public void setQueId(int queId) {
		this.queId = queId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Option> getOption() {
		return option;
	}
	public void setOption(List<Option> option) {
		this.option = option;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "PaperQuestion [queId=" + queId + ", title=" + title + ", option=" + option + ", answer=" + answer
				+ ", score=" + score + ", type=" + type + "]";
	}
	
}
