package com.zzti.share.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzti.share.dao.Gold_logDao;
import com.zzti.share.dao.KnowledgeDao;
import com.zzti.share.dao.ProfessionDao;
import com.zzti.share.dao.PromotionDao;
import com.zzti.share.dao.Que_typeDao;
import com.zzti.share.dao.QuestionDao;
import com.zzti.share.dao.RechargeDao;
import com.zzti.share.dao.SchoolDao;
import com.zzti.share.dao.SubjectDao;
import com.zzti.share.dao.Tea_paperDao;
import com.zzti.share.dao.UserDao;
import com.zzti.share.dto.Option;
import com.zzti.share.dto.PaperInfo;
import com.zzti.share.dto.PaperQuestion;
import com.zzti.share.dto.QuestionInfo;
import com.zzti.share.dto.SubjectInfo;
import com.zzti.share.dto.UserInfo;
import com.zzti.share.entity.Gold_log;
import com.zzti.share.entity.Knowledge;
import com.zzti.share.entity.Profession;
import com.zzti.share.entity.Promotion;
import com.zzti.share.entity.Que_type;
import com.zzti.share.entity.Question;
import com.zzti.share.entity.School;
import com.zzti.share.entity.Subject;
import com.zzti.share.entity.Tea_paper;
import com.zzti.share.entity.User;
import com.zzti.share.service.CommonService;
import com.zzti.share.util.Utils;
@Service
public class CommonServiceImpl implements CommonService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Autowired
	private UserDao userDao;

	@Autowired
	private RechargeDao rechargeDao;
	
	@Autowired
	private PromotionDao promotionDao;
	
	@Autowired
	private Gold_logDao gold_logDao;
	
	@Autowired
	private SchoolDao schoolDao;
	
	@Autowired
	private ProfessionDao professionDao;
	
	@Autowired
	private SubjectDao subjectDao;
	
	@Autowired
	private Que_typeDao que_typeDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private KnowledgeDao knowledgeDao;
	
	@Autowired
	private Tea_paperDao tea_paperDao;
	
	@Override
	public User login(String phone, String password) {		
		return userDao.check(phone, password);
	}

	@Override
	public int register(String phone, String password,String username,int schoolId,int professionId,int identity) {
		User u1 = userDao.getUserByPhone(phone);
		if(u1 == null) {
			User user = new User();
			user.setPhone(phone);
			user.setPassword(password);
			user.setUsername(username);
			user.setSchoolId(schoolId);
			user.setProfessionId(professionId);
			user.setIdentity(identity);
			user.setTime(new Date());
			return userDao.addUser(user);
		}else{
			return 0;
		}
	}
	
	@Override
	public User getUser(String phone) {
		return userDao.getUserByPhone(phone);
	}
	
	@Override
	public int updatePassword(String phone, String password) {
		return userDao.updatePassword(phone, password);
	}

	@Override
	public int recharge(int userId, String gold, int count) {
		gold = gold.substring(0,gold.length() - 2);
		int goldnum = Integer.parseInt(gold);
		int sum = goldnum * count;
		return rechargeDao.addRecharge(userId, sum, new Date());
	}

	@Override
	public int promotion(int userId) {
		Promotion pro = promotionDao.getPromotionByUser(userId);
		if(pro == null) {
			System.out.println("推广记录为空");
			String ip = "zzti.share." + userId;
			Promotion promotion = new Promotion();
			promotion.setIp(ip);
			promotion.setUserId(userId);
			promotion.setSum(1);
			promotionDao.addPromotion(promotion);
		} else {
			System.out.println("推广记录已存在");
			int sum = pro.getSum();
			promotionDao.updateSum(userId, ++sum);
		}
		return 1;
	}

	@Override
	public ArrayList<School> getSchool() {
		return schoolDao.getAll();
	}

	@Override
	public ArrayList<Profession> getProfession() {
		return professionDao.getAll();
	}

	@Override
	public ArrayList<SubjectInfo> getSubjectInfo() {
		return subjectDao.getAllInfo();
	}

	@Override
	public ArrayList<Que_type> getQue_type(int subjectId) {
		return que_typeDao.getQue_typeBySubject(subjectId);
	}

	@Override
	public ArrayList<Knowledge> getKnowledge(int subjectId) {
		return knowledgeDao.getKnowledgeBySubject(subjectId);
	}

	@Override
	public ArrayList<QuestionInfo> getQuestion() {
		return questionDao.getAll();
	}

	@Override
	public QuestionInfo getQuestionInfoById(int queId) {
		return questionDao.getQuestionInfoByQueId(queId);
	}

	@Override
	public ArrayList<Question> getQuestionById(int queId) {
		return questionDao.getQuestionByQueId(queId);
	}

	@Override
	public ArrayList<Subject> getSubject() {
		return subjectDao.getAll();
	}

	@Override
	public SubjectInfo getSubjectInfoById(int id) {
		return subjectDao.getSubjectById(id);
	}

	@Override
	public int addLog(int userId, int gold, String service) {
		User user = userDao.getUserById(userId);
		userDao.updateGold(userId,user.getGold() + gold);
		System.out.println("用户金币已修改");
		Gold_log log = new Gold_log();
		log.setUserId(userId);
		log.setLog(service + "，金币收益 " + gold);
		log.setGold(gold);
		log.setTime(new Date());
		gold_logDao.addGold_log(log);
		System.out.println("金币记录已生成");
		return 1;
	}

	@Override
	public UserInfo getUserInfo(int id) {
		return userDao.getUserInfo(id);
	}

	@Override
	public int updateUserInfo(int userId, String username, String phone, int schoolId, int professionId) {
		User user = new User();
		user.setId(userId);
		user.setUsername(username);
		user.setPhone(phone);
		user.setSchoolId(schoolId);
		user.setProfessionId(professionId);
		return userDao.updateInfo(user);
	}

	@Override
	public ArrayList<Subject> getSubjectByPro(int professionId) {
		return subjectDao.getSubejctByProfession(professionId);
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
	public ArrayList<PaperInfo> getAllPaperByUser(int userId) {
		return tea_paperDao.getPaperByUser(userId);
	}

	@Override
	public ArrayList<PaperInfo> getAllPaperByName(String name) {
		return tea_paperDao.getPaperByName(name);
	}

	@Override
	public ArrayList<QuestionInfo> getQuestionByName(String name) {
		return questionDao.getQuestionByName(name);
	}

	@Override
	public ArrayList<SubjectInfo> getSubjectInfoByName(String name) {
		return subjectDao.getSubjectInfoByName(name);
	}
}
