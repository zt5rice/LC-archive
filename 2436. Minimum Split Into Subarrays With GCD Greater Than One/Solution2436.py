class Solution2436:
    def minimumSplits(self, nums: List[int]) -> int:
        res, gcd = 1, nums[0]
        
        def getGcd(a:int, b:int)->int:
            return a if b == 0 else getGcd(b, a%b)
        
        for num in nums:
            gcd = getGcd(gcd, num)
            if gcd == 1:
                gcd = num
                res += 1
        return res