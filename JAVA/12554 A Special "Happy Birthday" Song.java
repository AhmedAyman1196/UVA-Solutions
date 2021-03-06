import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = sc.nextInt(), idx = 0 ;
		String person[] = sc.nextStringArray(n);
		String song[] = { "Happy", "birthday", "to", "you", "Happy", "birthday", "to", "you", "Happy", "birthday", "to",
				"Rujia", "Happy", "birthday", "to", "you" };
		boolean sang[] = new boolean[n];
		while (true) {
			boolean check = true;
			for(int i = 0 ; i < 16 ; i ++ , idx++){
				if(idx==n)idx=0;
				pw.println(person[idx]+": "+song[i]) ;
				sang[idx] = true ;
			}
			for (int i = 0; i < n && check; i++)
				if (!sang[i])
					check = false;
			if (check)
				break;
		}
		pw.flush();
		;
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
			return br.ready() || st.hasMoreTokens();
		}

		public String[] nextStringArray(int n) throws IOException {
			String[] array = new String[n];
			for (int i = 0; i < n; i++) {
				array[i] = next();
			}
			return array;
		}
	}
}
