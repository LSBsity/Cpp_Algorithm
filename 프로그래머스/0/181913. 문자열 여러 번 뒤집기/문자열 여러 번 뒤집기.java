
class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] arr = my_string.toCharArray();
        for (int[] query : queries) {
            int start = query[0], end = query[1];
            while (start < end) {
                char temp = arr[start];
                arr[start++] = arr[end];
                arr[end--] = temp;
            }
        }
        return new String(arr);
    }
}