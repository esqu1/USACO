import java.util.*;
import java.io.*;

public class RadioContact{
    public static Queue<State> = new PriorityQueue<State>();
    public static int[] initB, initJ, pathB, pathJ;
    
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader("radio.in"));
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("radio.out")));
	StringTokenizer st = new StringTokenizer(br.readLine());
	st = new StringTokenizer(br.readLine());
	initJ = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
	st = new StringTokenizer(br.readLine());
	initB = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};	
	st = new StringTokenizer(br.readLine());
	String[] sJ = st.nextToken().split("");
	st = new StringTokenizer(br.readLine());
	String[] sB = st.nextToken().split("");
	q.add(new State(0,0,0,initB[0],initB[1],initJ[0],initJ[1]));

	while(q.size() > 0){
	    State s = q.remove();
	    String j = sJ[q.john];
	    String b = sB[q.bessie];

	    // Case 1: 
	    if(b.equals("N")){ q.add(new State(q.bessie,q.john,q.energy+dist(q.posBx,q.posBy+1,q.posJx,q.posJy))); }
	    else if(b.equals("S")){ q.add(new State(q.bessie,q.john,q.energy+dist(q.posBx,q.posBy-1,q.posJx,q.posJy))); }
	    else if(b.equals("W")){ q.add(new State(q.bessie,q.john,q.energy+dist(q.posBx-1,q.posBy,q.posJx,q.posJy))); }
	    else if(b.equals("E")){ q.add(new State(q.bessie,q.john,q.energy+dist(q.posBx+1,q.posBy,q.posJx,q.posJy))); }
	    tempB = q.posB
	    

		
					     
	}
	/*	pathB = new int[sB.length()];
	pathJ = new int[sJ.length()];
	for (int i = 0; i < pathB.length; i++) {
	    String nyeh = sJ[i];
	    if(nyeh == "N"){ pathB[i] = 1; }
	    else if(nyeh == "S"
	    } */
	
    }

    public static int dist(int bx, int by, int jx, int jy){
	return (bx-jx)*(bx-jx) + (by-jy)*(by-jy);
    }

    static class State implements Comparable<State>{
	public int bessie, john, energy;
	public int posBx, posBy, posJx, posJy;
	State(int b, int j, int e, int Bx, int By, int Jx, int Jy){
	    bessie = b; john = j; energy = e; posBx = Bx; posBy = By; posJx = Jx; posJy = Jy;
	}

	int compareTo(State other){
	    return energy - other.energy;
	}
    }
}
