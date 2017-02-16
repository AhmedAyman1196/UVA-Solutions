import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) throws IOException {
		int cases = sc.nextInt();
		for (int t = 1; t <= cases; t++) {
			int n = sc.nextInt() , idx = sc.nextInt()  , pass  =sc.nextInt() ;
			while(pass-->0){
				idx++ ;
				if(idx==n+1)idx = 1 ;
			}
			pw.println("Case " + t + ": "+idx );
		}
		pw.flush();
		pw.close();
	}
}
