/**
 * USACO 2015-2016 CONTEST 1 PROBLEM 3
 * BY BRANDON LIN
 * JAVA
 */
import java.util.*;
import java.io.*;
public class BCount{ // SOLUTION DOES NOT GET ALL TEST CASES, THIS IS A NAIVE SOLUTION
    private static char[] s;

    public static HashMap<Character,Integer> count(String str){
	HashMap<Character,Integer> map = new HashMap<Character,Integer>();          
	for(int i = 0; i < str.length(); i++){
	    char c = str.charAt(i);
	    Integer val = map.get(new Character(c));
	    if(val != null){
		map.put(c, new Integer(val + 1));
	    }else{
		map.put(c,1);
	    }
	}
	return map;
    }

    public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
	StringTokenizer st = new StringTokenizer(br.readLine());
	s = new char[Integer.parseInt(st.nextToken())];
	int Q = Integer.parseInt(st.nextToken());
	for (int i = 0; i < s.length; i++) {
	    st = new StringTokenizer(br.readLine());
	    s[i] = st.nextToken().charAt(0);
	}
	for (int i = 0; i < Q; i++) {
	    st = new StringTokenizer(br.readLine());
	    HashMap<Character,Integer> m = count((new String(s)).substring(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())));
	    int a1 = 0, a2 = 0, a3 = 0;
	    if(m.get('1') != null){
		a1 = m.get('1');
	    }if(m.get('2') != null){
		a2 = m.get('2');
	    }if(m.get('3') != null){
		a3 = m.get('3');
	    }
	    pw.println(a1 + " " + a2 + " " + a3);
	}

	pw.close();
    }
    
}
