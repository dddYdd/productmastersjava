package five.hard;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    ArrayList<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      numbers.add(scanner.nextInt());
    }

    ArrayList<Integer> uniqueNumbers = removeDuplicates(numbers);
    System.out.println(uniqueNumbers);
  }

  public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
    LinkedHashSet<Integer> set = new LinkedHashSet<>(list);
    return new ArrayList<>(set);
  }
}
