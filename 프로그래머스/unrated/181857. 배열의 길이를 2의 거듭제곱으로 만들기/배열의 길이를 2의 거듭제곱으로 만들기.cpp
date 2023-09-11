#include <string>
#include <vector>
#include <math.h>
using namespace std;

vector<int> solution(vector<int> arr) {
    int cnt = 1;
    
    while (cnt < arr.size())
        cnt *= 2;
    
    arr.resize(cnt, 0);
    
    return arr;
}