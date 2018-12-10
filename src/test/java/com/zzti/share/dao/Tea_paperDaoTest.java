package com.zzti.share.dao;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzti.share.BaseTest;
import com.zzti.share.dto.PaperInfo;
import com.zzti.share.dto.QuestionInfo;
import com.zzti.share.entity.Question;
import com.zzti.share.entity.Tea_paper;

public class Tea_paperDaoTest extends BaseTest {
	
	@Autowired
	private Tea_paperDao tea_paperDao;

	@Test
	public void testAddtea_paper() throws Exception {
		Tea_paper paper = new Tea_paper();
		paper.setTpName("计算机操作系统");
		paper.setSubjectId(7);
		paper.setUserId(1);
		paper.setSchoolId(1);
		paper.setQuestionId("53,48,25,72,13,47,46,34,70,26,81,41,57,30,55,80,18,76,79,42,");
		paper.setScore(100);
		paper.setOpenTime(new Date());
		int i = tea_paperDao.addTea_paper(paper);
		System.out.println("返回ID：" + paper.getId());
	}
	
	@Test
	public void testGetPaperByName() throws Exception {
		ArrayList<PaperInfo> list = tea_paperDao.getPaperByName("java");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
