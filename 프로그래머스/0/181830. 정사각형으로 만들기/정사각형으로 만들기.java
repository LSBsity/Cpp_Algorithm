class Solution {
    public int[][] solution(int[][] arr) {
        int max = Integer.max(arr.length, arr[0].length);
        int[][] newArr = new int[max][max];
        int idx = 0;
        for (int[] arrs : arr) {
            System.arraycopy(arrs, 0, newArr[idx], 0, arrs.length);
            idx++;
        }

        return newArr;
    }
}