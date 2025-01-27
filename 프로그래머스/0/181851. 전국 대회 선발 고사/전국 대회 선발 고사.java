import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;

        List<Pairs> list = new ArrayList<>();
        for (int i = 0; i < rank.length; i++) {
            list.add(new Pairs(rank[i], attendance[i], i));
        }

        list.sort(Comparator.comparing(Pairs::getRank));

        int[] ints = new int[3];
        int idx = 0;
        for (Pairs p : list) {
            if (p.getAvail()) {
                ints[idx++] = p.getIndex();
                if (idx == 3) break;
            }
        }

        return 10000 * ints[0] + 100 * ints[1] + ints[2];
    }

    static class Pairs {

        Integer rank;
        Boolean avail;
        Integer index;

        public Pairs(Integer rank, Boolean avail, int index) {
            this.rank = rank;
            this.avail = avail;
            this.index = index;
        }


        public Integer getRank() {
            return rank;
        }

        public Boolean getAvail() {
            return avail;
        }

        public Integer getIndex() {
            return index;
        }
    }
}