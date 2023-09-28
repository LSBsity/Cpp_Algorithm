#include <string>
#include <vector>
#include <map>
using namespace std;

typedef struct {
    int x, y;
} coor;

vector<int> solution(vector<string> p, vector<string> r) {
    pair<int, int> start;

    int row = p.size();
    int col = p[0].size();

    for (int i = 0; i < row; i++)
        for (int j = 0; j < col; j++) 
            if (p[i][j] == 'S')
                start = make_pair(i,j);

    map<char, int> map = {{'N', 0}, {'S', 1}, {'W', 2}, {'E', 3}};
    coor movable[4] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    for (string route : r) {
        char dir = map[route[0]];
        int dis = route[2] - '0';

        int nx = start.first;
        int ny = start.second;

        while (dis--) {
            nx += movable[dir].x;
            ny += movable[dir].y;

            if ((nx < 0 || row <= nx || ny < 0 || col <= ny) || p[nx][ny] == 'X')
                break;
        }
        if (dis < 0) start = make_pair(nx, ny);
    }

    return {start.first, start.second};
}