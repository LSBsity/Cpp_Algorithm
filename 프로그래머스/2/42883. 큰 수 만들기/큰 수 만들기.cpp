#include <string>
#include <vector>
#include <stack>
using namespace std;

string solution(string number, int k) {
    string ans = "";
    stack<char> stk;
    int i = 0;

    while (k > 0 && i < number.size()) {
        while (!stk.empty() && k > 0 && stk.top() < number[i]) {
            stk.pop();
            k--;
        }
        stk.push(number[i]);
        i++;
    }

    while (!stk.empty()) {
        ans = stk.top() + ans;
        stk.pop();
    }
    
    ans += number.substr(i);
    if (k) ans.erase(ans.size() - 1, 1);

    return ans;
}