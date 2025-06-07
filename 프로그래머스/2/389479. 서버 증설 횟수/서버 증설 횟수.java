class Solution {
    public int solution(int[] arr, int m, int k) {
        int answer = 0;
        int[] servers = new int[24];
        
        for (int i = 0; i < 24; i++) {
            int required = arr[i] / m;
            int activeServer = 0;
            
            for (int j = Math.max(0, i - k + 1); j <= i; j++) {
                activeServer += servers[j];
            }
            
            if (activeServer < required) {
                servers[i] = required - activeServer;
                answer += required - activeServer;
            }
        }
        return answer;
    }
}