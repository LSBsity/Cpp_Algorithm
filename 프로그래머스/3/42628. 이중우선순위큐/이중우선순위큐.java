import java.util.*;

class Solution {
    public int[] solution(String[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String str : arr) {
            String[] splited = str.split(" ");
            if (splited[0].equals("I")) {
                Integer value = Integer.valueOf(splited[1]);
                map.put(value, map.getOrDefault(value, 0) + 1);
            } else if (splited[0].equals("D") && splited[1].equals("1")) { //max
                if (map.isEmpty()) continue;
                Integer maxKey = map.lastKey();
                map.put(maxKey, map.get(maxKey) - 1);
                if (map.get(maxKey) == 0) {
                    map.remove(maxKey);
                }
            } else { //min
                if (map.isEmpty()) continue;
                Integer minKey = map.firstKey();
                map.put(minKey, map.get(minKey) - 1);
                if (map.get(minKey) == 0) {
                    map.remove(minKey);
                }
            }

        }
        
        
        return map.isEmpty() ? new int[]{0, 0} : new int[]{map.lastKey(), map.firstKey()};
    }
}