import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int losts = n - lost.length; 
        
        Arrays.sort(reserve);
        Arrays.sort(lost);
        
        boolean[] v = new boolean[31];
        for (var i : reserve) { 
            for (var j : lost) {
                if (i == j) {
                    losts++;
                    v[i] = true;
                    break;
                }
            }
        }

        for (int i = 0, idx = 0; i < reserve.length; i++) {
            if (idx >= lost.length) break;
            if (v[reserve[i]]) continue;
            
            for (int j = idx; j < lost.length; j++) {
                if (v[lost[j]]) continue;
                if (Math.abs(reserve[i] - lost[j]) == 1) {
                    v[lost[j]] = true;
                    idx++;
                    losts++;
                    break;
                } 
            }
        }
        
        return losts;
    }
}