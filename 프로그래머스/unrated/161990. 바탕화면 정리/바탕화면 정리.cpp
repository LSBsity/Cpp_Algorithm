#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> v) {
    int xMin = 50, yMin = 50, xMax = -1, yMax = -1;
    for (int i = 0; i < v.size(); i++)
        for (int j = 0; j < v[0].size(); j++)
            if (v[i][j] == '#') {
                xMin = min(xMin, i);
                yMin = min(yMin, j);
                xMax = max(xMax, i);
                yMax = max(yMax, j);
            }

    return {xMin, yMin, xMax + 1, yMax + 1};
}