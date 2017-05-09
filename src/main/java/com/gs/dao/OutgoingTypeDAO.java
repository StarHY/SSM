package com.gs.dao;

import com.gs.bean.OutgoingType;
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
public interface OutgoingTypeDAO extends BaseDAO<String, OutgoingType>{

    public OutgoingType queryByName(@Param("outTypeName") String outTypeName);

    public List<OutgoingType> queryPagerStatus(@Param("status")String status, @Param("pager")Pager pager);
    public int countStatus(String status);
}