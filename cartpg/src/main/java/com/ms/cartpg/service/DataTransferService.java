//package com.ms.cartpg.service;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DataTransferService {
////    @Autowired
////    private JdbcTemplate jdbcTemplate;
////
////    public void transferTableData(
////            String sourceDbname, String sourceUser, String sourcePassword, String sourceTable,
////            String targetDbname, String targetUser, String targetPassword
////    ) {
////        String sql = "SELECT transfer_table_data(?, ?, ?, ?, ?, ?, ?)";
////        jdbcTemplate.update(sql, sourceDbname, sourceUser, sourcePassword, sourceTable, targetDbname, targetUser, targetPassword);
////    }
//
//
//    private final JdbcTemplate sourceJdbcTemplate;
//    private final JdbcTemplate targetJdbcTemplate;
//
//    public DataTransferService(
//            @Qualifier("sourceDataSource") DataSource sourceDataSource,
//            @Qualifier("targetDataSource") DataSource targetDataSource
//    ) {
//        this.sourceJdbcTemplate = new JdbcTemplate(sourceDataSource);
//        this.targetJdbcTemplate = new JdbcTemplate(targetDataSource);
//    }
//
//    public void transferTableData(String sourceTable) {
//        String sql = "SELECT transfer_table_data(?, ?, ?, ?, ?, ?, ?)";
//        String sourceDbname = "source_dbname";
//        String sourceUser = "source_user";
//        String sourcePassword = "source_password";
//        String targetDbname = "target_dbname";
//        String targetUser = "target_user";
//        String targetPassword = "target_password";
//
//        sourceJdbcTemplate.update(sql, sourceDbname, sourceUser, sourcePassword, sourceTable, targetDbname, targetUser, targetPassword);
//    }
//}
//
