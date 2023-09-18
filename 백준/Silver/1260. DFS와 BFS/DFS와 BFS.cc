#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
#define MAX 100001
#define endl '\n';

vector<int> graph[MAX];
bool visited[MAX];
bool visited1[MAX];

bool compare(int a, int b)
{
    return a < b;
}

void dfs(int x)
{
    visited[x] = true;
    cout << x << " ";
    for (int i = 0; i < graph[x].size(); i++)
    {
        int y = graph[x][i];
        if (!visited[y])
            dfs(y);
    }
}

void bfs(int start)
{
    queue<int> q;
    q.push(start);
    visited1[start] = true;
    while (!q.empty())
    {
        int x = q.front();
        q.pop();
        cout << x << ' ';
        for (int i = 0; i < graph[x].size(); i++)
        {
            int y = graph[x][i];
            if (!visited1[y])
            {
                q.push(y);
                visited1[y] = true;
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
    
    for (int i = 1; i < m; i++)
        sort(graph[i].begin(), graph[i].end(), compare);

    dfs(r);
    cout << endl;
    bfs(r);
    
    return 0;
}