#include<iostream>
#include<vector>

using namespace std;

class Solution0419 {
public:
    int countBattleships(vector<vector<char>>& board) {
        int r = board.size(), c = board[0].size();
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != 'X') continue;
                if ((i > 0 && board[i-1][j] == 'X') ||
                   (j > 0 && board[i][j-1] == 'X') ) continue;
                count++;
            }
        }
        return count;
    }
};