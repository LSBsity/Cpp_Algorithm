class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = 1;
        int right = 200_000_000;
        
        while (left <= right) {
            int mid = (right + left) / 2;
            
            System.out.println(left + " " + mid + " " + right);
            if (this.canCross(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private boolean canCross(int[] stones, int k, int mid) {
        
        int count = 0;
        for (var stone : stones) {
            if (stone - mid < 0) {
                count++;
                if (count >= k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        
        return true;
    }
}