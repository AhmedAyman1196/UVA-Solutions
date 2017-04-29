import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
		// ~~~~~~~~~~~~~~~~ Main Method ~~~~~~~~~~~~~~~~~~~~~~~~~~
		int t = sc.nextInt();
		for (int tc = 1; tc <=t; tc++) {
			int n = sc.nextInt(), m = sc.nextInt();
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for (int i = 0; i < m; i++) {
				int vertex1 = sc.nextInt(), vertex2 = sc.nextInt(), cost = sc.nextInt();
				pq.add(new Edge(vertex1, vertex2, cost));
			}
			// Kruskal
			UnionFind uf = new UnionFind(n) ;
			long ans = Integer.MAX_VALUE ;
			while(!pq.isEmpty()){
				Edge e = pq.poll() ;
				if(!uf.isSameSet(e.vertex1, e.vertex2)){
					uf.unionSet(e.vertex1, e.vertex2);
					ans = Math.min(ans, e.cost);
				}
			}

			pw.printf("Case #%d: %d\n", tc, ans) ;
		}	
		pw.flush();
	}

	static class Edge implements Comparable<Edge> {
		Integer vertex1, vertex2 ;
		Long cost;

		public Edge(int vertex1, int vertex2, long cost) {
			// TODO Auto-generated constructor stub
			this.vertex1 = vertex1;
			this.vertex2 = vertex2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return e.cost.compareTo(cost);
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

		public int[] nextIntArray(int n) throws IOException {
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextInt();
			}
			return array;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] array = new long[n];
			for (int i = 0; i < n; i++) {
				array[i] = nextLong();
			}
			return array;
		}

		public String[] nextStringArray(int n) throws IOException {
			String[] array = new String[n];
			for (int i = 0; i < n; i++) {
				array[i] = next();
			}
			return array;
		}

		public char[][] nextCharMap(int n) throws IOException {
			char[][] array = new char[n][];
			for (int i = 0; i < n; i++) {
				array[i] = next().toCharArray();
			}
			return array;
		}

		public int[][] nextIntMap(int n, int m) throws IOException {
			int[][] map = new int[n][];
			for (int i = 0; i < n; i++) {
				map[i] = nextIntArray(m);
			}
			return map;
		}

	}
}
