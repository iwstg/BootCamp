package boot.start.repository;

import boot.start.domain.Users;
import org.apache.catalina.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UserRepository {
//    9월 1일 수업때 시작할 내용
//    private static final UserRepository instance = new UserRepository();
//    public static UserRepository getInstance(){
//        return instance;
//    }
//
//    private UserRepository(){
//        createUsers();
//    }

    private final ConcurrentMap<Long, Users> usersMap = new ConcurrentHashMap<>();
    private static Long userIdx = 0L;

    // INSERT INTO users VALUE ?
    public Users save(Users user){
        user.setUserIdx(++userIdx);
        usersMap.put(user.getUserIdx(), user);
        return user;
    }

    // SELECT * FROM users WHERE user_idx = 1; 과 동일함
    public Optional<Users> findByIdx(Long userIdx){
        return Optional.ofNullable(usersMap.get(userIdx));
    }

    // SELECT * FROM users;
    public List<Users> findAll(){
        return new ArrayList<>(usersMap.values());
    }

    // DELETE FROM users WHERE user_idx = ?
    public void delete(Long userIdx){
        usersMap.remove(userIdx);
    }
}
