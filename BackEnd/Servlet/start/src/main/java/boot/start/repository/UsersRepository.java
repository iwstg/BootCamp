package boot.start.repository;

import boot.start.domain.Users;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UsersRepository {
    // 싱글톤 인스턴스
    private static final UsersRepository instances = new UsersRepository();
    private UsersRepository() {}
    public static UsersRepository getInstance() {
        return instances;
    }

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
