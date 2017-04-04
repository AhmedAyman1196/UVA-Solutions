import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
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

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt() ;
		// StringBuilder sb = new StringBuilder() ;
		// PrintWriter pw = new PrintWriter(System.out);
		// boolean h[] = new boolean[n+1];
		// boolean v[] = new boolean[n+1];
		// for(int i = 0 ; i < n ; i ++){
		// int z1 = sc.nextInt()+1 ;
		// int z2 =sc.nextInt()+1 ;
		// if(!h[z1]&&!v[z2]){
		// sb.append(i+" ");
		// v[z1] = true ;
		// h[z2] = true ;
		// }
		// }
		// pw.println(sb);pw.flush();pw.close();
		//
		int n = sc.nextInt();
		while (n != 0) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			int sum = 0 ; int ans = 0 ; 
			for(int i = 0 ; i<n ; i++){
				sum += a[i];
				ans = Math.max(ans,sum );
				if(sum<0)sum=0;
			}
			if(ans==0)System.out.println("Losing streak.");
			else System.out.printf("The maximum winning streak is %d.\n",ans);
			n  = sc.nextInt() ;
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