package com.gs.controller;

import ch.qos.logback.classic.Logger;
import com.gs.bean.AccessoriesType;
import com.gs.common.bean.ControllerResult;
import com.gs.common.bean.Pager;
import com.gs.common.bean.Pager4EasyUI;
import com.gs.service.AccessoriesTypeService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
/**
 * Created by GOD on 2017/4/17.
 */
@Controller
@RequestMapping("accessoriesType")
public class AccessoriesTypeController {

    private Logger logger = (Logger) LoggerFactory.getLogger(AccessoriesTypeController.class);

    @Resource
    private AccessoriesTypeService accessoriesTypeService;

    @RequestMapping(value = "type", method = RequestMethod.GET)
    private String type() {
        logger.info("显示配件分类");
        return "accessories/accessories_type";
    }

    @RequestMapping(value = "stock", method = RequestMethod.GET)
    private String stock() {
        logger.info("显示配件信息");
        return "accessories/stock";
    }

    @ResponseBody
    @RequestMapping(value = "pager", method = RequestMethod.GET)
    public Pager4EasyUI<AccessoriesType> queryPager(@Param("pageNumber") String pageNumber, @Param("pageSize") String pageSize) {
        logger.info("分页查询");
        Pager pager = new Pager();
        pager.setPageNo(Integer.valueOf(pageNumber));
        pager.setPageSize(Integer.valueOf(pageSize));
        pager.setTotalRecords(accessoriesTypeService.count());
        List<AccessoriesType> accessoriesTypes = accessoriesTypeService.queryByPager(pager);
        return new Pager4EasyUI<AccessoriesType>(pager.getTotalRecords(), accessoriesTypes);
    }

    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ControllerResult addAccType(AccessoriesType accessoriesType) {
        logger.info("添加");
        System.out.println(accessoriesType);
        accessoriesType.setAccTypeStatus("Y");
        accessoriesTypeService.insert(accessoriesType);
        return ControllerResult.getSuccessResult("添加成功");
    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ControllerResult updateAccType(AccessoriesType accessoriesType) {
        logger.info("更新");
        accessoriesType.setAccTypeStatus("Y");
        accessoriesTypeService.update(accessoriesType);
        return ControllerResult.getSuccessResult("修改成功");
    }

    @ResponseBody
    @RequestMapping(value = "update_status", method = RequestMethod.GET)
    public ControllerResult updateStatus(@Param("id") String id, @Param("status") String status) {
        logger.info("更新状态");
        if (status.equals("Y")) {
            accessoriesTypeService.active(id);
        } else if (status.equals("N")) {
            accessoriesTypeService.inactive(id);
        }
        return ControllerResult.getSuccessResult("更新成功");
    }
}