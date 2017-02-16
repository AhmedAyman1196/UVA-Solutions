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
		ArrayList<BigInteger> a  = new ArrayList<BigInteger>();
		 a.add( BigInteger.ONE);
		 a.add( BigInteger.ONE);
		for(int i = 2  ; i<10000 ; i++)
			a.add( a.get(i-1).add(a.get(i-2)) ) ;
		int n ; 
		 while (true ) {
              n = sc.nextInt();
             System.out.println (a.get(n-1));
             if(!sc.ready())break ;
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
