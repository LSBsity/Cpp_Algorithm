import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public int solution(String A, String B) {
        if (A.equals(B)) return 0;
        
        int answer = 0;

        List<Character> list = new ArrayList<>();
        for (char c : A.toCharArray()) {
            list.add(c);
        }
        
        int right = 0, left = 0;
        boolean able = false;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == 0) {
                    Collections.rotate(list, 1);
                    right++;
                } else {
                    Collections.rotate(list, -1);
                    left++;
                }

                String convert = list.stream().map(String::valueOf)
                        .collect(Collectors.joining());
                if (convert.equals(B)) {
                    able = true;
                    break;
                }
            }
        }

        if (able) {
            return Math.min(left, right);
        } else {
            return -1;
        }
    }
}