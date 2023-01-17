# modify solution to general size puzzle board
# lintcode https://www.lintcode.com/problem/794/
# leetcode https://leetcode.com/problems/sliding-puzzle/description/
class Solution0773:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        src = self.matrix_to_string(board)
        tgt = "123450"

        from collections import deque
        queue = deque([src])
        distance = {src: 0}

        while queue:
            curt = queue.popleft()
            if curt == tgt:
                return distance[tgt]
            for next in self.get_next(curt, board):
                if next in distance:
                    continue
                queue.append(next)
                distance[next] = distance[curt] + 1
        return -1
            
    def get_next(self, curt: string, board: List[List[int]]):
        states = []
        dirs = ((0,1),(1,0),(0,-1),(-1,0))
        zero_idx = curt.find('0')
        x, y = zero_idx // len(board[0]), zero_idx % len(board[0])
        for i in range(4):
            x_, y_ = x + dirs[i][0], y + dirs[i][1]
            if 0 <= x_ < len(board) and 0 <= y_ < len(board[0]):
                next_state = list(curt)
                next_state[x*len(board[0])+y] = next_state[x_*len(board[0])+y_]
                next_state[x_*len(board[0])+y_] = '0'
                states.append("".join(next_state))
        return states

    def matrix_to_string(self, board: List[List[int]]) -> str:
        str_list = []
        for i in range(len(board)):
            for j in range(len(board[0])):
                str_list.append(str(board[i][j]))
        return "".join(str_list)