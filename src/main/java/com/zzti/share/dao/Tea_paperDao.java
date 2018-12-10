package com.zzti.share.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzti.share.dto.PaperInfo;
import com.zzti.share.entity.Tea_paper;

public interface Tea_paperDao {

	public int addTea_paper(Tea_paper paper);
	
	public Tea_paper getPaperById(int id);
	
	public Tea_paper getPaper(@Param("schoolId") int schoolId, @Param("subjectId") int subjectId);	

	public ArrayList<PaperInfo> getAll();
	
	public ArrayList<PaperInfo> getPaperByUser(int userId);
	
	public ArrayList<PaperInfo> getPaperByName(@Param("name") String name);
}
