class Solution {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (var c : targets[i].toCharArray()) {
                int min = Integer.MAX_VALUE;
                for (var key : keymap) {
                    int idx = key.indexOf(c);
                    if (idx != -1) min = Math.min(min, idx + 1);
                }
                if (min == Integer.MAX_VALUE) {
                    sum = -1;
                    break;
                }
                sum += min;
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}