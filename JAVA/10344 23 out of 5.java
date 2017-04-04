import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	static boolean next_permutation(int[] A) {
		for (int a = A.length - 2; a >= 0; --a) {
			if (A[a] < A[a + 1]) {
				for (int b = A.length - 1;; --b) {
					if (A[b] > A[a]) {
						int t = A[a];
						A[a] = A[b];
						A[b] = t;
						for (++a, b = A.length - 1; a < b; ++a, --b) {
							t = A[a];
							A[a] = A[b];
							A[b] = t;
						}
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		while (true) {
			int a[] = new int[5], sum = 0;
			
			for (int i = 0; i < 5; i++) 
				sum += (a[i] = sc.nextInt());
						if (sum == 0)
				break;
			Arrays.sort(a);
			boolean check = false;
			while (true) {
				for (int i1 = 0; i1 < 3; i1++)
					for (int i2 = 0; i2 < 3; i2++)
						for (int i3 = 0; i3 < 3; i3++)
							for (int i4 = 0; i4 < 3; i4++) {
								long ans = 0;
								if (i1 == 0) ans = a[0] + a[1];
								else if (i1 == 1) ans = a[0] - a[1];
								else ans = a[0] * a[1];

								if (i2 == 0) ans = ans + a[2];
								else if (i2 == 1) ans = ans - a[2];
								else ans = ans * a[2];

								if (i3 == 0) ans = ans + a[3];
								else if (i3 == 1) ans = ans - a[3];
								else ans = ans * a[3];

								if (i4 == 0) ans = ans + a[4];
								else if (i4 == 1) ans = ans - a[4];
								else ans = ans * a[4];

								if (ans == 23) {
									check = true;
									break;
								}
							}
				if (!next_permutation(a))
					break;
			}
			if (check)
				pw.println("Possible");
			else
				pw.println("Impossible");
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

