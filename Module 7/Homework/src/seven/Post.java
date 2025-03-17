package seven;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Post {
    private static final AtomicInteger postCounter = new AtomicInteger(1);
    private final int id;
    private final User author;
    private final String text;
    private int likes;
    private int reposts;
    private final LocalDateTime timestamp;

    public Post(User author, String text) {
        if (text.length() > 280) {
            throw new IllegalArgumentException("Текст не может быть длиннее 280 символов!");
        }
        this.id = postCounter.getAndIncrement();
        this.author = author;
        this.text = text;
        this.likes = 0;
        this.reposts = 0;
        this.timestamp = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public User getAuthor() {
        return author;
    }

    public int getLikes() {
        return likes;
    }

    public int getReposts() {
        return reposts;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void like() {
        likes++;
    }

    public void repost() {
        reposts++;
    }

    @Override
    public String toString() {
        return "Post{id=" + id + ", author=" + author.getName() +
                ", content='" + text + "', likes=" + likes +
                ", reposts=" + reposts + ", timestamp=" + timestamp + "}";
    }
}
