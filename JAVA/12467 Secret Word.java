import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static String s, pat;
	static int back[], ans, n, m;

	static void kmpPreprocess() {
		int i = 0, j = -1;
		n = s.length();
		m = pat.length();
		ans = 0;
		back = new int[m + 1];
		back[0] = -1;
		while (i < m) {
			while (j >= 0 && pat.charAt(i) != pat.charAt(j))
				j = back[j];
			i++;
			j++;
			back[i] = j;
		}
	}

	static void kmpSearch() {
		int i = 0, j = 0;
		while (i < n) {
			while (j >= 0 && s.charAt(i) != pat.charAt(j)) {
				j = back[j];
			}
			ans = Math.max(ans, j);
			i++;
			j++;
			if (j == m)
				j = back[j];
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			pat = sc.next();
			s = new StringBuilder(pat).reverse().toString();
			kmpPreprocess();
			kmpSearch();
			pw.println(new StringBuilder(pat.substring(0, ans + 1)).reverse());
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
