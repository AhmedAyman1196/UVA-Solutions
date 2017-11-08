import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	static boolean match(String s, String pat) {
		if (s.length() % pat.length() != 0)
			return false;
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			j++;
			if (j == pat.length())
				j = 0;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		int t = sc.nextInt();
		while (t-- > 0) {
			String s = sc.next();
			int n = s.length(), ans = 1;
			for (int i = 0; i < n; i++) {
				String pat = s.substring(0, i + 1);
				if (match(s, pat)) {
					ans = i+1;
					break;
				}
			}
			pw.println(ans);
			if(t!=0)
				pw.println();
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
