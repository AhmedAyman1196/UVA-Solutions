import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] dp;
	static String[] s1, s2;

	static int solve(int x, int y) {
		int res = 0;
		if (x == s1.length || y == s2.length)
			return 0;

		if (dp[x][y] != -1)
			return dp[x][y];

		if (s1[x].equals(s2[y]))
			res = 1 + solve(x + 1, y + 1);
		res = Math.max(res, solve(x + 1, y));
		res = Math.max(res, solve(x, y + 1));
		return dp[x][y] = res;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		int t = 1;
		while (true) {
			String s11 = sc.nextLine(), s22 = sc.nextLine();
			if (s11.equals("") || s22.equals(""))
				pw.println(((t < 10) ? " " : "") + t + ". Blank!");
			else {
				s1 = s11.replaceAll("[^a-zA-Z_0-9]", " ").split(" ");
				s2 = s22.replaceAll("[^a-zA-Z_0-9]", " ").split(" ");
				dp = new int[s1.length + 2][s2.length + 2];
				for (int i = 0; i <= s1.length; i++)
					Arrays.fill(dp[i], -1);
				if (t < 10)
					pw.printf(" %d. Length of longest match: %d\n", t, solve(0, 0));
				else
					pw.printf("%d. Length of longest match: %d\n", t, solve(0, 0));

			}
			if (!sc.ready())
				break;
			t++;
		}
		pw.flush();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(InputStream s) {
			// TODO Auto-generated constructor stub
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public String next() throws IOException {
			if (st == null || !st.hasMoreElements())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
