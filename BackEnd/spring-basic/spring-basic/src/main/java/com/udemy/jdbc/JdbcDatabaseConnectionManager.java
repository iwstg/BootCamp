package com.udemy.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
@Component
public class JdbcDatabaseConnectionManager implements DatabaseConnectionManager{
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "devdb";
    private static final String PASSWORD = "devdb";


    @Override
    public Connection getConnection() throws SQLException {
        try{
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            log.info("DB 연결 성공: {}", connection);
            return connection;
        }catch(SQLException e){
            log.error("DB 연결 실패: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public void closeConnection(Connection connection) {
        if(connection != null){
            try {
                connection.close();
                log.info("DB 연결 종료");
            } catch (SQLException e) {
                log.error("DB 종료 실패 : {}", e.getMessage());
            }
        }
    }
}
