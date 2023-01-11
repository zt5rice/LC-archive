class Solution1027 {
    // public int longestArithSeqLength(int[] nums) {
    //     int n = nums.length;
    //     Map<Integer, Integer>[] diffMap = new Map[n];
    //     int res = 2;
    //     for (int i = 0; i < n; i++) {
    //         diffMap[i] = new HashMap<Integer, Integer>();
    //         for (int j = 0; j < i; j++) {
    //             int diff = nums[i] - nums[j];
    //             int count = diffMap[j].getOrDefault(diff,1) + 1;
    //             diffMap[i].put(diff, count);
    //             res = Math.max(res, count);
    //         }
    //     }
    //     return res;
    // }
    public int longestArithSeqLength(int[] A) {
        //minimum sequence is 2 because any two numbers can be a sequence for ex: 1,2 or 1,10 or 2,7 it is a sequence
        int res = 2, n = A.length;
        //define an array of hashmaps for a difference with previous numbers - hashmap key as difference, value as a counter
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        //outer loop - interate through numbers
        for (int j = 0; j < A.length; j++) {
            //create a hashmap
            dp[j] = new HashMap<>();
            //iterate from beginning to find a difference with all previous numbers
            for (int i = 0; i < j; i++) {
                int d = A[j] - A[i];
                //for the difference, look in the "i"th hashmap if that difference exist, if it does, increment the counter
                //dp: [{},{1:2},{2:2,3:2},{3:3,5:2,6:2},{1:2,4:2,6:2,7:2}] check 3:3 for 4, 7, 10
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                //take max 
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }
}