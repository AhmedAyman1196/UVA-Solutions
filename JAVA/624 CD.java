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
	static ArrayList<Integer> ans;
	static int max;

	public static int sum(int i, int max) {
		if (i == a.length || max == 0)
			return 0;
		if (max - a[i] >= 0) {
			int x1 = a[i] + sum(i + 1, max - a[i]);
			int x2 = sum(i + 1, max);
			if (x1 > x2) {
				return x1;
			} else
				return x2;
		} else {
			int x = sum(i + 1, max);
			return x;
		}
	}

	public static int print(int i, int max) {
		
		if (i == a.length && max != 0)
			return Integer.MIN_VALUE;
		if (i == a.length && max == 0){
			return 0;
		}
		int x1 = print(i + 1, max - a[i]);
		
		if (x1 ==0) {
			ans.add(a[i]);
			return 0;
		}
		return print(i + 1, max);
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		while (true) {
			max = sc.nextInt();
			int n = sc.nextInt();
			a = new int[n];
			ans = new ArrayList<Integer>();
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			
			int tmp = sum(0, max);
			
			print(0 , tmp);
			Collections.reverse(ans);
			for (int i = 0; i < ans.size(); i++)
				pw.print(ans.get(i) + " ");
			
			pw.printf("sum:%d\n", tmp);
			if (!sc.ready())
				break;
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