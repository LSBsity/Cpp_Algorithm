import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            Integer ints = map.getOrDefault(array[i], 0);
            ints++;
            map.put(array[i], ints);
        }

        LinkedList<Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(Entry.comparingByValue(Comparator.reverseOrder()));

        if (list.size() == 1) {
            return list.get(0).getKey();
        } else {
            if (list.get(0).getValue() == list.get(1).getValue()) {
                return -1;
            } else {
                return list.get(0).getKey();
            }
        }
    }
}
