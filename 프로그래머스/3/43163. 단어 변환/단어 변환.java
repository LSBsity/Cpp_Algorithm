class Solution {

    int min = Integer.MAX_VALUE;

    public void dfs(String[] words, String cur, String target, boolean[] visited, int depth) {
        if (cur.equals(target)) {
            min = Math.min(min, depth);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && check(cur, words[i])) {
                visited[i] = true;
                dfs(words, words[i], target, visited, depth + 1);
                visited[i] = false;  // 백트래킹
            }
        }
    }

    private boolean check(String cur, String w) {
        int count = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != w.charAt(i)) count++;
        }
        return count == 1;
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(words, begin, target, visited, 0);
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}