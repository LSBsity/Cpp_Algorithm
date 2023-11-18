#include <string>
#include <vector>

using namespace std;

int iMax = 1000001;
int cnt[1000001] = {
    0,
};

int solve(int x, int y, int n, int count) {
    if (cnt[x] != 0 && cnt[x] <= count) return iMax;

    cnt[x] = count;
    if (x == y) return count;

    int one,two,three;
    one = two = three = iMax;

    if (x + n <= y) one = solve(x + n, y, n, count + 1);
    if (x * 2 <= y) two = solve(x * 2, y, n, count + 1);
    if (x * 3 <= y) three = solve(x * 3, y, n, count + 1);

    return min(one, min(two, three));
}

int solution(int x, int y, int n) {
    int answer = solve(x, y, n, 0);

    return answer >= iMax ? -1 : answer;
}