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


	public static void main(String[] args) throws IOException {
		// -------------------- Main ------------------
		long n, k;
		while (true) {
			
			n = sc.nextInt();k = sc.nextInt();
			double ans = 0 ; 
			if(k>n-k)
				for(long i = k+1 ; i <=n ; i ++)
					ans += Math.log10(i) - Math.log10(n-i+1) ; 
			else
				for(long i = n-k+1 ; i <=n ; i++)
					ans+= Math.log10(i)- Math.log10(n-i+1) ;
			ans = Math.floor(ans) +1 ; 
			pw.println((long)ans);
			if (!sc.ready())
				break;
		}

		// ---------------------------------------------
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
