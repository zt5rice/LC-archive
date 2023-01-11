class Solution2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int psum[] = new int[s.length() + 1];
        int next[] = new int[s.length() + 1], prev[] = new int[s.length() + 1];
        Arrays.fill(next, Integer.MAX_VALUE);
        int res[] = new int[queries.length];
        for (int i = 0; i < s.length(); ++i) {
            psum[i + 1] = psum[i] + (s.charAt(i) == '|' ? 1 : 0);
            prev[i + 1] = s.charAt(i) == '|' ? i : prev[i];
        }
        for (int i = s.length() - 1; i >= 0; --i)
            next[i] = s.charAt(i) == '|' ? i : next[i + 1];
        for (int j = 0; j < queries.length; ++j) {
            int l = next[queries[j][0]], r = prev[queries[j][1] + 1];
            res[j] = l < r ? r - l - (psum[r] - psum[l]) : 0;
        }        
        return res;
    }
     // public int[] platesBetweenCandles(String s, int[][] queries) {
     //     int n = s.length();
     //     TreeMap<Integer,Integer> map=new TreeMap();
     //     int index=0;
     //     for(int i=0;i<s.length();i++)
     //     {
     //         if(s.charAt(i)=='|')
     //             map.put(i,++index);
     //     }
     //     int[] ans=new int[queries.length];
     //     for(int i=0;i<queries.length;i++)
     //     {
     //         Integer index1=map.ceilingKey(queries[i][0]);
     //         Integer index2=map.floorKey(queries[i][1]);
     //         if(index1==null || index2==null || index2<=index1)
     //             continue;
     //         int place1=map.get(index1);
     //         int place2=map.get(index2);
     //         ans[i]=index2-index1+1-(place2-place1+1);
     //     }
     //    return ans;
     //  }
}