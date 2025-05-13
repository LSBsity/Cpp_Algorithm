class Solution {
    public int[] solution(int[] arr, int k) {
        int first = 0, last = Integer.MAX_VALUE;
        
        int sum = 0, start = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end]; 
            
            while (sum > k && start <= end) {
                sum -= arr[start++];
            }
            
            if (sum == k && last - first > end - start) {
                first = start;
                last = end;
            }
        }
        
        return new int[]{first, last};
    }
}