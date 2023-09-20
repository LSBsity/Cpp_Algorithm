#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>

using namespace std;
#define MAX 301

int T, I;
int arr[MAX][MAX];
bool visited[MAX][MAX];
int cx, cy, tx, ty;
int dx[] = {2, 1, -1, -2, -2, -1, 1, 2};
int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
queue<pair<int, int>> q;
vector<int> ans;

void bfs(int x, int y)
{
    q.push({x, y});
    visited[x][y] = true;
    while (!q.empty())
    {
        int a = q.front().first;
        int b = q.front().second;
        q.pop();
        if (a == tx && b == ty)
        {
            ans.push_back(arr[a][b]);
            while (!q.empty())
            {
                q.pop();
            }
            break;
        }
        for (int i = 0; i < 8; i++)
        {
            int na = a + dx[i];
            int nb = b + dy[i];
            if (0 <= na && 0 <= nb && na < I && nb < I && !visited[na][nb])
            {
                q.push({na, nb});
                visited[na][nb] = true;
                arr[na][nb] = arr[a][b] + 1;
            }
        }
    }
}

int main()
{
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> I;
        cin >> cx >> cy;
        cin >> tx >> ty;

        bfs(cx, cy);
        memset(arr, 0, sizeof(arr));
        memset(visited, 0, sizeof(visited));
    }
    for (int i = 0; i < ans.size(); i++)
        cout << ans[i] << endl;
}
