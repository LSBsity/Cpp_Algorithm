import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        return this.go(numbers, target);
    }
    
    private int go(int[] numbers, int target) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
   
        int count = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == numbers.length) {
                if (cur[1] == target) {
                    count++;
                }
                continue;
            }
            
            q.offer(new int[] {cur[0] + 1, cur[1] + numbers[cur[0]]});
            q.offer(new int[] {cur[0] + 1, cur[1] - numbers[cur[0]]});
        }
 
        return count;
    }
}