import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[1_000_001];
        q.offer(x);
        v[x] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == y) return cnt;
                int[] nexts = {cur + n, cur * 2, cur * 3};
                for (var next : nexts) {
                    if (next <= y && !v[next]) {
                        v[next] = true;
                        q.offer(next);
                    }
                }
            }
            cnt++;    
        }
        return -1;
    }
}