import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int sub = 100 - progresses[i];
            q.offer(sub % speeds[i] == 0 ? sub / speeds[i] : sub / speeds[i] + 1);
        }
        
        List<Integer> answer = new ArrayList<>();
        int cnt = 1;
        int prevDay = q.poll();

        while (!q.isEmpty()) {
            int day = q.poll();
            if (prevDay >= day) {
                cnt++;
            } else {
                answer.add(cnt);
                prevDay = day;
                cnt = 1;
            }
        }
        answer.add(cnt);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}