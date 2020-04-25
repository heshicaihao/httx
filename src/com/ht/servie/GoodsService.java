package com.ht.servie;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.ht.model.Goods;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;

public interface GoodsService {
	Goods getByKey(Integer instkey);
    PageResult<Goods> listPage(Goods goods);
	UIReturn save(Goods goodsEntity);
    UIReturn delete(int id);
    List<Goods> listGoodsByUserKey(int userKey);
    void importFile(MultipartFile file, HttpServletRequest req) throws Exception;
    List<Goods> listGoodsByUserKeyNameLike(int userKey,String nameLike);
}
