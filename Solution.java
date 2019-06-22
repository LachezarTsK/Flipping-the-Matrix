import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfQueries = scanner.nextInt();

		for (int i = 0; i < numberOfQueries; i++) {

			int half_squareSide = scanner.nextInt();
			int[][] matrix = new int[2 * half_squareSide][2 * half_squareSide];

			for (int row = 0; row < 2 * half_squareSide; row++) {
				for (int column = 0; column < 2 * half_squareSide; column++) {
					matrix[row][column] = scanner.nextInt();
				}
			}

			int result = maxSum_matrixUpperLeftQuarter(matrix, half_squareSide);
			System.out.println(result);
		}
		scanner.close();
	}

	/**
	 * There are no limits to the number of rotations. The allowed rotations are:
	 * 
	 * I. Each column around the matrix horizontal central axis.
	 * 
	 * II. Each row around the matrix vertical central axis.
	 * 
	 * Therefore, each cell of the matrix could take maximum four different values:
	 *
	 * 1. Its current value.
	 * 
	 * 2. The value of its symmetrical cell around the matrix central vertical axis.
	 * 
	 * 3. The value of its symmetrical cell around the matrix central horizontal
	 * axis.
	 * 
	 * 4. The value of its symmetrical cell around the intersection of the matrix
	 * central vertical and horizontal axes.
	 * 
	 * Thus the method takes the maximum of the four possible values for each cell
	 * in the upper left quarter of the matrix.
	 * 
	 * @return Maximum sum of the elements in the upper left quarter of the matrix.
	 */
	public static int maxSum_matrixUpperLeftQuarter(int[][] matrix, int half) {
		int maxSum = 0;
		int maxIndex = 2 * half - 1;
		int maxElement = 0;

		for (int row = 0; row < half; row++) {
			for (int column = 0; column < half; column++) {

				maxElement = matrix[row][column];
				maxElement = Math.max(maxElement, matrix[row][maxIndex - column]);
				maxElement = Math.max(maxElement, matrix[maxIndex - row][maxIndex - column]);
				maxElement = Math.max(maxElement, matrix[maxIndex - row][column]);

				maxSum += maxElement;
			}
		}
		return maxSum;
	}
}
