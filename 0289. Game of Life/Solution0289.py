class Solution: #22
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        dd = [-1,0,1]
        r, c = len(board), len(board[0])
        
        def countNei(curr: int, curc: int) -> int:
            count = 0
            for dr, dc in product(dd, dd):
                if dr == 0 and dc == 0: 
                    continue
                nr, nc = curr+dr, curc + dc
                if 0 <= nr < r and 0 <= nc < c and abs(board[nr][nc]) == 1:
                    count += 1
            return count
        
        for i in range(r):
            for j in range(c):
                cur_count = countNei(i, j)
                if board[i][j] == 1 and (cur_count < 2 or cur_count > 3):
                    board[i][j] = -1
                elif board[i][j] == 0 and cur_count == 3:
                    board[i][j] = 2
        
        for i in range(r):
            for j in range(c):
                if board[i][j] > 0:
                    board[i][j] = 1
                else:
                    board[i][j] = 0
        