#include <string>
#include <vector>
#include <numeric>

using namespace std;

int solution(vector<int> arr) {
    return arr.size() >= 11 ? accumulate(arr.begin(), arr.end(), 0) : accumulate(arr.begin(), arr.end(), 1,multiplies<int>());
}