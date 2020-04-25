package com.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ht.model.Goods;
import com.ht.model.GoodsExample;
import com.ht.model.UIGoodsImport;
import com.ht.model.UserGoods;

public interface GoodsMapper {
		int countByExample(GoodsExample example);

		int deleteByExample(GoodsExample example);

		int deleteByPrimaryKey(Integer id);

		int insert(Goods record);

		int insertSelective(Goods record);

		List<Goods> selectByExample(GoodsExample example);
		List<Goods> selectByExample2(GoodsExample example);

		Goods selectByPrimaryKey(Integer id); 

		int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

		int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

		int updateByPrimaryKeySelective(Goods record);

		int updateByPrimaryKey(Goods record);
		
		List<Goods> getGoodsByUserId(int userKey);
		
		List<Goods> getGoodsByUserIdNameLike(@Param("userKey") int userKey,@Param("gnameLike") String gnameLike);
		
		void addUserGoods(UserGoods userGoods);
		
		int getUserGoodsSeq(int userKey);
		
		List<Goods> getGoodsByIntEntreportId(int intEntreportId);
		
		UserGoods getUserGoods(UserGoods userGoods);
		
		List<Goods> select4Export(GoodsExample example);
		
		List<UIGoodsImport> checkExistence(String transInstkey);
		
		void addUIImport(UIGoodsImport ui);
		
		void cleanGoodsUI(String transInstkey);
}