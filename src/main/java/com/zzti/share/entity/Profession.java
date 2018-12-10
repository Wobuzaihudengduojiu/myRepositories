package com.zzti.share.entity;

public class Profession {
	private int id;
	private String professionName;	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	@Override
	public String toString() {
		return "Profession [id=" + id + ", professionName=" + professionName + "]";
	}
	
	
}
