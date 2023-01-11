class Solution0219:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        numset = set()
        for i,n in enumerate(nums):
            if n in numset: 
                return True
            numset.add(n)
            if len(numset) > k:
                numset.remove(nums[i-k])
        return False