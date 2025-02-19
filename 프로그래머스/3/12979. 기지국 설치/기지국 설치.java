class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int left = 1;
        int cover = w * 2 + 1;

        for (int station : stations) {
            int distance = station - w - left;

            if (distance > 0) {
                answer += distance / cover;
                if (distance % cover != 0) {
                    answer++;
                }
            }

            left = station + w + 1;
        }

        if (left <= n) {
            int distance = n - left + 1;
            answer += distance / cover;
            if (distance % cover != 0) {
                answer++;
            }
        }

        return answer;
    }
}