import java.io.*;
import java.util.*;

public class RegulaFalse{

    /**
     * The funtion f(x) = exp(-2x)+x-3
     */
    public static double f(double x){
	return Math.exp(-2*x)+x-3;
    }

    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	//Input a,b
	String[] interval = in.nextLine().split(",");
	//Interval [a,b]
	double a = Double.valueOf(interval[0]);
	double b = Double.valueOf(interval[1]);
	int itrallowed = 100; //Maximum iterations allowed
	int iterations = 0; //Counter of iterations
	//f(x) = 0
	//If f(a)*f(b) > 0 then there is no solution
	if(f(a)*f(b) > 0){
	    System.out.println("No found");   
	}else{
	    double x0 = 0.0; //The solution, 0.0 to initialize the varaible.
	    double epsilon = 0.0003; //Error margin
	    while(Math.abs(b-a) > epsilon &&
		  iterations++ < itrallowed){
		double fa = f(a); //f(a)
		double fb = f(b); //f(b)
		//The slope of the secant line from (a,f(a)) to (b,f(b))
		double m = (fb-fa)/(b-a);
		//The point at which the secant line crosses the x-axis
		double c = a - fa/m;
		double fc = f(c); //f(c)
		if(fc == 0){
		    x0 = c; //c is solution
		    break;
		}else if(fa*fc < 0.0){
		    b = c; //The solution is in [a,c]
		}else{
		    a = c; //The solution is in [c,b]
		}
		x0 = c; //The aproximation of the solution at this iteration
	    }
	    //This to avoid rounding off while printig with printf() method
	    x0 = (int)(x0*100000)/100000.0;
	    System.out.printf("%.5f\n",x0); //Prints the solution
	}
    }
    
}
