package com.zzti.share.dao;

import java.util.ArrayList;

import com.zzti.share.entity.Gold_log;

public interface Gold_logDao {

	public int addGold_log(Gold_log log);
	
	public ArrayList<Gold_log> getAll();
}
