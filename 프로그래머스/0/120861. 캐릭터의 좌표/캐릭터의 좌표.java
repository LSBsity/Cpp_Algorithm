import java.util.Map;

class Solution {

    private final Map<String, int[]> map = Map.of(
            "left", new int[]{-1, 0},
            "right", new int[]{1, 0},
            "up", new int[]{0, 1},
            "down", new int[]{0, -1}
    );

    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};
        int x = board[0] / 2, y = board[1] / 2;

        for (String s : keyinput) {
            int[] move = map.get(s);
            if (Math.abs(answer[0] + move[0]) <= x && Math.abs(answer[1] + move[1]) <= y) {
                answer[0] += move[0];
                answer[1] += move[1];
            }

        }

        return answer;
    }
}