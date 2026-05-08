import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        
        char last = words[0].charAt(0);
        int idx = 1, cnt = 1;
        for (String word : words) {
            if (last != word.charAt(0) || !set.add(word)) {
                return new int[] {idx, (cnt - 1) / n + 1};
            }
            last = word.charAt(word.length() - 1);
            idx = idx % n + 1;
            cnt++;
        }

        return new int[] {0, 0};
    }
}

// 0 1 2 3 4 5 6 7