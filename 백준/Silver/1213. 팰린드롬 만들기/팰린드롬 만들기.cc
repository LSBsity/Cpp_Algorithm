#include <bits/stdc++.h>

using namespace std;

int arr[200];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int check = 0, mid;
    string str, ret;
    cin >> str;

    for (char i: str)
        arr[i]++;

    for (int i = 'Z'; i >= 'A'; i--) {
        if (arr[i]) {
            if (arr[i] & 1) {
                mid = (char) i;
                check++;
                arr[i]--;
            }
            if (check == 2)
                break;
            for (int j = 0; j < arr[i]; j += 2) {
                ret = (char) i + ret;
                ret += (char) i;
            }
        }
    }

    if (mid)
        ret.insert(ret.begin() + ret.size() / 2, mid);
    if (check == 2)
        cout << "I'm Sorry Hansoo\n";
    else
        cout << ret << "\n";

    return 0;
}