import java.io.*;
import java.util.*;

/**
 * Matrix Inverse.
 */
public class MatrixInverse{

    /**
     * Given a Matrix "A", multiplies the row "row" by "x" and returns an array
     * with the resulting row without modifying the original matrix.
     * @param A The Matrix.
     * @param row The row.
     * @param x The number by which the method will multiply the row row.
     * @return The resulting row.
     */
    public static double[] multiplyRow(double[][] A, int row, double x){
		double[] r = new double[A[row].length];
		for(int i = 0; i < A[row].length; i ++)
		    r[i] = A[row][i] * x;
		return r;
    }

    /**
     * Given a Matrix "A", adds the ith row with the jth row and returns an
     * array with the resulting row without modifying the original matrix.
     * @param A The Matrix.
     * @param i The ith row of A.
     * @param j The jth row of A.
     * @return The resulting row.
     */
    public static double[] addRows(double[][] A, int i, int j){
		double[] r = new double[A[i].length];
		for(int k = 0; k < r.length; k++)
		    r[k] = A[i][k] + A[j][k];
		return r;
    }

    /**
     * The main method.
     */
    public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		//Input: Matrix A
		ArrayList<String[]> A = new ArrayList<>();
		int n = 0; //The number of columns/rows of A.
		while(in.hasNextLine()){
		    String[] r = in.nextLine().split(" "); //ith row of A.
		    A.add(r);
		    n++;
		    if(r.length == n) //The number of columns equals the number of rows.
				break;
		}
		//Matrix [A|I]
		double[][] AI = new double[n][2*n];
		for(int j = 0; j < n; j++){
		    for(int i = 0; i < n; i++){
			    //Matrix A
				AI[j][i] = Double.valueOf((A.get(j))[i]);
		    }
		}
		//Identity Matrix
		for(int k = 0; k < n; k++){
		    AI[k][k+n] = 1.0;
		}
		//Now AI = [A|I]
		for(int i = 0; i < n; i++){ //i The column of AI
		    for(int j = 0; j < n; j++){ //j The row of AI
			double Aji = AI[j][i];
			//Putting 0 out of the diagonal of A
			if(j != i && Aji != 0){
			    if(AI[i][i] == 0){
				AI[i] = addRows(AI, i, n-1);
			    }
			    AI[j] = multiplyRow(AI, j, -AI[i][i]/Aji);
			    AI[j] = addRows(AI, j, i);
			}
		    }
		}
		//Putting 1 on the diagonal of AI
		for(int i = 0; i < n; i++)
		    AI[i] = multiplyRow(AI, i, 1/AI[i][i]);
		//Now AI = [I|A^-1]
		for(int i = 0; i < n; i++){
		    for(int j = 0; j < n; j++){
			//Printig A^-1
			System.out.printf("%.3f ", AI[i][j+n] + 0.0);
			//Printing 3 decimal places
			//+ 0.0 to avoid negative 0 on uoutput
		    }
		    System.out.print("\n");
		}
    }
    
}
