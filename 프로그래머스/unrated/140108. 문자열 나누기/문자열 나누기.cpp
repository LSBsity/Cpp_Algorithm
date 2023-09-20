#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int fir = 0, sec = 0, cnt = 0, i = 0;
    while (s.size() && i < s.size()) {
        char x = s[0];
        s[i] == x ? fir++ : sec++;
        if (fir == sec) {
            s = s.substr(fir + sec);
            cnt++;
            i = fir = sec = 0;
            continue;
        } else if (s.size() <= 1) {
            cnt++;
            break;
        }
        i++;
    }
    if (fir != sec && s.size() <= i) cnt++;
    return cnt;
}
