package seven;
import java.util.*;

public class TwitterConsoleApp {
  private static final Scanner scanner = new Scanner(System.in);
  private static final TwitterService twitterService = new TwitterService();
  private static User currentUser;

  public static void main(String[] args) {
    new TwitterConsoleApp().run();
  }

  public void run() {
    System.out.print("Введите ваше имя: ");
    String userName = scanner.nextLine().trim();
    currentUser = new User(userName);
    System.out.println("Добро пожаловать, " + currentUser.getName() + "!");

    twitterService.initializePosts();

    while (true) {
      showMenu();
      int choice = getIntInput();
      switch (choice) {
        case 1 -> createPost();
        case 2 -> likePost();
        case 3 -> repostPost();
        case 4 -> twitterService.showAllPosts();
        case 5 -> showPopularPosts();
        case 6 -> twitterService.showUserPosts(currentUser);
        case 7 -> {
          System.out.println("Выход...");
          return;
        }
        default -> System.out.println("Некорректный ввод. Попробуйте снова.");
      }
    }
  }

  private void createPost() {
    System.out.print("Введите текст поста (макс. 280 символов): ");
    String postText = scanner.nextLine().trim();
    if (postText.isEmpty()) {
      System.out.println("Пост не может быть пустым.");
      return;
    }
    twitterService.createPost(currentUser, postText);
  }

  private void likePost() {
    System.out.print("Введите ID поста для лайка: ");
    int postId = getIntInput();
    twitterService.likePost(postId);
  }

  private void repostPost() {
    System.out.print("Введите ID поста для репоста: ");
    int postId = getIntInput();
    twitterService.repostPost(postId);
  }

  private void showPopularPosts() {
    System.out.print("Введите количество популярных постов для отображения: ");
    int count = getIntInput();
    twitterService.showPopularPosts(count);
  }

  private int getIntInput() {
    try {
      return Integer.parseInt(scanner.nextLine().trim());
    } catch (NumberFormatException e) {
      System.out.println("Некорректный ввод.");
      return -1;
    }
  }

  private static void showMenu() {
    System.out.println("\n=== Twitter Console ===");
    System.out.println("1. Написать пост");
    System.out.println("2. Лайкнуть пост");
    System.out.println("3. Сделать репост");
    System.out.println("4. Показать все посты");
    System.out.println("5. Показать популярные посты");
    System.out.println("6. Показать мои посты");
    System.out.println("7. Выход");
    System.out.print("Выберите действие: ");
  }
}
