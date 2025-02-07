import java.util.*;

class Solution {

    private final Map<String, Integer> map = new HashMap<>();
    private Integer index = 27;

    public Solution() {
        for (int i = 65; i <= 90; i++) {
            map.put("" + (char) i, i - 64);
        }
    }

    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < msg.length(); i++) {
            int findIdx = i;
            int maxCode = 0, skipCount = 0;

            while (true) {
                String subs = msg.substring(i, ++findIdx);
                if (!map.containsKey(subs)) {
                    map.put(subs, index++);
                    break;
                }
                maxCode = map.get(subs);
                skipCount++;
                if (findIdx >= msg.length()) {
                    break;
                }
            }

            i += skipCount - 1;
            list.add(maxCode);
        }

        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}