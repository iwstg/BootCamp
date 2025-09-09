package com.udemy.jdbc.controller;

import com.udemy.jdbc.domain.Users;

import com.udemy.jdbc.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/jdbc/users")
public class UsersController {
    private final UsersRepository usersRepository;

    @PostMapping
    public Users saveUser(@RequestBody Users user){
        log.info("사용자 등록 요청 : {}", user);
        return usersRepository.save(user);
    }

    @GetMapping("/{userId}")
    public Users findById(@PathVariable String userId){
        log.info("사용자 조회 요청 : {}", userId);
        return usersRepository.findById(userId);
    }

    @GetMapping
    public List<Users> findAll(){
        log.info("사용자 전체 조회 요청");
        return usersRepository.findAll();
    }

    @PutMapping("/{userId}")
    public Users updateuser(@RequestBody String userId, @RequestBody Users user){
        log.info("사용자 수정 요청 : {}", userId);
        user.setUserId(userId);
        return usersRepository.update(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId){
        log.info("사용자 수정 요청 : {}", userId);
        usersRepository.deleteById(userId);
    }
}
