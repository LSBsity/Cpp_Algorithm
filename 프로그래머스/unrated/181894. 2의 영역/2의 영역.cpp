#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> arr) {
    
    vector<int>::iterator start = find(arr.begin(), arr.end(), 2);
    vector<int>::iterator end = find(arr.rbegin(), arr.rend(), 2).base(); 

    if (start == arr.end() || end == arr.begin())
        return vector<int>(1, -1);
    
    return vector<int> (start, end); 
}