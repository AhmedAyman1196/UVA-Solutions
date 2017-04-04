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
	static int[] ST, a;

	// lazy propagation >> not lazy :)))
	public static void propagate(int idx, int startRange, int endRange, int changeVal, int currleft, int currright) {
		if (currleft > currright)
			return;

		// 1 - no overlap
		if (startRange > currright || endRange < currleft)
			return;
		// 2 - total overlap
		if (startRange <= currleft && endRange >= currright) {
			ST[idx] = changeVal;

			return;
		}
		// 3- partial overlap :
		int mid = (currright + currleft) / 2;
		propagate(2 * idx + 1, startRange, endRange, changeVal, currleft, mid);
		propagate(2 * idx + 2, startRange, endRange, changeVal, mid + 1, currright);
		ST[idx] = (ST[2 * idx + 1] + ST[2 * idx + 2]);
	}

	static int query(int idx, int qleft, int qright, int currleft, int currright) {

		if (currright < currleft)
			return 0;

		// 1-no overlap
		if (qleft > currright || qright < currleft) {
			return 0;
		}
		// 2-total overlap
		if (qleft <= currleft && qright >= currright)
			return ST[idx];
		// 3-partial overlap
		int mid = (currright + currleft) / 2;
		int x1 = query(idx * 2 + 1, qleft, qright, currleft, mid);
		int x2 = query(idx * 2 + 2, qleft, qright, mid + 1, currright);
		return x1 + x2;
	}

	static int build(int idx, int start, int end) {
		if (start == end) // you reached the leaf .
			return ST[idx] = a[start];
		int mid = (start + end) >> 1;
		int x1 = build((idx * 2) + 1, start, mid);
		int x2 = build((idx * 2) + 2, mid + 1, end);
		return ST[idx] = x1 + x2;
	}

	public static void main(String[] args) throws IOException {
		int n = sc.nextInt(), counter = 1;
		while (true) {
			if (n == 0)
				break;
			a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			int size = 1;
			while (size < a.length)
				size *= 2;
			ST = new int[(size << 1) - 1];
			build(0, 0, n - 1);
			String s = sc.next();
			StringBuilder sb = new StringBuilder();
			while (true) {
				if (s.equals("END"))
					break;

				if (s.equals("S")) {
					int pos = sc.nextInt() - 1;
					int value = sc.nextInt();
					// System.out.println("update: " + value + " in "+ pos);
					// System.out.println(Arrays.toString(ST));
					propagate(0, pos, pos, value, 0, n - 1);
					// System.out.println();
					// System.out.println(Arrays.toString(ST));
					// System.out.println("---------------------------------------");
				} else {
					int left = sc.nextInt() - 1;
					int right = sc.nextInt() - 1;
					// System.out.println("query");
					// System.out.println(left+" "+right);
					// System.out.println(query(0, left, right, 0, n - 1) +
					// "\n");
					// System.out.println(Arrays.toString(ST));
					// System.out.println("---------------------------------------");

					sb.append(query(0, left, right, 0, n - 1) + "\n");
				}
				s = sc.next();
			}
			n = sc.nextInt();
			pw.println("Case " + (counter++) + ":");
			if (n != 0)
				pw.println(sb);
			else
				pw.print(sb);

		}

		pw.flush();
		pw.close();
		// ---------------------------------------------

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
			return 0;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}

}
