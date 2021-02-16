package com.phoenixhell.springcloud;

import com.phoenixhell.springcloud.bean.SeataOrder;
import com.phoenixhell.springcloud.mapper.SeataOrderMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestMBG {
    @Test
    public void test() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    @Autowired
    private SeataOrderMapper seataOrderMapper;
    //Test 跑单元测试是要求方法不能有参数和返回类型的
    //import org.junit.jupiter.api.Test;  必须是jupiter才生效
    @Test
    public void test2(){
        List<SeataOrder> seataOrders = seataOrderMapper.selectByExample(null);
        for (SeataOrder seataOrder : seataOrders) {
            System.out.println(seataOrder);
        }
    }
}
