class Solution {
    public int solution(int num) {
        if (num == 1) return 0;
        
        int count = 0;
        while (count <= 500) {
            if (num % 2 == 1) {
                num = num * 3 + 1;
            } else {
                num /= 2;
            }
            count++;
            
            if (num == 1) return count;
        }
        
        return -1;
    }
}