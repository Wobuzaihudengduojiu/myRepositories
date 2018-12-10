package com.zzti.share.dao;

import java.util.ArrayList;

import com.zzti.share.entity.Que_type;

public interface Que_typeDao {

	public int addQue_type(Que_type que_type);
		
	public ArrayList<Que_type> getQue_typeBySubject(int subjectId);
	
	public String getQue_typeById(int id);
}
