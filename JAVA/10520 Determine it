import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static long  memo[][]   ;
	static int n ;
	static long a(int i , int j ) {
		if(memo[i][j]!=-1)return memo[i][j] ;
		
		if(i>=j){
			long r1 = 0  , r2 = 0;
			
			if(i!= n)
				for(int k =i+1 ; k <=n ; k ++)
					r1 = Math.max(r1, a(k , 1)+a(k , j)) ;
			
			if(j!=0)
				for(int k = 1; k <j ; k++)
					r2 = Math.max(r2 , a(i , k)+a(n , k )) ;
			
			return memo[i][j] = r1+r2;
			
		}
		long res = 0  ; 
		for(int k = i ; k < j ; k++)
			res = Math.max(a(i , k )+a(k+1,  j) , res) ;
		
		return memo[i][j] =res ;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		while(true){
			n = sc.nextInt() ;
			memo = new long [25][25] ;
			for(int i = 0 ; i < 25 ; i++)
				Arrays.fill(memo[i] , -1 ) ;
			
			memo[n][1] = sc.nextInt();
			System.out.println(a(1,n)) ;
			
			if(!sc.ready())break ; 
		}
		pw.flush();
		pw.close();
	}

	

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}

}
