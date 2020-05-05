//
//package com.example.webapp.service;
//
//import java.io.IOException;
//
//import com.baomidou.mybatisplus.generator.AutoGeneratorMy;
//import com.baomidou.mybatisplus.generator.ConfigGeneratorMy;
//
//import com.baomidou.mybatisplus.annotations.IdType;
//
//import javax.naming.ConfigurationException;
//
///***
// @ClassName :CustomGenerator
// *@Description :
// *@Author :xujialin
// *@CreationDate :2016年11月4日下午2:29:50
// */
//
//public class MybatisPlusGenerator {
//    public static void main(String[] args) throws ConfigurationException,
//            IOException {
//        ConfigGeneratorMy cg = new ConfigGeneratorMy();
//        // 配置 MySQL 连接
//        cg.setDbUrl("jdbc:mysql://18.163.206.217:3306/test");
//        cg.setDbUser("root");
//        cg.setDbPassword("lg123");
//        cg.setDbDriverName("com.mysql.jdbc.Driver");
//        // 配置包名
//        String[] table = {"user_info"};
//        cg.setTableNames(table);
//        cg.setBuliderModel(true);
//        cg.setResultMap(true);
//        cg.setFileOverride(true);
//        cg.setEntityPackage("com.example.webapp.po");
//        cg.setMapperName("I%sMapper");
//        cg.setMapperPackage("com.example.webapp.dao");
//        cg.setServiceImplName("%sService");
//        cg.setServicePackage("com.example.webapp.service.iService");
//        cg.setXmlPackage("com.example.webapp.dao");
//        cg.setServiceImplPackage("com.example.webapp.service");
//        cg.setControllerPackage("com.example.webapp.controller");
//
//        // 配置表主键策略
//        cg.setIdType(IdType.AUTO);
//
//        // 配置保存路径
//        cg.setSaveDir(System.getProperty("user.dir") + "/webdemo/src/main/java/");
//        // 其他参数请根据上面的参数说明自行配置，当所有配置完善后，运行AutoGenerator.run()方法生成Code
//        // 生成代码
//        AutoGeneratorMy.run(cg);
//    }
//}
//
