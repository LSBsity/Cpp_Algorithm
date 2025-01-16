import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int[] solution(int n) {
        return getValues(n).stream()
                .mapToInt(i -> i)
                .distinct()
                .toArray();
    }

    private static List<Integer> getValues(int n) {
        List<Integer> arr = new ArrayList<>();
        int i = 2;
        while (i <= n) {
            if (n % i == 0) {
                arr.add(i);
                n /= i;
            } else {
                i++;
            }
        }
        return arr;
    }
}