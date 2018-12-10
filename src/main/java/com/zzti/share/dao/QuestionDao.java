package com.zzti.share.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.zzti.share.dto.QuestionInfo;
import com.zzti.share.entity.Question;

public interface QuestionDao {

	public int addQuestion(Question question);
	
	public ArrayList<Question> getQuestionByQueId(int queId);
	
	public ArrayList<Question> getQuestion(int queId);
	
	public Question getLast();
	
	public ArrayList<QuestionInfo> getAll();
	
	public QuestionInfo getQuestionInfoByQueId(int queId);
	
	public ArrayList<Integer> getQueId(@Param("subjectId") int subjectId,@Param("typeId") String typeId,
			@Param("knowledgeId") String knowledgeId,@Param("lv") String lv);
	
	public ArrayList<QuestionInfo> getQuestionByName(@Param("name") String name);

}
