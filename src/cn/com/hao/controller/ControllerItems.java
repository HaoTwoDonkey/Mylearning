package cn.com.hao.controller;

import cn.com.hao.annotation.AnnoLog;
import cn.com.hao.common.Result;
import cn.com.hao.common.ResultGenerator;
import cn.com.hao.pojo.Items;
import cn.com.hao.pojo.ItemsCustom;
import cn.com.hao.pojo.PageBean;
import cn.com.hao.service.ItemsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : hao
 * @description : 订单的Controller
 * @time : 2018/3/12 13:33
 */
@Controller
@RequestMapping("/orderList")
public class ControllerItems {

    @Autowired private ItemsService itemsService;
    private static final Logger log = Logger.getLogger(ControllerItems.class);

    @RequestMapping("/queryList")
    public @ResponseBody
    List<Items> queryOrderList(@RequestParam(value = "name",required = false) String name){

        List<Items> items = itemsService.findItemsListByName(name);
        if(items.size()==0){
            return new ArrayList<Items>(1);
        }
        return items;
    }

    @RequestMapping("/queryListByPage")
    @AnnoLog(operationType="查询商品列表分页")
    public @ResponseBody
    PageBean<Items> findItemsListByPage(ItemsCustom itemsCustom){

        PageHelper.startPage(itemsCustom.getPage(),itemsCustom.getRows());
        List<Items> items = itemsService.findItemsListByPage(itemsCustom);
        if(items.size()==0){
            return new PageBean(0,new ArrayList());
        }
        PageInfo<Items> pageInfo = new PageInfo<Items>(items);

        PageBean<Items> pageBean = new PageBean<Items>(pageInfo.getTotal(),pageInfo.getList());
        return pageBean;
    }



    @RequestMapping("/addItem")
    public @ResponseBody Result addOrderItem(Items items){
        log.debug("__________获取到名字没有"+items.getName());
        Integer lastId = itemsService.addOrderItem(items);
        if(lastId == null){
            return ResultGenerator.genFailResult("error");
        }
        return ResultGenerator.genSuccessResult(lastId);
    }
}
