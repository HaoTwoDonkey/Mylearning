package cn.com.hao.mapper;



import cn.com.hao.pojo.ItemsCustom;
import cn.com.hao.pojo.ItemsQueryVo;

import java.util.List;

public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}