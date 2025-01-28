class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = "";

        while (n > 0) {
            int remain = n % 3;
            str += remain;
            n /= 3;
        }
        
        for (int i = str.length() - 1, exp = 0; i >= 0; i--) {
            char c = str.charAt(i);
            answer += ((int) c - '0') * Math.pow(3, exp++);
        }
        
        
        return answer;
    }
}

 