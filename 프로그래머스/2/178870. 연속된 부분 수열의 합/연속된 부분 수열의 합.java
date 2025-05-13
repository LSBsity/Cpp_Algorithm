class Solution {
    public int[] solution(int[] arr, int k) {
        int first = Integer.MAX_VALUE, last = 0;
        
        int sum = 0, start = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end]; 
            
            while (sum > k && start <= end) {
                sum -= arr[start++];
            }
            
            if (sum == k) {
                if (Math.abs(first - last) > Math.abs(start - end)) {
                    first = start;
                    last = end;
                }
            }
        }
        
        return new int[]{first, last};
    }
}