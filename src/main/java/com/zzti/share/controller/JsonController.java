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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzti.share.dto.PaperInfo;
import com.zzti.share.entity.Knowledge;
import com.zzti.share.entity.Que_type;
import com.zzti.share.entity.Subject;
import com.zzti.share.entity.User;
import com.zzti.share.service.CommonService;
import com.zzti.share.service.TeacherService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
public class JsonController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value = "/getKnowledge", method = RequestMethod.POST )
	private void getKnowledge(@Param("subject") String subject,HttpServletRequest req,HttpServletResponse res){
		System.out.println("getSubject" + subject);
		int i = Integer.parseInt(subject);
		List<Knowledge> knowledgeList = commonService.getKnowledge(i);
		req.getSession().setAttribute("knowledgeList", knowledgeList);
        try{
        	JSONArray json = JSONArray.fromObject(knowledgeList);  
        	System.out.println(json);
            //JSONObject是一个{}包裹起来的一个对象(Object)，此处希望以对象为单位进行操作，所以创建JSONObject对象  
            JSONObject jb = new JSONObject();  
            //将jsonArray对象装入  
            jb.put("knowledge", json);  
            //输出Json数据，它就是一种特殊格式的字符串  
            res.getWriter().write(jb.toString());  
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	@RequestMapping(value = "/getQueType", method = RequestMethod.POST )
	private void getQueType(@Param("subject") String subject,HttpServletRequest req,HttpServletResponse res){
		System.out.println("getSubject" + subject);
		int i = Integer.parseInt(subject);
		List<Que_type> que_typeList = commonService.getQue_type(i);
		req.getSession().setAttribute("que_typeList", que_typeList);
        try{
        	JSONArray json = JSONArray.fromObject(que_typeList);  
        	System.out.println(json);
            //JSONObject是一个{}包裹起来的一个对象(Object)，此处希望以对象为单位进行操作，所以创建JSONObject对象  
            JSONObject jb = new JSONObject();  
            //将jsonArray对象装入  
            jb.put("que_type", json);  
            //输出Json数据，它就是一种特殊格式的字符串  
            res.getWriter().write(jb.toString());  
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	@RequestMapping(value = "/getSubject", method = RequestMethod.POST )
	private void getSubject(@Param("profession") String profession,HttpServletRequest req,HttpServletResponse res){
		System.out.println("getSubject" + profession);
		int i = Integer.parseInt(profession);
		List<Subject> subjectList = commonService.getSubjectByPro(i);
		req.getSession().setAttribute("subjectList", subjectList);
        try{
        	JSONArray json = JSONArray.fromObject(subjectList);  
        	System.out.println(json);
            //JSONObject是一个{}包裹起来的一个对象(Object)，此处希望以对象为单位进行操作，所以创建JSONObject对象  
            JSONObject jb = new JSONObject();  
            //将jsonArray对象装入  
            jb.put("subject", json);  
            //输出Json数据，它就是一种特殊格式的字符串  
            res.getWriter().write(jb.toString());  
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	@RequestMapping(value = "/getPaper", method = RequestMethod.POST )
	private void getPaper(HttpServletRequest req,HttpServletResponse res){
		User user = (User) req.getSession().getAttribute("user");
		ArrayList<PaperInfo> paperList = commonService.getAllPaperByUser(user.getId());
		req.getSession().setAttribute("paperList", paperList);
        try{
        	JSONArray json = JSONArray.fromObject(paperList);  
        	System.out.println(json);
            //JSONObject是一个{}包裹起来的一个对象(Object)，此处希望以对象为单位进行操作，所以创建JSONObject对象  
            JSONObject jb = new JSONObject();  
            //将jsonArray对象装入  
            jb.put("subject", json);  
            //输出Json数据，它就是一种特殊格式的字符串  
            res.getWriter().write(jb.toString());  
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}
}
