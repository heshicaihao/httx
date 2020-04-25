package com.ht.servie;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.ht.model.IntEntrepot;
import com.ht.model.IntEntrepotDetail;
import com.ht.model.PageResult;
import com.ht.model.UIReturn;
import com.ht.util.HTException;

public interface IntEntrepotService {


	
	IntEntrepot getByKey(Integer instkey);
	
    PageResult<IntEntrepot> listPage(IntEntrepot intEntrepot);
    
    PageResult<IntEntrepotDetail> listIntEntrepotDetailByIntEntrepotId(Integer id);
	UIReturn save(IntEntrepot intEntrepot);
    UIReturn delete(int id);
    UIReturn deleteDetails(int id);
	List<IntEntrepotDetail> get4ExportHGReport(int id);
	
	void saveDetails(IntEntrepotDetail intEntrepotDetail);
	
	void saveActNo(Map<String,Object> params) throws HTException ;

	void importFile(MultipartFile file, HttpServletRequest req) throws Exception;
}
