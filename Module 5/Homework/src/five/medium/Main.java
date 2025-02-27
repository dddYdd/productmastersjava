package five.medium;

public class Main {
  public static void main(String[] args) {
    List<DayOfWeek> days = new ArrayList<>(Arrays.asList(DayOfWeek.values()));

    System.out.println("Days of the week:");
    for (DayOfWeek day : days) {
      System.out.println(day);
    }

    System.out.println("Is SATURDAY a weekend? " + isWeekend(DayOfWeek.SATURDAY));
    System.out.println("Is MONDAY a weekend? " + isWeekend(DayOfWeek.MONDAY));


  }

  public static boolean isWeekend(DayOfWeek day) {
    return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
  }
