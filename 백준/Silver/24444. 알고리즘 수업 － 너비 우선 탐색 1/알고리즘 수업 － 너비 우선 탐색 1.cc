#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
#define MAX 100001

vector<int> graph[MAX];
bool visited[MAX];
int result[MAX];
int cnt = 0;

bool compare(int n, int m)
{
    return n < m;
}

void bfs(int start)
{
    queue<int> q;
    q.push(start);
    visited[start] = true;
    result[start] = ++cnt;
    while (!q.empty())
    {
        int x = q.front();
        q.pop();
        for (int i = 0; i < graph[x].size(); i++)
        {
            int y = graph[x][i];
            if (!visited[y])
            {
                visited[y] = true;
                result[y] = ++cnt;
                q.push(y);
            }
        }
    }
}

int main()
{
    int n, m, r;
    scanf("%d %d %d", &n, &m, &r);

    for (int i = 1; i <= m; i++)
    {
        int n, m;
        scanf("%d %d", &n, &m);
        graph[n].push_back(m);
        graph[m].push_back(n);
    }
    for (int i = 1; i <= n; i++)
        sort(graph[i].begin(), graph[i].end(), compare);

    bfs(r);

    for (int i = 1; i <= n; i++)
        cout << result[i] << "\n";

    return 0;
}