import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());
        
        long sum = 0;

        for (int i = 0; i < enemy.length; i++) {
            if (!pq.isEmpty() && sum > n){

                int max = pq.poll();
                sum -= max;
                
                if (k == 0) {
                    return i - 1;
                }
                k--;
            }
            pq.offer(enemy[i]);
            sum += enemy[i]; 
            
            if (sum > n && k == 0) return i;
        }
        
        return enemy.length;
    }
}