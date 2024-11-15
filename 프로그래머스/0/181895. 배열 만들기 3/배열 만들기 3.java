class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] ints = new int[intervals[0][1] - intervals[0][0] + 1 + intervals[1][1] - intervals[1][0] + 1];
        int idx = 0;
        for (int[] interval : intervals) {
            for (int i = interval[0]; i <= interval[1]; i++) {
                ints[idx++] = arr[i];
            }
        }
        return ints;
    }
}
