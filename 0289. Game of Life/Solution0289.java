class Solution0289 { // 54 - 06
    int[] del = new int[]{-1, 0, 1};
    int[][] board;
    int r, c;
    
    public void gameOfLife(int[][] board) {
        this.board = board;
        this.r = board.length; this.c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int curCount = countNei(i, j);
                // System.out.print(curCount + " ");
                if (board[i][j] == 1 && (curCount < 2 || curCount > 3)) {
                    this.board[i][j] = -1;
                } else if (board[i][j] == 0 && curCount == 3) {
                    this.board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                 if (this.board[i][j] > 0) {
                     this.board[i][j] = 1;
                 } else {
                     this.board[i][j] = 0;
                 }
            }
        }
        return;
    }
    
    private int countNei(int curr, int curc) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int dr = del[i], dc = del[j];
                if (dr == 0 && dc == 0) continue;
                int nextr = curr + dr, nextc = curc + dc;
                if (nextr >= 0 && nextr < r && nextc >= 0 && nextc < c && 
                    Math.abs(board[nextr][nextc]) == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}

/* c    n
1  1    0   count < 2                 board -1
2  1    1   2 <= count <= 3           board  1
3  0    1   count == 3                board  2

*/