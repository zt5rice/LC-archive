from typing import List


class Solution0974:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        m = [0 for i in range(k)]
        m[0] = 1
        count, tot_sum = 0, 0
        for num in nums:
            tot_sum += num
            cur_rem = tot_sum % k
            if cur_rem < 0:
                cur_rem = cur_rem + k
            count += m[cur_rem]
            m[cur_rem] += 1
            
        return count