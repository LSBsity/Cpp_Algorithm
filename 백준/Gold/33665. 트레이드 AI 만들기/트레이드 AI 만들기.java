import java.io.*;
import java.util.*;

public class Main {

    static final int COLORS = 10;
    static final int PER_COLOR = 4;
    static final int TOTAL = COLORS * PER_COLOR;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // w[i][k]: 색상 i(0~9)에서 k개(0~4) 보유 시 가치, k=0은 0으로 채움
        int[][] w = new int[COLORS][5];
        for (int i = 0; i < COLORS; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= 4; k++) {
                w[i][k] = Integer.parseInt(st.nextToken());
            }
            w[i][0] = 0;
        }

        String ownStr = br.readLine().trim();   // 길이 40, '0','1','2'
        String tradeStr = br.readLine().trim(); // 길이 40, '0','1','2'
        String mortStr = br.readLine().trim();  // 길이 40, '0','1'

        int myCash = Integer.parseInt(br.readLine().trim());
        int oppCash = Integer.parseInt(br.readLine().trim());

        int myOfferCash = Integer.parseInt(br.readLine().trim());
        int oppOfferCash = Integer.parseInt(br.readLine().trim());

        int A = Integer.parseInt(br.readLine().trim());
        int B = Integer.parseInt(br.readLine().trim());

        int[] own = new int[TOTAL];    // 0,1(나),2(상대)
        int[] trade = new int[TOTAL];  // 0,1(내가 받음),2(상대가 받음)
        boolean[] mort = new boolean[TOTAL];
        for (int i = 0; i < TOTAL; i++) {
            own[i] = ownStr.charAt(i) - '0';
            trade[i] = tradeStr.charAt(i) - '0';
            mort[i] = mortStr.charAt(i) == '1';
        }

        if (!isValid(own, trade, myCash, oppCash, myOfferCash, oppOfferCash)) {
            System.out.println("NO");
            return;
        }

        // 2) 전 상태 가치
        int beforeMe = computeValue(true, own, mort, w, myCash, A, B);
        int beforeOpp = computeValue(false, own, mort, w, oppCash, A, B);

        // 3) 트레이드 적용
        int[] ownAfter = own.clone();
        // 도시 이동
        for (int i = 0; i < TOTAL; i++) {
            if (trade[i] == 1) {       // 상대 → 나
                // own: 2 -> 1
                ownAfter[i] = 1;
            } else if (trade[i] == 2) { // 나 → 상대
                // own: 1 -> 2
                ownAfter[i] = 2;
            }
        }
        // 현금 이동
        int myCashAfter = myCash - myOfferCash + oppOfferCash;
        int oppCashAfter = oppCash - oppOfferCash + myOfferCash;

        // 4) 후 상태 가치
        int afterMe = computeValue(true, ownAfter, mort, w, myCashAfter, A, B);
        int afterOpp = computeValue(false, ownAfter, mort, w, oppCashAfter, A, B);

        // 5) 수락 조건 비교
        int beforeDiff = beforeMe - beforeOpp;
        int afterDiff = afterMe - afterOpp;

        System.out.println(afterDiff >= beforeDiff ? "YES" : "NO");
    }

    // 유효성 검사:
    // - trade[i]==1 이면 현재 소유가 반드시 2(상대)이어야 함
    // - trade[i]==2 이면 현재 소유가 반드시 1(나)이어야 함
    // - 현금 제시는 보유 이내
    static boolean isValid(int[] own, int[] trade, int myCash, int oppCash, int myOffer, int oppOffer) {
        if (myOffer > myCash) return false;
        if (oppOffer > oppCash) return false;

        for (int i = 0; i < TOTAL; i++) {
            if (trade[i] == 1) {
                if (own[i] != 2) return false; // 상대 소유가 아니면 내가 받을 수 없음
            } else if (trade[i] == 2) {
                if (own[i] != 1) return false; // 내 소유가 아니면 상대가 가져갈 수 없음
            }
        }
        return true;
    }

    // 플레이어별 재산가치 계산
    static int computeValue(boolean forMe, int[] own, boolean[] mort, int[][] w, int cash, int A, int B) {
        // 색상별 보유 수 카운트
        int sum = 0;
        for (int color = 0; color < COLORS; color++) {
            int cnt = 0;
            int base = color * PER_COLOR;
            for (int j = 0; j < PER_COLOR; j++) {
                int idx = base + j;
                if (forMe) {
                    if (own[idx] == 1) cnt++;
                } else {
                    if (own[idx] == 2) cnt++;
                }
            }
            sum += w[color][cnt];
        }

        sum += (cash * A) / 100;

        int mortCnt = 0;
        for (int i = 0; i < TOTAL; i++) {
            if (mort[i]) {
                if (forMe && own[i] == 1) mortCnt++;
                if (!forMe && own[i] == 2) mortCnt++;
            }
        }
        sum -= mortCnt * B;

        return sum;
    }
}