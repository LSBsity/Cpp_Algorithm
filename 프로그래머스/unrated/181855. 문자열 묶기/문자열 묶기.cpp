#include <string>
#include <vector>
#include <algorithm>
using namespace std;


int solution(vector<string> strArr) {
    vector<int> arr(99999,0);
    
    for (int i = 0; i < strArr.size(); i++) arr[strArr[i].size()]++;
    
    return *max_element(arr.begin(),arr.end());
}