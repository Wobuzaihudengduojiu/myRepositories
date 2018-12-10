package com.zzti.share.dao;

import java.util.ArrayList;

import com.zzti.share.entity.Profession;

public interface ProfessionDao {

	public int addProfession(Profession profession);
	
	public ArrayList<Profession> getAll();
}
