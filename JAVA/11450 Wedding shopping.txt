import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

/*07:05:45PM

 String x =sc.next();
 char inp [] = x.toCharArray();
 SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
 SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
 Date date = parseFormat.parse(x.substring(0, 5)+" "+x.substring(8, 10));
 System.out.println(displayFormat.format(date)+":"+x.substring(6, 8));
 */

public class Main {
	static ArrayList<Integer>[] prices;
	static int memo[][];

	public static int dp(int type, int money) {
		if (type == prices.length)
			return 0;
		if (memo[type][money] != -1)
			return memo[type][money];
		int max = -10000;
		for (int i = 0; i < prices[type].size(); i++) {
			if (money - prices[type].get(i) >=0) {
				int curr = prices[type].get(i) + dp(type + 1, money - prices[type].get(i));
				if (curr >= max)
					max = curr;
			}
		}
		return memo[type][money] = max;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int money = sc.nextInt(), types = sc.nextInt();
			memo = new int[21][205];
			for (int i = 0; i < 21; i++)
				Arrays.fill(memo[i], -1);
			prices = new ArrayList[types];
			for (int i = 0; i < types; i++)
				prices[i] = new ArrayList<Integer>();
			// ------------------------------------------------------
			for (int i = 0; i < types; i++) {
				int k = sc.nextInt();
				for (int j = 0; j < k; j++) {
					prices[i].add(sc.nextInt());
				}
			}
			// ------------------------------------------------------
			int answer = dp(0, money);
			if (answer < 0)
				System.out.println("no solution");
			else
				System.out.println(answer);
		}
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