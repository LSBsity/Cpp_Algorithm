import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        return go(x, y, n);
    }
    
    private static int go(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, 0});
        
        boolean[] v = new boolean[y * 3];
        v[x] = true;
        
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == y) {
                min = Math.min(min, cur[1]);
                continue;
            } 
            
            if (cur[0] > y) continue;
            
            if (!v[cur[0] + n]) {
                q.offer(new int[] {cur[0] + n, cur[1] + 1});
                v[cur[0] + n] = true;
            }
            
            if (!v[cur[0] * 2]) {
                q.offer(new int[] {cur[0] * 2, cur[1] + 1});
                v[cur[0] * 2] = true;
            }
            if (!v[cur[0] * 3]) {
               q.offer(new int[] {cur[0] * 3, cur[1] + 1});
               v[cur[0] * 3] = true;
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    } 
}