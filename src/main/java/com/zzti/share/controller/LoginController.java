package com.zzti.share.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zzti.share.entity.Admin;
import com.zzti.share.entity.Profession;
import com.zzti.share.entity.School;
import com.zzti.share.entity.User;
import com.zzti.share.service.AdminService;
import com.zzti.share.service.CommonService;


@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET )
	private String goLogin(HttpServletRequest req){
		String msg = req.getParameter("msg");
		req.setAttribute("msg", msg);
		return "login/login";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.POST )
	private String login(@Param("phone") String phone,@Param("password") String password,HttpServletRequest req,RedirectAttributes redirectAttributes){
		User user = commonService.login(phone, password);
		System.out.println(user);
		if(user == null) {
//			req.setAttribute("msg", "账号密码错误！");
//			redirectAttributes.addAttribute("msg", "账号密码错误！");
			Admin admin = adminService.login(phone, password);
			if(admin == null) {
				redirectAttributes.addFlashAttribute("msg", "账号密码错误！");
				return "redirect:/login/login";			
			} else {
				redirectAttributes.addFlashAttribute("user", admin);
				return "redirect:/admin/showMain";
			}
		} else {
			//req.getSession().setAttribute("user", user);
			redirectAttributes.addFlashAttribute("user", user);
			if(user.getIdentity()==1){
				return "redirect:/teacher/showMain";
			}else{
				return "redirect:/student/showMain";
			}
		}
		
	}
	
	@RequestMapping(value = "/doRegister", method = RequestMethod.GET )
	private String register(HttpServletRequest req){		
		ArrayList<School> schoolList = commonService.getSchool();
		req.getSession().setAttribute("schoolList", schoolList);
		
		ArrayList<Profession> professionList = commonService.getProfession();
		req.getSession().setAttribute("professionList", professionList);
		return "login/register";	
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST )
	private String register(@Param("phone") String phone,@Param("password") String password,
			@Param("username") String username,@Param("school") int school,@Param("profession") int profession,
			@Param("identity") int identity,HttpServletRequest req){
		int i = commonService.register(phone, password, username, school, profession, identity);
		if(i==0){
			req.setAttribute("msg", "账号已存在！");
			return "login/register";
		}else{
			req.getSession().setAttribute("msg", "注册成功！");
			return "login/login";			
		}		
	}
	
	@RequestMapping(value = "/findPwd", method = RequestMethod.GET )
	private String findPwd(HttpServletRequest req){		
		
		return "login/findPwd";	
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.POST )
	private String check(@Param("phone") String phone,HttpServletRequest req){
		User user = commonService.getUser(phone);
		if(user == null){
			req.setAttribute("msg", "手机号不存在！");
			return "login/findPwd";			
		}else{
			req.getSession().setAttribute("phone", user.getPhone());
			return "login/updatePwd";
		}
	}
	
	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST )
	private String updatePwd(@Param("phone") String phone,@Param("password") String password,HttpServletRequest req){		
		int i = commonService.updatePassword(phone, password);
		req.setAttribute("msg", "密码修改成功！");
		return "login/login";	
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET )
	private String login(HttpServletRequest req){
		req.getSession().removeAttribute("user");
		return "login/login";
	}
}
