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
	static int n, m, x, y, color[], ans;
	static ArrayList<Integer> adjList[];
	static boolean visited[];

	public static void main(String args[]) throws IOException {
		int t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			adjList = new ArrayList[n];
			visited = new boolean[n];
			color = new int[n];
			for (int i = 0; i < n; i++)
				adjList[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				adjList[x].add(y);
				adjList[y].add(x);
			}
			boolean isBipartite = true;
			ans = 0;
			for (int i = 0; i < n && isBipartite; i++) {
				if (!visited[i]) {
					color[i] = 1; 
					x =1 ;
					y = 0;
					Queue<Integer> q = new LinkedList<>();
					q.add(i);
					while (!q.isEmpty() && isBipartite) {
						int u = q.poll();
						if (!visited[u]) {
							for (int j = 0; j < adjList[u].size(); j++) {
								int v = adjList[u].get(j);
								if (color[v] == 0){
									color[v] = (color[u] == 2) ? 1 : 2;
									if (color[v] == 1)
										x++;
									else
										y++;
									q.add(v);
								}
								else if (color[v] == color[u])
									isBipartite = false;
							}
						}
						visited[u] = true;
					}
					ans += Math.max(1 ,Math.min(x, y));
				}
			}
			pw.println(isBipartite ? ans : -1);
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
