#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
#define endl '\n';
#define MAX 50

int arr[MAX][MAX];
int visited[MAX][MAX];
int v, n, m, t;
int result = 0;
vector<int> vv;

bool dfs(int x, int y)
{
    if (x <= -1 || x >= n || y <= -1 || y >= m)
        return false;
    if (arr[x][y] == 1)
    {
        arr[x][y] = 0;
        dfs(x - 1, y);
        dfs(x, y - 1);
        dfs(x + 1, y);
        dfs(x, y + 1);
        return true;
    }
    return false;
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);
    cin >> v;
    for (int i = 0; i < v; i++)
    {
        cin >> n >> m >> t;
        for (int i = 0; i < t; i++)
        {
            int a, b;
            cin >> a >> b;
            arr[a][b] = 1;
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (dfs(i, j))
                    result++;
            }
        }
        vv.push_back(result);
        result = 0;
    }

    for (int i = 0; i < vv.size(); i++)
        cout << vv[i] << endl;
    

    return 0;
}