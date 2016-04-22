import java.io.*;
import java.util.*;

public class BisectionMethod{

    public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		//Input a,b
		String[] interval = in.nextLine().split(",");
		//Interval [a,b]
		double a = Double.valueOf(interval[0]);
		double b = Double.valueOf(interval[1]);
		//f(x) = Cos(x) - x
		//If f(a)*f(b) > 0 then there is no solution
		if((Math.cos(a) - a) * (Math.cos(b) - b) > 0){
		    System.out.println("No found");   
		}else{
		    double x0 = 0.0; //The solution, 0.0 to initialize the varaible.
		    double e = Math.abs(b-a); //Error through iterations.
		    double epsilon = 0.0001; //Error margin
		    while(e > epsilon){
			double c = (a + b)/2; //Midpoint between a and b
			double fa = Math.cos(a) - a; //f(a)
			double fb = Math.cos(b) - b; //f(b)
			double fc = Math.cos(c) - c; //f(c)
			if(fa == 0.0){
			    x0 = a; //a is solution
			    break;
			}else if(fb == 0.0){
			    x0 = b; //b is solution
			    break;
			}else if(fa*fc < 0.0){
			    b = c; //The solution is in [a,c]
			}else{
			    a = c; //The solution is in [c,b]
			}
			double cn = (a + b)/2; //Midpoint between the new a and new b
			e = Math.abs((cn-c)/cn*100); //The relative error
			x0 = c; //The aproximation of the solution at this iteration
		    }
		    System.out.printf("%.5f\n",x0);//Prints the solution
		}
    }
}

