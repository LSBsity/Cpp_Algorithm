#include <string>
#include <vector>
#include <numeric>
#include <math.h>

using namespace std;

int solution(vector<int> num_list) {
    int answer = 0;
    return accumulate(num_list.begin(), num_list.end(), 1, multiplies<int>()) < pow(accumulate(num_list.begin(), num_list.end(),0), 2) ? 1 : 0;
}