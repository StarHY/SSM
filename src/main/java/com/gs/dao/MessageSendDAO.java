package com.gs.dao;

import com.gs.bean.MessageSend;
import com.gs.bean.User;
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
public interface MessageSendDAO extends BaseDAO<String, MessageSend>{

    /**
     * 根据查询车主Id更新短信信息
     * @param idList
     * @param sendMsg
     * @return
     */
    public void batchUpdateBySendMsg(@Param("idList") String[] idList,
                                     @Param("sendMsg")String sendMsg);
    /**
     * 根据车主Id添加信息Id
     * @param msd
     * @return
     */
    public void addMessageId(List<MessageSend> msd);

    /**
     * 根据查询车主Id更新发送时间
     * @param idList
     * @return
     */
    public void batchUpdateBySuccess(@Param("idList")String[] idList);
}