import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt(), m = sc.nextInt();
			UnionFind x = new UnionFind(n);
			for (int i = 0; i < n; i++)
				x.updatemoney(i, sc.nextInt());
			for (int i = 0; i < m; i++)
				x.unionSet(sc.nextInt(), sc.nextInt());
			pw.println(x.possible()? "POSSIBLE" :  "IMPOSSIBLE");
		}
		pw.flush();pw.close();
	}

	static class UnionFind {

		public Vector<Integer> p, rank, setSize, have;
		public int numSets , num;

		public UnionFind(int N) {
			p = new Vector<Integer>(N);
			rank = new Vector<Integer>(N);
			setSize = new Vector<Integer>(N);
			have = new Vector<Integer>(N);
			numSets  = num = N;
			for (int i = 0; i < N; i++) {
				p.add(i);
				rank.add(0);
				setSize.add(1);
				have.add(0);
			}
		}

		public void updatemoney(int index, int x) {
			have.set(index, have.get(index) + x);
		}

		public int findSet(int i) {
			if (p.get(i) == i)
				return i;
			else {
				int ret = findSet(p.get(i));
				p.set(i, ret);
				return ret;
			}
		}

		public boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		public void unionSet(int i, int j) {
			if (!isSameSet(i, j)) {
				numSets--;
				int x = findSet(i), y = findSet(j);

				if (rank.get(x) > rank.get(y)) {
					p.set(y, x);
					setSize.set(x, setSize.get(x) + setSize.get(y));
					updatemoney(x, have.get(y));
				} else {
					p.set(x, y);
					setSize.set(y, setSize.get(y) + setSize.get(x));
					if (rank.get(x) == rank.get(y))
						rank.set(y, rank.get(y) + 1);
					updatemoney(y, have.get(x));
				}
			}
		}

		public int numDisjointSets() {
			return numSets;
		}

		public int sizeOfSet(int i) {
			return setSize.get(findSet(i));
		}

		public boolean possible() {
			for(int i = 0 ; i < num ; i ++){
				int curr = have.get(findSet(i));
				if(curr!=0)return false ;
			}
			return true ;
			
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
