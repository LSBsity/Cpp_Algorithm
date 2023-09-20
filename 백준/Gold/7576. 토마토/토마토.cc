#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>

using namespace std;
#define MAX 1001

int N, M, result = 0;
int arr[MAX][MAX];

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

struct tomato
{
    int x, y;
};

queue<tomato> q;
bool check(int nx, int ny)
{
    return (0 <= nx && 0 <= ny && nx < M && ny < N);
}

void bfs()
{
    while (!q.empty())
    {
        int x = q.front().x;
        int y = q.front().y;
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (check(nx, ny) && arr[nx][ny] == 0)
            {
                arr[nx][ny] = arr[x][y] + 1;
                q.push({nx, ny});
            }
        }
    }
}

int main()
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        for (int j = 0; j < N; j++)
        {
            scanf("%d", &arr[i][j]);
            if (arr[i][j] == 1)
                q.push({i, j});
        }
    }
    bfs();

    for (int i = 0; i < M; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (arr[i][j] == 0)
            {
                cout << "-1";
                return 0;
            }
            else if (arr[i][j] > result)
                result = arr[i][j];
        }
    }

    cout << result - 1;

    return 0;
}