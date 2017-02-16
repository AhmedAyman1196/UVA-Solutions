import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int t = sc.nextInt() ;
		while(t-->0){
			int n =sc.nextInt() , min =Integer.MAX_VALUE ;
			ArrayList<Integer> ans = new ArrayList<>() ;
			for(int i = 0 ; i < n ; i ++){
				String a = sc.nextLine() ;
				String s[] =a.split(" ");
				
				if(s.length<min){
					ans.clear();
					ans.add(i+1) ;
					min = s.length ;
				}else if(s.length==min)ans.add(i+1);
			}
			for(int i = 0 ; i < ans.size()-1 ; i ++)
				System.out.print(ans.get(i)+" ");
			System.out.println(ans.get(ans.size()-1));
		}
	}
	static  class Scanner {
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
