/**
 * USACO 2015-2016 CONTEST 1 PROBLEM 2
 * BY BRANDON LIN
 * JAVA
 */
import java.util.*;
import java.io.*;
public class HighCard{
    private static int[] elsie, bessie;
    private static int POINTS;

    public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int N = Integer.parseInt(st.nextToken());
	elsie = new int[N];
	bessie = new int[N];
	for (int i = 0; i < N; i++) {
	    st = new StringTokenizer(br.readLine());
	    elsie[i] = Integer.parseInt(st.nextToken());
	}
	Arrays.sort(elsie);

	int start = elsie[0]+1;
	int startindex = 1;
	while(startindex < elsie.length ){ // Basically we're going to use Bessie's smallest possible cards to beat Elsie's smallest possible cards, and we will place as much as possible to rack the most points.
	    if(start == elsie[startindex]){
		start++;
		startindex++;
	    }else if(start > elsie[POINTS]){
		POINTS++;
		start++;
	    }else{
		start++;
	    }
	}
	POINTS += 2*N - elsie[elsie.length - 1];
	pw.println(POINTS);
	pw.close();
	
    }
    
}
