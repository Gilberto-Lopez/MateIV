import java.io.*;
import java.util.*;

/**
 * Fourth order Runge-Kutta Method for solving ODE
 */
public class RungeKutta4{

    /**
     * Differential equation given by y' = x-y^2
     */
    public static double dy(double x, double y){
	return x-y*y;
    }

    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	String[] inputs = in.nextLine().split(",");
	//Initial condition y(x0) = y0
	double x0 = Double.valueOf(inputs[0]);
	double y0 = Double.valueOf(inputs[1]);
	//The number of subintervals to divide de interval [x0,xn]
	double n = Double.valueOf(inputs[2]);
	//The point to calculate the solution
	double xn = Double.valueOf(inputs[3]);
	//The step size
	double h = (xn - x0)/n;
	double xi = x0;
	double yi = y0;
	for(int i = 0; i < n; i++){
	    //Kutta
	    /*
	      double k1 = dy(xi, yi);
	      double k2 = dy(xi + h/3, yi + h*k1/3);
	      double k3 = dy(xi + 2*h/3, yi - h*k1/3 + h*k2);
	      double k4 = dy(xi + h, yi + h*k1 - h*k2 + h*k3);
	      yi = yi + (k1 + 3*k2 + 3*k3 + k4)*h/8;
	      xi += h;
	    */
	    //Runge
	    //The coefficients k1, k2, k3 and k4
	    double k1 = dy(xi, yi);
	    double k2 = dy(xi + h/2, yi + h*k1/2);
	    double k3 = dy(xi + h/2, yi + h*k2/2);
	    double k4 = dy(xi + h, yi + h*k3);
	    //y_i+1
	    yi = yi + (k1 + 2*k2 + 2*k3 + k4)*h/6;
	    //x_i+1
	    xi += h;
	}
	yi = (int)(yi*100000)/100000.0;
	System.out.println(yi);
    }

}
