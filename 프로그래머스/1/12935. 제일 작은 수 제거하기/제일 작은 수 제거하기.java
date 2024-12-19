import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] ints = new int[arr.length];
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i < min) min = i;
        }
        int idx = 0;
        for (int i : arr) {
            if (i != min) {
                ints[idx++] = i;
            }
        }
        if (idx == 0) return new int[]{-1};
        return Arrays.copyOf(ints, idx);
    }
}