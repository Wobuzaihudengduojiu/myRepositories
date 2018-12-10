package com.zzti.share.dao;

import java.util.ArrayList;

import com.zzti.share.entity.Knowledge;

public interface KnowledgeDao {

	public int addKnowledge(Knowledge knowledge);
	
	public ArrayList<Knowledge> getAll();
	
	public ArrayList<Knowledge> getKnowledgeBySubject(int subjectId);
}
