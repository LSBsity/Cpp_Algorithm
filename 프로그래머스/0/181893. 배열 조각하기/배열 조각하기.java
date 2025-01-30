import java.util.Arrays;

class Solution {

    public int[] solution(int[] arr, int[] query) {
        int start = 0;
        int end = arr.length;

        for (int i = 0; i < query.length; i++) {
            if (i % 2 != 0) {
                start += query[i];
            } else {
                end = start + query[i];
            }
        }
        
        return Arrays.copyOfRange(arr, start, end + 1);
    }
}
