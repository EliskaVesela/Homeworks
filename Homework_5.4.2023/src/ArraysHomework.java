public class ArraysHomework {
    public static void main(String[] args) {
        ukol1();
        ukol2();
    }

    private static void ukol1() {
        // Create an array of strings with 12 elements
        String[] strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven" };
        String[] arraystrings = "zero one two three four five six seven eight nine ten eleven".split(" ");

        // Create an empty array of strings with 5 elements
        String[] secondStrings = new String[5];


        // Copy the 3rd to 6th elements (inclusive) from the first array to the end of the second array
        int pointer = secondStrings.length - 1;
        for (int i = 6; i >= 3; i--) {
            secondStrings[pointer] = strings[i];
            pointer--;
        }

        // Set the 0th element of the second array to the last element of the first array
        secondStrings[0] = strings[strings.length - 1];


        // Print the second array
        for (String secondString : secondStrings) {
            System.out.println(secondString);
        }

        System.out.println();

        for (int i = 0; i < secondStrings.length; i++) {
            System.out.println(secondStrings[i]);
        }

        System.out.println();
    }

    public static void ukol2() {
        //Vytvořte dvě matice 5x5 naplněné náhodnými čísly od 0 do 10;
        int[][] matrix1 = new int[5][5];
        int[][] matrix2 = new int[5][5];
        fillMatrixWithNumbers(matrix1);
        fillMatrixWithNumbers(matrix2);

        System.out.println("Matrices are filled up with numbers:\n");
        printMatrix(matrix1);
        System.out.println();
        printMatrix(matrix2);
        System.out.println();


        // Calculate sum, difference, product, and determinant

        // sum
        int[][] sum = calculateSum(matrix1, matrix2);
        System.out.println("Their sum is:\n");
        printMatrix(sum);

        System.out.println();
        // difference
        int[][] diff = calculateDiff(matrix1, matrix2);
        System.out.println("Their diff is:\n");
        printMatrix(diff);

        System.out.println();
        // product
        int[][] product = calculateProduct(matrix1, matrix2);
        System.out.println("Their product is:\n");
        printMatrix(product);

        System.out.println();

        System.out.println("Determinants:\n");
        System.out.println("Matrix1 = " +determinantOfMatrix(matrix1, matrix1.length));
        System.out.println("Matrix2 = " +determinantOfMatrix(matrix2, matrix2.length));
        System.out.println("SumMatrix = " +determinantOfMatrix(sum, sum.length));
        System.out.println("DiffMatrix = " +determinantOfMatrix(diff, diff.length));
        System.out.println("ProductMatrix = " +determinantOfMatrix(product, product.length));

    }

    // Fill matrices with random numbers
    private static void fillMatrixWithNumbers(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = generateRandomNumber(0, 10);
            }
        }
    }

    private static int generateRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max + 1 - min)) + min);
    }

    // Method to calculate sum of two matrices
    private static int[][] calculateSum(int[][] matrix1, int[][] matrix2) {
        int[][] sumMatrix = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return sumMatrix;
    }

    // Method to calculate difference of two matrices
    private static int[][] calculateDiff(int[][] matrix1, int[][] matrix2) {
        int[][] diffMatrix = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                diffMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return diffMatrix;
    }

    // Method to calculate product of two matrices
    private static int[][] calculateProduct(int[][] matrix1, int[][] matrix2) {
        int[][] productMatrix = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                productMatrix[i][j] = multiplyMatrixCell(matrix1, matrix2, i, j);
            }
        }
        return productMatrix;
    }

    //Helpful method to calculate product
    private static int multiplyMatrixCell(int[][] matrix1, int[][] matrix2, int row, int col) {
        int cell = 0;
        for (int i = 0; i < matrix2.length; i++) {
            cell += matrix1[row][i] * matrix2[i][col];
        }
        return cell;
    }

    //To calculate determinant I used these two methods
    private static void getCofactor(int mat[][], int temp[][], int p, int q, int n) {
        int i = 0, j = 0;

        // Looping for each element
        // of the matrix
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // Copying into temporary matrix
                // only those element which are
                // not in given row and column
                if (row != p && col != q) {
                    temp[i][j++] = mat[row][col];
                    // Row is filled, so increase
                    // row index and reset col index
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    /* Recursive function for finding determinant
    of matrix. n is current dimension of matrix[][]. */
    private static int determinantOfMatrix(int matrix[][], int n) {

        int D = 0; // Initialize result

        // Base case : if matrix
        // contains single element
        if (n == 1)
            return matrix[0][0];

        // To store cofactors
        int temp[][] = new int[matrix.length][matrix[0].length];

        // To store sign multiplier
        int sign = 1;

        // Iterate for each element of first row
        for (int f = 0; f < n; f++) {
            // Getting Cofactor of mat[0][f]
            getCofactor(matrix, temp, 0, f, n);
            D += sign * matrix[0][f]
                    * determinantOfMatrix(temp, n - 1);

            // terms are to be added
            // with alternate sign
            sign = -sign;
        }

        return D;
    }

    //Method to print matrix
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }



}