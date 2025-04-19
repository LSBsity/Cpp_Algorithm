class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            int rem = n % 3;
            n /= 3;
            
            if (rem == 0) {
                sb.append(4);
                n--; 
            } else {
                sb.append(rem);
            }
        }
        
        return sb.reverse().toString();
    }
}