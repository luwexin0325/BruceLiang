//
////import com.zeyiyouhuo.framework.generator.AutoGenerator;
////import com.zeyiyouhuo.framework.generator.config.DataSourceConfig;
////import com.zeyiyouhuo.framework.generator.config.GlobalConfig;
////import com.zeyiyouhuo.framework.generator.config.PackageConfig;
////import com.zeyiyouhuo.framework.generator.config.StrategyConfig;
////import com.zeyiyouhuo.framework.generator.config.rules.DbType;
////import com.zeyiyouhuo.framework.generator.config.rules.NamingStrategy;
//import org.junit.jupiter.api.Test;
//
///**
// * ${DESCRIPTION}
// *
// * @author -gj
// * @create 2018-01-22 9:16
// **/
//public class Generator {
//    @Test
//    public void generateCode() {
//        String moduleName = "stl";
//        String entityPackage = "com.demo.demo.entity." + moduleName;
//        String dtoPackage = "com.demo.demo.dto." + moduleName;
//        String servicePackage = "com.demo.demo.service." + moduleName;
//        String serviceImplPackage = "com.demo.demo.service.Impl."+ moduleName +".impl";
//        String mapperPackage = "com.demo.demo.mapper." + moduleName;
//        String controllerPackage = "com.demo.demo.controller." + moduleName;
//        String mapperXmlPackage = "com.demo.demo.mapper." + moduleName + ".xml";
//        String tablePrefix = "t_stl";
//        String[] tableNames = {"t_stl_salvage_amount"};
//
//        GlobalConfig config = new GlobalConfig();
//        config.setActiveRecord(false)
//                .setAuthor("lwx")
//                .setEnableCache(false)
//                .setOutputDir("F:\\codeGen")
//                .setBaseColumnList(true)
//                .setBaseResultMap(true)
//                .setFileOverride(true);
//        String dbUrl = "jdbc:mysql://localhost:3306/tms?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
//        DataSourceConfig dataSourceConfig = new DataSourceConfig();
//        dataSourceConfig.setDbType(DbType.MYSQL)
//                .setUrl(dbUrl)
//                .setUsername("root")
//                .setPassword("root")
//                .setDriverName("com.mysql.jdbc.Driver");
//        StrategyConfig strategyConfig = new StrategyConfig();
//        strategyConfig
//                .setCapitalMode(true)
//                .setEntityLombokModel(true)
//                .setDbColumnUnderline(true)
//                .setNaming(NamingStrategy.underline_to_camel)
//                .setTablePrefix(tablePrefix)
//                .setSuperEntityClass("com.zeyiyouhuo.framework.mybatis.entity.BaseEntity")
//                .setSuperEntityColumns(new String[] { "id","create_time","modify_time","delete_flag"})
//                .setRestControllerStyle(true)
//                .setEntityBooleanColumnRemoveIsPrefix(true)
//                .setSuperControllerClass("com.zeyiyouhuo.framework.controller.AbstractController")
//                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
//        config.setServiceName("%sService");
//        new AutoGenerator().setGlobalConfig(config)
//                .setDataSource(dataSourceConfig)
//                .setStrategy(strategyConfig)
//                .setPackageInfo(
//                        new PackageConfig()
//                                .setParent("")
//                                .setController(controllerPackage)
//                                .setEntity(entityPackage).setConverter(converterPackage)
//                                .setMapper(mapperPackage).setService(servicePackage).setServiceImpl(serviceImplPackage).setXml(mapperXmlPackage)
//                                .setDto(dtoPackage)
//                ).execute();
//    }
//
//
//}
