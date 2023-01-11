public class Solution0246 {

    Map<Character, Character> dict = new HashMap<>(
    Map.of('0', '0', '1', '1', '6', '9', '8',  '8', '9', '6'));
    
    public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length() - 1;
        while (i < j) {
            char left = num.charAt(i++);
            char right = num.charAt(j--);
            if (!dict.containsKey(left) || dict.get(left) != right) {
                return false;
            }
        }
        if (i != j) {
            return true;
        }
        return num.charAt(i) == '0' || num.charAt(i) == '1' || num.charAt(i) == '8';
    }
  
}
