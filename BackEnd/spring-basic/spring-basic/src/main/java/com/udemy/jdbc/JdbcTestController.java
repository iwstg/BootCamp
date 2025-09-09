package com.udemy.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
public class JdbcTestController {
    private final JdbcDatabaseConnectionManager connManager = new  JdbcDatabaseConnectionManager();

    @GetMapping("/jdbc/test")
    public String testConnection(){
        try(Connection conn = connManager.getConnection()){
            return "DB 연결 성공 " + conn.getMetaData().getURL();
        }catch (SQLException e){
            return "DB 연결 실패 " + e.getMessage();
        }
    }
}
