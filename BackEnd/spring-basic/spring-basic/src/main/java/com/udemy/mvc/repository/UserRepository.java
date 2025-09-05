package com.udemy.mvc.repository;


import com.udemy.mvc.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class UserRepository {
    private final ConcurrentMap<Long, User> usersMap = new ConcurrentHashMap<>();
    private static AtomicLong userIndex = new AtomicLong(1);

    public User save(User user){
        Long idx = userIndex.getAndIncrement();
        user.setUserIdx(idx);
        user.setRegistrationDate(LocalDate.now());
        user.setUpdateDate(LocalDate.now());
        usersMap.put(idx, user);
        log.info("[save] userIdx={}, user={}", idx, user);
        return user;
    }

    // SELECT * FROM USER WHERE user_idx = ?
    public Optional<User> findByUserIdx(Long userIdx){
        return Optional.ofNullable(usersMap.get(userIdx));
    }

    // SELECT * FROM USER WHERE USER_ID = ? LIMIT 1
    public Optional<User> findByUserId(String userId){
        return usersMap.values().stream()
                .filter(u -> Objects.equals(u.getUserId(), userId))
                .findFirst();
    }

    // SELECT * FROM USER WHERE USER_NAME = ?
    public List<User> findByUserName(String userName){
        return usersMap.values().stream()
                .filter(u -> Objects.equals(u.getUserName(), userName))
                .toList();
    }

    // SELECT * FROM USER;
    public List<User> findAll(){
        return new ArrayList<>(usersMap.values());
    }

    // UPDATE USER SET USER_NAME = ? WHERE USER_IDX = ?
    public Optional<User> update(Long userIdx, User updated){
        User existing = usersMap.get(userIdx);
        if (existing == null){ return Optional.empty(); }

        if(updated.getUserId() != null) existing.setUserId(updated.getUserId());
        if(updated.getUserName() != null) existing.setUserName(updated.getUserName());
        usersMap.put(userIdx, existing);

        log.info("[update] userIdx={}, updated={}", userIdx, existing);

        return Optional.of(existing);
    }

    // DELETE FROM USER WHERE USER_IDX = ?
    public boolean delete(Long userIdx){
        User removed = usersMap.remove(userIdx);
        log.info("[delete] userIdx={}, removed={}", userIdx, removed != null);
        return removed != null;
    }
}
