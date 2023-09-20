#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;
#define MAX 100001

vector<int> graph[MAX];
bool visited[MAX];
int result[MAX];
int cnt = 0;

bool compare(int a, int b)
{
    return a < b;
}

void dfs(int r)
{
    visited[r] = true;
    cnt++;
    result[r] = cnt;
    for (int i = 0; i < graph[r].size(); i++)
    {
        int y = graph[r][i];
        if (!visited[y])
        {
            dfs(y);
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

    dfs(r);

    for (int i = 1; i <= n; i++)
        cout << result[i] << '\n';
    
    

    return 0;
}