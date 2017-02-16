import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static ArrayList<Integer>[] incoming  , outgoing;
	static StringBuilder ans;
	static boolean visited[];

	public static void main(String args[]) throws IOException {
			n = sc.nextInt();
			m = sc.nextInt();
			while (!(n == 0 && m == 0)) {
				incoming = new ArrayList[n];
				outgoing = new ArrayList[n] ;
				visited = new boolean[n];
				ans = new StringBuilder();
				Queue<Integer> q = new LinkedList<>();
				for (int i = 0; i < n; i++){
					incoming[i] = new ArrayList<>();
					outgoing[i] = new ArrayList<>();
				}
				
				for (int i = 0; i < m; i++){ // a should be first 
					int a = sc.nextInt()-1 ,b = sc.nextInt()-1 ;
					incoming[b].add(a);
					outgoing[a].add(b);
				}
				for (int i = 0; i < n; i++) {
					if (incoming[i].size() == 0){
					q.add(i) ;
				}
			}
			
			while(!q.isEmpty()){
				int v = q.peek() ;
				q.poll() ;
				visited[v] = true ;
				ans.append((v+1)+"\n");
				for(int i = 0 ; i < outgoing[v].size() ; i ++){
					int u  = outgoing[v].get(i);
					incoming[u].remove(((Integer)v));
					if(incoming[u].size()==0)q.add(u);
				}
			}
			boolean check = true ;
			for(int i = 0 ; i < n ; i ++){
				if(!visited[i])check = false;
			}
			if(check)pw.println(ans);
			else pw.println("IMPOSSIBLE");
			
			n = sc.nextInt();
			m = sc.nextInt();
		}
		pw.flush();
		pw.close();
	}

	static public class Scanner {
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
