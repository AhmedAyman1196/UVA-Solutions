import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);
	static int n, x, y, color[];
	static ArrayList<Integer> adjList[];
	static boolean visited[];

	public static void main(String args[]) throws IOException {
		n = sc.nextInt();
		while (true) {
			adjList = new ArrayList[n];
			color = new int[n];
			visited = new boolean[n];
			for (int i = 0; i < n; i++)
				adjList[i] = new ArrayList<>();

			while (true) {
				x = sc.nextInt() - 1;
				y = sc.nextInt() - 1;
				if (x == -1 && y == -1)
					break;
				adjList[x].add(y);
				adjList[y].add(x);
			}

			Queue<Integer> q = new LinkedList<Integer>();
			boolean isBipartite = true;
			for (int j = 0; j < n; j++) {
				if (!visited[j])
					q.add(j);
				while (!q.isEmpty()) {
					int u = q.poll();
					for (int i = 0; i < adjList[u].size(); i++) {
						int v = adjList[u].get(i);
						if (!visited[v]) {
							if (color[v] == 0) {
								color[v] = color[u] == 1 ? 2 : 1;
								q.add(v);
							} else {
								if (color[v] == color[u]) {
									isBipartite = false;
								}
							}
						}
					}
					visited[u] = true;
				}
			}
			pw.println(isBipartite? "YES":"NO");
			n = sc.nextInt();
			if (n == 0)
				break;

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
