package cn.com.hao.controller;

import cn.com.hao.common.Result;
import cn.com.hao.common.ResultGenerator;
import cn.com.hao.pojo.Items;
import cn.com.hao.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : hao
 * @description : ¶©µ¥µÄController
 * @time : 2018/3/12 13:33
 */
@Controller
@RequestMapping("/orderList")
public class ControllerItems {

    @Autowired private ItemsService itemsService;
    @RequestMapping("/queryList")
    public @ResponseBody
    List<Items> queryOrderList(@RequestParam(value = "name") String name){

        List<Items> items = itemsService.findItemsListByName(name);
        if(items.size()==0){
            return new ArrayList<Items>(1);
        }
        return items;
    }
}
