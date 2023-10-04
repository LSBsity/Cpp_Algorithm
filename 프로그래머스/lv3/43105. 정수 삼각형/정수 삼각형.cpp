#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> t) {
    int k = t.size() - 1;
    reverse(t.begin(), t.end());
    for (int i = 0; i < t.size() - 1; i++) {
        for (int j = 0; j < k; j++)
            t[i + 1][j] = max(t[i][j] + t[i + 1][j], t[i][j + 1] + t[i + 1][j]);
        k--;
    }
    return t[t.size() - 1][0];
}