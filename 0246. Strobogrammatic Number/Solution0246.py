class Solution0246:
    def isStrobogrammatic(self, num: str) -> bool:
        digit_map = {'0': '0', '1': '1', '6': '9', '8': '8', '9': '6'}
        i, j = 0, len(num) - 1
        while i <= j:
            if num[i] not in digit_map or \
                digit_map[num[i]] != num[j]:
                return False
            i+=1
            j-=1
        return True