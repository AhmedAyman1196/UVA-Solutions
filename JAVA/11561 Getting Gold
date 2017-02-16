import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemA {
	// 11561 - Getting Gold
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
	static int n, m, posx, posy;
	static int a[][];
	static boolean visited[][];

	static int dfs(int i, int j) {
		if (!valid(i, j) || visited[i][j])
			return 0;
		visited[i][j] = true;
		int ans = a[i][j] == 1 ? 1 : 0;
		boolean trap = false;
		if (valid(i + 1, j) && a[i + 1][j] == 2)
			trap = true;
		if (valid(i - 1, j) && a[i - 1][j] == 2)
			trap = true;
		if (valid(i, j + 1) && a[i][j + 1] == 2)
			trap = true;
		if (valid(i, j - 1) && a[i][j - 1] == 2)
			trap = true;
		if (!trap)
			ans += dfs(i + 1, j) + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i, j - 1);

		return ans;
	}

	static boolean valid(int i, int j) {
		if (i < 0 || j < 0 || i >= m || j >= n || a[i][j] == 3)
			return false;
		return true;
	}

	public static void main(String[] args) throws IOException {
		n = sc.nextInt();
		m = sc.nextInt();
		while (true) {
			a = new int[m][n];
			visited = new boolean[m][n];
			for (int i = 0; i < m; i++) {
				String s = sc.next();
				for (int j = 0; j < n; j++) {
					char c = s.charAt(j); // 3 = wall , 1 = gold , 2 = trap ;
					if (c == '#')
						a[i][j] = 3;
					if (c == 'G')
						a[i][j] = 1;
					if (c == 'T')
						a[i][j] = 2;
					if (c == 'P') {
						posx = i;
						posy = j;
					}
				}
			}
			pw.println(dfs(posx, posy));
			if (!sc.ready())
				break;
			n = sc.nextInt();
			m = sc.nextInt();
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
