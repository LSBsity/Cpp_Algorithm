import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] answer = new int[5];
        char[][] map = new char[T][T];
        int[] heart = new int[2];
        boolean check = false;
        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            for (int j = 0; j < T; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '*' && !check) {
                    heart[0] = i + 1;
                    heart[1] = j;
                    check = true;
                }
            }
        }
        for (int j = 0; j < T; j++) {
            if (map[heart[0]][j] == '*') {
                answer[0] = heart[1] - j;
                break;
            }
        }
        for (int j = T - 1; j >= 0; j--) {
            if (map[heart[0]][j] == '*') {
                answer[1] = j - heart[1];
                break;
            }
        }

        int[] legs = new int[4];
        for (int i = T - 1; i >= 0; i--) {
            if (map[i][heart[1]] == '*') {
                answer[2] = i - heart[0];
                legs[0] = i + 1;
                legs[1] = heart[1] - 1;
                legs[2] = i + 1;
                legs[3] = heart[1] + 1;
                break;
            }
        }

        for (int i = T - 1; i >= legs[0]; i--) {
            if (map[i][legs[1]] == '*') {
                answer[3] = i - legs[0] + 1;
                break;
            }
        }
        for (int i = T - 1; i >= legs[2]; i--) {
            if (map[i][legs[3]] == '*') {
                answer[4] = i - legs[2] + 1;
                break;
            }
        }

        System.out.println((heart[0] + 1) + " " + (heart[1] + 1));
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2] + " " + answer[3] + " " + answer[4]);
    }
}
