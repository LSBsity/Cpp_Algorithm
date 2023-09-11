#include <string>
#include <vector>
#include <numeric>
#include <math.h>
using namespace std;

int solution(vector<int> arr1, vector<int> arr2) {
    if (arr1.size() == arr2.size())
        return accumulate(arr1.begin(), arr1.end(), 0) == accumulate(arr2.begin(), arr2.end(), 0) ? 0 : accumulate(arr1.begin(), arr1.end(), 0) > accumulate(arr2.begin(), arr2.end(), 0) ? 1 : -1;
    else
        return arr1.size() > arr2.size() ? 1 : -1;
}