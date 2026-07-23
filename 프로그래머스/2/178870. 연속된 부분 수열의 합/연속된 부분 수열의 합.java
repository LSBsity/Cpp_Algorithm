class Solution {
    public int[] solution(int[] arr, int k) {
        int[] temp = {0, 0};
        int min = Integer.MAX_VALUE;
        
        int left = 0;
        int right = 1;
        int sum = arr[0];
        
        if (sum == k) {
            return new int[] {0, 0};
        }
        
        while (left < right) {
            if (sum < k && right < arr.length) {
                sum += arr[right++];    
            } else if (sum > k) {
                sum -= arr[left++];
            }  else {
                if (sum == k && min > right - 1 - left) {
                    temp[0] = left;
                    temp[1] = right - 1;
                    min = right - 1 - left;
                }
                sum -= arr[left++];
            }
        }
        
        if (arr[arr.length - 1] == k) {
            return new int[] {arr.length - 1, arr.length - 1};
        }
        
        return temp;
    }
}