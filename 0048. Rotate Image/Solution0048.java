public class Solution0048 {
    public void rotate(int[][] matrix) {
        int topRow = 0;
        int bottomRow = matrix.length - 1;
        int leftCol = 0;
        int rightCol = matrix[0].length - 1;
        while (topRow <= bottomRow && leftCol <= rightCol) {
            for (int i = 0; i < rightCol - leftCol; i++) {
                int temp = matrix[topRow][leftCol + i];
                matrix[topRow][leftCol + i] = matrix[bottomRow - i][leftCol];
                matrix[bottomRow - i][leftCol] = matrix[bottomRow][rightCol - i];
                matrix[bottomRow][rightCol - i] = matrix[topRow + i][rightCol];
                matrix[topRow + i][rightCol] = temp;
            }
            topRow++;
            bottomRow--;
            leftCol++;
            rightCol--;
        }
    }    
}
