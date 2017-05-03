package com.gs.service.impl;

import com.gs.bean.Company;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gs.dao.CompanyDAO;
import com.gs.service.CompanyService;
import com.gs.common.bean.Pager;
/**
*由Wjhsmart技术支持
*
*@author Wjhsmart
*@since 2017-04-14 16:58:54
*/
@Service
public class CompanyServiceImpl implements CompanyService {

	@Resource
	private CompanyDAO companyDAO;

	public int insert(Company company) { return companyDAO.insert(company); }
	public int batchInsert(List<Company> list) { return companyDAO.batchInsert(list); }
	public int delete(Company company) { return companyDAO.delete(company); }
	public int deleteById(String id) {
        return companyDAO.deleteById(id);
    }
	public int batchDelete(List<Company> list) { return companyDAO.batchDelete(list); }
	public int update(Company company) { return companyDAO.update(company); }
	public int batchUpdate(List<Company> list) { return companyDAO.batchUpdate(list); }
	public List<Company> queryAll() { return companyDAO.queryAll(); }
	public List<Company> queryByStatus(String status) { return companyDAO.queryByStatus(status); }
	public Company query(Company company) { return companyDAO.query(company); }
	public Company queryById(String id) { return companyDAO.queryById(id); }
	public List<Company> queryByPager(Pager pager) { return companyDAO.queryByPager(pager); }
	public int count() { return companyDAO.count(); }
	public int inactive(String id) { return companyDAO.inactive(id); }
	public int active(String id) { return companyDAO.active(id); }

	public List<Company> queryByStatusPager(String status,Pager pager) {
		return companyDAO.queryByStatusPager(status, pager);
	}

	public int statusCount(String status) {
		return companyDAO.statusCount(status);
	}
}