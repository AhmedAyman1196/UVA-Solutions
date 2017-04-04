import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// ~~~~~~~~~~~~~~~ Main Method ~~~~~~~~~~~~~~~~~~
		int tc = sc.nextInt() ;
		while(tc-->0){
			int n = sc.nextInt() ; 
			ArrayList<Integer> adjList[] = new ArrayList[n] ;
			for(int i = 0 ; i < n ; i ++)
				adjList[i] = new ArrayList<>() ;
			
			for(int i = 0 ; i < n ; i ++){
				int x = sc.nextInt() ;
				int m = sc.nextInt() ;
				for(int j = 0 ; j < m ;j ++)
					adjList[x].add(sc.nextInt()) ;
			}
			
			int source= sc.nextInt() , target = sc.nextInt() , distance = 0 ;
			// bfs
			Queue<Integer> q = new LinkedList<Integer>() ;
			q.add(source) ;
			boolean visited[] = new boolean[n] ;
			visited[source] = true ;
			while(!q.isEmpty()){
				HashSet<Integer> a = new HashSet<>() ;
				boolean found = false ;
				while(!q.isEmpty()){
					int x = q.poll() ;
					if(x==target){
						found = true ;
						break ;
					}
//					visited[x] = true ;
					for(Integer i  : adjList[x])
						if(!visited[i]){
							visited[i] = true;
							a.add(i) ;
						}
				}
				if(found)break ;
				distance++ ;
				q.addAll(a);
			}
			pw.println(source+" "+target+" "+(-1+distance));
			if(tc!=0)
				pw.println();
			
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
			return br.ready();
		}

	}
}
