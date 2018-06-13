package com.my.sample.core;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * Created by ehomeud on 2017/4/26.
 */

public class CustomGenerator {

    // 输出目录
    private static String outPutDir = "D:\\workspace\\idea\\ground-self\\sample-core\\src\\main\\java";
    private static String author = "shiyongbiao";
    private static String jdbcUrl = "jdbc:mysql://192.168.2.242:3306/employees?useUnicode=true&amp;characterEncoding=UTF-8&amp;generateSimpleParameterMetadata=true";
    private static String username = "root";
    private static String password = "root";

    private static String parent = "com.my.sample.core";

    private static String[] include = new String[]{};

    private static String[] exclude = new String[]{};

    public static void main(String[] args) throws InterruptedException {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outPutDir);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor(author);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        /*dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                return super.processTypeConvert(fieldType);
            }
        });*/

        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUrl(jdbcUrl);
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        // strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(include); // 需要生成的表
        strategy.setExclude(exclude); // 排除生成的表
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(parent);
        pc.setMapper("dao.mapper");
        pc.setXml("xml");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }

}