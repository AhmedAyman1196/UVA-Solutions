import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// ~~~~~~~~~~~~~~~ Main Method ~~~~~~~~~~~~~~~~~~
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			Key a[] = new Key[n];
			boolean found0 = false;
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				if (s.equals("0000"))
					found0 = true;
				a[i] = new Key(s);
			}
			ArrayList<Edge> edges = new ArrayList<>();

			for (int i = 0; i < n; i++)
				for (int j = i + 1; j < n; j++) {
					int from = i;
					int to = j;
					int weight = a[i].dist(a[j]);
					edges.add(new Edge(to, from, weight));
				}

			if (!found0) { // problem might be here
				Key k = new Key("0000");
				for (int i = 0; i < n; i++) {
					edges.add(new Edge(505, i, k.dist(a[i])));
				}
			}
			// Kruskal
			Collections.sort(edges);
			UnionFind uf = new UnionFind(510);
			long ans = 0;
			boolean taken = false;
			for (Edge e : edges) {
				if (!uf.isSameSet(e.from, e.to)) {
					if ((e.from == 505 || e.to == 505) && taken )
						continue;
					if(e.from==505||e.to == 505)
						taken = true ; 
					uf.unionSet(e.from, e.to);
					ans += e.weight;
				}
			}
			pw.println(ans);
		}
		pw.flush();
	}

	public static class Edge implements Comparable<Edge> {
		public Integer to, from, weight;

		public Edge(int to, int from, int weight) {
			// TODO Auto-generated constructor stub
			this.to = to;
			this.from = from;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge arg0) {
			// TODO Auto-generated method stub
			return weight.compareTo(arg0.weight);
		}

	}

	public static class Key {
		public String s;
		public int x1, x2, x3, x4;

		public Key(String s) {
			// TODO Auto-generated constructor stub
			x1 = Integer.parseInt(s.charAt(0) + "");
			x2 = Integer.parseInt(s.charAt(1) + "");
			x3 = Integer.parseInt(s.charAt(2) + "");
			x4 = Integer.parseInt(s.charAt(3) + "");

		}

		public int dist(Key k) {
			return d(k.x1, x1) + d(k.x2, x2) + d(k.x3, x3) + d(k.x4, x4);
		}

		public int d(int k1, int k2) {
			int max = Math.max(k1, k2);
			int min = Math.min(k1, k2);
			return Math.min(max - min, 10 - max + min);
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

	public static class UnionFind {

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
}
