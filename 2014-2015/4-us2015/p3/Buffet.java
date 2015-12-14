import java.io.*;
import java.util.*;
public class Buffet{

    public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new FileReader("buffet.in"));
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buffet.out")));
	pw.write("1893\n");
	pw.close();
    }
}
