import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
	static int n, m, a[][];
	static int dp[][], ans;
	static ArrayList<Integer> chosen;

	// r = n , c= m
	static int solve(int r, int c) {
		if (c == m)
			return 0;
		if (dp[r][c] != Integer.MAX_VALUE)
			return dp[r][c];
		int res = Integer.MAX_VALUE;
		// mid
		res = Math.min(res, solve(r, c + 1));
		// up
		if (r == 0)
			res = Math.min(res, solve(n - 1, c + 1));
		else
			res = Math.min(res, solve(r - 1, c + 1));
		// down
		if (r == n - 1)
			res = Math.min(res, solve(0, c + 1));
		else
			res = Math.min(res, solve(r + 1, c + 1));

		return dp[r][c] = res + a[r][c];
	}

	static void print(int r, int c) {
		chosen.add(r + 1);
		if (c == m - 1)
			return;
		int to = solve(r, c) - a[r][c];

		if (r == n - 1 && to == solve(0, c + 1)) // to 0
			print(0, c + 1);
		else if (r != 0 && to == solve(r - 1, c + 1)) // to r-1
			print(r - 1, c + 1);
		else if (to == solve(r, c + 1)) // to r
			print(r, c + 1);
		else if (r != n - 1 && to == solve(r + 1, c + 1))// to r+1
			print(r + 1, c + 1);
		else if (r == 0 && to == solve(n - 1, c + 1)) // to n-1
			print(n - 1, c + 1);

	}

	public static void main(String[] args) throws IOException {
		while (true) { // replace br.ready
			n = sc.nextInt();
			m = sc.nextInt();
			a = new int[n][m];
			dp = new int[n][m];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++) {
					a[i][j] = sc.nextInt();
					dp[i][j] = Integer.MAX_VALUE;
				}
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++)
				ans = Math.min(ans, solve(i, 0));

			chosen = new ArrayList<>();
			for (int i = 0; i < n; i++)
				if (ans == solve(i, 0)) {
					print(i, 0);
					break;
				}

			for (int i = 0; i < m; i++)
				pw.print(chosen.get(i) + ((i == m - 1) ? "\n" : " "));

			pw.println(ans);
			if (!sc.isReady())
				break;
		}
		pw.flush();
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

		public boolean isReady() throws IOException {
			return br.ready() || st.hasMoreElements();
		}
	}

}
