#include <iostream>

using namespace std;

int main()
{
    int king = 1;
    int queen = 1;
    int rook = 2;
    int shop = 2;
    int knight = 2;
    int pon = 8;

    int in_king, in_queen, in_rook, in_shop, in_knight, in_pon;
    cin >> in_king;
    cin >> in_queen;
    cin >> in_rook;
    cin >> in_shop;
    cin >> in_knight;
    cin >> in_pon;

    cout << king - in_king << " ";
    cout << queen - in_queen << " ";
    cout << rook - in_rook << " ";
    cout << shop - in_shop << " ";
    cout << knight - in_knight << " ";
    cout << pon - in_pon << " ";

    return 0;
}