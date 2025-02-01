class Solution {

    public int solution(int[] common) {
        int diff = common[1] - common[0];
        int last = common[common.length - 1];

        if (common[2] - common[1] == diff) {
            return last + diff;
        }

        int diffs = common[2] / common[1];
        int lasts = last * diffs;
        if (last < 0) {
            return lasts * -1;
        } else {
            return lasts;
        }
    }
}