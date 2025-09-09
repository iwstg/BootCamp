package com.udemy.jdbc;


import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnectionManager {
    Connection getConnection() throws SQLException;
    void closeConnection(Connection connection);
}
