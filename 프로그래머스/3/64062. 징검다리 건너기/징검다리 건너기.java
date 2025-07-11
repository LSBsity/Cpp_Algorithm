class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000; 

        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println(left + " " + mid + " " + right + " -> " + answer);

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
        for (int stone : stones) {
            if (stone - mid < 0) {
                count++; 
                if (count >= k) return false; 
            } else {
                count = 0;
            }
        }
        return true;
    }
}
