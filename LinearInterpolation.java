import java.io.*;
import java.util.*;
import java.text.*;

public class LinearInterpolation{

    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	Hashtable<Double, Double> points = new Hashtable<>();
	ArrayList<Double> xs = new ArrayList<>();
	String[] spoints;
	double t = 0;
	while(in.hasNextLine()){
	    spoints = in.nextLine().split(" ");
	    if(spoints.length == 1){
		t = Double.valueOf(spoints[0]);
		break;
	    }else{
		double x = Double.valueOf(spoints[0]);
		double y = Double.valueOf(spoints[1]);
		xs.add(x);
		points.put(x,y);
	    }
	}
	xs.sort((a, b) -> (int)(a - b));
	double t1 = 0;
	double t2 = 0;
	for(int i = 0; i < xs.size(); i++){
	    if(xs.get(i) >= t){
		t2 = xs.get(i);
		t1 = xs.get(i-1);
		break;
	    }
	}
	double m = (points.get(t2) - points.get(t1))/(t2 - t1);
	double v = points.get(t1) + m*(t - t1);
	DecimalFormat df = new DecimalFormat("#.####");
	System.out.printf(df.format(v) + "\n");
    }
    
}
