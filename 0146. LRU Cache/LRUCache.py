from collections import OrderedDict
class LRUCache:

    def __init__(self, capacity: int):
        self.CAP = capacity
        self.cache = OrderedDict()

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        delVal = self.cache[key]
        del self.cache[key]
        self.cache[key] = delVal
        return delVal

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            del self.cache[key]
        elif len(self.cache) >= self.CAP:
            delKey = next(iter(self.cache))
            del self.cache[delKey]
        self.cache[key] = value
            


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)