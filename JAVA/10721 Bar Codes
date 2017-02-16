import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static long n  ,  max , maxsections, memo[][][] ;
	
	static long dp(int idx ,  int counter , int sections){
//		System.out.println(idx+" " +counter+" "+sections);
//		System.out.println(counter);
		if(sections>maxsections)return  0 ;
		if(counter>max)return 0 ;
		if(idx==n){
//			System.out.println("    finish  "  + idx+" "+counter+" "+sections);
//			System.out.println(sections==maxsections? idx+" "+counter+" "+sections :"Failure");
			return sections==maxsections?  1 : 0  ;
		}
		if(memo[idx][counter][sections]>-1)return memo[idx][counter][sections] ; 
		
		return memo[idx][counter][sections] = dp(idx+1 , counter+1  , sections) + dp(idx+1 , 1 , sections+1) ;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		while(true){
		 n = sc.nextInt() ;
		 maxsections =sc.nextInt() ;
		 max = sc.nextInt() ;
		 memo = new long[55][55][55] ;
		 for(int i = 0 ; i< 55 ; i ++)
			 for(int j = 0 ; j < 55 ; j ++) 
			 Arrays.fill(memo[i][j], -1) ;
		 
		 pw.println(dp(1 , 1, 1));
			if(!sc.ready())break ;
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
