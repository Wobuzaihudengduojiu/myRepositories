package com.zzti.share.dao;

import java.util.ArrayList;

import com.zzti.share.entity.School;

public interface SchoolDao {

	public int addSchool(School school);
	
	public ArrayList<School> getAll();
}
