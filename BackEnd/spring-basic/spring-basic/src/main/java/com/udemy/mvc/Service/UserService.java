package com.udemy.mvc.Service;

import com.udemy.mvc.domain.User;
import com.udemy.mvc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user){
        validatorForCreate(user);
        User saved = userRepository.save(user);
        log.info("[UserService] created userIdx={}, userId={}", saved.getUserIdx(), saved.getUserId());
        return saved;
    }

    public Optional<User> getUserByIdx(Long userIdx) {
        return userRepository.findByUserIdx(userIdx);
    }

    public Optional<User> getUserByUserId(String userId) {
        if (!StringUtils.hasText(userId)) return Optional.empty();
        return userRepository.findByUserId(userId);
    }

    public List<User> getUsersByUserName(String userName) {
        if (!StringUtils.hasText(userName)) return Collections.emptyList();
        return userRepository.findByUserName(userName);
    }

    public List<User> getAllUsers(){ return userRepository.findAll(); }

    public Optional<User> updateUser(Long userIdx, User patch) {
        if (patch == null) return Optional.empty();
        return userRepository.update(userIdx, patch);
    }

    public boolean deleteUser(Long userIdx) {
        return userRepository.delete(userIdx);
    }

    private void validatorForCreate(User user){
        if(user == null){
            throw new IllegalArgumentException("user must not be null");
        }
        if(!StringUtils.hasText(user.getUserId())){
            throw new IllegalArgumentException("userId must not be blank");
        }
        if(!StringUtils.hasText(user.getUserName())){
            throw new IllegalArgumentException("userName must not be blank");
        }
    }
}
