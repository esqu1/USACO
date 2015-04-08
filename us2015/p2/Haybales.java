import java.util.*;
import java.io.*;

public class Haybales{

    static class Bale implements Comparable<Bale>{
	int size,position;
	Bale(int si, int pos){
	    size = si;
	    position = pos;
	}

	public int compareTo(Bale other){
	    return position - other.position;
	}

	public String toString(){
	    return "(" + size + "," + position + ")";
	}
    }
    
    private static Bale[] lower;
    private static Bale[] higher;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new FileReader("trapped.in"));
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("trapped.out")));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int L = Integer.parseInt(st.nextToken());
	int initpos = Integer.parseInt(st.nextToken());
	lower = new Bale[L];
	higher = new Bale[L];
	int lowerc = 0;
	int higherc = 0;
	for (int i = 0; i < L; i++) {
	    st = new StringTokenizer(br.readLine());
	    int size = Integer.parseInt(st.nextToken());
	    int pos = Integer.parseInt(st.nextToken());
	    if(pos < initpos){
		lower[lowerc] = new Bale(size,pos);
		lowerc++;
	    }else{
		higher[higherc] = new Bale(size,pos);
		higherc++;
	    }
	}
	for (int i = 0; i < lowerc; i++) {
	    for (int j = 0; j < higherc; j++) {
		//System.out.println(lower[i] + "," + higher[j]);

		int dist = higher[j].position - lower[i].position;
		if(lower[i].size < dist && dist - lower[i].size < min && higher[j].size > dist){
		    
		    min = dist - lower[i].size;
		}else if(higher[j].size < dist && dist - higher[j].size < min && lower[i].size > dist){
		    min = dist - higher[j].size;
		}
	    }
	}
	if(min == Integer.MAX_VALUE){
	    min = -1;
	}
	pw.write(min + "\n");
	pw.close();
    }
}
