#include <string>
#include <string.h>
#include <map>

#define ROW 6
#define COL 6

using namespace std;

typedef struct {
    int x, y;
} coor;

int solution(string dirs) {
    int answer = 0;
    pair<int, int> s = {0, 0};

    map<pair<pair<int, int>, pair<int, int>>, int> donePath;
    map<char, int> map = {{'U', 0}, {'D', 1}, {'L', 2}, {'R', 3}};
    coor mov[4] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int donePoint[12][12];
    memset(donePoint, 0, sizeof(donePoint));

    for (const auto& route : dirs) {
        char dir = map[route];
        coor next = {s.first + mov[dir].x, s.second + mov[dir].y};
        if ((next.x < -5 || ROW <= next.x || next.y < -5 || COL <= next.y)) {
            continue;
        }
        if (!donePath[{{s.first, s.second}, {next.x, next.y}}]) {
            answer++;
            donePath[{{s.first, s.second}, {next.x, next.y}}]++;
            donePath[{{next.x, next.y}, {s.first, s.second}}]++;
        }
        s = {next.x, next.y};
    }
    
    return answer;
}