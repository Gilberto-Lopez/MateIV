import java.io.*;
import java.util.*;

/**
 * LU Decomposition
 */
public class LUDecomposition{

    public static double[] sumRows(double[] rowI, double[] rowJ){
	double[] row = new double[3];
	for(int k = 0; k < 3; k++)
	    row[k] = rowI[k] + rowJ[k];
	return row;
    }

    public static double[] multiplyRow(double[] row, double n){
	double[] rowN = new double[3];
	int i = 0;
	for(double k : row)
	    rowN[i++] = k*n;
	return rowN;
    }

    public static void printMatrix(double[][] A){
	for(int i = 0; i < 3; i++)
	    System.out.printf("%.3f %.3f %.3f\n", A[i][0], A[i][1], A[i][2]);
    }
    
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	String[] fr = in.nextLine().split(" ");
	String[] sr = in.nextLine().split(" ");
	String[] tr = in.nextLine().split(" ");
	double[][] A = new double[3][3]; //The matrix
	for(int i = 0; i < 3; i++){
	    A[0][i] = Double.valueOf(fr[i]);
	    A[1][i] = Double.valueOf(sr[i]);
	    A[2][i] = Double.valueOf(tr[i]);
	}
	double[][] U = A.clone();//The upper triangular matrix
	double[][] L = new double[3][3]; //The lower triangular matrix.
	for(int i = 0; i < 3; i++)
	    L[i][i] = 1; //Identitiy matrix

	double k;
	for(int i = 0; i < 2; i++)
	    for(int j = i+1; j < 3; j++)
		if(U[i][i] != 0){
		    k = U[j][i]/U[i][i] + 0.0; //+ 0.0 avoid -0.0
		    U[j] = sumRows(U[j], multiplyRow(U[i], -k));
		    L[j][i] = k;
		}
	System.out.println("L =");
	printMatrix(L);
	System.out.println("U =");
	printMatrix(U);
    }

}
