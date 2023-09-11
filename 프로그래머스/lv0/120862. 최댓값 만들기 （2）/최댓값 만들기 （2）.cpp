#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> arr)
{
    sort(arr.rbegin(), arr.rend());
    arr.erase(unique(arr.begin(), arr.end()), arr.end());
    int a = arr[0] * arr[1];
    int b = arr[arr.size()-2] * arr[arr.size()-1];

    return a > b ? a : b;
}