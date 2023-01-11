class Solution2244 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        int res = 0;
        for (int k : freq.keySet()) {
            int count = freq.get(k);
            if (count == 1) {
                return -1;
            } else {
                res += (count + 2) / 3;
            }
        }
        return res;
    }
}
/*
freq = 3*m  -> m
       3m+1 -> (m-1) + 2 = m+1
       3m+2 -> m + 1
*/