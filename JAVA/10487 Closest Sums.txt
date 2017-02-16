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
	static int a[];

	static int sum(int x) {
		int sum = a[0] + a[1] ;
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a.length; j++)
				if (i != j && a[i] != a[j]) {
					int curr = a[i] + a[j];
					if (Math.abs(curr - x) < Math.abs(sum - x)) {
						sum = Math.abs(curr );
					}
				}

		return sum;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int counter = 1 ;
		while (n != 0) {
			a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			int m = sc.nextInt();
			pw.printf("Case %d:\n", counter);
			for (int i = 0; i < m; i++) {
				int c = sc.nextInt();
				int x = sum(c);
				pw.printf("Closest sum to %d is %d.\n", c,x);
			}
			n = sc.nextInt();
			counter++; 
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