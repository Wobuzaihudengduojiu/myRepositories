package com.zzti.share.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.zzti.share.entity.Promotion;

public interface PromotionDao {

	public int addPromotion(Promotion promotion);
	
	public ArrayList<Promotion> getAll();
	
	public Promotion getPromotionByUser(int userId);
	
	public int updateSum(@Param("userId") int userId,@Param("sum") int sum);
}
