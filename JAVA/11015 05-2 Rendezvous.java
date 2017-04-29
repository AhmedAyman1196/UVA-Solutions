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
		
		int n =sc.nextInt() , m = sc.nextInt() , t = 1 ;
		while(true){
			if(!sc.ready())break ;
			HashMap<Integer, String> map = new HashMap<>() ;
			for(int i = 0 ; i < n ; i ++)
				map.put(i, sc.next()) ;
			
			int adjMat[][] = new int[n][n] ;
			for(int i = 0 ; i < n ; i ++)
				Arrays.fill(adjMat[i] , Integer.MAX_VALUE) ;
			for(int i = 0 ; i < n ; i ++)
				adjMat[i][i] = 0 ;
			
			for(int i = 0 ; i <  m ; i ++){
				int h1 = sc.nextInt()-1 , h2 = sc.nextInt()-1 , cost = sc.nextInt() ;
				adjMat[h1][h2] = cost ;
				adjMat[h2][h1] = cost ;
			}
			
			for(int k = 0 ; k < n ; k ++)
				for(int i = 0 ; i < n ; i ++)
					for(int j = 0 ; j < n ; j++){
						if(adjMat[i][k]!=Integer.MAX_VALUE&&adjMat[k][j]!=Integer.MAX_VALUE)
							adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k]+adjMat[k][j]) ;
					}
			
			int dist[] = new int[n] ;
						
			for(int i = 0 ; i < n  ; i ++){
				int sum  = 0 ;
				for(int j = 0 ; j < n ; j ++)
					 sum += adjMat[i][j] ;
				dist[i] = sum ; 
			}
			
			int ans = 0  , min  =Integer.MAX_VALUE ;
			for(int i =0 ; i < n; i ++)
				if(dist[i]<min){
					min = dist[i] ;
					ans = i;
				}
			pw.printf("Case #%d : %s\n" , t++ ,map.get(ans) ) ; 
			
			if(!sc.ready())break ;
			n = sc.nextInt() ;
			m = sc.nextInt() ;
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
