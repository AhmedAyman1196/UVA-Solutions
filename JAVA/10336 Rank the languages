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
	static int[] dx = { 1, 0, 0, -1 }, dy = { 0, 1,- 1, 0 };
	static int x, y, a[][];
	static boolean visited[][];

	static void flow(int i, int j, int state) {
		if (i < 0 || j < 0 || i >= x || j >= y)
			return;
		if (visited[i][j] || a[i][j] != state)
			return;
		visited[i][j] = true;
		for (int t = 0; t < 4; t++)
			flow(i + dx[t], j + dy[t], state);

	}

	public static void main(String args[]) throws IOException {
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			x = sc.nextInt();
			y = sc.nextInt();
			a = new int[x][y];
			visited = new boolean[x][y];
			int result[] = new int[27];
			for (int i = 0; i < x; i++) {
				String s = sc.next();
				for (int j = 0; j < y; j++)
					a[i][j] = s.charAt(j) - 'a';
			}

			for (int i = 0; i < x; i++)
				for (int j = 0; j < y; j++) {
					if (!visited[i][j]) {
						result[a[i][j]] += 1;
						flow(i, j, a[i][j]);
					}
				}
//			System.out.println(Arrays.toString(result));
			pw.println("World #" + t);
			ArrayList<pair> ans = new ArrayList<>() ;
			for (int i = 0; i < 27; i++) {
				if(result[i]!=0)
				ans.add(new pair(result[i], (char)('a' + i))) ;
			}
			Collections.sort(ans);
			for(int i =0 ; i < ans.size() ; i++){
				pw.println(ans.get(i).c + ": " + ans.get(i).x);
				
			}
		}
		pw.flush();
		pw.close();
	}
	
	public static class pair implements Comparable<pair>{
		int x ;
		char c ; 
		public pair(int x1, char c1){
			x =x1 ; 
			c =c1 ;
		}
		
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			if(x==o.x)return c - o.c ;
			return o.x-x ;
		}
		
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
