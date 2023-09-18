#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main(void)
{
    vector<int> arr, arr2;
    int a, b, sum, goal = 0;
    int min = 9999999;
    cin >> a >> b;
    for (int i = 0; i < a; i++)
    {
        int temp;
        cin >> temp;
        arr.push_back(temp);
    }
    for (int i = 0; i < a - 2; i++)
        for (int j = i + 1; j < a - 1; j++)
            for (int z = j + 1; z < a; z++)
            {
                sum = arr[i] + arr[j] + arr[z];
                if (b - sum < min && b - sum >= 0)
                {
                    min = b - sum;
                    goal = sum;
                }
            }
    cout << goal << endl;

    return 0;
}