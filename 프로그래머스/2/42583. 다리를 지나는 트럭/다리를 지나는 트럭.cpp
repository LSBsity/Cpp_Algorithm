#include <string>
#include <vector>
#include <queue>
#include <string.h>
using namespace std;

typedef struct {
    int time;
    int w;
} info;

int solution(int len, int w, vector<int> v) {
    queue<int> q;
    info arr[10001];
    memset(arr, 0, sizeof(arr));
    int i = 0, sec = 0, max = 0;
    do {
        sec++;
        if (!q.empty() && arr[q.front()].time + len <= sec) {
            max -= arr[q.front()].w;
            q.pop();
        }
        if (i < v.size() && max + v[i] <= w) {
            max += v[i];
            q.push(i);
            arr[i].time = sec, arr[i].w = v[i];
            i++;
        }
    } while (!q.empty());

    return sec;
}