class Solution0904:
    def totalFruit(self, fruits: List[int]) -> int:
        # 初始化
        i, j = 0, 0
        res = 0
        classMap = defaultdict(int)
        classCnt = 0
        
        # 移动滑窗右边界 
        while j < len(fruits):
            # 判断当前是否满足条件
            if classMap[fruits[j]] == 0:
                classCnt += 1
            classMap[fruits[j]] += 1

            # 若不满足条件，移动i
            while classCnt > 2:
                if classMap[fruits[i]] == 1:
                    classCnt -= 1
                classMap[fruits[i]] -= 1
                i += 1

            # 一旦满足条件，更新结果
            res = max(res, j - i + 1)
            j += 1
        return res



# 最小滑窗模板：给定数组 nums，定义滑窗的左右边界 i, j，求满足某个条件的滑窗的最小长度。


# while j < len(nums):
#     判断[i, j]是否满足条件
#     while 满足条件：
#         不断更新结果(注意在while内更新！)
#         i += 1 （最大程度的压缩i，使得滑窗尽可能的小）
#     j += 1
# 最大滑窗模板：给定数组 nums，定义滑窗的左右边界 i, j，求满足某个条件的滑窗的最大长度。

# while j < len(nums):
#     判断[i, j]是否满足条件
#     while 不满足条件：
#         i += 1 （最保守的压缩i，一旦满足条件了就退出压缩i的过程，使得滑窗尽可能的大）
#     不断更新结果（注意在while外更新！）
#     j += 1

# 作者：frostep
# 链接：https://leetcode.cn/problems/fruit-into-baskets/solution/shen-du-jie-xi-zhe-dao-ti-he-by-linzeyin-6crr/
# 来源：力扣（LeetCode）
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。