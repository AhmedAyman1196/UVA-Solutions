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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = 0 ; 
		while(true){
			n  = sc.nextInt() ; 
			if(n==0)break ;
			String s = Integer.toString(n,2) ;
			
			int sum = 0 ; 
			for(int i = 0 ; i <s.length() ; i++){
				if(s.charAt(i)=='1')sum++;
			}
			pw.printf("The parity of "+s+" is %d (mod 2).\n",sum);
			
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
	int first;
	int second;

	Pair(int f, int s) {
		first = f;
		second = s;
	}

	public void add() {
		second++;
	}

	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return (first > second) ? 1 : first < second ? -1 : 0;
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