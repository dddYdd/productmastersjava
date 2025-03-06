package six.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SafeList<T> {
    private final List<T> list = new ArrayList<>();
    private final Set<T> set = new HashSet<>();

    public void add(T element) {
        if (element == null || set.contains(element)) {
            return;
        }
        set.add(element);
        list.add(element);
    }

    public T get(int index) {
        if (index < 0 || index >= list.size()) {
            return null;
        }
        return list.get(index);
    }

    public int size() {
        return list.size();
    }
}
