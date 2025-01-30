class Solution {

    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1, idx = 1; i < food.length; i++, idx++) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(idx);
            }
        }

        return sb.toString() + sb.append("0").reverse();
    }
}