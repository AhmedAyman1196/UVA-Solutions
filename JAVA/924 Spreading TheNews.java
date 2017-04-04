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
		int n = sc.nextInt() ; // number of employees ( 0 --> n-1 )
		ArrayList<Integer> adjList [] = new ArrayList[n] ;
		for(int i = 0 ; i < n ; i ++)
			adjList[i] = new ArrayList<>() ;
		for(int i = 0 ; i < n ; i ++){
			int m = sc.nextInt() ; // number of friends 
			for(int j = 0 ; j < m ; j++){
				int x = sc.nextInt() ;
				adjList[i].add(x) ;
			}
		}
		
		int t = sc.nextInt() ;
		while(t-->0){
			int source = sc.nextInt() , day = 0  , max = 0 , curr = 1  ;
			Queue<Integer> q = new LinkedList<Integer>() ;
			q.add(source) ;
			boolean visited[] = new boolean[n] ;
			visited[source] = true ;
			while(!q.isEmpty()){
				HashSet<Integer> a = new HashSet<>() ; // holds friends that hear at this day
				while(!q.isEmpty()){
					int x = q.poll() ;
//					visited[x] = true ;
					for(Integer i  : adjList[x])
						if(!visited[i]){
							visited[i] = true;
							a.add(i) ;
						}
				}
				if(max<a.size()){
					day = curr; 
					max = a.size() ;
				}
				curr++ ;
				q.addAll(a);
			}
			if(max==0)pw.println(0);
			else pw.println(max+" "+day);
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
