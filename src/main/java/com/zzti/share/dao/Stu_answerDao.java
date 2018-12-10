package com.zzti.share.dao;

import com.zzti.share.entity.Stu_answer;

public interface Stu_answerDao {

	public int addStu_answer(Stu_answer answer);
	
	public Stu_answer getAnswer(int QuestionId);
}
