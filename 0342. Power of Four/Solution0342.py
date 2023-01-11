class Solution0342:
    def isPowerOfFour(self, num: int) -> bool:
         return (num > 0) and ((num & (num - 1)) == 0) and ((num & 0xaaaaaaaa) == 0)