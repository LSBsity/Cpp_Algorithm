import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[1_000_001];
        
        q.offer(x);
        v[x] = true;
        int level = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int current = q.poll();
                if (current == y) return level;
                
                int[] nexts = {current + n, current * 2, current * 3};
                for (int next : nexts) {
                    if (next <= y && !v[next]) {
                        v[next] = true;
                        q.offer(next);
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
}