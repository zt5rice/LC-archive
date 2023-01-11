"""
Time complexity: O(N)
Space complexity: O(N) => stack space
"""
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack = []
        max_len = 0
        cur_str = []
        left = 0
        for i in range(len(s)):
            if s[i] == "(":
                stack.append(i)
                left += 1
            else:  # s[i] == ")"
                if left > 0:
                    left -= 1
                    left_idx = stack.pop()
                    while cur_str and (left_idx < cur_str[-1][0]):
                        cur_str.pop()
                    if cur_str and left_idx == cur_str[-1][1] + 1:
                        cur_str[-1][1] = i
                    else:
                        cur_str.append([left_idx, i])
            if cur_str:
                max_len = max(max_len, cur_str[-1][1] - cur_str[-1][0]+1)
        return max_len

    def longestValidParentheses2(self, s: str) -> int:
        stk = []
        n, res = len(s), 0
        for i in range(n):
            if s[i] == '(':
                stk.append(i)
            else:
                if len(stk) > 0 and s[stk[-1]] == '(':
                    stk.pop()
                    left = -1 if len(stk) == 0 else stk[-1]
                    res = max(res, i - left)
                else:
                    stk.append(i)
        return res