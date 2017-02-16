import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt() ;
		for(int tc = 1 ; tc<=t ; tc++){
			int n = sc.nextInt() ; 
			char[][] a = new char[n][n] ;
			boolean done[][] = new boolean[n][n] ;
			
			for(int i = 0 ; i < n ; i ++){
				String s = sc.next() ;
				for(int j = 0 ; j < n ; j ++){
					char c = s.charAt(j) ;
					if(c!='.'){
						done[i][j] = true ;
						a[i][j] = c ;
					}else a[i][j] ='.' ;
				}
			}
			
		char[] possible = {'A' ,'B' , 'C' , 'D' , 'E' , 'F' , 'G' ,'H' , 'I'};
		for(int i = 0 ; i < n ; i ++)
			for(int j = 0 ; j < n ; j ++){
				if(!done[i][j]){
					char up = i!=n-1?a[i+1][j]:'.' , down = i!=0 ?a[i-1][j]:'.' ,
							left = j!=0 ?a[i][j-1] :'.', right= j!=n-1 ?a[i][j+1]:'.' ; 
//							System.out.println(up+" "+down+" "+left+" "+right);
					for(int k = 0 ; k < possible.length ; k++){
						char c = possible[k] ;
						if(c!=up&&c!=down&&c!=left&&c!=right){
							a[i][j] = c ;
							break ;
						}
					}
				}
			}
			System.out.println("Case "+tc+":");
			for(int i = 0 ; i < n ; i ++){
				for(int j = 0 ; j < n ; j ++)
					System.out.print(a[i][j]) ;
				System.out.println();
			}
			
		}
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
