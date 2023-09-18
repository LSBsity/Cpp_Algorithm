#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int x, y, Xx, Yy, answer;
    cin >> x >> y >> Xx >> Yy;
    vector<int> xX;
    xX.push_back(Yy - y);
    xX.push_back(Yy - xX[0]);
    xX.push_back(Xx - x);
    xX.push_back(Xx - xX[2]);
    sort(xX.begin(), xX.end());
    cout << xX[0];
}
