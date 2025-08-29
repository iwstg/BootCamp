package boot.start.practice.postmanageprogram;

import java.time.LocalDateTime;

public class Post {
    private long postIdx;
    private String title;
    private String content;
    private LocalDateTime time;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public long getPostIdx() {
        return postIdx;
    }

    public void setPostIdx(long postIdx) {
        this.postIdx = postIdx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
