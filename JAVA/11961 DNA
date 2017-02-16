import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
	static TreeSet<String> ans  ;
	static int n , k ; 
	static String str ;
	
	static void solve(int k  , String s , int idx){
		// base case
		if(k<0)return ;
		if(idx==n){  
			ans.add(s.toString()) ;
			return ;
		}
		// recursion 
		
		solve(str.charAt(idx)=='A'? k:k-1 , s+('A') , idx+1) ;
		solve(str.charAt(idx)=='C'? k:k-1 , s+('C') , idx+1) ;
		solve(str.charAt(idx)=='G'? k:k-1 , s+('G') , idx+1) ;
		solve(str.charAt(idx)=='T'? k:k-1 , s+('T') , idx+1) ;

		
	}

	public static void main(String[] args) throws IOException {
		int t = sc.nextInt() ;
		while(t-->0){
			n = sc.nextInt()  ;
			k = sc.nextInt();
			str = sc.next() ;
			ans = new TreeSet<>() ;
			solve( k  ,"" , 0) ;
			ans.add(str) ;
			
			pw.println(ans.size());
			for (String s : ans) {
			    pw.println(s);
			}

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

