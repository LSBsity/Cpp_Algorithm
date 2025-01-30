import java.util.Arrays;

class Solution {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;

        for (int[] arr : commands) {
            int start = arr[0];
            int end = arr[1];
            int target = arr[2];

            int[] temp = Arrays.copyOfRange(array, start - 1, end);
            Arrays.sort(temp);
            answer[idx++] = temp[target - 1];
        }

        return answer;
    }
}