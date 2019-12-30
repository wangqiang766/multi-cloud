package com.wq.multiuser;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {
   public static final String[] TABLE=new String[]{"user","order_pool"};
   public static final String[] TABLE_PRE=new String[]{};
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir")+"/multi-modules/multi-user";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("wangqiang766");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setBaseResultMap(true);
        gc.setEnableCache(true);
        gc.setBaseColumnList(true);
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://47.91.250.171:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("130173");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.wq.multiuser");
        pc.setXml("xml");
        pc.setEntity("domain.entity");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityColumnConstant(true);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(TABLE);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(TABLE_PRE);
        mpg.setStrategy(strategy);
        mpg.execute();
    }

}
