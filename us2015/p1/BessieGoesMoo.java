import java.util.*;
import java.io.*;

public class BessieGoesMoo{
    private static long[] B = new long[7];
    private static long[] E = new long[7];
    private static long[] S = new long[7];
    private static long[] I = new long[7];
    private static long[] G = new long[7];
    private static long[] O = new long[7];
    private static long[] M = new long[7];
    private static long count = 0;
    
    public static int propermod(int a, int b){
	if(a % b < 0){
	    return ((a % b) + b) % b;
	}else{
	    return a % b;
	}
    }
    
    public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new FileReader("bgm.in"));
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bgm.out")));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int L = Integer.parseInt(st.nextToken());
	for (int a = 0; a < L; a++) {
	    st = new StringTokenizer(br.readLine());
	    char c = st.nextToken().charAt(0);
	    if(c == 'B'){
		B[propermod(Integer.parseInt(st.nextToken()),7)] += 1;
	    }else if(c == 'E'){
		E[propermod(Integer.parseInt(st.nextToken()),7)] += 1;
	    }else if(c == 'S'){
		S[propermod(Integer.parseInt(st.nextToken()),7)] += 1;
	    }else if(c == 'I'){
		I[propermod(Integer.parseInt(st.nextToken()),7)] += 1;
	    }else if(c == 'G'){
		G[propermod(Integer.parseInt(st.nextToken()),7)] += 1;
	    }else if(c == 'O'){
		O[propermod(Integer.parseInt(st.nextToken()),7)] += 1;
	    }else if(c == 'M'){
		M[propermod(Integer.parseInt(st.nextToken()),7)] += 1;
	    }
	}

	for (int b = 0; b < 7; b++) {
	    for (int e = 0; e < 7; e++) {
		for (int s = 0; s < 7; s++) {
		    for (int i = 0; i < 7; i++) {
			for (int g = 0; g < 7; g++) {
			    for (int o = 0; o < 7; o++) {
				for (int m = 0; m < 7; m++) {
				    if(propermod((b + e + s + s + i + e) * (g + o + e + s) * (m + o + o),7) == 0){
					count += M[m] * O[o] * E[e] * S[s] * G[g] * B[b] * I[i];
				    }
				}
			    }
			}
		    }
		}
	    }
	}
	
	pw.write(count + "\n");
	pw.close();
    }
}
