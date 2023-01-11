import java.util.Arrays;

public class Solution1329 {
    public int[][] diagonalSort(int[][] mat) {
        // n： 矩阵行 m ：矩阵列
        int n = mat.length, m = mat[0].length;
        for (int k = 0; k < Math.min(m,n) - 1; k++) {
            // 冒泡排序
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m - 1; j++) {
                    if (mat[i][j] > mat[i + 1][j + 1]) {
                        int t = mat[i][j];
                        mat[i][j] = mat[i + 1][j + 1];
                        mat[i + 1][j + 1] = t;
                    }
                }
            }
        }
        return mat;
    }
    public static void main(String[] args) {
        Solution1329 sol = new Solution1329();
        int[][] mat = new int[][]{{1,2,3,4,5},{2,3,4,5,6}};
        int[][] res = sol.diagonalSort(mat);
        System.out.println(Arrays.deepToString(res));
        }

// 作者：one0ne-v
// 链接：https://leetcode.cn/problems/sort-the-matrix-diagonally/solution/java-zhao-gui-lu-mo-ni-by-one0ne-v-aolf/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}