import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        
        Integer[] boxed = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            boxed[i] = numbers[i];
        }
        Collections.rotate(Arrays.asList(boxed), direction.equals("right") ? 1 : -1);
        
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = boxed[i];
        }
        
        return answer;
    }
}