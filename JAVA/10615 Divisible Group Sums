import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long memo[][][];
	static long a[], n, q, d, m;
	static boolean v[][][] ;
	public static long dp(int pos  , int taken , int sum) {
		
		if(taken == m)return sum==0 ? 1: 0 ;
	    if(pos == n ) return 0;

	    long l =  memo[ pos ][ taken ][ sum ];
	    if( v[ pos ][ taken ][ sum ] ) return l;
	    
	    v[ pos ][ taken ][ sum ] = true;
	    l  = dp(pos+1,taken+1, (int) (((sum + a[pos])%d+d)%d) ) + dp(pos+1,taken,sum) ;
	    return memo[pos][taken][sum] = l;
	    
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int set = 1 ;
		memo = new long[207][11][21] ;

		while ((n = sc.nextInt()) != 0 && (q = sc.nextInt()) != 0) {
			a = new long[207];
			for(int i =  0; i < n ; i ++)a[i] = sc.nextLong() ;
			int query = 1 ;
			while (q-- > 0) {
				if(query==1)
					pw.println("SET "+set+":");
				d = sc.nextInt();
				m = sc.nextInt();
//				memo = new long[207][11][21] ;
				v = new boolean[207][11][21] ;
						
//				long ans =  dp(0,0,0) ;
				pw.println("QUERY "+query+": "+dp(0,0,0));
				query++ ;
			}
			set++ ;
		}
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
