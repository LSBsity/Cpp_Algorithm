import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T, N, M, K, A, B;
    static int result;

    static int[] receptionDesk, repairDesk;
    static int[] customer;

    static boolean[] receptionDeskStatus, repairDeskStatus;

    static PriorityQueue<int[]> receptionQ;
    static PriorityQueue<int[]> repairQ;

    static PriorityQueue<int[]> waitQ;

    // int[] { 고객번호, 들어간 창구 번호, 나가야할 시간 (들어온 시간 + 처리 속도) }
    // 나가야할 시간 순으로 오름차순 정렬 -> 매 시간 체크하여 나갈 시간이면 빼준다
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            receptionQ = new PriorityQueue<>((o1, o2) -> {
                if (o1[2] == o2[2]) {
                    return Integer.compare(o1[1], o2[1]); // 창구 번호 기준
                }
                return Integer.compare(o1[2], o2[2]); // 먼저 끝나는 순
            });

            repairQ = new PriorityQueue<>((o1, o2) -> {
                if (o1[2] == o2[2]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[2], o2[2]);
            });

            waitQ = new PriorityQueue<>((o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[2], o2[2]); // 같다면 고객 번호가 빠른 순으로
                }
                return Integer.compare(o1[1], o2[1]); // 기본적으로는 들어온 시간 순으로 비교
            });

            receptionDesk = new int[N];
            receptionDeskStatus = new boolean[N];

            repairDesk = new int[M];
            repairDeskStatus = new boolean[M];

            customer = new int[K];

            result = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                receptionDesk[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                repairDesk[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                customer[i] = Integer.parseInt(st.nextToken());
            }

            go();

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(result == 0 ? -1 : result)
                    .append('\n');
        }

        System.out.println(sb);
    }

    public static void go() {
        for (int currentTime = 0, newCustomerNum = 1;; currentTime++) {

            // repairQ를 먼저 비워준다
            while (!repairQ.isEmpty() && currentTime == repairQ.peek()[2]) {
                int[] repairComplete = repairQ.poll();
                int deskNum = repairComplete[1];

                repairDeskStatus[deskNum] = false;
            }

            // repairDesk에 들어가려는 손님을 waitQ에서 뺀 뒤 repairQ에 넣는다
            for (int deskNum = 0; deskNum < M; deskNum++) {
                if (waitQ.isEmpty())
                    break;
                if (!repairDeskStatus[deskNum]) {
                    int[] waitCustomer = waitQ.poll();
                    int waitCustomerNum = waitCustomer[0];
                    int outTime = currentTime + repairDesk[deskNum];
                    int prevDeskNum = waitCustomer[2];

                    repairQ.offer(new int[] { waitCustomerNum, deskNum, outTime });
                    repairDeskStatus[deskNum] = true;

                    if (prevDeskNum + 1 == A && deskNum + 1 == B) {
                        result += waitCustomerNum;
                    }
                }
            }

            // 자리가 생겼으니 receptionQ를 비워준다
            while (!receptionQ.isEmpty() && currentTime == receptionQ.peek()[2]) {
                int[] receptionComplete = receptionQ.poll();
                int deskNum = receptionComplete[1];

                receptionDeskStatus[deskNum] = false;

                // 그럼 repairDesk로 가기 위한 waitQ에 넣어준다.
                int customerNum = receptionComplete[0];
                waitQ.offer(new int[] { customerNum, currentTime, deskNum });
            }

            // 새로운 고객을 receptionQ에 넣어준다
            while (newCustomerNum <= K && customer[newCustomerNum - 1] <= currentTime) {
                boolean assigned = false;
                for (int deskNum = 0; deskNum < N; deskNum++) {
                    if (!receptionDeskStatus[deskNum]) {
                        int outTime = currentTime + receptionDesk[deskNum];
                        receptionQ.offer(new int[] { newCustomerNum, deskNum, outTime });
                        receptionDeskStatus[deskNum] = true;
                        newCustomerNum++;
                        assigned = true;
                        break; // 한 명만 처리하고 창구 확인 다시
                    }
                }
                if (!assigned)
                    break; // 자리가 없으면 대기
            }

            if (newCustomerNum > K && receptionQ.isEmpty() && waitQ.isEmpty() && repairQ.isEmpty())
                break;

        }
    }
}