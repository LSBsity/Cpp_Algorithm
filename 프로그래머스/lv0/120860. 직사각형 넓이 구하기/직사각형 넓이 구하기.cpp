#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<vector<int>> dots)
{
    vector<int> xBig;
    vector<int> yBig;

    for (int i = 0; i < dots.size(); i++)
    {
        xBig.push_back(dots[i][0]);
        yBig.push_back(dots[i][1]);
    }

    sort(xBig.begin(), xBig.end());
    sort(yBig.begin(), yBig.end());


    int a = xBig[xBig.size()-1] - xBig[0];
    int b = yBig[yBig.size()-1] - yBig[0];

    return a * b;
}