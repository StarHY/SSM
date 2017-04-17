package com.gs.service.impl;

import com.gs.bean.IncomingType;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gs.dao.IncomingTypeDAO;
import com.gs.service.IncomingTypeService;
import com.gs.common.bean.Pager;
/**
*由Wjhsmart技术支持
*
*@author Wjhsmart
*@since 2017-04-14 16:58:54
*/
@Service
public class IncomingTypeServiceImpl implements IncomingTypeService {

	@Resource
	private IncomingTypeDAO incomingTypeDAO;

	public int insert(IncomingType incomingType) { return incomingTypeDAO.insert(incomingType); }
	public int batchInsert(List<IncomingType> list) { return incomingTypeDAO.batchInsert(list); }
	public int delete(IncomingType incomingType) { return incomingTypeDAO.delete(incomingType); }
	public int deleteById(String id) {
        return incomingTypeDAO.deleteById(id);
    }
	public int batchDelete(List<IncomingType> list) { return incomingTypeDAO.batchDelete(list); }
	public int update(IncomingType incomingType) { return incomingTypeDAO.update(incomingType); }
	public int batchUpdate(List<IncomingType> list) { return incomingTypeDAO.batchUpdate(list); }
	public List<IncomingType> queryAll() { return incomingTypeDAO.queryAll(); }
	public List<IncomingType> queryByStatus(String status) { return incomingTypeDAO.queryByStatus(status); }
	public IncomingType query(IncomingType incomingType) { return incomingTypeDAO.query(incomingType); }
	public IncomingType queryById(String id) { return incomingTypeDAO.queryById(id); }
	public List<IncomingType> queryByPager(Pager pager) {
		return incomingTypeDAO.queryByPager(pager);
	}
	public int count() {
		return incomingTypeDAO.count();
	}
	public int inactive(String id) { return incomingTypeDAO.inactive(id); }
	public int active(String id) { return incomingTypeDAO.active(id); }

}