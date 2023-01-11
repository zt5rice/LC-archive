class Solution0833 { // 03
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        List<int[]> sorted = new ArrayList<>();
        for (int i = 0; i < indices.length; i++) {
            sorted.add(new int[]{indices[i], i}); // s,  sources/targets
        }
        Collections.sort(sorted, Comparator.comparing(i-> -i[0]));
        for (int[] arr : sorted) {
            int i = arr[0], j = arr[1];
            String src = sources[j], tgt = targets[j];
            if (i <= s.length() && i+src.length() <= s.length()) { // lee215 not working
                if (s.substring(i, i+src.length()).equals(src)) {
                    s = s.substring(0,i) + tgt + s.substring(i+src.length());
                }                
            }
        }
        return s;
    }
}