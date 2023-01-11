public class Solution0032 {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}

// class Solution { // 05 - 08
//     // public int longestValidParentheses(String s) {
//     //     int max = 0;
//     //     Deque<Integer> stack = new ArrayDeque<>();
//     //     for (int i = 0; i < s.length(); i++) {
//     //         char c = s.charAt(i);
//     //         if (c == '(') {
//     //             stack.offerLast(i);
//     //         } else {
//     //             if (!stack.isEmpty() && s.charAt(stack.peekLast()) == '(') {
//     //                 stack.pollLast();
//     //                 int left = stack.isEmpty()? -1 : stack.peekLast();
//     //                 max = Math.max(max, i - left); // (left, right]
//     //             } else {
//     //                 stack.offerLast(i);
//     //             }
//     //         }
//     //     }
//     //     return max;
//     // }

// }

/** 
max:2-0=2,3-0=3
stk:

   i
0123
(())

*/
