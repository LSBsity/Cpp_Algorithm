#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<vector<int>> v) {
    int s = v.size();
    for (int i = 1; i < s; i++) {
        v[i][0] += max({v[i - 1][1], v[i - 1][2], v[i - 1][3]});
        v[i][1] += max({v[i - 1][0], v[i - 1][2], v[i - 1][3]});
        v[i][2] += max({v[i - 1][0], v[i - 1][1], v[i - 1][3]});
        v[i][3] += max({v[i - 1][0], v[i - 1][1], v[i - 1][2]});
    }
    s--;
    return max({v[s][0], v[s][1], v[s][2], v[s][3]});
}