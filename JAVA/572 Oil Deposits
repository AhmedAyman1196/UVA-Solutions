import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);
	static int[] dx = {1,1,0,-1,-1,-1, 0, 1}, dy = {0,1,1, 1, 0,-1,-1,-1};
	static int x, y;
	static boolean visited[][], has[][];

	static void flow(int i, int j) {
		 if((i<0||j<0||i>=x||j>=y))
			 return ;
		 if(visited[i][j])return ;
		 
		 visited[i][j] = true; 
		 if(has[i][j])
			 for(int t = 0 ; t < 8 ; t++)
 					 flow(i +dx[t] , j+dy[t]) ;

	}

	static int checkStar(int i, int j) {
		return 1;
	}

	public static void main(String args[]) throws IOException {
		x = sc.nextInt();
		y = sc.nextInt();
		while (!(x== 0 && y== 0)) {
			has = new boolean[x][y];
			visited = new boolean[x][y] ;
			for (int i = 0; i < x; i++) {
				String s = sc.next();
				for (int j = 0; j < y; j++)
					if (s.charAt(j) == '@')
						has[i][j] = true;
			}
			
			int ans = 0;
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++)
					if (!visited[i][j]&&has[i][j]) {
						ans += checkStar(i, j);
						flow(i, j);
					}
			}
			pw.println(ans);
			x =sc.nextInt() ;
			y = sc.nextInt() ;
			
		}
		pw.flush();
		pw.close();

	}

	static public class Scanner {
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
