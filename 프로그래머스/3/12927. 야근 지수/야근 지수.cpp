#include <string>
#include <vector>
#include <queue>
#include <numeric>
#include <math.h>
using namespace std;

long long solution(int n, vector<int> works) {
    long long answer = 0;
    priority_queue<int> q(works.begin(), works.end());
    int k = accumulate(works.begin(), works.end(), 1);

    while (n) {
        int z = q.top();
        q.pop();
        while (z >= q.top()) {
            z--, n--, k--;
            if (!k) return 0;
            if (!n) break;
        }
        q.push(z);
    }

    while (!q.empty()) {
        int i = q.top();
        q.pop();
        answer += pow(i, 2);
    }

    return answer;
}