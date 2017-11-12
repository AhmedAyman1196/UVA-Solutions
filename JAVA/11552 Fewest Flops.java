import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static String s;
	static int k;
	static int[][] memo;

	static int solve(int idx, int last) {
		if (idx == s.length())
			return 0;

		if (memo[idx / k][last] != -1)
			return memo[idx / k][last];

		HashSet<Character> set = new HashSet<>();
		for (int i = idx; i < idx + k; i++)
			set.add(s.charAt(i));

		char x = (char) (last + 'a');

		if (set.size() == 1)
			for (Character c : set) {
				if (c == x)
					return solve(idx + k, c - 'a');
				else
					return 1 + solve(idx + k, c - 'a');
			}
		int res = Integer.MAX_VALUE;
		for (Character c1 : set)// before
			for (Character c2 : set)
				if (c1 != c2) {
					int curr = ((c1 == x) ? 0 : 1) + solve(idx + k, c2 - 'a');
					res = Math.min(curr, res);
				}
		
		return memo[idx / k][last] = res + set.size() - 1;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			k = sc.nextInt();
			s = sc.next();
			memo = new int[s.length() / k + 2][27];
			for (int i = 0; i < memo.length; i++)
				for (int j = 0; j < memo[i].length; j++)
					memo[i][j] = -1;

			pw.println(solve(0, 26));
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
