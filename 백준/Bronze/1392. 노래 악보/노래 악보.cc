#include <iostream>
#include <algorithm>

using namespace std;

int main()
{

    int N, Q;
    cin >> N >> Q;
    int A[N+1]; A[0] = 0;
    for (int i=1; i<=N; i++)
        cin >> A[i];

    for (int i=1; i<=N; i++) {
        A[i] += A[i-1];
    }

    for (int i=0; i<Q; i++) {
        int q; cin >> q;
        cout << distance(A, upper_bound(A, A+(N+1), q)) << endl;
    }
}