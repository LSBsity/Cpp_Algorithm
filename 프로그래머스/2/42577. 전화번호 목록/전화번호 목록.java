import java.util.*;

class Solution {
    public boolean solution(String[] arr) {
        boolean answer = true;
        
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1].startsWith(arr[i])) return false;
        }
        
        return answer;
    }
}