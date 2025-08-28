package boot.start.repository;

import boot.start.domain.Users;
import org.apache.catalina.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UserRepository {
    private final ConcurrentMap<Long, Users> usersMap = new ConcurrentHashMap<>();
    private static Long userIdx = 0L;

    public Users save(Users user){
        user.setUserIdx(++userIdx);
        usersMap.put(user.getUserIdx(), user);
        return user;
    }

    // SELECT * FROM users WHERE user_idx = 1; 과 동일함
    public Optional<Users> findByIdx(Long userIdx){
        return Optional.ofNullable(usersMap.get(userIdx));
    }
}
