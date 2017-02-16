import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	static void input(int a[], int n) throws IOException {
		for (int i = 0; i < n; ++i)
			a[i] = sc.nextInt();
	}

	static double fact(double x) {
		if (x == 0)
			return 1;
		else
			return x * fact(x - 1);
	}

	static double pair(int x) {
		return fact(x) / (Math.pow(2, x / 2) * fact(x / 2));
	}

	public static void main(String[] args) throws IOException {
		// -------------------- Main ------------------
		BigInteger a [] = new BigInteger [1000 + 5];
        a [0] = BigInteger.ONE;
        a [1] = new BigInteger("2");
		for (int i = 2; i < 1002; i++)
			a[i] = a[i - 1].add(a[i - 2]);
		
		 while (sc.ready() ) {
             int number = sc.nextInt();
             System.out.println (a[number]);
       }
		

		// ---------------------------------------------
		pw.flush();
		pw.close();
	}

}

class Pair implements Comparable<Pair> {
	long first, second;

	public Pair(long f, long s) {
		first = f;
		second = s;
	}

	@Override
	public int compareTo(Pair o) {
		if (o.first > this.first)
			return -1;
		return 1;
	}

	public String toString() {
		return "" + first;
	}

}

class Scanner {
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
