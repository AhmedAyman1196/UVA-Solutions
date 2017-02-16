import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
		ArrayList<Integer> fib = new ArrayList<Integer>();
		fib.add(1);fib.add(1);fib.add(2);
		for (int i = 3; fib.get(i-1)<1000000000 ; i++)
			fib.add(fib.get(i - 1) + fib.get(i - 2) + fib.get(i - 3));
//		System.out.println(fib);
		int n = sc.nextInt() ; 
		while(n!=0){
			if(n==1||n==2)pw.println(0);
			else if(n==3)pw.println(1);
			else pw.println((1<<n)-fib.get(n+1));
			n = sc.nextInt() ;
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
