import java.util.*;

class Solution {

    private Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] courses) {
        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);

            for (int course : courses) {
                if (arr.length < course) continue;
                comb(arr, new char[course], 0, 0, course);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator
                .comparingInt((Map.Entry<String, Integer> e) -> e.getKey().length())
                .thenComparing(Map.Entry::getValue, Comparator.reverseOrder()));

        List<String> answer = new ArrayList<>();
        int curLen = -1, curMax = 0;

        for (Map.Entry<String, Integer> e : list) {
            int len = e.getKey().length();
            if (len != curLen) {        
                curLen = len;
                curMax = e.getValue();
            }
            if (curMax >= 2 && e.getValue() == curMax) {
                answer.add(e.getKey());
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private void comb(char[] arr, char[] out, int start, int depth, int r) {
        if (depth == r) {
            map.put(String.valueOf(out), map.getOrDefault(String.valueOf(out), 0) + 1);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            out[depth] = arr[i];
            comb(arr, out, i + 1, depth + 1, r);
        }
    }
}