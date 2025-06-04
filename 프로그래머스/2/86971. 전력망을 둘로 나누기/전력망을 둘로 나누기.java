class Solution {

    private int getParent(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    private void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private int countGroupSize(int[] parent, int group) {
        int count = 0;
        for (int i = 1; i < parent.length; i++) {
            if (getParent(parent, i) == group) {
                count++;
            }
        }
        return count;
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            int[] parent = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                parent[j] = j;
            }

            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                unionParent(parent, wires[j][0], wires[j][1]);
            }

            int groupRoot = getParent(parent, 1);
            int groupSize = countGroupSize(parent, groupRoot);
            int otherSize = n - groupSize;
            int diff = Math.abs(groupSize - otherSize);

            answer = Math.min(answer, diff);
        }

        return answer;
    }
}