package example1;

public class User {
  private final String name;
  private final int age;

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}
