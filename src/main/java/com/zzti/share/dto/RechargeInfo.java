package com.zzti.share.dto;

import java.util.Date;

public class RechargeInfo {

	private int id;
	private String username;
	private int sum;
	private Date time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "RechargeInfo [id=" + id + ", username=" + username + ", sum=" + sum + ", time=" + time + "]";
	}
	
}
