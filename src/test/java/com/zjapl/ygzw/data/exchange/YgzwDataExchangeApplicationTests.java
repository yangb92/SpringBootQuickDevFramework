package com.zjapl.ygzw.data.exchange;

import com.zjapl.ygzw.data.exchange.wsbs.dao.WsbsDnTaskGeneralBasicMapper;
import com.zjapl.ygzw.data.exchange.zww.dao.ZwwDnTaskGeneralBasicMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = YgzwDataExchangeApplication.class)
class YgzwDataExchangeApplicationTests {

    @Resource
    private WsbsDnTaskGeneralBasicMapper wsbs;

    @Resource
    private ZwwDnTaskGeneralBasicMapper zww;

    @Test
    public void testData(){
        int count1 = wsbs.selectCount(new com.zjapl.ygzw.data.exchange.wsbs.entity.DnTaskGeneralBasic());

        int count2 = zww.selectCount(new com.zjapl.ygzw.data.exchange.zww.entity.DnTaskGeneralBasic());

        System.out.println(count1 + "-" + count2);
    }
}
