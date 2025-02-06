import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] counts = new int[N + 2];

        for (int i : stages) {
            counts[i]++;
        }

        List<Pair> pairs = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = i; j <= N + 1; j++) {
                sum += counts[j];
            }
            pairs.add(new Pair(i, sum == 0 ? 0 : (double) counts[i] / sum));
        }

        pairs.sort(
                Comparator.comparing(Pair::getRate)
                        .reversed()
                        .thenComparing(Pair::getIdx)
        );

        return pairs.stream()
                .mapToInt(Pair::getIdx)
                .toArray();
    }

    static class Pair {
        int idx;
        double rate;

        public Pair(int idx, double rate) {
            this.idx = idx;
            this.rate = rate;
        }

        public int getIdx() {
            return idx;
        }

        public double getRate() {
            return rate;
        }
    }
}