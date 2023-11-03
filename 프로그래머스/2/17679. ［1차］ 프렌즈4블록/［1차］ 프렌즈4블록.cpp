#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int m, int n, vector<string> v) {
    int answer = 0, sign;
    queue<pair<int, int>> t;

    while (1) {
        sign = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (v[i][j] != ' ' && v[i][j] == v[i][j + 1] && v[i][j] == v[i + 1][j] && v[i][j] == v[i + 1][j + 1]) {
                    t.push({i, j});
                    sign = 1;
                }
            }
        }

        if (!sign) break;
        vector<vector<int>> visited(m, vector<int>(n, 0));

        while (!t.empty()) {
            auto i = t.front();
            t.pop();
            int x = i.first, y = i.second;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (!visited[x + i][y + j]) {
                        v[x + i][y + j] = ' ';
                        visited[x + i][y + j]++;
                        answer++;
                    }
                }
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (v[i + 1][j] == ' ' && v[i][j] != ' ') {
                    int x = i + 1;
                    char temp = v[i][j];
                    v[i][j] = ' ';
                    while (x + 1 < m && v[x + 1][j] == ' ') x++;
                    v[x][j] = temp;
                }
            }
        }
    }

    return answer;
}