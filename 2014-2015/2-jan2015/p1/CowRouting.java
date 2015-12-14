import java.util.*;
import java.io.*;
public class test{
    private static int city1, city2;
    private static int[][] trips;
    private static int min = 9000000000;

    public static void main(String[] args) {
	BufferedReader br = new BufferedReader(new FileReader("cowroute.in"));
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));
	StringTokenizer st = new StringTokenizer(br.readLine());
	city1 = st.nextToken();
	city2 = st.nextToken();
	trips = new int[Integer.parseInt(st.nextToken())][];
	for(int i = 0; i < trips.length; i++){
	    int cost = Integer.parseInt(st.nextToken());
	    int[] cities = new int[Integer.parseInt(st.nextToken())];
	    for(int j = 0; j < cities.length; j++){
		cities[j] = Integer.parseInt(st.nextToken());
	    }
	    if(cities.index(
    }
