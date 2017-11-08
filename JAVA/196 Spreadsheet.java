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
	static int n, m;
	static long value[][];
	static ArrayList<String>[][] form;

	static Pair Trans(String s) {
		String alpha = "", nums = "";
		for (int i = s.length() - 1, j = 0; true; i--, j++) {
			if (Character.isAlphabetic(s.charAt(i))) {
				alpha = s.substring(0, i + 1);
				nums = s.substring(i + 1);
				break;
			}
		}
		// System.out.println(alpha+" "+nums);
		int i = 0, j = Integer.parseInt(nums);
		for (int x = 0; x < alpha.length(); x++) {
			int y = alpha.charAt(alpha.length() - x - 1) - 'A' + 1;
			i += Math.pow(26, x) * (y);
		}
		return new Pair(j - 1, i - 1);
	}

	static void solve(int x, int y) {
		// System.out.println(x + " " + y);
		if (value[x][y] != Long.MIN_VALUE)
			return;
		long sum = 0;
		for (int i = 0; i < form[x][y].size(); i++) {
			String curr = form[x][y].get(i);
			Pair p = Trans(curr);
			solve(p.i, p.j);
			sum += value[p.i][p.j];
		}
		value[x][y] = sum;
	}

	public static void main(String[] args) throws IOException {
		int x = 5;
		while (x-- > 0) {
			String s = sc.next();
			System.out.println(Trans(s).i + " " + Trans(s).j);
		}
		int t = sc.nextInt();
		while (t-- > 0) {
			m = sc.nextInt();
			n = sc.nextInt();
			value = new long[n][m];
			form = new ArrayList[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					form[i][j] = new ArrayList<>();
				}
			}
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++) {
					String s = sc.next();
					if (s.charAt(0) == '=') {
						value[i][j] = Long.MIN_VALUE;
						// System.out.println(s.substring(1));
						StringTokenizer st = new StringTokenizer(s.substring(1), "+");
						while (st.hasMoreTokens())
							form[i][j].add(st.nextToken());
					} else
						value[i][j] = Integer.parseInt(s);
				}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (value[i][j] == Long.MIN_VALUE)
						solve(i, j);
					pw.print(value[i][j] + ((j == m - 1) ? "" : " "));
				}
				pw.println();
			}
		}
		pw.flush();
	}

	static class Pair {
		int i, j;

		public Pair(int i, int j) {
			// TODO Auto-generated constructor stub
			this.i = i;
			this.j = j;
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

		public boolean isReady() throws IOException {
			return br.ready() || st.hasMoreElements();
		}
	}

}
