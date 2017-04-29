import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// ~~~~~~~~~~~~~~~ Main Method ~~~~~~~~~~~~~~~~~~
		
		int n = sc.nextInt()  , r =sc.nextInt()  , t = 1;
		while(!(n==0&&r==0)){
			HashMap<String, Integer> map = new HashMap<>();
			int idx = 0 ;
			int adjMat[][] = new int[n][n] ;
			for(int i = 0 ; i < n ; i ++)
				Arrays.fill(adjMat[i], Integer.MAX_VALUE) ;
			for(int i  = 0 ; i < n ; i ++)
				adjMat[i][i] = 0 ;
			
			for(int i = 0 ; i < r ; i ++){
				String s1  =sc.next() , s2 = sc.next() ;
				if(!map.containsKey(s1))
					map.put(s1, idx++);
				if(!map.containsKey(s2))
					map.put(s2, idx++);
				int x1 = map.get(s1) , x2 = map.get(s2) ;
				adjMat[x1][x2] = 1 ;
				adjMat[x2][x1] = 1 ;				
			}
			for(int k = 0;  k < n ; k ++)
				for(int i = 0 ; i < n ; i ++)
					for(int j =  0  ; j < n ; j ++)
						if(adjMat[i][k]!=Integer.MAX_VALUE&&adjMat[k][j]!=Integer.MAX_VALUE)
							adjMat[i][j] =Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]) ;
			
			int max  = 0 ;
			for(int i = 0 ; i < n ; i ++)
				for(int j = 0 ; j < n ;j++)
					max = Math.max(adjMat[i][j], max ) ;
			
			if(max==Integer.MAX_VALUE)
				pw.printf("Network %d: DISCONNECTED\n\n", t++) ;
			else 
			pw.printf("Network %d: %d\n\n", t++ , max) ;
			n = sc.nextInt() ;
			r = sc.nextInt() ;
		}
		pw.flush();
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
			return br.ready() || st.hasMoreTokens();
		}

	}
}
