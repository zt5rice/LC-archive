public class Solution0008 {
    public static void main(String[] args) {
        Solution0008 sol = new Solution0008();
        String s = "-2147483647";
        int res = sol.myAtoi(s);
        System.out.println("Input :" + s);
        System.out.println("Output:" + res);
        System.out.println();

        s = "  +  413";
        res = sol.myAtoi(s);
        System.out.println("Input :" + s);
        System.out.println("Output:" + res);
        System.out.println();

        s = "00000-42a1234";
        res = sol.myAtoi(s);
        System.out.println("Input :" + s);
        System.out.println("Output:" + res);
        System.out.println();
        
        s = "+-12";
        res = sol.myAtoi(s);
        System.out.println("Input :" + s);
        System.out.println("Output:" + res);
        System.out.println();

                
        s = "+1";
        res = sol.myAtoi(s);
        System.out.println("Input :" + s);
        System.out.println("Output:" + res);
        System.out.println();
                        
        s = "words and 987";
        res = sol.myAtoi(s);
        System.out.println("Input :" + s);
        System.out.println("Output:" + res);
        System.out.println();
    }
    public int myAtoi(String s) { // 1083/1083
        int n = s.length(), res = 0;
        int sym = 1; // 1 - positive , -1 - negative
        boolean symFound = false;
        boolean numFound = false;
        for (int i = 0; i < n; i++) {
            char curc = s.charAt(i);
            // 1. ' '
            if (!numFound && !symFound && curc == ' ') {
                continue;
            } else if (!numFound && !symFound && curc == '-') {// 2. symbol
                sym = -1;
                symFound = true;
            } else if (!numFound && !symFound && curc == '+') {// 2. symbol
                sym = 1;
                symFound = true;
            } else if (Character.isDigit(curc)) {// 3. num
                // out of bound
                numFound = true;
                int curn = (int) (curc - '0'); // 214748364(7)
                if (sym == 1 && ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && curn >= 7))) {
                    return Integer.MAX_VALUE;
                } 
                if (sym == -1 && ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && curn >= 8))) {
                    return Integer.MIN_VALUE;
                }
                res *= 10;
                res += (int) (curc - '0');
            } else {
                break;
            }
        }
        // System.out.println(res);
        // System.out.println(sym);
        return sym*res;
    }
}
