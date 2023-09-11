#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {

    if (arr[arr.size() - 1] > arr[arr.size() - 2])
        arr.push_back(arr[arr.size() - 1] - arr[arr.size() - 2]);
    else
        arr.push_back(arr[arr.size() - 1] * 2);
    return arr;
}