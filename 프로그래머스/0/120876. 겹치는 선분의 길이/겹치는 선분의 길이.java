
class Solution {
    public int solution(int[][] lines) {
        int[] arr = new int[201];
        int count = 0;
        for (int[] line : lines) {
            for (int i = line[0] + 100; i <= line[1] + 100 - 1; i++) {
                arr[i]++;
                if (arr[i] == 2) {
                    count++;
                }
            }
        }


        return count;
    }
}