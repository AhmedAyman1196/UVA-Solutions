import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);
		public static void main(String[] args) throws IOException {
		int tc = sc.nextInt() ;
		for(int t =1; t<=tc ; t++){
			int n = sc.nextInt()  , miles = 0 , juice = 0 ;//mile 30 sec = 10 , juice 60 = 15 
			for(int i = 0 ; i < n ; i ++){
				double x = sc.nextInt()+1 ;
				miles += Math.ceil(x/30) ;
				juice += Math.ceil(x/60) ;
			}
			miles *= 10 ;
			juice *= 15 ;
			if(miles < juice)pw.printf("Case %d: Mile %d" , t , miles);
			else if(miles > juice)pw.printf("Case %d: Juice %d",t , juice) ;
			else pw.printf("Case %d: Mile Juice %d", t , juice) ;
			
			pw.println();
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
			return br.ready() || st.hasMoreTokens();
		}

	}
}
