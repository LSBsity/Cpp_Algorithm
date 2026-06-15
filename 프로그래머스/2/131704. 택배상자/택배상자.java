import java.util.*;

class Solution {

    public int solution(int[] arr) {
        int answer = 0;
        Queue<Integer> main = new LinkedList<>();
        Deque<Integer> sub = new ArrayDeque<>();
        
        for (int i = 1; i <= arr.length; i++) {
            main.offer(i);
        }

        int i = 0;
        while (i < arr.length) {
            int should = arr[i];
            
            
            if (!main.isEmpty() && main.peek() != should) {
                if (!sub.isEmpty() && sub.peek() != should) {
                    sub.push(main.poll());
                } else if (!sub.isEmpty() && sub.peek() == should) {
                    sub.pop();
                    answer++;
                    i++;
                } else {
                    sub.push(main.poll());
                }
            } else if (!main.isEmpty() && main.peek() == should) {
                main.poll();
                answer++;
                i++;
            } else if (!sub.isEmpty() && sub.peek() == should) {
                sub.pop();
                answer++;
                i++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}