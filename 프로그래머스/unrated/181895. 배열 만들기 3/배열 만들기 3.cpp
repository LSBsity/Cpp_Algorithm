#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> intervals) {
    vector<int> x (arr.begin() + intervals[0][0], arr.begin() + intervals[0][1] + 1);
    vector<int> y (arr.begin() + intervals[1][0], arr.begin() + intervals[1][1] + 1);
    
    x.insert(x.end(), y.begin(), y.end());
    
    return x;
}