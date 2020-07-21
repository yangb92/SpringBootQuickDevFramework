package com.zjapl.ygzw.data.exchange;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

// 关闭默认的数据源配置
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class YgzwDataExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(YgzwDataExchangeApplication.class, args);
    }

}
