class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        
        for (boolean i : included) {   
            if (i) answer += a;
            a += d;
        }
        
        return answer;
    }
}