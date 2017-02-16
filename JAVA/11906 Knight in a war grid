import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);
	static int n, m, x1, x2, odd, even;
	static boolean water[][];
	static boolean visited[][];

	static void solve() {
		Queue<pair> q = new LinkedList<>();
		q.add(new pair(0, 0));
		while (!q.isEmpty()) {
			pair x = q.poll();
			if (!visited[x.f][x.s]) {
				int total = 0;
				pair tmp ;
				ArrayList<pair> a = new ArrayList<>();
				if (check(x.f + x1, x.s + x2)) {
					total++;
					tmp = new pair(x.f + x1, x.s + x2) ;
					q.add(tmp);
					a.add(tmp);
				}
				if (check(x.f - x1, x.s + x2)) {
					
					tmp = new pair(x.f - x1, x.s + x2);
					if(!a.contains(tmp)){
						q.add(tmp) ;
						a.add(tmp);
						total++ ;
					}
				}
				if (check(x.f + x1, x.s - x2)) {
					tmp = new pair(x.f + x1, x.s - x2);
					if(!a.contains(tmp)){
						q.add(tmp) ;
						a.add(tmp);
						total++ ;
					}
				}
				if (check(x.f - x1, x.s - x2)) {
					
					tmp = new pair(x.f - x1, x.s - x2);
					if(!a.contains(tmp)){
						q.add(tmp) ;
						a.add(tmp);
						total++ ;
					}
				}

				if (check(x.f + x2, x.s + x1)) {
					
					tmp = new pair(x.f + x2, x.s + x1);
					if(!a.contains(tmp)){
						q.add(tmp) ;
						a.add(tmp);
						total++ ;
					}
				}
				if (check(x.f - x2, x.s + x1)) {
					tmp = new pair(x.f - x2, x.s + x1);
					if(!a.contains(tmp)){
						q.add(tmp) ;
						a.add(tmp);
						total++ ;
					}
				}
				if (check(x.f + x2, x.s - x1)) {
					tmp = new pair(x.f + x2, x.s - x1);
					if(!a.contains(tmp)){
						q.add(tmp) ;
						a.add(tmp);
						total++ ;
					}
				}
				if (check(x.f - x2, x.s - x1)) {
					tmp = new pair(x.f - x2, x.s - x1);
					if(!a.contains(tmp)){
						q.add(tmp) ;
						a.add(tmp);
						total++ ;
					}
				}
				visited[x.f][x.s] = true;

				if (total % 2 == 0)
					even++;
				else
					odd++;
			}
		}

	}

	static boolean check(int x, int y) {
		// System.out.println(x+" "+y);
		if (x >= n || x < 0 || y < 0 || y >= m || water[x][y]) {
			// System.out.println("denied");
			return false;
		}
		return true;
	}

	public static void main(String args[]) throws IOException {
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			x1 = sc.nextInt();
			x2 = sc.nextInt();
			int w = sc.nextInt();
			water = new boolean[n][m];
			visited = new boolean[n][m];
			while (w-- > 0)
				water[sc.nextInt()][sc.nextInt()] = true;
			odd = even = 0;
			solve();
			pw.println("Case " + t + ": " + even + " " + odd);
		}
		pw.flush();
		pw.close();
	}

	static class pair {
		int f, s;

		public pair(int f, int s) {
			this.f = f;
			this.s = s;
		}
		@Override
		public boolean equals(Object other){
			pair x = (pair)other ; 
			if(x.f==f&&x.s==s)return true ;
			return false ;
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
