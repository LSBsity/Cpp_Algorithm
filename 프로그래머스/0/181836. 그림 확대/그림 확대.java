class Solution {

    public String[] solution(String[] picture, int k) {
        String[] str = new String[picture.length * k];

        int idx = 0;
        for (String s : picture) {
            StringBuilder sb = new StringBuilder();
            for (String tmp : s.split("")) {
                sb.append(tmp.repeat(k));
            }
            for (int i = 0; i < k; i++) {
                str[idx++] = sb.toString();
            }
        }

        return str;
    }
}