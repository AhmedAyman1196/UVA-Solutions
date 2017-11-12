import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static ArrayList<Integer> adjList[];
	static int counter, SCC, dfs_num[], dfs_low[];
	static boolean[] visited;
	static Stack<Integer> stack;

	static void solve() {
		dfs_num = new int[n];
		dfs_low = new int[n];
		counter = SCC = 0;
		visited = new boolean[n];
		stack = new Stack<>();

		for (int i = 0; i < n; ++i)
			if (dfs_num[i] == 0)
				tarjanSCC(i);
	}

	static void tarjanSCC(int u) {
		dfs_num[u] = dfs_low[u] = ++counter;
		stack.push(u);

		for (int v : adjList[u]) {
			if (dfs_num[v] == 0)
				tarjanSCC(v);
			if (!visited[v])
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
		}
		if (dfs_num[u] == dfs_low[u]) {
			// SCC found
			while (true) {
				int v = stack.pop();
				visited[v] = true;
				if (v == u)
					break;
			}
			SCC++;
		}

	}

	static boolean initialize() throws IOException {
		n = sc.nextInt();
		m = sc.nextInt();
		if (n == 0 && m == 0)
			return false;
		adjList = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++)
			map.put(sc.nextLine(), i);

		for (int i = 0; i < m; i++)
			adjList[map.get(sc.nextLine())].add(map.get(sc.nextLine()));

		return true;
	}

	static void print() {
		System.out.println(SCC);
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

