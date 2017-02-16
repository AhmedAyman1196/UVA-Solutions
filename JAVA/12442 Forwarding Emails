import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static int adjList[] = new int[50005], memo[] = new int[50005], counter;
	static boolean visited[] = new boolean[50005];

	static int solve(int idx) {

		int v = adjList[idx], r = 0;
		visited[idx] = true;

		if (!visited[v])
			r = solve(v) + 1;
		visited[idx] = false;
		memo[idx] = r;
		return r;
	}

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		// PrintWriter pw = new PrintWriter(System.out);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(), n1 = n;
			while (n1-- > 0) {
				int u = sc.nextInt()-1, v = sc.nextInt()-1;
				adjList[u] = v;
				visited[u] = false;
				memo[u] = -1;
			}

			int ans = -1, ansidx = 0;
			int x = 0;
			for (int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(Arrays.copyOfRange(memo, 0, n)));
//				System.out.println(Arrays.toString(Arrays.copyOfRange(visited, 0, n)));
				if (memo[i] == -1)solve(i);
				if (memo[i] > ans) {
					ans = memo[i];
					ansidx = i+1;
				}
			}

			pw.println("Case " + t + ": " + ansidx);
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
