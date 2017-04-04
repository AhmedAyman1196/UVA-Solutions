import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Integer> adjList[];
	static int n, m, num[], low[], parent[];
	static int counter, root, rootchild;
	static HashSet<Integer> AP;

	static void solve() {
		for (int i = 0; i < n; ++i)
			if (num[i] == 0) {
				root = i;
				rootchild = 0;
				counter = 1; 
				APS(i);
				if (rootchild > 1)
					AP.add(i);
			}
	}

	static void APS(int u) { // Articulation Points Search
		low[u] = num[u] = counter++;
		
		for (int i = 0; i < adjList[u].size(); i++) {
			int v = adjList[u].get(i);
			if (num[v] == 0) {
				parent[v] = u;
				if (u == root)
					rootchild++;
				APS(v);

				if (low[v] >= num[u]&&u!=root)
					AP.add(u);

				low[u] = Math.min(low[u], low[v]);

			} else if (v != parent[u])
				low[u] = Math.min(low[u], num[v]);
		}
	}

	@SuppressWarnings("unchecked")
	static boolean initialize() throws IOException {
		n = sc.nextInt();
		if (n == 0)
			return false;
		adjList = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();
		num = new int[n];
		low = new int[n];
		parent = new int[n];
		root = 0;
		rootchild = 0;
		counter = 1;
		AP = new HashSet<Integer>();
		while (true) {
			String s = sc.nextLine(), a1[] = s.split(" ");
			int x = Integer.parseInt(a1[0]) - 1;
			if (x == -1)
				break;
			for (int i = 1; i < a1.length; i++) {
				int y = Integer.parseInt(a1[i]) - 1;
				adjList[x].add(y);
				adjList[y].add(x);
			}

		}

		return true;
	}

	static void print() {
		System.out.println(AP.size());
	}

	public static void main(String[] args) throws IOException {
		while (initialize()) {
			solve();
			print();
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

