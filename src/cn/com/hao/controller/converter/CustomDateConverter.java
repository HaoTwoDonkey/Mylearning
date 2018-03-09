package cn.com.hao.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : hao
 * @description : 参数转换器 把字符串转换成日期
 * @time : 2018/3/8 16:56
 */
public class CustomDateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try{
            return simpleDateFormat.parse(source);
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
