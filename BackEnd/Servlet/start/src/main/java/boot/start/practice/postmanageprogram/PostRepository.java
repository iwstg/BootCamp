package boot.start.practice.postmanageprogram;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PostRepository {

    private final ConcurrentMap<Long, Post> postsMap = new ConcurrentHashMap<>();
    private static long postIdx = 0L;

    public void save(Post post){
        post.setPostIdx(++postIdx);
        post.setTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        postsMap.put(post.getPostIdx(), post);
    }

    public Post findByPostIdx(long idx){
        return postsMap.get(idx);
    }

    public List<Post> findAll(){
        return new ArrayList<>(postsMap.values());
    }

}
