import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {	
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		PrintWriter pw  = new PrintWriter(System.out ); 
		int t = sc.nextInt() ; 
		for(int r = 1 ; r<=t ; r++){
			int n = sc.nextInt()  , ans = -1 , have = 0 , startans = 0  , endans = 0 ,currstart = 0 ; 
			int a[] = new int[n] ; 
			for(int i = 0 ; i < n-1 ; i ++){
				int x = sc.nextInt() ; 
				have+=x ; 
				if(have<0){
					have =  0 ;
					currstart = i+1 ;
				}else if(have==ans) {
					int x1 = -startans+endans ; 
					int x2 = i-currstart  ;
					if(x1<x2){
						startans = currstart ; 
						endans = i ; 
					}
				}else if(have>ans){
					startans = currstart ; 
					endans = i ; 
				}
				
				ans = Math.max(have, ans) ;
			}
			if(ans>0)
			pw.println("The nicest part of route " +r+ " is between stops " +(startans+1)+ " and "+(endans+2));
			else pw.println("Route "+r+" has no nice parts");
		}
		pw.flush(); 
		pw.close();
	}

	static class Scanner {
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

}
