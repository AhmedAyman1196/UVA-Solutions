import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		while (true) {
			String s1 = sc.nextLine(), s2 = sc.nextLine();
			int dp[][] = new int[s1.length() + 2][s2.length() + 2];

			for (int i = 1; i <= s1.length(); i++) {
				for (int j = 1; j <= s2.length(); j++) {
					if (s1.charAt(i - 1) == s2.charAt(j - 1))
						dp[i][j] = 1 + dp[i - 1][j - 1];
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
					dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
				}
			}
			pw.println(dp[s1.length()][s2.length()]);
			if (!sc.ready())
				break;
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
