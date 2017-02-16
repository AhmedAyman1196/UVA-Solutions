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
		ST[idx] = (ST[2 * idx + 1] * ST[2 * idx + 2]);
	}

	static int query(int idx, int qleft, int qright, int currleft, int currright) {

		if (currright < currleft)
			return 1;

		// 1-no overlap
		if (qleft > currright || qright < currleft) {
			return 1;
		}
		// 2-total overlap
		if (qleft <= currleft && qright >= currright)
			return ST[idx];
		// 3-partial overlap
		int mid = (currright + currleft) / 2;
		int x1 = query(idx * 2 + 1, qleft, qright, currleft, mid);
		int x2 = query(idx * 2 + 2, qleft, qright, mid + 1, currright);
		return x1 * x2;
	}

	static int build(int idx, int start, int end) {
		if (start == end) // you reached the leaf .
			return ST[idx] = a[start];
		int mid = (start + end) >> 1;
		int x1 = build((idx * 2) + 1, start, mid);
		int x2 = build((idx * 2) + 2, mid + 1, end);
		return ST[idx] = x1 * x2;
	}

	public static void main(String[] args) throws IOException {
		int n = sc.nextInt(), k = sc.nextInt();
		while (true) {
			StringBuilder ans = new StringBuilder();
			a = new int[n];

			Arrays.fill(a, 1);
			for (int i = 0; i < n; i++){
				int x = sc.nextInt();
				a[i] = x==0? 0: x>0? 1 : -1 ;
			}
			int size = 1;
			while (size < a.length)
				size *= 2;
			ST = new int[(size << 1) - 1];
			build(0, 0, a.length - 1);
			for (int i = 0; i < k; i++) {
				String s = sc.next();
				if (s.equals("C")) {
					int x = sc.nextInt() - 1;
					int value = sc.nextInt() ;
					value = value==0? 0 : value>0 ? 1: -1 ;
					propagate(0, x, x, value, 0, n - 1);
				}else{
					long x = query(0, sc.nextInt()-1, sc.nextInt()-1, 0, n-1);
					ans.append(x==0?0:x>0?"+":"-");
				}
			}
			pw.println(ans);
			if (!sc.ready())
				break;
			n = sc.nextInt();
			k = sc.nextInt();
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
