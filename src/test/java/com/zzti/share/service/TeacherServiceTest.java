package com.zzti.share.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzti.share.BaseTest;
import com.zzti.share.dao.Tea_paperDao;
import com.zzti.share.dto.PaperInfo;
import com.zzti.share.dto.PaperQuestion;
import com.zzti.share.entity.Question;
import com.zzti.share.entity.Sub_check;
import com.zzti.share.entity.Subject;
import com.zzti.share.entity.Tea_paper;

public class TeacherServiceTest extends BaseTest{

	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private Tea_paperDao tea_paperDao;
	
//	@Test
//	public void addSubjectTest() throws Exception {
//		int user_id = 3;
//		int profession_id = 1;
//		String name = "C语言";
//		int i = teacherService.addSubject(name, profession_id, user_id);
//		System.out.println("输出结果：" + i);
//	}
	
//	@Test
//	public void selectNoCheckSubjectTest() throws Exception {		
//		ArrayList<Subject> list = teacherService.selectNoCheckSubject();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//	}
//	
//	@Test
//	public void checkSubjectTest() throws Exception {		
//		Sub_check sub_check = new Sub_check();
//		sub_check.setUser_id(3);
//		sub_check.setSubject_id(1);
//		sub_check.setIscheck(1);
//		int i = teacherService.checkSubject(sub_check);
//		System.out.println("输出结果：" + i);
//	}
	@Test
	public void addTeaPaperTest() throws Exception {
		String teaPaper = "数据结构测试试卷";
		int subject = 7;
		String knowledge = "10,11,12,13,14,15,16,17,18,19";
		String que_type = "9,10";
		String qtnum = "10,10,,";
		String qtscore = "3,4,,";
		int lv = 2;
		int userId = 1;
		int schoolId = 1;
		teacherService.addPaper(teaPaper, subject, knowledge, que_type, qtnum, qtscore, lv, userId, schoolId);
	}
	
	@Test
	public void getTeaPaperTest() throws Exception {
		Tea_paper paper = tea_paperDao.getPaperById(7);
		List<PaperQuestion> pq = teacherService.getTea_Paper(paper);
		for (int i = 0; i < pq.size(); i++) {
			System.out.println(pq.get(i));
		}
	}
	
	@Test
	public void getAllTeaPaperTest() throws Exception {
		List<PaperInfo> paper = teacherService.getAllTea_Paper();
		for (int i = 0; i < paper.size(); i++) {
			System.out.println(paper.get(i));
		}
	}
	
	@Test
	public void getOneTeaPaperTest() throws Exception {
		List<PaperQuestion> pq = teacherService.getTea_PaperById(11);
		for (int i = 0; i < pq.size(); i++) {
			System.out.println(pq.get(i));
		}
	}
	
	@Test
	public void onlyTest() throws Exception {
		String str = "选项A";
		System.out.println(str.substring(2));
	}
}
