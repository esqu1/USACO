/**
 * USACO 2015-2016 CONTEST 1 PROBLEM 1
 * BY BRANDON LIN
 * JAVA
 */
import java.util.*;
import java.io.*;
public class Lights{

    static class Room implements Comparable<Room>{
	public int x,y,a,b;

	public Room(int x1, int y1, int a1, int b1){
	    x = x1; y = y1; a = a1; b = b1;
	}

	public int compareTo(Room other){
	    if(x - other.x == 0 && y - other.y == 0 && a - other.a == 0 && b - other.b == 0){
		return 0;
	    }else if(x - other.x == 0 && y - other.y == 0 && a - other.a == 0){
		return b - other.b;
	    }else if(x - other.x == 0 && y - other.y == 0){
		return a - other.a;
	    }else if(x - other.x == 0){
		return y - other.y;
	    }else{
		return x - other.x;
	    }
	}
    }
    
    private static int[][] rooms;
    private static Queue<Room> q,q1;
    private static int total = 0;

    public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int N = Integer.parseInt(st.nextToken());
	rooms = new int[N+2][N+2];
	rooms[1][1] = 2; // 2 will mean its connected to (1,1)
	q1 = new PriorityQueue<Room>();
	q = new PriorityQueue<Room>(); // this queue contains all the switches we haven't used yet
	int M = Integer.parseInt(st.nextToken());
	for (int i = 0; i < M; i++) {
	    st = new StringTokenizer(br.readLine());
	    int x1 = Integer.parseInt(st.nextToken());
	    int y1 = Integer.parseInt(st.nextToken());
	    int a = Integer.parseInt(st.nextToken());
	    int b = Integer.parseInt(st.nextToken());
	    if(rooms[x1][y1] == 2){ // preliminary assessment of switches
		if(rooms[a - 1][b] == 2 || rooms[a + 1][b] == 2 || rooms[a][b - 1] == 2 || rooms[a][b + 1] == 2){
		    rooms[a][b] = 2;
		    for (Room s : q1) {
			if(rooms[s.a - 1][s.b] == 2 || rooms[s.a + 1][s.b] == 2 || rooms[s.a][s.b - 1] == 2 || rooms[s.a][s.b + 1] == 2){ // check to see if any 1 rooms now become 2 rooms
			    rooms[s.a][s.b] = 2;
			}
		    }
		}else{
		    rooms[a][b] = 1;
		    q1.add(new Room(x1,y1,a,b));
		}
		//total += 1;
	    }else{
		q.add(new Room(x1,y1,a,b)); // we'll put them in the queue
	    }
	}
	
	Iterator<Room> it = q.iterator();
	while(it.hasNext()){
	    Room r = it.next();
	    if(rooms[r.x][r.y] == 2){
		if(rooms[r.a - 1][r.b] == 2 || rooms[r.a + 1][r.b] == 2 || rooms[r.a][r.b - 1] == 2 || rooms[r.a][r.b + 1] == 2){
		    rooms[r.a][r.b] = 2;
		    for (Room s : q1) { // check to see if any 1 rooms now become 2 rooms
			if(rooms[s.a - 1][s.b] == 2 || rooms[s.a + 1][s.b] == 2 || rooms[s.a][s.b - 1] == 2 || rooms[s.a][s.b + 1] == 2){
			    rooms[s.a][s.b] = 2;
			}
		    }
		}else{
		    rooms[r.a][r.b] = 1;
		    q1.add(r);
		}
		it.remove();
		it = q.iterator();
	    }
	}
	for (int i = 0; i < rooms.length; i++) { // add the rooms that are lit
	    for (int j = 0; j < rooms[0].length; j++) {
		total +=  rooms[i][j] > 0 ? 1 : 0;
	    }
	}
       
	pw.println(total);
	pw.close();	
    }
}
