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
	static long n  ,   k ,  memo[][] ;
	static long dp(int idx , int ssf){ // ssf = Sum So Far
		if(ssf>n)return 0 ; 
		if(idx==k)return memo[idx][ssf] = ssf==n? 1: 0 ;
		if(memo[idx][ssf]!=-1)return memo[idx][ssf] ; 
		long res  = 0 ;
		for(int i = 0 ; i <=n ; i ++)
			res += (dp(idx+1  , ssf+ i)%1000000) ;
		
		return memo[idx][ssf] = res%1000000 ;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		n = sc.nextLong() ;k =sc.nextLong() ;
		while(true){
			if(k==0&&n==0 )break ; 
			memo = new long[105][105] ;
			for(int i = 0 ; i < 105 ; i ++)
				Arrays.fill(memo[i], -1 ) ; 
			pw.println(dp(0,0));
			n = sc.nextLong()   ; k = sc.nextLong() ;
			
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
