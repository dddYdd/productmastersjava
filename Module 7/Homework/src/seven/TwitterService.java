package seven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TwitterService {
  private final List<Post> posts = new ArrayList<>();

  public void initializePosts() {
    posts.add(new Post(new User("Alice"), "Привет, мир!"));
    posts.add(new Post(new User("Bob"), "Сегодня отличный день!"));
    posts.add(new Post(new User("Charlie"), "Люблю программировать на Java."));
    System.out.println("Добавлены стартовые посты.");
  }

  public void createPost(User author, String text) {
    Post newPost = new Post(author, text);
    posts.add(newPost);
    System.out.println("Пост добавлен: " + newPost);
  }

  public void likePost(int postId) {
    Optional<Post> post = posts.stream()
            .filter(p -> p.getId() == postId)
            .findFirst();
    post.ifPresentOrElse(Post::like, () -> System.out.println("Пост не найден."));
  }

  public void repostPost(int postId) {
    Optional<Post> post = posts.stream()
            .filter(p -> p.getId() == postId)
            .findFirst();
    post.ifPresentOrElse(Post::repost, () -> System.out.println("Пост не найден."));
  }

  public void showAllPosts() {
    posts.stream()
            .sorted(Comparator.comparing(Post::getTimestamp).reversed())
            .forEach(System.out::println);
  }

  public void showPopularPosts(int count) {
    posts.stream()
            .sorted(Comparator.comparing(Post::getLikes).reversed())
            .limit(count)
            .forEach(System.out::println);
  }

  public void showUserPosts(User user) {
    posts.stream()
            .filter(p -> p.getAuthor().equals(user))
            .forEach(System.out::println);
  }
}
