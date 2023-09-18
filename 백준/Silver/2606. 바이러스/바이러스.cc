#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
#define MAX 100001

vector<int> graph[MAX];
bool visited[MAX];
int cnt = 0;

void bfs(int start)
{
    queue<int> q;
    q.push(start);
    visited[start] = true;
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
                cnt++;
                q.push(y);
            }
        }
    }
    cout << cnt;
}

int main()
{
    int n, m;
    scanf("%d %d", &n, &m);

    for (int i = 1; i <= m; i++)
    {
        int n, m;
        scanf("%d %d", &n, &m);
        graph[n].push_back(m);
        graph[m].push_back(n);
    }


    bfs(1);

    return 0;
}