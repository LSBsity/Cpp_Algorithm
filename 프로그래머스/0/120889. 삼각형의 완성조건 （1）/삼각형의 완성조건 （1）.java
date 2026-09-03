import java.util.*;

class Solution {
    public int solution(int[] s) {
        Arrays.sort(s);
        return s[2] < s[0] + s[1] ? 1 : 2;
    }
}