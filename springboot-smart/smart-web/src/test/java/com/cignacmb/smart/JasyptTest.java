package com.cignacmb.smart;

import lombok.extern.java.Log;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: caokang
 * @Date: Created in 10:28 2020/4/27
 * @annotation:Jasypt加密数据库
 * @version:1.0
 * @TableName:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class JasyptTest {

    @Test
    public void contextLoads() {
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword("****");
        log.info("请将数据源的秘钥将application-dev.yml中的ENC()替换");
        log.info("主数据源的密码：" + basicTextEncryptor.encrypt("***"));
        log.info("副数据源的密码：" + basicTextEncryptor.encrypt("***"));
    }
}