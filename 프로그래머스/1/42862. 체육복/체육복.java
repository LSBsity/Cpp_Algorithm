import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int saved = n - lost.length;
        boolean[] v = new boolean[31];
        
        Arrays.sort(reserve);
        Arrays.sort(lost);
        
        for (var i : reserve) {
            for (var j : lost) {
                if (i == j) {
                    v[i] = true;
                    saved++;
                    break;
                }
            }
        }
        
        for (var i : reserve) {
            if (v[i]) {
                continue;
            }
            for (var j : lost) {
                if (!v[j] && Math.abs(j - i) == 1) {
                    v[j] = true;
                    saved++;
                    break;
                }
            }
        }
        
        return saved;
    }
}