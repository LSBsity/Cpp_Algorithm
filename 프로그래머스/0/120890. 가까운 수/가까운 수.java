class Solution {
    public int solution(int[] array, int n) {
        int[] checks = new int[array.length];
        int minAbs = Integer.MAX_VALUE;
        int minAns = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            checks[i] = Math.abs(array[i] - n);
            if (checks[i] < minAbs) {
                minAbs = checks[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (checks[i] == minAbs && minAns > array[i]) {
                minAns = array[i];
            }
        }

        return minAns;
    }
}