import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (var i : scoville) {
            q.offer(i);
        }
        
        while (q.size() >= 2 && q.peek() < K) {
            q.offer(q.poll() + q.poll() * 2);
            answer++;
            if (q.size() < 2 && q.peek() < K) {
                return -1;
            }
        }
        
        return answer;
    }
}