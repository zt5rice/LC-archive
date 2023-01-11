class Solution0163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int prev = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            int curr = (i < nums.length) ? nums[i] : upper + 1;
            if (prev + 1 <= curr - 1) {
                result.add(formatRange(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return result;
    }

    // formats range in the requested format
    private String formatRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        }
        return lower + "->" + upper;
    }
}


/*0 -1 1 0 2 2 4 49 51 74  76  99
 0  [ 0,  1,  3,  50,    75] 99
 s: 
 0 -1 null
 1 0  null
 2 2  2
 4 49 4->49
 51 74  51->74
 76 99  76->99
*/