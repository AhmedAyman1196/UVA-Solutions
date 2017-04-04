import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int n = sc.nextInt();
			int b[][] = new int[n][n];
			for (int i = 0; i < n; i++)
				Arrays.fill(b[i], 1);
			int blocks = sc.nextInt();
			for (int k = 0; k < blocks; k++) {
				int r1 = sc.nextInt() - 1, c1 = sc.nextInt() - 1;
				int r2 = sc.nextInt() - 1, c2 = sc.nextInt() - 1;
				for (int i = r1; i <= r2; i++)
					Arrays.fill(b[i], c1, c2 + 1, -10001);
			}

			int a[][] = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					a[i][j] = b[i][j];
					if (i > 0)
						a[i][j] += a[i - 1][j];
					if (j > 0)
						a[i][j] += a[i][j - 1];
					if (i > 0 && j > 0)
						a[i][j] -= a[i - 1][j - 1];

				}

			int maxsub = -100000;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					for (int k = i; k < n; k++)
						for (int l = j; l < n; l++) {
							int sub = a[k][l];
							if (i > 0)
								sub -= a[i - 1][l];
							if (j > 0)
								sub -= a[k][j - 1];
							if (i > 0 && j > 0)
								sub += a[i - 1][j - 1];
							maxsub = Math.max(sub, maxsub);
						}
			if (maxsub > 0)
				pw.println(maxsub);
			else
				pw.println(0);

		}
		pw.flush();
		pw.close();

	}
}

class Triple {
	long x, y, z;

	public Triple(long a, long b, long c) {
		x = a;
		y = b;
		z = c;
	}
}

class Pair implements Comparable<Pair> {
	String t;
	String a;

	Pair(String f, String b) {
		t = f;
		a = b;
	}

	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return a.compareTo(o.a) == 0 ? t.compareTo(o.t) : a.compareTo(o.a);
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