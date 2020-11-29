//package com.example.webapp.service;///**
//
//import com.baomidou.mybatisplus.annotations.IdType;
//import com.baomidou.mybatisplus.generator.AutoGeneratorMy;
//import com.baomidou.mybatisplus.generator.ConfigGeneratorMy;
//
//import java.io.IOException;
//
//// */
//public class MybatisPlusGenerator {
//    public static void main(String[] args) throws IOException {
//
//        ConfigGeneratorMy cg = new ConfigGeneratorMy();
//        // 配置 MySQL 连接
//        cg.setDbDriverName("com.mysql.cj.jdbc.Driver");
//        cg.setDbUser("root");
//        cg.setDbPassword("lg123xx..");
//        cg.setDbUrl("jdbc:mysql://150.158.155.24/db1?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true");
//        // 配置包名
//        String[] table = {"user_img"};
//        cg.setTableNames(table);
//        cg.setBuliderModel(true);
//        cg.setResultMap(true);
//        cg.setFileOverride(true);
//        cg.setEntityPackage("com.example.webapp.domain.po");
//        cg.setMapperName("I%sMapper");
//        cg.setMapperPackage("com.example.webapp.dao");
//        cg.setServiceImplName("%sService");
//        cg.setServicePackage(null);
//        cg.setXmlPackage("com.example.webapp.mapper");
//        cg.setServiceImplPackage("com.example.webapp.service");
//        cg.setControllerPackage("com.example.webapp.web");
//
//        // 配置表主键策略
//        cg.setIdType(IdType.AUTO);
//
//        // 配置保存路径
//        cg.setSaveDir(System.getProperty("user.dir") + "/src/main/java/");
//        // 其他参数请根据上面的参数说明自行配置，当所有配置完善后，运行AutoGenerator.run()方法生成Code
//        // 生成代码
//        AutoGeneratorMy.run(cg);
//    }
//}