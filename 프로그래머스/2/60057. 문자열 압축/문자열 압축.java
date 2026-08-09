class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n;

        for (int unit = 1; unit <= n / 2; unit++) {
            int len = 0;
            int i = 0;

            while (i < n) {
                if (i + unit > n) {     
                    len += n - i;
                    break;
                }
                
                String chunk = s.substring(i, i + unit);
                int count = 1;
                int j = i + unit;

                while (s.startsWith(chunk, j)) {
                    count++;
                    j += unit;
                }
                
                len += unit + (count > 1 ? String.valueOf(count).length() : 0);
                i = j;
            }
            answer = Math.min(answer, len);
        }
        return answer;
    }
}