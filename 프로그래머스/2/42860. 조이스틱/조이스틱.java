import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) chars[i] = 'A';

        int move = n - 1;  // 오른쪽으로 쭉

        for (int i = 0; i < n; i++) {
            char target = name.charAt(i);
            char cur = chars[i];

            int idx;
            if (target < 'N') idx = target - cur;
            else idx = 'Z' - target + 1;
            answer += idx;

            int j = i + 1;
            while (j < n && name.charAt(j) == 'A') j++;

            move = Math.min(move, i + (n - j) + Math.min(i, n - j));
        }
        return answer + move;
    }
}