import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length <= 2) return Arrays.copyOf(arr, arr.length);

        double log = Math.log(arr.length) / Math.log(2);
        int ceil = (int) Math.ceil(log);
        int exp = (int) Math.pow(2, ceil);
        return Arrays.copyOf(arr, exp);
    }
}