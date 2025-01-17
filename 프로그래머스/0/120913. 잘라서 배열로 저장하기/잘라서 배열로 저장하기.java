class Solution {
    public String[] solution(String my_str, int n) {
        int size = (my_str.length() % n == 0) ? my_str.length() / n : my_str.length() / n + 1;
        String[] answers = new String[size];
        for (int i = 0, idx = 0; i < my_str.length(); i += n) {
            answers[idx++] = i + n > my_str.length() ? my_str.substring(i) : my_str.substring(i, i + n);
        }
        return answers;
    }
}
