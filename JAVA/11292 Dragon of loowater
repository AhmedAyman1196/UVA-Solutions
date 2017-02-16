import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
		int n = sc.nextInt()  , m =  sc.nextInt() ; 
		while(!(n==0&& m ==0)){
			 Integer[] dragon = new Integer[n] , knight = new Integer[m] ;
			 for(int i = 0 ; i < n ; i ++)dragon[i] = sc.nextInt() ;
			 for(int i = 0 ; i < m ; i ++)knight[i] = sc.nextInt() ;
			 Arrays.sort(dragon);
			 Arrays.sort(knight);
			 int cost = 0  , check = 0   ; 
			 for(int i = 0 , idx = 0  ; i < n ; idx++){
				 if(idx==m){
					 check = -1 ;
					 break ;
				 }
				 if(knight[idx]>=dragon[i]){
					 cost+=knight[idx];
					 i++ ;
				 }
			 }
			 
			 if(check==-1)pw.println("Loowater is doomed!");
			 else pw.println(cost);
			 n = sc.nextInt() ;
			 m = sc.nextInt() ;
		}
		pw.flush();pw.close();
		
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

