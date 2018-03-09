package cn.com.hao.controller;

import cn.com.hao.pojo.Items;
import cn.com.hao.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author : hao
 * @description :
 * @time : 2018/3/8 14:26
 */
@Controller
public class ControllerOne {

    @Autowired
    private ItemsService itemsService;
    @RequestMapping("/query")
    public ModelAndView queryItems(@RequestParam(value = "name") String name){

        List<Items> itemsList = itemsService.findItemsListByName(name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",itemsList);

        modelAndView.setViewName("/itemsList");
        return  modelAndView;
    }
}
