import java.util.HashSet;
import java.util.Set;

class Solution {

    private static final int[] dx = new int[]{0, -1, 0, 1};
    private static final int[] dy = new int[]{1, 0, -1, 0};
    private final Set<String> set = new HashSet<>();

    public int solution(String dirs) {
        int cnt = 0;
        
        int[] dir = {0, 0};
        for (char c : dirs.toCharArray()) {
            int idx = getDir(c);
            int newX = dir[0] + dx[idx];
            int newY = dir[1] + dy[idx];
            if (newX >= -5 && newX <= 5 && newY >= -5 && newY <= 5) {
                String path1 = String.format("%d %d %d %d", dir[0], dir[1], newX, newY);
                String path2 = String.format("%d %d %d %d", newX, newY, dir[0], dir[1]);
                if (!set.contains(path1)) {
                    set.add(path1);
                    set.add(path2);
                    cnt++;
                }
                dir[0] = newX;
                dir[1] = newY;
            }
        }

        return cnt;
    }

    private int getDir(char c) {
        return switch (c) {
            case 'R' -> 0;
            case 'U' -> 1;
            case 'L' -> 2;
            case 'D' -> 3;
            default -> throw new IllegalArgumentException();
        };
    }
}
