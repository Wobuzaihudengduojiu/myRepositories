package com.zzti.share.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzti.share.dto.PaperInfo;
import com.zzti.share.dto.PaperQuestion;
import com.zzti.share.dto.SubjectInfo;
import com.zzti.share.entity.Sub_check;
import com.zzti.share.entity.Tea_paper;

public interface TeacherService {

	public int addSubject(String name, int professionId, int userId);
	
	public ArrayList<SubjectInfo> getNoCheckSubject();

	public int checkSubject(int userId,int subjectId,int ischeck);
	
	public int getLast();
	
	public int getSubjectId(String subjectName);
	
	public int addQuestion(int queId,String key,String value,int knowledgeId,int typeId,int subjectId,int userId,int lv);
	
	public Tea_paper addPaper(String teaPaper,int subject,String knowledge,String que_type,String qtnum,
			String qtscore,int lv,int userId,int schoolId);
	
	public int addQue_type(String name);
	
	public int addKnowledge(String txt,int subjectId);
	
	public int addXuanze(int queId,String txt,int knowledgeId,int typeId,int subjectId,int userId,int lv);
	
	public int addTiankong(int queId,String txt,int knowledgeId,int typeId,int subjectId,int userId,int lv);
	
	public int addQita(int queId,String txt,int knowledgeId,int typeId,int subjectId,int userId,int lv);

	public List<PaperQuestion> getTea_Paper(Tea_paper paper);
	
	public ArrayList<PaperInfo> getAllTea_Paper();
	
	public List<PaperQuestion> getTea_PaperById(int paperId);
	
	public Tea_paper getOneTea_Paper(int paperId);
	
	public ArrayList<SubjectInfo> getNoSubjectByName(String name);
}
