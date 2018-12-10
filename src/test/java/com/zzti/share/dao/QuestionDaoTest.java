package com.zzti.share.dao;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzti.share.BaseTest;
import com.zzti.share.dto.QuestionInfo;
import com.zzti.share.entity.Question;

public class QuestionDaoTest extends BaseTest {
	
	@Autowired
	private QuestionDao questionDao;

	@Test
	public void testAddUser() throws Exception {
		ArrayList<QuestionInfo> list = questionDao.getAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	

	@Test
	public void testgetQuestionByQueId() throws Exception {
		ArrayList<Question> list = questionDao.getQuestionByQueId(1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void testgetLast() throws Exception {
		Question q = questionDao.getLast();
		System.out.println(q);
	}
	
	@Test
	public void testgetQueId() throws Exception {
		int subjectId = 7;
		String typeId = "9,10";
		String knowledgeId = "15,16,17,18,19";
		String lv = "5,6";
		ArrayList<Integer> list = questionDao.getQueId(subjectId, typeId, knowledgeId, lv);
		System.out.println(list);
		
	}

	@Test
	public void testgetQuestionByName() throws Exception {
		ArrayList<QuestionInfo> list = questionDao.getQuestionByName("java");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
