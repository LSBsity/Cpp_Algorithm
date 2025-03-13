import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int size = Arrays.stream(number)
            .sum();
   
        for (int i = 0; i <= discount.length - size; i++) {
            int[] check = Arrays.copyOf(number, number.length);
            for (int j = i; j < i + size; j++) {
                String item = discount[j];
                    for (int k = 0; k < want.length; k++) {
                        if (want[k].equals(item)) {
                            check[k]--;
                        }
                    }
            }
            boolean isEmpty = true;
            for (int k = 0; k < want.length; k++) {
                if (check[k] != 0) {
                    isEmpty = false;
                    break;
                }
            }
            
            if (isEmpty) {
                answer++;
            }
        }
        
        return answer;
    }
}