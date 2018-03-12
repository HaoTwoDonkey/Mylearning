package cn.com.hao.service;

import cn.com.hao.pojo.Items;

import java.util.List;

/**
 * @author : hao
 * @description :
 * @time : 2018/3/8 17:16
 */
public interface ItemsService {
    List<Items> findItemsListByName(String name);

    Integer addOrderItem(Items items);
}
