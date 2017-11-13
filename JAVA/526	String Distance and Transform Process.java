import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// re5em awy el printing
	static int[][] dp;
	static String s1, s2;
	static StringBuilder ans;

	static int solve(int x, int y) {
		if (x == s1.length())
			return s2.length() - y;
		if (y == s2.length())
			return s1.length() - x;

		if (dp[x][y] != -1)
			return dp[x][y];

		int res = Integer.MAX_VALUE;
		if (s1.charAt(x) == s2.charAt(y))
			res = solve(x + 1, y + 1); // match
		else
			res = 1 + solve(x + 1, y + 1); // replace

		res = Math.min(res, 1 + solve(x + 1, y)); // delete
		res = Math.min(res, 1 + solve(x, y + 1)); // insert
		return dp[x][y] = res;
	}

	static void Print(int x, int y, int offset, int counter) {

		if (x == s1.length()) {
			for (int i = y, j = 0; i < s2.length(); i++, j++) {
				ans.append(counter++);
				ans.append(" ");
				ans.append("Insert ");
				ans.append(x + 1 + offset + j);
				ans.append(",");
				ans.append(s2.charAt(i));
				ans.append("\n");
			}
			return;
		}
		if (y == s2.length()) {
			// return s1.length() - x;
			for (int i = x; i < s1.length(); i++) {
				ans.append(counter++);
				ans.append(" ");
				ans.append("Delete ");
				ans.append(x+1+offset);
				ans.append("\n");
			}
			return;
		}

		int res = solve(x, y);

		if (s1.charAt(x) == s2.charAt(y) && res == solve(x + 1, y + 1)) {
			Print(x + 1, y + 1, offset, counter); // match
		} else if (res == 1 + solve(x + 1, y)) {// delete
			ans.append(counter++);
			ans.append(" ");
			ans.append("Delete ");
			ans.append(x + 1 + offset);
			ans.append("\n");
			Print(x + 1, y, offset - 1, counter);
		} else if (res == 1 + solve(x + 1, y + 1)) {// replace
			ans.append(counter++);
			ans.append(" ");
			ans.append("Replace ");
			ans.append(x + 1 + offset);
			ans.append(",");
			ans.append(s2.charAt(y));
			ans.append("\n");
			Print(x + 1, y + 1, offset, counter);
		} else if (res == 1 + solve(x, y + 1)) {// insert
			ans.append(counter++);
			ans.append(" ");
			ans.append("Insert ");
			ans.append(x + 1 + offset);
			ans.append(",");
			ans.append(s2.charAt(y));
			ans.append("\n");
			Print(x, y + 1, offset + 1, counter);
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		while (true) {
			s1 = sc.nextLine();
			s2 = sc.nextLine();

			dp = new int[s1.length() + 2][s2.length() + 2];
			for (int i = 0; i <= s1.length(); i++)
				Arrays.fill(dp[i], -1);

			int x = solve(0, 0);
			pw.println(x);
			if (x > 0) {
				ans = new StringBuilder();
				Print(0, 0, 0, 1);
				ans.setLength(ans.length() - 1);
				pw.println(ans);
			}

			if (!sc.ready())
				break;
			pw.println();
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
