package com.gs.dao;

import com.gs.bean.MaintainFix;
import com.gs.bean.User;
import com.gs.common.bean.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*由Wjhsmart技术支持
*
*@author Wjhsmart
*@since 2017-04-14 16:35:15
*/
@Repository
public interface MaintainFixDAO extends BaseDAO<String, MaintainFix>{
    public List<MaintainFix> queryBymaintainPager(@Param("pager") Pager pager,@Param("user") User user);
    public int MaintainCont(User user);

    /*
    * 查询项目是维修还是保养
    * */
    public List<MaintainFix> queryByType(@Param("companyId")String companyId,@Param("maintainOrFix")String maintainOrFix);
}