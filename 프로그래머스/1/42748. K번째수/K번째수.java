import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        
        for (int[] command : commands) {
            int start = command[0];
            int end = command[1];
            int len = command[2];
            
            int[] temp = new int[end - start + 1];
            
            System.arraycopy(array, start - 1, temp, 0, end - start + 1);
            
            Arrays.sort(temp);
            System.out.println(Arrays.toString(temp));
            
            answer[idx++] = temp[len - 1];
        }
        
        
        return answer;
    }
}