import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	static ArrayList<Integer> adjList[];
	static boolean[] included, isAcorn, visited;
	static int trees, acorns;

	static void initialize() {
		adjList = new ArrayList[26];
		for (int i = 0; i < 26; i++)
			adjList[i] = new ArrayList<>();
		isAcorn = new boolean[26];
		included = new boolean[26];
		visited = new boolean[26];
		Arrays.fill(isAcorn, true);

	}

	static boolean dfs(int u, int parent) {
		if (!included[u])
			return true;
		if (visited[u]|| (u==parent && adjList[u].size()==0))
			return false;
		boolean ans = visited[u] = true;
		for (Integer v : adjList[u])
			if (v != parent) {
				ans = ans && dfs(v, u);
				isAcorn[v] = isAcorn[u] = false;
			}
		return ans;
	}

	static void solve() {
		trees = 0;
		acorns = 0;
		for (int i = 0; i < 26; i++)
			if (included[i]&&!visited[i]){
				if (dfs(i, i))
					trees++;
//				System.out.println((char)('A'+i));
			}

		for (int i = 0; i < 26; i++)
			if (isAcorn[i] && adjList[i].size() == 0 && included[i])
				acorns++;

		print();
	}

	static void print() {
		pw.printf("There are %d tree(s) and %d acorn(s).\n", trees, acorns);
	}

	public static void main(String[] args) throws IOException {

		int tc = sc.nextInt();
		while (tc-- > 0) {
			initialize();
			while (true) {
				String s = sc.next();
				if (s.charAt(0) == '*')
					break;
				int x = s.charAt(1) - 'A', y = s.charAt(3) - 'A';
				adjList[x].add(y);
				adjList[y].add(x);
			}
			String s = sc.nextLine();
			for (int i = 0; i < s.length(); i += 2)
				included[(int) (s.charAt(i) - 'A')] = true;
			solve();

		}
		pw.flush();
		pw.close();
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
			return br.ready() || st.hasMoreTokens();
		}

	}

}

