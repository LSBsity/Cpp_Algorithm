#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string word) {
    vector<string> v;
    string arr = "AEIOU";
    for (int a = 0; a < 5; a++) {
        v.push_back(string(1, arr[a]));
        for (int b = 0; b < 5; b++) {
            v.push_back(string(1, arr[a]) + string(1, arr[b]));
            for (int c = 0; c < 5; c++) {
                v.push_back(string(1, arr[a]) + string(1, arr[b]) + string(1, arr[c]));
                for (int d = 0; d < 5; d++) {
                    v.push_back(string(1, arr[a]) + string(1, arr[b]) + string(1, arr[c]) + string(1, arr[d]));
                    for (int e = 0; e < 5; e++) 
                        v.push_back(string(1, arr[a]) + string(1, arr[b]) + string(1, arr[c]) + string(1, arr[d]) + string(1, arr[e]));
                }
            }
        }
    }
    
    return find(v.begin(), v.end(), word) - v.begin() + 1;
}