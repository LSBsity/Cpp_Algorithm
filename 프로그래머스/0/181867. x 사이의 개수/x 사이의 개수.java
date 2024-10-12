import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String myString) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'x') {
                list.add(count);
                count = -1;
            }
            count++;
        }
        list.add(count);
        return list.stream().mapToInt(i -> i).toArray();
    }
}