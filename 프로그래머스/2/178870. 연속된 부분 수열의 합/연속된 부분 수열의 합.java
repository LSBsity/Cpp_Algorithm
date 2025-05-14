class Solution {

    public int[] solution(int[] arr, int target) {
        int sum = 0, first = 0, last = Integer.MAX_VALUE;
    
        for (int start = 0, end = 0; end < arr.length; end++) {
            sum += arr[end]; // right pointer++
            
            while (sum > target && start <= end) {
                sum -= arr[start++]; // left pointer++
            }
            
            if (sum == target && last - first > end - start) {
                first = start;
                last = end;
            }
        }
        
        return new int[]{first, last};
    }
}