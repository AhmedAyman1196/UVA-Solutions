import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);

	static int GCD(int i , int j ){
		if(j==0)return  i ; 
		else return GCD( j , i %j) ;
	}
	
	public static void main(String args[]) throws IOException {
		int N;
		while ((N = sc.nextInt()) != 0) {
			int G = 0;
			for (int i = 1; i < N; i++)
				for (int j = i + 1; j <= N; j++) {
					G += GCD(i, j);
				}
			pw.println(G);
		}
		pw.flush();
		pw.close();
	}
}
