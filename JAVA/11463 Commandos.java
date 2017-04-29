import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
		// ~~~~~~~~~~~~~~~~ Main Method ~~~~~~~~~~~~~~~~~~~~~~~~~~
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt(), r = sc.nextInt();
			int[][] adjMat = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(adjMat[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < n; i++) // important line
				adjMat[i][i] = 0;

			for (int i = 0; i < r; i++) {
				int v1 = sc.nextInt(), v2 = sc.nextInt();
				adjMat[v1][v2] = 1;
				adjMat[v2][v1] = 1;
			}
			int source = sc.nextInt(), target = sc.nextInt();

			// Floyd Warshall
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (adjMat[i][k] != Integer.MAX_VALUE && adjMat[k][j] != Integer.MAX_VALUE)
							adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);
					}
				}
			}
			int ans = 0;

			for (int i = 0; i < n; i++) {
				if (adjMat[source][i] != Integer.MAX_VALUE && adjMat[i][target] != Integer.MAX_VALUE)
					ans = Math.max(adjMat[source][i] + adjMat[i][target], ans);
			}
			pw.printf("Case %d: %d\n", tc, ans);

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

		public boolean ready() throws IOException {
			return br.ready();
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextInt();
			}
			return array;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] array = new long[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextLong();
			}
			return array;
		}

		public String[] nextStringArray(int n) throws IOException {
			String[] array = new String[n];
			for (int i = 0; i < n; i++) {
				array[i] = next();
			}
			return array;
		}

		public char[][] nextCharMap(int n) throws IOException {
			char[][] array = new char[n][];
			for (int i = 0; i < n; i++) {
				array[i] = next().toCharArray();
			}
			return array;
		}

		public int[][] nextIntMap(int n, int m) throws IOException {
			int[][] map = new int[n][];
			for (int i = 0; i < n; i++) {
				map[i] = nextIntArray(m);
			}
			return map;
		}

	}
}
