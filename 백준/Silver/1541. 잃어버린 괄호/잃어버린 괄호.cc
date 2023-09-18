#include <iostream>
#include <deque>
#include <algorithm>
#include <vector>
#include <sstream>
#define endl '\n'
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string str;
    cin >> str;
    stringstream ss(str);
    int n; char c;
    ss >> n;
    int sum = n;
    int save = 0;

    while (!ss.eof())
    {
        ss >> c;
        ss >> n;

        if (c == '+')
        {
            if (save == 0) sum += n;
            else save += n;
        }
        else if (c == '-')
        {
            if (save == 0) save += n;
            else
            {
                sum -= save;
                save = n;
            }
        }
    }

    if (save != 0)
        sum -= save;

    cout << sum;

    return 0;
}
