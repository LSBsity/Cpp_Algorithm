#include <string>
#include <vector>
#include <math.h>
#include <set>
#include <algorithm>
using namespace std;

bool check(int num) {
    for (int i = 2; i <= sqrt(num); i++)
        if (!(num % i)) return false;
    return true;
}

int solution(string str) {
    int answer = 0;
    set<int> nums;
    sort(str.begin(), str.end());
    string temp;
    do {
        for (int i = 1; i <= str.size(); i++) {
            temp = str.substr(0, i);
            nums.insert(stoi(temp));
        }
    } while (next_permutation(str.begin(), str.end()));

    for (set<int>::iterator it = nums.begin(); it != nums.end(); it++)
        if (*it >= 2 && check(*it)) answer++;

    return answer;
}