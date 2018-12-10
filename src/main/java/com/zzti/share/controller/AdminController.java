package com.zzti.share.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzti.share.dto.PaperInfo;
import com.zzti.share.dto.PaperQuestion;
import com.zzti.share.dto.QuestionInfo;
import com.zzti.share.dto.RechargeInfo;
import com.zzti.share.dto.SubjectCheck;
import com.zzti.share.dto.SubjectInfo;
import com.zzti.share.dto.UserInfo;
import com.zzti.share.entity.Admin;
import com.zzti.share.entity.Knowledge;
import com.zzti.share.entity.Profession;
import com.zzti.share.entity.Question;
import com.zzti.share.entity.Recharge;
import com.zzti.share.entity.School;
import com.zzti.share.entity.Tea_paper;
import com.zzti.share.entity.User;
import com.zzti.share.service.AdminService;
import com.zzti.share.service.CommonService;


@Controller
@RequestMapping("admin")
public class AdminController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/goMain", method = RequestMethod.GET)
	private String main(HttpServletRequest req){	
		ArrayList<SubjectInfo> subjectList = adminService.getNoCheckSubject();
		req.getSession().setAttribute("subjectList", subjectList);
		List<RechargeInfo> rechargeList = adminService.getNoRecharge();
		req.getSession().setAttribute("rechargeList", rechargeList);
		return "admin/mainAdm";		
	}
	
	@RequestMapping(value = "/showMain", method = RequestMethod.GET)
	private String main(@ModelAttribute("user") Admin admin,HttpServletRequest req){
		ArrayList<SubjectInfo> subjectList = adminService.getNoCheckSubject();
		req.getSession().setAttribute("subjectList", subjectList);
		List<RechargeInfo> rechargeList = adminService.getNoRecharge();
		req.getSession().setAttribute("rechargeList", rechargeList);
		req.getSession().setAttribute("user", admin);
		return "admin/mainAdm";		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET )
	private String login(HttpServletRequest req){
		req.getSession().removeAttribute("user");
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/doQuestionList", method = RequestMethod.GET)
	private String doQuestionList(HttpServletRequest req){
		ArrayList<QuestionInfo> questionList = commonService.getQuestion();
		req.getSession().setAttribute("questionList", questionList);
		return "admin/questionList";
	}
	
	@RequestMapping(value = "/getQuestion", method = RequestMethod.GET)
	private String getQuestion(@Param("queId") int queId,HttpServletRequest req){
		QuestionInfo questionInfo = commonService.getQuestionInfoById(queId);
		req.getSession().setAttribute("questionInfo", questionInfo);
		ArrayList<Question> questionList = commonService.getQuestionById(queId);
		req.getSession().setAttribute("questionList", questionList);
		return "admin/questionInfo";
	}
	
	@RequestMapping(value = "/doSubjectList", method = RequestMethod.GET)
	private String doSubjectList(HttpServletRequest req){
		ArrayList<SubjectInfo> subjectList = commonService.getSubjectInfo();
		req.getSession().setAttribute("subjectList", subjectList);
		return "admin/subjectList";
	}
	
	@RequestMapping(value = "/getSubjectById", method = RequestMethod.GET)
	private String getSubjectById(@Param("id") int id,HttpServletRequest req){
		SubjectInfo subjectInfo = commonService.getSubjectInfoById(id);
		req.getSession().setAttribute("subjectInfo", subjectInfo);
		ArrayList<Knowledge> knowledgeList = commonService.getKnowledge(id);
		req.getSession().setAttribute("knowledgeList", knowledgeList);
		return "admin/subjectInfo";
	}
	
	@RequestMapping(value = "/getNoSubject", method = RequestMethod.GET)
	private String getNoSubject(HttpServletRequest req){
		ArrayList<SubjectInfo> subjectList = adminService.getNoCheckSubject();
		req.getSession().setAttribute("subjectList", subjectList);
		return "admin/subjectCheckList";
	}
	
	@RequestMapping(value = "/getNoSubjectById", method = RequestMethod.GET)
	private String getNoSubjectById(@Param("id") int id,HttpServletRequest req){
		ArrayList<SubjectCheck> subjectCheckList = adminService.selectSub_check(id);
		req.getSession().setAttribute("subjectCheckList", subjectCheckList);
		req.getSession().setAttribute("subjectId", id);
		return "admin/subjectCheckInfo";
	}
	
	@RequestMapping(value = "/doCheckSubject", method = RequestMethod.GET)
	private String doCheckSubject(@Param("ischeck") int ischeck,HttpServletRequest req){
		if(ischeck == 1) {
			Admin admin = (Admin) req.getSession().getAttribute("user");
			int subjectId = (int) req.getSession().getAttribute("subjectId");
			adminService.checkSubject(subjectId, admin.getId());
		}
		return "redirect:/admin/getNoSubject";
	}
	
	@RequestMapping(value = "/getAdminInfo", method = RequestMethod.GET)
	private String getUserInfo(HttpServletRequest req){
		Admin a = (Admin) req.getSession().getAttribute("user");
		Admin admin = adminService.getAdmin(a.getId());
		req.getSession().setAttribute("userInfo", admin);
		return "admin/adminInfo";
	}
	
	@RequestMapping(value = "/doUpdateAdminInfo", method = RequestMethod.GET)
	private String doUpdateUserInfo(HttpServletRequest req){
		Admin admin = (Admin) req.getSession().getAttribute("user");
		req.getSession().setAttribute("user", admin);
		return "admin/updateAdminInfo";
	}
	
	@RequestMapping(value = "/updateAdminInfo", method = RequestMethod.POST )
	private String updateUserInfo(@Param("username") String username,@Param("phone") String phone,
			HttpServletRequest req){
		Admin admin = (Admin) req.getSession().getAttribute("user");
		adminService.updateInfo(phone, username);
		return "redirect:getAdminInfo";
	}
	
	@RequestMapping(value = "/doUpdatePwd", method = RequestMethod.GET)
	private String doUpdatePwd(HttpServletRequest req){
		Admin admin = (Admin) req.getSession().getAttribute("user");
		req.getSession().setAttribute("user", admin);
		return "admin/updatePwd";
	}
	
	@RequestMapping(value = "/goTeaPaperList", method = RequestMethod.GET)
	private String goTeaPaperList(HttpServletRequest req){
		ArrayList<PaperInfo> paperList = commonService.getAllTea_Paper();
		req.getSession().setAttribute("paperList", paperList);
		return "admin/paperList";
	}
	
	@RequestMapping(value = "/getTeaPaperById", method = RequestMethod.GET)
	private String getTeaPaperById(@Param("id") int id,HttpServletRequest req){
		List<PaperQuestion> paperQuestionList = commonService.getTea_PaperById(id);
		req.getSession().setAttribute("paperQuestionList", paperQuestionList);
		req.getSession().setAttribute("num", paperQuestionList.size());
		Tea_paper tea_paper = commonService.getOneTea_Paper(id);
		req.getSession().setAttribute("teaPaper", tea_paper);
		return "admin/paperInfo";
	}
	
	@RequestMapping(value = "/getNoRecharge", method = RequestMethod.GET)
	private String getNoRecharge(HttpServletRequest req){
		List<RechargeInfo> rechargeList = adminService.getNoRecharge();
		req.getSession().setAttribute("rechargeList", rechargeList);
		return "admin/rechargeList";
	}

	@RequestMapping(value = "/getRechargeById", method = RequestMethod.GET)
	private String getRechargeById(@Param("id") int id, @Param("check") int check ,
			HttpServletRequest req){
		Admin admin = (Admin) req.getSession().getAttribute("user");
		System.out.println(admin.getId());
		adminService.checkRecharge(id, admin.getId(), check);
		Recharge recharge = adminService.getRechargeById(id);
		if (check == 1) {
			commonService.addLog(recharge.getUserId(), recharge.getSum(), "金币充值");
		}
		return "redirect:getNoRecharge";
	}
	
	@RequestMapping(value = "/selectPaper", method = RequestMethod.GET)
	private String selectPaper(@Param("name") String name, HttpServletRequest req){
		ArrayList<PaperInfo> paperList = commonService.getAllPaperByName(name);
		req.getSession().setAttribute("paperList", paperList);
		return "admin/paperList";
	}
	
	@RequestMapping(value = "/selectQuestion", method = RequestMethod.GET)
	private String selectQuestion(@Param("name") String name, HttpServletRequest req){
		ArrayList<QuestionInfo> questionList = commonService.getQuestionByName(name);
		req.getSession().setAttribute("questionList", questionList);
		return "admin/questionList";
	}
	
	@RequestMapping(value = "/selectSubject", method = RequestMethod.GET)
	private String selectSubject(@Param("name") String name, HttpServletRequest req){
		ArrayList<SubjectInfo> subjectList = commonService.getSubjectInfoByName(name);
		req.getSession().setAttribute("subjectList", subjectList);
		return "admin/subjectList";
	}
	
	@RequestMapping(value = "/selectCheckList", method = RequestMethod.GET)
	private String selectCheckList(@Param("name") String name, HttpServletRequest req){
		ArrayList<SubjectInfo> subjectList = adminService.getNoSubjectByName(name);
		req.getSession().setAttribute("subjectList", subjectList);
		return "admin/subjectCheckList";
	}
}
