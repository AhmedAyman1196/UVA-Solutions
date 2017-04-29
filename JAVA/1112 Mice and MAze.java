import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// ~~~~~~~~~~~~~~~ Main Method ~~~~~~~~~~~~~~~~~~
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int n = sc.nextInt(), exit = sc.nextInt() - 1, timer = sc.nextInt();
			int m = sc.nextInt(); // edges

			ArrayList<Edge> edgeList[] = new ArrayList[n];
			for (int i = 0; i < n; i++)
				edgeList[i] = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				int from = sc.nextInt() - 1, to = sc.nextInt() - 1, cost = sc.nextInt();
				edgeList[to].add(new Edge(from, cost)); // flipped the to and
														// from to run dijkstra
														// reversed
			}

			PriorityQueue<Pair> pq = new PriorityQueue<>();
			int dist[] = new int[n];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[exit] = 0;
			pq.add(new Pair(exit, 0)); // start from 0 (source)
			while (!pq.isEmpty()) {
				Pair p = pq.poll();
				if (p.distance <= dist[p.vertex]) // lazy deletion
					for (Edge e : edgeList[p.vertex]) { // pass on all
														// neighbours
						if (dist[e.to] > p.distance + e.cost) {
							dist[e.to] = p.distance + e.cost;
							pq.add(new Pair(e.to, dist[e.to]));
						}
					}
			}
			int ans = 0;
			for (int i = 0; i < n; i++) {
				if (dist[i] <= timer)
					ans++;
			}
			pw.println(ans);
			if (tc != 0)
				pw.println();
		}
		pw.flush();
	}

	static class Pair implements Comparable<Pair> {
		Integer distance, vertex;

		public Pair(int vertex, int distance) {
			// TODO Auto-generated constructor stub
			this.vertex = vertex;
			this.distance = distance;
		}

		@Override
		public int compareTo(Pair p) {
			// TODO Auto-generated method stub
			return distance.compareTo(p.distance);
		}
	}

	static class Edge {
		int to, cost;

		public Edge(int to, int cost) {
			// TODO Auto-generated constructor stub
			this.to = to;
			this.cost = cost;
		}
	}

	// static
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
