class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int cover = w * 2 + 1;
        int right = 1;
        for (int i = 0; i < stations.length; i++) {
            int station = stations[i];
            int start = station - w;
            int end = station + w;

            int distance = start - right;
            right = end + 1;
            if (distance > 0) {
                if (distance <= cover) {
                    answer++;
                } else {
                    answer += distance / cover;
                    if (distance % cover != 0) {
                        answer++;
                    }
                }

            }
        }

        if (right <= n) {
            int distance = n - right + 1;
            if (distance > 0) {
                if (distance <= cover) {
                    answer++;
                } else {
                    answer += distance / cover;
                    if (distance % cover != 0) {
                        answer++;
                    }
                }
            }

        }
        return answer;
    }
}