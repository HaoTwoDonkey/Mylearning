package cn.com.hao.service;

import cn.com.hao.pojo.Items;
import cn.com.hao.pojo.ItemsCustom;

import java.util.List;

/**
 * @author : hao
 * @description :
 * @time : 2018/3/8 17:16
 */
public interface ItemsService {
    List<Items> findItemsListByName(String name);

    Integer addOrderItem(Items items);

    List<Items> findItemsListByPage(ItemsCustom itemsCustom);

    Integer queryListNumByPage(ItemsCustom itemsCustom);
}
