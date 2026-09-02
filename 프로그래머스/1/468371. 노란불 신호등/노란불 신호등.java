class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        
        int lcm = -1;
        for (int[] signal : signals) {
            int sum = signal[0] + signal[1] + signal[2];
            lcm = lcm(lcm, sum);
        }
        
        for (int t = 1; t <= lcm; t++) {
            boolean check = true;
            
            for (int[] s : signals) {
                int pos = (t - 1) % (s[0] + s[1] + s[2]);
                
                if (pos < s[0] || pos >= s[0] + s[1]) {
                    check = false;
                    break;
                }
            }
            
            if (check) return t;
        }
        
        return -1;
    }
    
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}