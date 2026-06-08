import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (i, j) -> Integer.compare(Integer.parseInt(j + i), Integer.parseInt(i + j)));
        
        for (String str : arr) {
            answer += str;
        }
    
        if (answer.charAt(0) == '0') return "0";
        
        return answer;
    }
}