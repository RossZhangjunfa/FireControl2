package com.bolijiang3d.program.base;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 测试生成代码
 * </p>
 *
 * @author zjf
 * @date 2020/01/02
 */
public class Generator {

    public static void main(String[] arg) {
        String packageName = "com.bolijiang3d.program";   //包名称
        String moduleName = "";    //模块名称
        //多张表接着写
        generateByTables(packageName, moduleName,"admin");
    }

    private static void generateByTables(String packageName, String moduleName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();

        // 连接数据库
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)   //数据库类型
                .setUrl("jdbc:mysql://61.178.17.40:3306/moxi")
                .setUsername("tam")
                .setPassword("tam@root")
                .setDriverName("com.mysql.jdbc.Driver");

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //.setCapitalMode(true)
                // 公共父类
                //.setSuperEntityClass("")
                // 写于父类中的公共字段
                //.setSuperEntityColumns("id")
                // 实体类是否使用 Lombok 注释
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                // 公共父类
                //.setSuperControllerClass("")
                .setControllerMappingHyphenStyle(true)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组

        //项目路径 （子项目路径可以没有）
        //E:\ZJFProject\FireControl\fireControl-server\fireControl-business
        String projectPath = "E:/ZJFProject/FireControl/fireControl-server/fireControl-business";

        config.setActiveRecord(false)
                .setAuthor("zjf")
                .setOutputDir(projectPath + "/src/main/java")
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setFileOverride(true)
                .setActiveRecord(false)
                .setEnableCache(false)
                .setOpen(false)
                .setServiceName("%sService");
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setModuleName(moduleName)
                                //.setController("controller")
                );

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        //调整xml 生成路径
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/resources/mapper/" + moduleName + "/"
                        + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();
        templateConfig.setXml(null);    //去掉默认xml模板
        mpg.setTemplate(templateConfig);

        mpg.execute();
    }
}
