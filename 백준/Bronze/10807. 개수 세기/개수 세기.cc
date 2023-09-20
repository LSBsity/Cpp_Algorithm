#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main(void)
{
    vector<int> arr;
    int a;
    cin >> a;

    for (int i = 0; i < a; i++)
    {
        int b;
        cin >> b;
        arr.push_back(b);
    }
    int c;
    int count = 0;
    cin >> c;
    for (int i = 0; i < arr.size(); i++)
    {
        if (arr[i] == c)
            count++;
    }
    
    cout << count;

    return 0;
}