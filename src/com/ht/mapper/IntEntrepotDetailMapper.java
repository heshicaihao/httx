package com.ht.mapper;

import com.ht.model.IntEntrepotDetail;
import com.ht.model.IntEntrepotDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntEntrepotDetailMapper {
    int countByExample(IntEntrepotDetailExample example);

    int deleteByExample(IntEntrepotDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IntEntrepotDetail record);

    int insertSelective(IntEntrepotDetail record);

    List<IntEntrepotDetail> selectByExample(IntEntrepotDetailExample example);

    IntEntrepotDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IntEntrepotDetail record, @Param("example") IntEntrepotDetailExample example);

    int updateByExample(@Param("record") IntEntrepotDetail record, @Param("example") IntEntrepotDetailExample example);

    int updateByPrimaryKeySelective(IntEntrepotDetail record);

    int updateByPrimaryKey(IntEntrepotDetail record);
    
    List<IntEntrepotDetail> getDetails(int id);
    
    Integer getSeqNo(int userId);
    
    void updateActNo(IntEntrepotDetail rec);
    
    void addUI(IntEntrepotDetail intEntrepotDetail);
    
    List<String> checkUserGoods(@Param("userKey") int userKey, @Param("transInstKey") String transInstKey);
    
    void cleanUI(String transInstKey);
    
    void addImportDetails(@Param("transInstKey") String transInstKey, @Param("inOrderId") int inOrderId);
    
    List<IntEntrepotDetail> getDetailsListFromUI(String transInstKey);
    
    void updateTotalNum(@Param("instkey") String instkey,@Param("actNo") int actNo);
    
    List<String> checkInactiveGoods(@Param("userKey") int userKey, @Param("transInstKey") String transInstKey);
    
    List<IntEntrepotDetail> selectForUpdate(@Param("hiddenid") int hiddenid,@Param("list") List<Integer> ids);
}