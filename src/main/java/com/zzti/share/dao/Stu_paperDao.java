package com.zzti.share.dao;

import java.util.ArrayList;

import com.zzti.share.entity.Stu_paper;

public interface Stu_paperDao {

	public int addStu_paper(Stu_paper paper);
	
	public ArrayList<Stu_paper> getPaper(int paperId);
}
