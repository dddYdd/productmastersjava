package six.medium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
  public static void main(String[] args) throws IOException {
    String filename = "C:\\Users\\77079\\IdeaProjects\\productmastersjava\\Module 6\\Homework\\src\\six\\medium\\words.txt";
    Set<String> uniqueWords = new HashSet<>();
    Map<String, Integer> wordCount = new HashMap<>();

    BufferedReader br = new BufferedReader(new FileReader(filename));
    String line;
    while ((line = br.readLine()) != null) {
      String[] words = line.split("\\W+");
      for (String w : words) {
        w = w.toLowerCase();
        if (!w.isEmpty()) {
          uniqueWords.add(w);
          wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }
      }
    }
    br.close();

    System.out.println(uniqueWords.size());
    for (String word : uniqueWords) {
      System.out.println(word + ": " + wordCount.get(word));
    }
  }
}
