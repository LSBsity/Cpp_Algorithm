#include <string>
#include <vector>
#include <memory.h>
using namespace std;

int solution(int n, int m, vector<int> section) {
    int* wall = new int[n + 1];
    memset(wall, 0, sizeof(int) * n + 1);

    for (int i = 0; i < section.size(); i++)
    wall[section[i]] = 1;

    int cnt = 0;
    for (int i = 1; i <= n; i++) {
        if (wall[i]) {
            for (int j = i; j < i + m; j++) {
                if (j > n) break;
                wall[j] = 0;
            }
            cnt++;
        }
    }
    return cnt;
}
