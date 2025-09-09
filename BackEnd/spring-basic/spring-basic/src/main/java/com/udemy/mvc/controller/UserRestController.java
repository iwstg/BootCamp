package com.udemy.mvc.controller;

import com.udemy.mvc.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.udemy.mvc.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserRestController {
    private final UserService userService;

    /* 공통 JSON 응답 헬퍼 */
    private ResponseEntity<Map<String, String>> message(HttpStatus status, String key, String value) {
        Map<String, String> body = new HashMap<>();
        body.put(key, value);
        return ResponseEntity.status(status).body(body);
    }
    private ResponseEntity<Map<String, String>> okMsg(String msg) {
        return message(HttpStatus.OK, "message", msg);
    }
    private ResponseEntity<Map<String, String>> bad(String msg) {
        return message(HttpStatus.BAD_REQUEST, "error", msg);
    }
    private ResponseEntity<Map<String, String>> notFound(String msg) {
        return message(HttpStatus.NOT_FOUND, "error", msg);
    }

    @PostMapping("/create")
    public ResponseEntity<?> registerUser(@RequestBody User newUser) {
        try {
            User created = userService.createUser(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (IllegalArgumentException e) {
            log.warn("Create user validation error: {}", e.getMessage());
            return bad(e.getMessage());
        }
    }

    /** [슬라이드 151] 전체 조회 (GET) */
    @GetMapping("/list")
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/update/{userIdx}")
    public ResponseEntity<?> updateUser(@PathVariable Long userIdx, @RequestBody User updatedUser) {
        return userService.updateUser(userIdx, updatedUser)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{userIdx}")
    public ResponseEntity<?> getUser(@PathVariable Long userIdx) {
        return userService.getUserByIdx(userIdx)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> notFound("사용자를 찾을 수 없습니다."));
    }


    @DeleteMapping("/delete/{userIdx}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userIdx) {
        boolean deleted = userService.deleteUser(userIdx);
        return deleted ? okMsg("사용자가 성공적으로 삭제되었습니다.")
                : notFound("사용자를 찾을 수 없습니다.");
    }

}