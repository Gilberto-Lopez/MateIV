import java.io.*;
import java.util.*;

public class NewtonRaphson{

    /**
     * Function f(x) = exp(cos(x)) - x
     */
    public static double f(double x){
	return Math.exp(Math.cos(x)) - x;
    }

    /**
     * The analytic derivative of f(x)
     */
    public static double Df(double x){
	return -Math.exp(Math.cos(x))*Math.sin(x) - 1;
    }

    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	//Input, the initial value
	double a = in.nextDouble();
	//Error margin
	double epsilon = 0.0001;
	//Maximum steps for the algorithm
	int maxsteps = 50;
	//The number of steps necesary to find a solution
	int steps = 0;
	//The relative error, 1 to initialize the variable
	double error = 1;
	while(error > epsilon &&
	      steps < maxsteps){
	    //Next step
	    steps++;
	    //f(a)
	    double fa = f(a);
	    //Next step point
	    double an = a - fa/Df(a);
	    //Relativa error
	    error = Math.abs((an-a)/an)*100.0;
	    a = an;
	}
	System.out.println(a);
	System.out.println(steps);
    }

}
