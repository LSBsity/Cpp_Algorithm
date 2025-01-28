import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
    
        int[] indexes = new int[numlist.length];
        
        for (int i = 0; i < numlist.length; i++) {
            indexes[i] = Math.abs(n - numlist[i]);
        }
        
        Integer[] numlistObj = Arrays.stream(numlist)
            .boxed()
            .toArray(Integer[]::new);

        Arrays.sort(numlistObj, (a, b) -> {
            int diffA = Math.abs(n - a);
            int diffB = Math.abs(n - b);
            if (diffA != diffB) {
                return diffA - diffB; 
            } else {
                return b - a; 
            }
        });
        
        return Arrays.stream(numlistObj).mapToInt(i -> i).toArray();
    }
}