package cn.com.hao.controller;

import cn.com.hao.common.Result;
import cn.com.hao.common.ResultGenerator;
import cn.com.hao.pojo.Items;
import cn.com.hao.service.ItemsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping("/addItem")
    public String addOrderItem(Items items){
        log.debug("__________获取到名字没有"+items.getName());
        Integer lastId = itemsService.addOrderItem(items);
        if(lastId == null){
            return "error";
        }
        return lastId.toString();
    }
}
