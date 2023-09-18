#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
#define endl '\n';

int a, b;
int cnt = 0;
int arr[101][101];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int bfs(int x, int y)
{
    queue<pair<int, int>> q;
    q.push({x, y});

    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= a || ny < 0 || ny >= b)
                continue;

            if (arr[nx][ny] == 0)
                continue;

            if (arr[nx][ny] == 1)
            {
                arr[nx][ny] = arr[x][y] + 1;
                q.push({nx, ny});
            }
        }
    } 
    
    return arr[a - 1][b - 1];
}

int main()
{
    cin >> a >> b;
    for (int i = 0; i < a; i++)
    {
        for (int j = 0; j < b; j++)
            scanf("%1d", &arr[i][j]);
    }

    cout << bfs(0, 0) << "\n";

    return 0;
}
