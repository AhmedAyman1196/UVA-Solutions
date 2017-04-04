import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

// TAAAAAAAKE CAAAAARE 
// you have to count the guide as a passenger *****

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);
	static int  start , end , num  ;
	static boolean visited[]  ;
	static ArrayList<Pair> adjList[] ;
	
	static int  dfs(int idx){
		if(visited[idx])return Integer.MAX_VALUE ;
		visited[idx] = true ; 
//		int ans = Integer.MAX_VALUE ; 
		for(Pair p : adjList[idx]){
			int to = p.to  ,  cost = p.cost ;
			if(to==end){
				return  cost ;
			}
			int x = dfs(to) ;
			if(x!=Integer.MAX_VALUE)
				return Math.min(cost , x ) ;
		}
		return  Integer.MAX_VALUE ; 
	}

	public static void main(String[] args) throws IOException {
		// ~~~~~~~~~~~~~~~ Main Method ~~~~~~~~~~~~~~~~~~
		
		int n = sc.nextInt()  , r = sc.nextInt() , t = 1  ; // number of cities and number of roads 
		while(!(n==0&&r==0)){
			
			Edge[] edges = new Edge[r];
			for(int i = 0 ; i < r ; i ++)
				edges[i]  = new Edge(sc.nextInt() -1 ,sc.nextInt() -1 ,  sc.nextInt() ) ;
			
			start = sc.nextInt()-1   ;
			end = sc.nextInt() -1 ; 
			num =sc.nextInt() ;// required number of tourists
			Arrays.sort(edges);
			UnionFind uf = new UnionFind(n) ;
			adjList = new ArrayList[n] ; // holds the chosen edges
			for(int i = 0 ; i < n ; i ++)
				adjList[i]  =new ArrayList<>() ;
			
			for(int i = 0; i < r ; i ++){
				Edge e = edges[i] ;
				if(!uf.isSameSet(e.from, e.to)){
					uf.unionSet(e.from, e.to);
					adjList[e.from].add(new Pair(e.cost, e.to));
					adjList[e.to].add(new Pair(e.cost, e.from));
				}
			}
			visited = new boolean[n];
			int ans = dfs(start)-1 ; // -1 because u count the guide as well
//			System.out.println(ans+" "+num);
			int z=  (int) Math.ceil((1.0*num) / ans); 
			pw.printf("Scenario #%d\nMinimum Number of Trips = %d\n\n", t++ ,z) ;
			n = sc.nextInt() ; 
			r = sc.nextInt() ;
		}
		pw.flush();
	}

	static class Pair {
		int cost;
		int to;

		public Pair(int cost, int to) {
			// TODO Auto-generated constructor stub
			this.cost = cost;
			this.to = to;
		}
	}

	static class Edge implements Comparable<Edge> {
		Integer from, to;
		Integer cost;

		public Edge(int from, int to, int cost) {
			// TODO Auto-generated constructor stub

			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return o.cost.compareTo(cost);
		}

	}

	static class UnionFind {

		private Vector<Integer> p, rank, setSize;
		private int numSets;

		public UnionFind(int N) { // N = number of initial sets
			p = new Vector<Integer>(N);
			rank = new Vector<Integer>(N);
			setSize = new Vector<Integer>(N);
			numSets = N;
			for (int i = 0; i < N; i++) {
				p.add(i);
				rank.add(0);
				setSize.add(1);
			}
		}

		public int findSet(int i) { // return the number of the set that has i
			if (p.get(i) == i)
				return i;
			else {
				int ret = findSet(p.get(i));
				p.set(i, ret);
				return ret;
			}
		}

		public Boolean isSameSet(int i, int j) { // checks if i and j in the
													// same
													// set
			return findSet(i) == findSet(j);
		}

		public void unionSet(int i, int j) { // links i and j and their sets
			if (!isSameSet(i, j)) {
				numSets--;
				int x = findSet(i), y = findSet(j);

				if (rank.get(x) > rank.get(y)) {
					p.set(y, x);
					setSize.set(x, setSize.get(x) + setSize.get(y));
				} else {
					p.set(x, y);
					setSize.set(y, setSize.get(y) + setSize.get(x));
					if (rank.get(x) == rank.get(y))
						rank.set(y, rank.get(y) + 1);
				}
			}
		}

		public int numDisjointSets() { // total number of sets
			return numSets;
		}

		public int sizeOfSet(int i) { // returns the number of elements of the
										// set
			return setSize.get(findSet(i));
		}

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
