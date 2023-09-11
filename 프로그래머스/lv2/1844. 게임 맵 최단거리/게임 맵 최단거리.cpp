#include <vector>
#include <queue>
using namespace std;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
queue<pair<int, int>> q;

int solution(vector<vector<int>> maps)
{
    q.push({0, 0});

    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= maps.size() || ny < 0 || ny >= maps[0].size())
                continue;
            if (maps[nx][ny] == 0)
                continue;
            if (maps[nx][ny] == 1)
            {
                maps[nx][ny] = maps[x][y] + 1;
                q.push({nx, ny});
            }
        }
    }

    if (maps[maps.size() - 1][maps[0].size() - 1] > 1)
        return maps[maps.size() - 1][maps[0].size() - 1];
    else
        return -1;
}