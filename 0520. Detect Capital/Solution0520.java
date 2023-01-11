class Solution0520 {
    public boolean detectCapitalUse(String word) {
        int cap = 0;
        boolean first = false;
        for (int i = 0; i < word.length(); i++) {
            if (i == 0 && Character.isUpperCase(word.charAt(i))) {
                first = true;
            }
            if (Character.isUpperCase(word.charAt(i))) {
                cap++;
            }
        }
        return (cap == 0 || cap == word.length() || (cap == 1 && first));
    }
}