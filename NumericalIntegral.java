import java.io.*;
import java.util.*;

public class NumericalIntegral{

    /**
     * The function f(x) = 3x + x^2*exp(-x)
     */
    public static double f(double x){
	return 3*x+x*x*Math.exp(-x);
    }

    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	String[] inputs = in.nextLine().split(",");
	//The interval of integration [a,b]
	double a = Double.valueOf(inputs[0]);
	double b = Double.valueOf(inputs[1]);
	//The number of subintervals to divide [a,b]
	int n = Integer.valueOf(inputs[2]);
	//dx step size
	double dx = Math.abs(b-a)/n;
	//The integral of f(x) from on [a,b]
	double integral = 0.0;
	for(int i = 1; i < n; i++){
	    //Adds 4*f(a + i*dx) if i is odd, 2*f(a + i*dx) if i is even
	    integral += ((i % 2) + 1)*2*f(a + i*dx);
	    //This doesnt add f(a) nor f(b)
	}
	integral = (integral + f(a) + f(b))* dx/3;
	integral = (int)(integral*100000)/100000.0;
	System.out.printf("%.5f", integral);
    }
    
}
