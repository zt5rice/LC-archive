from collections import deque
from typing import List

class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children

class Solution0429:
    def levelOrder(self, root: Node) -> List[List[int]]:
        res = []
        if not root: return res
        q = deque([root]) 
        while q:
            level = []
            len_ = len(q)
            for i in range(len_):
                cur_node = q.popleft()
                level.append(cur_node.val)
                for c in cur_node.children:
                    q.append(c)
            res.append(level)
        return res