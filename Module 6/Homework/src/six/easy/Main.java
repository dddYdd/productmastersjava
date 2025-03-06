package six.easy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> data = List.of(3, 1, 4, 1, 5, 9);
        NumberList numList = new NumberList(data);
        System.out.println(numList.findMin());
        System.out.println(numList.findMax());
        System.out.println(numList.sortUp());
        System.out.println(numList.sortDown());
        System.out.println(numList.isEl(4));
        System.out.println(numList.filterEl(4));
        System.out.println(numList.sumAll());
    }
}
