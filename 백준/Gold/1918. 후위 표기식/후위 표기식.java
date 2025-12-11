import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;
    static String infix;

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            infix = br.readLine();

            sb.append(go());
        }
        System.out.println(sb);
    }

    private static String go() {
        StringBuilder postfix = new StringBuilder();
        Deque<Character> stk = new ArrayDeque<>();

        for (char c : infix.toCharArray()) {
            if (Character.isLetter(c)) { // 피연산자면 바로 출력
                postfix.append(c);

            } else if (c == '(') { // 여는 괄호면 stk push
                stk.push(c);

            } else if (c == ')') { // 닫는 괄호면 여는 괄호를 만날 때 까지 pop
                while (!stk.isEmpty() && stk.peek() != '(') {
                    postfix.append(stk.pop());
                }
                stk.pop(); // '(' 제거

            } else { // 연산자면
                while (!stk.isEmpty() && precedence(c) <= precedence(stk.peek())) {
                    postfix.append(stk.pop());
                }
                stk.push(c);
            }
        }

        while (!stk.isEmpty()) {
            postfix.append(stk.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
}
