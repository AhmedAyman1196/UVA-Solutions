import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	// shayfak yala ya yasser yala
	// :P
	static void input(int[] a, int n) throws Exception {
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
	}

	public static void main(String[] args) throws Exception {
		// ----------------- Main -------------------------------
		int t = sc.nextInt() , n  ,a [];
		StringBuilder sb  ; 
		while (t-- > 0) {
			n = sc.nextInt() ;a= new int[10];sb = new StringBuilder();
			for (int i = 1; i <= n; i++)
				sb.append(i);
			String s = sb.toString();
			for (int i = 0; i < s.length(); i++) {
				a[s.charAt(i) - '0']++;
			}
			for (int i = 0; i < 9; i++)
				pw.print(a[i] + " ");
			pw.println(a[9]);
		}

		// ---------------------------------------------------------
		pw.flush();
		pw.close();

	}
}

class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s) {
		br = new BufferedReader(new InputStreamReader(s));
	}

	public Scanner(FileReader f) {
		br = new BufferedReader(f);
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