class Solution0645:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        def swap(lists,n1,n2):
            temp = lists[n1]
            lists[n1] = lists[n2]
            lists[n2] = temp
    
        n = len(nums)
        for i in range(n):
            while nums[i] != i+1 and nums[nums[i]-1] != nums[i]:
                swap(nums, i, nums[i] - 1)
                
        dup, los = -1, -1
        for i in range(n):
            if nums[i] != i+1:
                dup = nums[i]
                los = nums[i-1]+1 if i > 0 else 1
        return [dup, los]