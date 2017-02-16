import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
	static char safe[][];
	static int n, m, x, y;

	static void traverse() {
		char path[] = { 'I', 'E', 'H', 'O', 'V', 'A', '#' };
		int idx = 0;
		while (idx!=7) {
			if (x - 1 >= 0 && safe[x - 1][y] == path[idx]) {
				x -= 1;
				pw.print(idx == 6 ? "forth" : "forth ");
			} else if (y - 1 >= 0 && safe[x][y - 1] == path[idx]) {
				y--;
				pw.print(idx == 6 ? "left" : "left ");
			} else {
				y++;
				pw.print(idx == 6 ? "right" : "right ");
			}
			idx++;
		}

	}

	public static void main(String[] args) throws IOException {
		int t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			safe = new char[n][m];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < m; j++) {
					char c = s.charAt(j);
					if (c == '@') {
						x = i;
						y = j;
					} else
						safe[i][j] = c;
				}
			}
			traverse();
			pw.println();
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

