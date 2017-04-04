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
		// ~~~~~~~~~~~~~~~ Main Method ~~~~~~~~~~~~~~~~~~`
		int t = sc.nextInt();// test cases
		for (int tc = 1; tc <= t; tc++) {
			// input
			int n = sc.nextInt(); // number of nodes
			ArrayList<edge> edgeList = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine(), ", ");
				for (int j = 0; j < n; j++) {
					int x = Integer.parseInt(st.nextToken()); 
					if (x != 0) // zero means that no edge here
						edgeList.add(new edge(x, i, j));
				}
			}

			// Kruskal Algorithm (greedy)

			Collections.sort(edgeList); // sort edges in asceding order
			UnionFind uf = new UnionFind(n);
			StringBuilder ans = new StringBuilder();

			for (edge e : edgeList) {
				int to = e.to, from = e.from;
				if (!uf.isSameSet(to, from)) { // taking this edge wont form a
												// cycle
					char c1 = (char) (from + 'A'), c2 = (char) (to + 'A');
					ans.append(c1 + "-" + c2 + " " + e.weight + "\n");
					uf.unionSet(to, from);
				}
			}
			// output
			pw.printf("Case %d:\n", tc);
			pw.print(ans);
		}
		pw.flush();
	}

	static class edge implements Comparable<edge> {
		int weight, from, to;

		public edge(int weight, int from, int to) {
			// TODO Auto-generated constructor stub
			this.weight = weight;
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(edge o) {
			// TODO Auto-generated method stub
			Integer x1 = weight, x2 = o.weight;
			return x1.compareTo(x2);
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
