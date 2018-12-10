package com.zzti.share.service;

import java.util.ArrayList;
import java.util.List;

import com.zzti.share.dto.PaperInfo;
import com.zzti.share.dto.PaperQuestion;
import com.zzti.share.dto.QuestionInfo;
import com.zzti.share.dto.SubjectInfo;
import com.zzti.share.dto.UserInfo;
import com.zzti.share.entity.Knowledge;
import com.zzti.share.entity.Profession;
import com.zzti.share.entity.Que_type;
import com.zzti.share.entity.Question;
import com.zzti.share.entity.School;
import com.zzti.share.entity.Subject;
import com.zzti.share.entity.Tea_paper;
import com.zzti.share.entity.User;

public interface CommonService {

	public User login(String phone, String password);
	
	public int register(String phone, String password,String username,int schoolId,int professionId,int identity);
	
	public User getUser(String phone);
	
	public int updatePassword(String phone, String password);
	
	public int recharge(int userId, String gold, int count);
	
	public int promotion(int userId);
	
	public int addLog(int userId,int gold,String service);
	
	public ArrayList<School> getSchool();
	
	public ArrayList<Profession> getProfession();
	
	public ArrayList<Subject> getSubject();
	
	public ArrayList<Subject> getSubjectByPro(int professionId);
	
	public ArrayList<SubjectInfo> getSubjectInfo();
	
	public ArrayList<Que_type> getQue_type(int subjectId);
	
	public ArrayList<Knowledge> getKnowledge(int subjectId);
	
	public ArrayList<QuestionInfo> getQuestion();
	
	public QuestionInfo getQuestionInfoById(int queId);
	
	public ArrayList<Question> getQuestionById(int queId);
	
	public SubjectInfo getSubjectInfoById(int id);
	
	public UserInfo getUserInfo(int id);
	
	public int updateUserInfo(int userId, String username, String phone, int schoolId, int professionId);

	public Tea_paper addPaper(String teaPaper,int subject,String knowledge,String que_type,String qtnum,
			String qtscore,int lv,int userId,int schoolId);
	
	public List<PaperQuestion> getTea_Paper(Tea_paper paper);
	
	public ArrayList<PaperInfo> getAllTea_Paper();
	
	public List<PaperQuestion> getTea_PaperById(int paperId);
	
	public Tea_paper getOneTea_Paper(int paperId);
	
	public ArrayList<PaperInfo> getAllPaperByUser(int userId);
	
	public ArrayList<PaperInfo> getAllPaperByName(String name);
	
	public ArrayList<QuestionInfo> getQuestionByName(String name);
	
	public ArrayList<SubjectInfo> getSubjectInfoByName(String name);
}
