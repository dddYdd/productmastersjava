package seven;

public class User {
  private static int userCounter = 1;
  private final int id;
  private final String name;

  public User(String name) {
    this.id = userCounter++;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "User{id=" + id + ", name='" + name + "'}";
  }
}
