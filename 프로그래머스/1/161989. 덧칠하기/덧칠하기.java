class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        for (int i = 1, idx = 0; i <= n && idx <= section.length - 1;) {
            if (i == section[idx]) {
                i += m;
                idx++;
                answer++;
            } else if (i > section[idx]) {
                idx++;   
            } else {
                i++;
            }
        }
        
        return answer;
    }
}