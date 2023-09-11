#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string my_string, vector<int> indices) {
    sort(indices.begin(), indices.end());
    
    for (int i = indices.size() - 1; i >= 0; i--)
        my_string.erase(my_string.begin() + indices[i]);
    
    return my_string;
} 