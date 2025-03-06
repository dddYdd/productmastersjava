package six.easy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberList {
    private List<Integer> numbers;

    public NumberList(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int findMin() {
        return Collections.min(numbers);
    }

    public int findMax() {
        return Collections.max(numbers);
    }

    public List<Integer> sortUp() {
        List<Integer> sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);
        return sortedList;
    }

    public List<Integer> sortDown() {
        List<Integer> sortedList = new ArrayList<>(numbers);
        sortedList.sort(Collections.reverseOrder());
        return sortedList;
    }

    public boolean isEl(int value) {
        return numbers.contains(value);
    }

    public List<Integer> filterEl(int value) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : numbers) {
            if (num < value) {
                result.add(num);
            }
        }
        return result;
    }

    public int sumAll() {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }
        return sum;
    }
}
