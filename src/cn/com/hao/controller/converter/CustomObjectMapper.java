package cn.com.hao.controller.converter;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : hao
 * @description :
 * @time : 2018/3/12 15:30
 */
public class CustomObjectMapper extends ObjectMapper {
    /**
     * 解决Date类型返回json格式为自定义格式
     */
    public CustomObjectMapper() {
        CustomSerializerFactory customSerializerFactory = new CustomSerializerFactory();
        customSerializerFactory.addGenericMapping(Date.class, new JsonSerializer<Date>() {
            @Override
            public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                jsonGenerator.writeString(sdf.format(date));
            }
        });
        this.setSerializerFactory(customSerializerFactory);
    }
}
