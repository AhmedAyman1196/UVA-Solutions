import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
		while (true) {
			String s = sc.next();
			if (s.charAt(0) == '.')
				break;
			for (int i = 1; i <= s.length(); i++)
				if (compare(s, i)) {
					pw.println(s.length() / i);
					break;
				}
		}
		pw.flush();
	}

	private static boolean compare(String s, int end) {
		if (s.length() % end != 0)
			return false;
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			j++;
			if (j == end)
				j = 0;
		}
		return true;
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

		public String nextLine() throws IOException {
			return br.readLine();
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
