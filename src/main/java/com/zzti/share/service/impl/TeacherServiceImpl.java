package com.zzti.share.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzti.share.dao.Gold_logDao;
import com.zzti.share.dao.KnowledgeDao;
import com.zzti.share.dao.PromotionDao;
import com.zzti.share.dao.Que_typeDao;
import com.zzti.share.dao.QuestionDao;
import com.zzti.share.dao.RechargeDao;
import com.zzti.share.dao.Sub_checkDao;
import com.zzti.share.dao.SubjectDao;
import com.zzti.share.dao.Tea_paperDao;
import com.zzti.share.dao.UserDao;
import com.zzti.share.dto.Option;
import com.zzti.share.dto.PaperInfo;
import com.zzti.share.dto.PaperQuestion;
import com.zzti.share.dto.SubjectInfo;
import com.zzti.share.entity.Gold_log;
import com.zzti.share.entity.Knowledge;
import com.zzti.share.entity.Promotion;
import com.zzti.share.entity.Que_type;
import com.zzti.share.entity.Question;
import com.zzti.share.entity.Sub_check;
import com.zzti.share.entity.Subject;
import com.zzti.share.entity.Tea_paper;
import com.zzti.share.entity.User;
import com.zzti.share.service.TeacherService;
import com.zzti.share.util.Utils;
@Service
public class TeacherServiceImpl implements TeacherService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private Gold_logDao gold_logDao;
	
	@Autowired
	private SubjectDao subjectDao;
	
	@Autowired
	private Sub_checkDao sub_checkDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private Que_typeDao que_typeDao;
	
	@Autowired
	private KnowledgeDao knowlegdeDao;
	
	@Autowired
	private Tea_paperDao tea_paperDao;

	@Override
	public int addSubject(String name, int professionId, int userId) {
		Subject subject = new Subject();
		subject.setSubjectName(name);
		subject.setProfessionId(professionId);
		subject.setUserId(userId);
		return subjectDao.addSubject(subject);
	}

	@Override
	public ArrayList<SubjectInfo> getNoCheckSubject() {		
		return subjectDao.getNoCheck();
	}

	@Override
	public int checkSubject(int userId,int subjectId,int ischeck) {
		Sub_check sub_check = new Sub_check();
		sub_check.setUserId(userId);
		sub_check.setSubjectId(subjectId);
		sub_check.setIscheck(ischeck);
		sub_checkDao.addSub_check(sub_check);
		System.out.println("科目审核已添加");
		return 1;
	}

	@Override
	public int addQuestion(int queId,String title,String value,int knowledgeId,int typeId,int subjectId,int userId,int lv) {
		Question question = new Question();
		question.setQueId(queId+1);
		question.setTitle(title);
		question.setValue(value);
		question.setKnowledgeId(knowledgeId);
		question.setTypeId(typeId);
		question.setSubjectId(subjectId);
		question.setUserId(userId);
		question.setLv(lv);
		questionDao.addQuestion(question);
		return 1;
	}

	@Override
	public int getLast() {
		Question question = questionDao.getLast();
		return question.getQueId();
	}

	@Override
	public int addQue_type(String name) {	
		Que_type que_type = new Que_type();
		que_type.setQtName(name);
		return que_typeDao.addQue_type(que_type);
	}

	@Override
	public int addKnowledge(String txt, int subject_id) {
		String name[] = txt.split(",");
		for (int i = 0; i < name.length; i++) {
			Knowledge knowledge = new Knowledge();
			knowledge.setKnowledgeName(name[i]);
			knowledge.setSubjectId(subject_id);
			knowlegdeDao.addKnowledge(knowledge);
		}	
		return 1;
	}

	@Override
	public int addXuanze(int queId, String txt, int knowledgeId,int typeId,int subjectId,int userId, int lv) {
		String key[] = txt.split(",");
		for (int i = 0; i < key.length; i++) {
			Question question = new Question();
			question.setQueId(queId+1);
			question.setTitle("选项" + (char)(i+65));
			question.setValue(key[i]);
			question.setKnowledgeId(knowledgeId);
			question.setTypeId(typeId);
			question.setSubjectId(subjectId);
			question.setUserId(userId);
			question.setLv(lv);
			questionDao.addQuestion(question);
		}
		return 1;
	}

	@Override
	public int addTiankong(int queId, String txt, int knowledgeId,int typeId,int subjectId,int userId,int lv) {
		String key[] = txt.split(",");
		for (int i = 0; i < key.length; i++) {
			Question question = new Question();
			question.setQueId(queId+1);
			question.setTitle("填空" + (i+1));
			question.setValue(key[i]);
			question.setKnowledgeId(knowledgeId);
			question.setTypeId(typeId);
			question.setSubjectId(subjectId);
			question.setUserId(userId);
			question.setLv(lv);
			questionDao.addQuestion(question);
		}
		return 1;
	}

	@Override
	public int addQita(int queId, String txt, int knowledgeId,int typeId,int subjectId,int userId, int lv) {
		String key[] = txt.split(",");
		for (int i = 0; i < key.length; i++) {
			Question question = new Question();
			question.setQueId(queId+1);
			question.setTitle("问题" + (i+1));
			question.setValue(key[i]);
			question.setKnowledgeId(knowledgeId);
			question.setTypeId(typeId);
			question.setSubjectId(subjectId);
			question.setUserId(userId);
			question.setLv(lv);
			questionDao.addQuestion(question);
		}
		return 1;
	}

	@Override
	public int getSubjectId(String subject_name) {
		Subject subject = subjectDao.getSubjectByName(subject_name);
		return subject.getId();
	}

	@Override
	public Tea_paper addPaper(String teaPaper, int subject, String knowledge, String que_type, String qtnum, String qtscore,
			int lv, int userId, int schoolId) {
		//判定难度系数
		String lvs;
		if(lv == 3) {
			lvs = "6,7,8,9,10";
		} else if(lv == 2) {
			lvs = "4,5,6,7";
		} else {
			lvs = "1,2,3,4";
		}
		//将字符串拆分成数组
		String[] qtn = qtnum.split(",");
		String[] qts = qtscore.split(",");
		String[] queType = que_type.split(",");
		int score = 0;
		String queScore = "";
		List<Integer> queId;
		List<Integer> question = new ArrayList<Integer>();
		for (int i = 0; i < queType.length; i++) {//按题目类型随机取题目ID
			//算试卷总分值
			score += Integer.parseInt(qtn[i])*Integer.parseInt(qts[i]);
			//将每个题分值按字符串存入
			for (int j = 0; j < Integer.parseInt(qtn[i]); j++) {
				queScore += qts[i] + ",";
			}
			//取出符合要求的所以题目ID
			queId = questionDao.getQueId(subject, queType[i], knowledge, lvs);
			//随机取出指定数量题目ID
			question.addAll(Utils.createRandomList(queId, Integer.parseInt(qtn[i])));
		}
		//将选出问题的List转换为String字符串
		String queStr = "";
		for (int i = 0; i < question.size(); i++) {
			queStr += question.get(i) + ",";
		}
		System.out.println(question);
		System.out.println(score);
		System.out.println(queStr);
		System.out.println(queScore);

		Tea_paper paper = new Tea_paper();
		paper.setTpName(teaPaper);
		paper.setSubjectId(subject);
		paper.setUserId(userId);
		paper.setSchoolId(schoolId);
		paper.setQuestionId(queStr);
		paper.setScore(score);
		paper.setOpenTime(new Date());
		paper.setQueScore(queScore);
		tea_paperDao.addTea_paper(paper);
		//返回添加试卷的ID
		return paper;
	}

	@Override
	public List<PaperQuestion> getTea_Paper(Tea_paper paper) {
		String questionId = paper.getQuestionId();
		//将题目ID拆分成数组
		String[] queId = questionId.split(",");
		String[] queScore = paper.getQueScore().split(",");
		//存储题目
		List<PaperQuestion> paperQuestion = new ArrayList<PaperQuestion>();
		for (int i = 0; i < queId.length; i++) {
			List<Question> question = questionDao.getQuestion(Integer.parseInt(queId[i]));
			PaperQuestion pq = new PaperQuestion();
			List<Option> option = new ArrayList<Option>();
			for (int j = 0; j < question.size(); j++) {//把从数据库取出的题目数据存储到题目实体
				Question que = question.get(j);
				if("题目".equals(que.getTitle())) {
					pq.setTitle(que.getValue());
				} else if("答案".equals(que.getTitle())) {
					pq.setAnswer(que.getValue());
				} else {
					option.add(new Option(que.getId(),que.getQueId(),que.getTitle().substring(2),que.getValue()));
				}
				pq.setQueId(que.getQueId());
				//判断题目类型
				int typeId = que.getTypeId();
				String typeStr = que_typeDao.getQue_typeById(typeId);
				if("选择题".equals(typeStr)){
					pq.setType(1);
				} else if("填空题".equals(typeStr)) {
					pq.setType(2);
				} else {
					pq.setType(3);
				}
			}
			pq.setScore(Integer.parseInt(queScore[i]));
			pq.setOption(option);
			paperQuestion.add(pq);
		}
		return paperQuestion;
	}

	@Override
	public ArrayList<PaperInfo> getAllTea_Paper() {
		return tea_paperDao.getAll();
	}

	@Override
	public List<PaperQuestion> getTea_PaperById(int paperId) {
		Tea_paper paper = tea_paperDao.getPaperById(paperId);
		String questionId = paper.getQuestionId();
		//将题目ID拆分成数组
		String[] queId = questionId.split(",");
		String[] queScore = paper.getQueScore().split(",");
		//存储题目
		List<PaperQuestion> paperQuestion = new ArrayList<PaperQuestion>();
		for (int i = 0; i < queId.length; i++) {
			List<Question> question = questionDao.getQuestion(Integer.parseInt(queId[i]));
			PaperQuestion pq = new PaperQuestion();
			List<Option> option = new ArrayList<Option>();
			for (int j = 0; j < question.size(); j++) {//把从数据库取出的题目数据存储到题目实体
				Question que = question.get(j);
				if("题目".equals(que.getTitle())) {
					pq.setTitle(que.getValue());
				} else if("答案".equals(que.getTitle())) {
					pq.setAnswer(que.getValue());
				} else {
					option.add(new Option(que.getId(),que.getQueId(),que.getTitle().substring(2),que.getValue()));
				}
				pq.setQueId(que.getQueId());
				//判断题目类型
				int typeId = que.getTypeId();
				String typeStr = que_typeDao.getQue_typeById(typeId);
				if("选择题".equals(typeStr)){
					pq.setType(1);
				} else if("填空题".equals(typeStr)) {
					pq.setType(2);
				} else {
					pq.setType(3);
				}
			}
			pq.setScore(Integer.parseInt(queScore[i]));
			pq.setOption(option);
			paperQuestion.add(pq);
		}
		return paperQuestion;	
	}

	@Override
	public Tea_paper getOneTea_Paper(int paperId) {
		return tea_paperDao.getPaperById(paperId);
	}

	@Override
	public ArrayList<SubjectInfo> getNoSubjectByName(String name) {
		return subjectDao.getNoCheckByName(name);
	}

}
