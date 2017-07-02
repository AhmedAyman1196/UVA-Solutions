import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n != 0) {
			String s = sc.next();
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < n && ans != 0; i++) {
				if (s.charAt(i) == 'Z')
					ans = 0;
				else if (s.charAt(i) == 'R') {
					for (int j = i + 1; j < n && ans != 0; j++) {
						if (s.charAt(j) == 'R')
							i = j;
						else if (s.charAt(j) == 'D') {
							ans = Math.min(ans, j - i);
							i = j-1 ;
							break ;
						} else if (s.charAt(j) == 'Z') {
							ans = 0;
						}
					}
				} else if (s.charAt(i) == 'D') {
					for (int j = i + 1; j < n && ans != 0; j++) {
						if (s.charAt(j) == 'D')
							i = j;
						else if (s.charAt(j) == 'R') {
							ans = Math.min(ans, j - i);
							i = j-1 ;
							break ;
						} else if (s.charAt(j) == 'Z') {
							ans = 0;
						}
					}
				}
			}
			pw.println(ans);
			n = sc.nextInt();
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

	}

}

