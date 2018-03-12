package cn.com.hao.service.impl;

import cn.com.hao.mapper.ItemsMapper;
import cn.com.hao.pojo.Items;
import cn.com.hao.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : hao
 * @description :
 * @time : 2018/3/8 17:16
 */
@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> findItemsListByName(String name) {
        return itemsMapper.findItemsListByName(name);
    }

    @Override
    public Integer addOrderItem(Items items) {
        return itemsMapper.addOrderItem(items);
    }
}
