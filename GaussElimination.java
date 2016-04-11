import java.io.*;
import java.util.*;

/**
 * Gaussian Elimination
 */
public class GaussElimination{

    /**
     * Adds the two rows of matrix A and saves it in row "row".
     * @param A The matrix.
     * @param row The row.
     */
    public static void sumRows(int[][] A, int row){
	for(int i = 0; i < 3; i++)
	    A[row][i] = A[0][i] + A[1][i];
    }

    /**
     * Multiply the row row of a matrix A by n.
     * @param A The matrix.
     * @param row The row.
     * @param n The number by which multiply the row.
     */
    public static void multiplyRow(int[][] A, int row, int n){
	for(int i = 0; i < 3; i++)
	    A[row][i] *= n;
    }

    /**
     * Swaps the two rows of a matrix A.
     * @param A The matrix.
     */
    public static void swapRow(int[][] A){
	for(int i = 0; i < 3; i++){
	    int tmp = A[0][i];
	    A[0][i] = A[1][i];
	    A[1][i] = tmp;
	}
    }
    
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int[][] A = new int[2][3]; //matrix
	String[] fr = in.nextLine().split(" "); //fisrt row
	String[] sr = in.nextLine().split(" "); //second row
	for(int i = 0; i < 3; i++){
	    A[0][i] = Integer.valueOf(fr[i]);
	    A[1][i] = Integer.valueOf(sr[i]);
	}
	//Now we have A
	int a00 = A[0][0];
	int a10 = A[1][0];
	if(a10 != 0){
	    multiplyRow(A, 0, a10);
	    multiplyRow(A, 1, -a00);
	    sumRows(A, 1); //A10 is 0 now
	}
	int a01 = A[0][1];
	int a11 = A[1][1];
	if(a01 != 0){
	    multiplyRow(A, 0, a11);
	    multiplyRow(A, 1, -a01);
	    sumRows(A, 0); //A01 is 0 now
	}
	try{
	    int x1 = A[0][2]/A[0][0]; //(A00 is 1) solution x1
	    int x2 = A[1][2]/A[1][1]; //(A11 is 1) solution x2
	    System.out.println("x_1 = " + x1 + "\n" +
			       "x_2 = "+ x2);	
	}catch(Exception e){ //Divide by 0
	    System.out.err("NO SOLUTION.");
	}
    }
    
}
