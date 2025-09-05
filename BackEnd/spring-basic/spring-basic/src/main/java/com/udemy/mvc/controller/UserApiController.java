package com.udemy.mvc.controller;

import com.udemy.mvc.domain.User;
import com.udemy.mvc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserApiController {
    private final UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User req){
        User saved = userRepository.save(req);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/list") // "/users/list"전체검색 "/users/list?name=hello"아이디검색
    public ResponseEntity<List<User>> findAll(@RequestParam(value = "name", required = false) String name){
        if(name == null){
            log.info("Name이 존재하지 않음. 전체검색을 진행합니다.");
            return ResponseEntity.ok(userRepository.findAll());
        }else{
            log.info("{}이 확인됨. 해당 이름을 가진 정보를 찾습니다", name);
            return ResponseEntity.ok(userRepository.findByUserName(name));
        }
    }

    @PutMapping("/update/{userIdx}")
    public ResponseEntity<?> update(@PathVariable Long userIdx, @RequestBody User req){
        return userRepository.update(userIdx, req)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // 없으면 404 실행
    }

    @DeleteMapping("/delete/{userIdx}")
    public ResponseEntity<?> delete(@PathVariable Long userIdx){
        boolean ok =  userRepository.delete(userIdx);
        return ok ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
