package com.udemy.jdbc.repository;

import com.udemy.jdbc.JdbcDatabaseConnectionManager;
import com.udemy.jdbc.domain.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class UsersRepository {
    private final JdbcDatabaseConnectionManager connManager;

    public UsersRepository(JdbcDatabaseConnectionManager connManager) {
        this.connManager = connManager;
    }

    // INSERT, UPDATE, DELETE, SELECT 추가

    // Insert
    public Users save(Users users) {
        String sql = "INSERT INTO users (userId, userName, age) VALUES (?, ?, ?)";
        try (Connection con = connManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, users.getUserId());
            pstmt.setString(2, users.getUserName());
            pstmt.setInt(3, users.getAge());
            pstmt.executeUpdate();

            log.info("사용자 등록 완료 : {}", users);
            return users;
        } catch (SQLException e) {
            throw new RuntimeException("사용자 등록 실패", e);
        }
    }

    // Select where
    public Users findById(String userId) {
        String sql = "SELECT * FROM users WHERE userId = ?";
        try (Connection con = connManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ;

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Users(
                        rs.getString("userId"),
                        rs.getString("userName"),
                        rs.getInt("age")
                );
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException("사용자 조회 실패 ", e);
        }
    }

    // select *
    public List<Users> findAll() {
        String sql = "SELECT * FROM users";
        List<Users> result = new ArrayList<>();

        try (Connection con = connManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                result.add(new Users(
                        rs.getString("userId"),
                        rs.getString("userName"),
                        rs.getInt("age"))
                );
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException("사용자 조회 실패", e);
        }
    }


    // Update
    public Users update(Users users) {
        String sql = "UPDATE users SET userName =?, age =? WHERE userId = ?";
        try (Connection con = connManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, users.getUserName());
            pstmt.setInt(2, users.getAge());
            pstmt.setString(3, users.getUserId());
            pstmt.executeUpdate();

            log.info("사용자 수정 완료 : {}", users);
            return users;
        } catch (SQLException e) {
            throw new RuntimeException("사용자 등록 실패", e);
        }
    }

    //DELETE
    public void deleteById(String userId) {
        String sql = "DELETE FROM users WHERE userId = ?";
        try (Connection con = connManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            pstmt.executeUpdate();

            log.info("✅ 사용자 삭제 완료: {}", userId);

        } catch (SQLException e) {
            throw new RuntimeException("사용자 삭제 실패", e);
        }
    }
}