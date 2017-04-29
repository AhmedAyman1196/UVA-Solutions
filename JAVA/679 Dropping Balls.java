import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	
	static int search(int node ,int depth , int balls){
		double max = Math.pow(2, depth) -1 ;
		int left = node * 2 , right = ( node *2 ) +1 ;
		if(left>max&&right>max)
			return node ;
		else {
			if(balls%2==0)return search(right , depth , balls/2);
			else return search(left , depth , balls/2 +1) ;
		}
	}

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt() ; 
		while(t-->0){
			int depth = sc.nextInt() , n = sc.nextInt() ;
			pw.println(search( 1 , depth , n));
		}
		int last = sc.nextInt() ;
		pw.flush();
	}
}

