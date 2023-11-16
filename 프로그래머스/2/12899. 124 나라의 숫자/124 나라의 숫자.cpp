#include <string>
#include <vector>

using namespace std;

string solution(int n) {
    string answer = "";
    int rem = 0;
    while(n != 0) {
        rem = n % 3, n /= 3;
        if (rem == 0) {
            answer = "4" + answer;
            n--;
        } else {
            answer = to_string(rem) + answer;
        }
    }
    return answer;
}