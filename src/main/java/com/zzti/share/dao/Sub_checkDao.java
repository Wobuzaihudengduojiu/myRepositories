package com.zzti.share.dao;

import java.util.ArrayList;

import com.zzti.share.dto.SubjectCheck;
import com.zzti.share.entity.Sub_check;

public interface Sub_checkDao {

	public int addSub_check(Sub_check sub_check);
	
	public ArrayList<SubjectCheck> getSubBySubject(int subjectId);
	
}
