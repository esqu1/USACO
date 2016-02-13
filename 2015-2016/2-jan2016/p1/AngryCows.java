import java.util.*;
import java.io.*;

public class AngryCows{
    private static double[] line, diff;
    
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader("angry.in"));
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
	StringTokenizer st = new StringTokenizer(br.readLine());
	line = new double[Integer.parseInt(st.nextToken())];
	for (int i = 0; i < line.length; i++) {
	    st = new StringTokenizer(br.readLine());
	    line[i] = Integer.parseInt(st.nextToken()) * 1.0;
	}
	Arrays.sort(line);
	diff = new double[line.length - 1];
	for (int i = 0; i < diff.length; i++) {
	    diff[i] = line[i+1] - line[i];
	}
	System.out.println(Arrays.toString(diff));


	int[] meh = maxVal2(diff);
	double curr = diff[0];
	if(diff[meh[0]] / 2 > diff[meh[1]]){
	    diff[meh[0]] = diff[meh[0]] / 2;
	    for (int i = 1; i < diff.length; i++) {
		if(i <= meh[0]){
		    curr++;
		    if(curr < diff[i]){
			curr = diff[i];
		    }
		}else{
		    curr--;
		    if(curr < diff[i]){
			curr = diff[i];
		    }		       
		}
	    }
	    curr += diff.length - 1 - meh[0];
	}else{
	    for (int i = 1; i < diff.length; i++) {
		if(i <= meh[0]){
		    curr++;
		    if(curr < diff[i]){
			curr = diff[i];
		    }
		}else{
		    curr--;
		    if(curr < diff[i]){
			curr = diff[i];
		    }		       
		}
	    }
	    curr += diff.length - 1 - meh[0];
	}

	pw.println(curr);
	pw.close();
	
    }

    // Finds the 2 max positions of arr where the maximum occur.
    public static int[] maxVal2(double[] arr){
	int m2 = 1;
	int m = 0;
	for (int i = 0; i < arr.length; i++) {
	    if(arr[m] < arr[i]){
		m2 = m;
		m = i;
	    }else if(arr[m2] < arr[i]){
		m2 = i;
	    }
	}
	int[] l = {m,m2};
	return l;
    }
}
