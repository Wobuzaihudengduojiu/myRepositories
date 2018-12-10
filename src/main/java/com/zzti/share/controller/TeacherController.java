package com.zzti.share.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
import com.zzti.share.service.CommonService;
import com.zzti.share.service.TeacherService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("teacher")
public class TeacherController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value = "/goMain", method = RequestMethod.GET)
	private String goMain(HttpServletRequest req){	
		User user = (User) req.getSession().getAttribute("user");
		ArrayList<PaperInfo> paperList = commonService.getAllPaperByUser(user.getId());
		req.getSession().setAttribute("paperList", paperList);
		return "teacher/mainTea";		
	}
	
	@RequestMapping(value = "/showMain", method = RequestMethod.GET)
	private String showMain(@ModelAttribute("user") User user,HttpServletRequest req){
		req.getSession().setAttribute("user", user);
		ArrayList<PaperInfo> paperList = commonService.getAllPaperByUser(user.getId());
		req.getSession().setAttribute("paperList", paperList);
		return "teacher/mainTea";		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET )
	private String logout(HttpServletRequest req){
		req.getSession().removeAttribute("user");
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/doAddQuestion", method = RequestMethod.GET)
	private String doAddQuestion(HttpServletRequest req){
		ArrayList<Subject> subjectList = commonService.getSubject();
		req.getSession().setAttribute("subjectList", subjectList);
		ArrayList<Que_type> que_typeList = commonService.getQue_type(1);
		req.getSession().setAttribute("que_typeList", que_typeList);
		ArrayList<Knowledge> knowledgeList = commonService.getKnowledge(1);
		req.getSession().setAttribute("knowledgeList", knowledgeList);
		return "teacher/addQuestion";		
	}
	
	@RequestMapping(value = "/addxuanze", method = RequestMethod.POST )
	private String addxuanze(@Param("subject") int subject,@Param("que_type") int que_type,
			@Param("knowledge") int knowledge,@Param("lv") int lv,@Param("title") String title,
			@Param("answer") String answer,@Param("txt") String txt,HttpServletRequest req){
		User user = (User) req.getSession().getAttribute("user");
		int queId = teacherService.getLast();
		teacherService.addQuestion(queId, "题目", title, knowledge, que_type, subject, user.getId(), lv);
		teacherService.addQuestion(queId, "答案", answer, knowledge, que_type, subject, user.getId(), lv);
		teacherService.addXuanze(queId, txt, knowledge, que_type, subject, user.getId(), lv);
		commonService.addLog(user.getId(), 1, "增加题目");
		return "teacher/addQuestion";
	}
	
	@RequestMapping(value = "/addtiankong", method = RequestMethod.POST )
	private String addtiankong(@Param("subject") int subject,@Param("que_type") int que_type,
			@Param("knowledge") int knowledge,@Param("lv") int lv,@Param("title") String title,
			@Param("txt") String txt,HttpServletRequest req){
		User user = (User) req.getSession().getAttribute("user");
		int queId = teacherService.getLast();
		teacherService.addQuestion(queId, "题目", title, knowledge, que_type, subject, user.getId(), lv);
		teacherService.addTiankong(queId, txt, knowledge, que_type, subject, user.getId(), lv);
		commonService.addLog(user.getId(), 1, "增加题目");
		return "teacher/addQuestion";
	}
	
	@RequestMapping(value = "/addqita", method = RequestMethod.POST )
	private String addqita(@Param("subject") int subject,@Param("que_type") int que_type,
			@Param("knowledge") int knowledge,@Param("lv") int lv,@Param("title") String title,
			@Param("txt") String txt,HttpServletRequest req){
		System.out.println(txt);
		User user = (User) req.getSession().getAttribute("user");
		int queId = teacherService.getLast();
		teacherService.addQuestion(queId, "题目", title, knowledge, que_type, subject, user.getId(), lv);
		teacherService.addQita(queId, txt, knowledge, que_type, subject, user.getId(), lv);
		commonService.addLog(user.getId(), 1, "增加题目");
		return "teacher/addQuestion";
	}
	
	@RequestMapping(value = "/doAddSubject", method = RequestMethod.GET)
	private String doAddSubject(HttpServletRequest req){
		ArrayList<Profession> professionList = commonService.getProfession();
		req.getSession().setAttribute("professionList", professionList);
		return "teacher/addSubject";		
	}
	
	@RequestMapping(value = "/addSubject", method = RequestMethod.POST )
	private String addSubject(@Param("profession") int profession,@Param("subject") String subject,
			@Param("txt") String txt,HttpServletRequest req){
		User user = (User) req.getSession().getAttribute("user");
		teacherService.addSubject(subject, profession, user.getId());
		int subject_id = teacherService.getSubjectId(subject);
		teacherService.addKnowledge(txt, subject_id);
		return "teacher/mainTea";
	}
	
	@RequestMapping(value = "/doQuestionList", method = RequestMethod.GET)
	private String doQuestionList(HttpServletRequest req){
		ArrayList<QuestionInfo> questionList = commonService.getQuestion();
		req.getSession().setAttribute("questionList", questionList);
		return "teacher/questionList";
	}
	
	@RequestMapping(value = "/getQuestion", method = RequestMethod.GET)
	private String getQuestion(@Param("queId") int queId,HttpServletRequest req){
		QuestionInfo questionInfo = commonService.getQuestionInfoById(queId);
		req.getSession().setAttribute("questionInfo", questionInfo);
		ArrayList<Question> questionList = commonService.getQuestionById(queId);
		req.getSession().setAttribute("questionList", questionList);
		return "teacher/questionInfo";
	}
	
	@RequestMapping(value = "/doSubjectList", method = RequestMethod.GET)
	private String doSubjectList(HttpServletRequest req){
		ArrayList<SubjectInfo> subjectList = commonService.getSubjectInfo();
		req.getSession().setAttribute("subjectList", subjectList);
		return "teacher/subjectList";
	}
	
	@RequestMapping(value = "/getSubjectById", method = RequestMethod.GET)
	private String getSubjectById(@Param("id") int id,HttpServletRequest req){
		SubjectInfo subjectInfo = commonService.getSubjectInfoById(id);
		req.getSession().setAttribute("subjectInfo", subjectInfo);
		ArrayList<Knowledge> knowledgeList = commonService.getKnowledge(id);
		req.getSession().setAttribute("knowledgeList", knowledgeList);
		return "teacher/subjectInfo";
	}
	
	@RequestMapping(value = "/doSubjectCheckList", method = RequestMethod.GET)
	private String doSubjectCheckList(HttpServletRequest req){
		ArrayList<SubjectInfo> subjectList = teacherService.getNoCheckSubject();
		req.getSession().setAttribute("subjectList", subjectList);
		return "teacher/subjectCheckList";
	}
	
	@RequestMapping(value = "/getSubjectCheck", method = RequestMethod.GET)
	private String getSubjectCheck(@Param("id") int id,HttpServletRequest req){
		SubjectInfo subjectInfo = commonService.getSubjectInfoById(id);
		req.getSession().setAttribute("subjectInfo", subjectInfo);
		ArrayList<Knowledge> knowledgeList = commonService.getKnowledge(id);
		req.getSession().setAttribute("knowledgeList", knowledgeList);
		return "teacher/subjectCheckInfo";
	}
	
	@RequestMapping(value = "/addSub_check", method = RequestMethod.GET)
	private String addSub_check(@Param("ischeck") int ischeck,HttpServletRequest req){
		SubjectInfo subjectInfo = (SubjectInfo) req.getSession().getAttribute("subjectInfo");
		System.out.println(subjectInfo.getId());
		User user = (User) req.getSession().getAttribute("user");		
		System.out.println(user.getId());
		teacherService.checkSubject(user.getId(), subjectInfo.getId(), ischeck);
		commonService.addLog(user.getId(), 1, "审核科目");
		return "teacher/subjectCheckList";
	}
	
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
	private String getUserInfo(HttpServletRequest req){
		User user = (User) req.getSession().getAttribute("user");		
		UserInfo userInfo = commonService.getUserInfo(user.getId());
		req.getSession().setAttribute("userInfo", userInfo);
		return "teacher/teacherInfo";
	}
	
	@RequestMapping(value = "/doUpdateUserInfo", method = RequestMethod.GET)
	private String doUpdateUserInfo(HttpServletRequest req){
		User user = (User) req.getSession().getAttribute("user");
		req.getSession().setAttribute("user", user);
		
		ArrayList<School> schoolList = commonService.getSchool();
		req.getSession().setAttribute("schoolList", schoolList);
		
		ArrayList<Profession> professionList = commonService.getProfession();
		req.getSession().setAttribute("professionList", professionList);
		return "teacher/updateUserInfo";
	}
	
	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST )
	private String updateUserInfo(@Param("username") String username,@Param("phone") String phone,
			@Param("school") int school,@Param("profession") int profession,HttpServletRequest req){
		User user = (User) req.getSession().getAttribute("user");
		commonService.updateUserInfo(user.getId(), username, phone, school, profession);
		return "redirect:getUserInfo";
	}
	
	@RequestMapping(value = "/doUpdatePwd", method = RequestMethod.GET)
	private String doUpdatePwd(HttpServletRequest req){
		User user = (User) req.getSession().getAttribute("user");
		req.getSession().setAttribute("user", user);
		return "teacher/updatePwd";
	}
	
	@RequestMapping(value = "/goAddTeaPaper", method = RequestMethod.GET)
	private String goAddTeaPaper(HttpServletRequest req){
		ArrayList<Profession> professionList = commonService.getProfession();
		req.getSession().setAttribute("professionList", professionList);
		ArrayList<Subject> subjectList = commonService.getSubject();
		req.getSession().setAttribute("subjectList", subjectList);
		ArrayList<Que_type> que_typeList = commonService.getQue_type(1);
		req.getSession().setAttribute("que_typeList", que_typeList);
		ArrayList<Knowledge> knowledgeList = commonService.getKnowledge(1);
		req.getSession().setAttribute("knowledgeList", knowledgeList);
		return "teacher/addTeaPaper";
	}
	
	@RequestMapping(value = "/addTeaPaper", method = RequestMethod.POST )
	private String addTeaPaper(@Param("teaPaper") String teaPaper,
			@Param("subject") int subject,@Param("knowledge") String knowledge,
			@Param("que_type") String que_type,@Param("qtnum") String qtnum,
			@Param("qtscore") String qtscore,@Param("lv") int lv,HttpServletRequest req){
		User user = (User) req.getSession().getAttribute("user");
		Tea_paper paper = teacherService.addPaper(teaPaper, subject, knowledge, que_type, qtnum, qtscore, lv, user.getId(), user.getSchoolId());
		commonService.addLog(user.getId(), -10, "智能组卷");
		int id = paper.getId();
		return "redirect:getTeaPaperById?id="+id;
	}
	
	@RequestMapping(value = "/goTeaPaperList", method = RequestMethod.GET)
	private String goTeaPaperList(HttpServletRequest req){
		ArrayList<PaperInfo> paperList = teacherService.getAllTea_Paper();
		req.getSession().setAttribute("paperList", paperList);
		return "teacher/paperList";
	}
	
	@RequestMapping(value = "/getTeaPaperById", method = RequestMethod.GET)
	private String getTeaPaperById(@Param("id") int id,HttpServletRequest req){
		List<PaperQuestion> paperQuestionList = teacherService.getTea_PaperById(id);
		req.getSession().setAttribute("paperQuestionList", paperQuestionList);
		req.getSession().setAttribute("num", paperQuestionList.size());
		Tea_paper tea_paper = teacherService.getOneTea_Paper(id);
		req.getSession().setAttribute("teaPaper", tea_paper);
		return "teacher/paperInfo";
	}
	
	@RequestMapping(value = "/goRecharge", method = RequestMethod.GET)
	private String goRecharge(HttpServletRequest req){
		
		return "teacher/recharge";
	}
	
	@RequestMapping(value = "/doRecharge", method = RequestMethod.GET)
	private String doRecharge(@Param("gold") String gold,@Param("count") int count
			,HttpServletRequest req){
		User user = (User) req.getSession().getAttribute("user");
		commonService.recharge(user.getId(), gold, count);
		return "redirect:getUserInfo";
	}
	
	@RequestMapping(value = "/selectPaper", method = RequestMethod.GET)
	private String selectPaper(@Param("name") String name, HttpServletRequest req){
		ArrayList<PaperInfo> paperList = commonService.getAllPaperByName(name);
		req.getSession().setAttribute("paperList", paperList);
		return "teacher/paperList";
	}
	
	@RequestMapping(value = "/selectQuestion", method = RequestMethod.GET)
	private String selectQuestion(@Param("name") String name, HttpServletRequest req){
		ArrayList<QuestionInfo> questionList = commonService.getQuestionByName(name);
		req.getSession().setAttribute("questionList", questionList);
		return "teacher/questionList";
	}
	
	@RequestMapping(value = "/selectSubject", method = RequestMethod.GET)
	private String selectSubject(@Param("name") String name, HttpServletRequest req){
		ArrayList<SubjectInfo> subjectList = commonService.getSubjectInfoByName(name);
		req.getSession().setAttribute("subjectList", subjectList);
		return "teacher/subjectList";
	}
	
	@RequestMapping(value = "/selectCheckList", method = RequestMethod.GET)
	private String selectCheckList(@Param("name") String name, HttpServletRequest req){
		ArrayList<SubjectInfo> subjectList = teacherService.getNoSubjectByName(name);
		req.getSession().setAttribute("subjectList", subjectList);
		return "teacher/subjectCheckList";
	}
}
