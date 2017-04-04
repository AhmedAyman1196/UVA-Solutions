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
			// input
			int n = sc.nextInt();
			Point point[] = new Point[n];

			for (int i = 0; i < n; i++) { // each town has number from 1 to n &&
											// coordinate xi , yi
				point[i] = new Point(sc.nextInt(), sc.nextInt());
			}

			int m = sc.nextInt(); // input of already taken edges (roads)
			UnionFind uf = new UnionFind(n+1);
			for (int i = 0; i < m; i++) {
				int town1 = sc.nextInt() - 1, town2 = sc.nextInt() - 1;
				uf.unionSet(town1, town2);
			}

			ArrayList<Edge> edges = new ArrayList<>();

			for (int i = 0; i < n; i++)
				for (int j = i+1; j < n; j++)
					if (i != j) // to avoid an edge from a point to itself
						edges.add(new Edge(point[i], point[j], i, j));
			// kruskal's
			Collections.sort(edges);
			boolean check = true ;  // check if at least one new edge was added
			for (int i = 0; i < edges.size(); i++) {
				Edge e = edges.get(i);
				if (!uf.isSameSet(e.from, e.to)) {
					check = false ;
					uf.unionSet(e.from, e.to);
					pw.println(e.from + 1 + " " + (e.to + 1));
				}
			}
			if(check)
				pw.println("No new highways need");
			if (t != 0)
				pw.println();
		}
		pw.flush();
	}

	static class Edge implements Comparable<Edge> {
		Integer from, to;
		Double cost;
		Point p1, p2;

		public Edge(Point p1, Point p2, int from, int to) {
			// TODO Auto-generated constructor stub
			this.p1 = p1;
			this.p2 = p2;
			this.from = from;
			this.to = to;
			cost = Math.sqrt(distance(p1, p2)) ; // can remove the sqrt and still will work
		}

		public double distance(Point p1, Point p2) {
			return ((p1.x - p2.x) * (p1.x - p2.x)) + ((p1.y - p2.y) * (p1.y - p2.y));

		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return cost.compareTo(o.cost);
		}

	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
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
