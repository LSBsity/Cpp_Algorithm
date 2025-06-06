class Solution {
    
    private void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }
    
    private int findParent(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = findParent(parent, parent[x]);
    }
    
    private int getGroupSize(int[] parent, int x) {
        int count = 0;
        for (int i = 1; i < parent.length; i++) {
            if (findParent(parent, i) == x) {
                count++;
            }
        }
        return count;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] parent = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                parent[j] = j;
            }    
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                unionParent(parent, wires[j][0], wires[j][1]);
            }
            
            int rootSize = getGroupSize(parent, 1);
            int remain = n - rootSize;
            int diff = Math.abs(remain - rootSize);
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
}