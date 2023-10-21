#include <iostream>
#include <string>

using namespace std;

int main() {
    string a;
    int i;
    cin >> i;
    
    while(i--) {
        cin >> a;
        cout << a[0] << a[a.size()-1] << endl;
    }
}