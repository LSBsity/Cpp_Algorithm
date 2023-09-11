#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<int> query) {
    for (int i = 0; i < query.size(); i++)
    {
        if (i % 2)
            arr.erase(arr.begin(), arr.begin() + query[i]);
        else
            arr.erase(arr.begin() + query[i] + 1, arr.end());
    }
    return arr;
}