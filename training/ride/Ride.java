/*
ID: brandbe1
LANG: JAVA
TASK: ride
*/
import java.util.*;
import java.io.*;
public class Ride{
    private static String comet, group;

    public static int convert(String s){
	int i = 1;
	for(int j = 0; j <= s.length(); j++){
	    char k = s.charAt(j);
	    if(k <= 90 && k >= 65){
		i *= (k - 64);
	    }else if(k <= 122 && k >= 97){
		i *= (k - 96);
	    }
	}
	return i;
    }
    
    public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new FileReader("ride.in"));
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
	StringTokenizer st = new StringTokenizer(br.readLine());
	comet = st.nextToken();
	st = new StringTokenizer(br.readLine());
	group = st.nextToken();
	if(convert(comet) % 47 == convert(group) % 47){
	    pw.println("GO");
	}else{
	    pw.println("STAY");
	}

	pw.close();
    }
}
