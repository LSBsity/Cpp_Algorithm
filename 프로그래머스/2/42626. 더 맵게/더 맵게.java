import java.util.*;

class Solution {
    public int solution(int[] arr, int K) {
        int answer = 0;
        
        Arrays.sort(arr);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int food : arr) {
            pq.offer(food);
        }
        
        if (pq.peek() >= K) return 0;
        
        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first + second * 2);
            answer++;
            
            if (pq.peek() >= K) return answer;
        }
        
        return -1;
    }
}