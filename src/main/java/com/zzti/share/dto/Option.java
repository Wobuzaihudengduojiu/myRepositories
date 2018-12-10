package com.zzti.share.dto;

public class Option {

	private int id;
	private int queId;
	private String option;
	private String value;
	
	public Option(int id, int queId, String option, String value) {
		super();
		this.id = id;
		this.queId = queId;
		this.option = option;
		this.value = value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQueId() {
		return queId;
	}
	public void setQueId(int queId) {
		this.queId = queId;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Option [id=" + id + ", queId=" + queId + ", option=" + option + ", value=" + value + "]";
	}
	
	
}
