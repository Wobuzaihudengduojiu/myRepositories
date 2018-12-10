package com.zzti.share.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.zzti.share.dto.SubjectInfo;
import com.zzti.share.entity.Subject;

public interface SubjectDao {

	public int addSubject(Subject subject);
	
	public int updateCheck(@Param("id") int id,@Param("adminId") int adminId);
	
	public ArrayList<Subject> getAll();
	
	public ArrayList<Subject> getSubejctByProfession(int professionId);
	
	public SubjectInfo getSubjectById(int id);
	
	public Subject getSubjectByName(String subjectName);
	
	public ArrayList<SubjectInfo> getNoCheck();
	
	public ArrayList<SubjectInfo> getNoCheckByName(@Param("name") String name);
	
	public ArrayList<SubjectInfo> getAllInfo();
	
	public ArrayList<SubjectInfo> getSubjectInfoByName(@Param("name") String name);
}
