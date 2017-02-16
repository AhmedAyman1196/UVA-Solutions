import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in) ;
	static HashMap<Character, Integer> map = new HashMap<>() ;
	static boolean start ;
	static void solve(String s){
		int ans = start? 0: 1 ;
		start = false; 
		if(s.length()==2){// base case
			map.put(s.charAt(0), ans) ;
			return ;
		}
//		System.out.println(s);
		for(int i  = 2 ; i<s.length()-1 ; i++){
			char start = s.charAt(i-1);
			int idx = i-1;
			for(;i<s.length()-1; i++){
				if(s.charAt(i)==start){
					ans++ ;
					solve(s.substring(idx, i+1)) ;
					break ;
				}
			}
			i++ ;
		}
		if(!map.containsKey(s.charAt(0)))
			map.put(s.charAt(0), ans) ;
		else map.put(s.charAt(0), map.get(s.charAt(0)+1)) ;
		
	}
	static void print( int t){
		pw.println("Case "+t);
		Iterator it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        pw.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	public static void main(String args[]) throws IOException {
		int t = sc.nextInt() ; 
		for(int tc = 1 ; tc <=t ; tc ++){
			start = true ; 
			map.clear(); 
			solve(sc.next()) ;
			print(tc) ;
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
