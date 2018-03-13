package cn.com.hao.pojo;

/**
 * 
 * <p>Title: ItemsCustom</p>
 * <p>Description: 商品信息的扩展类</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-13下午3:24:05
 * @version 1.0
 */
public class ItemsCustom extends Items {
    /**
     * 第几页
     */
	Integer page;
    /**
     * 每页多少数据
     */
	Integer rows;
    /**
     * 分页开始的条数
     */
	Integer startNum ;

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
