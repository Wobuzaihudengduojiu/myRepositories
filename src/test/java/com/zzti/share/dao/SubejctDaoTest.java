package com.zzti.share.dao;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzti.share.BaseTest;
import com.zzti.share.dto.PaperInfo;
import com.zzti.share.dto.QuestionInfo;
import com.zzti.share.dto.SubjectInfo;
import com.zzti.share.entity.Question;
import com.zzti.share.entity.Tea_paper;

public class SubejctDaoTest extends BaseTest {
	
	@Autowired
	private SubjectDao subjectDao;

	@Test
	public void getSubjectInfoByNameTest() throws Exception {
		ArrayList<SubjectInfo> list = subjectDao.getSubjectInfoByName("java");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	
}
