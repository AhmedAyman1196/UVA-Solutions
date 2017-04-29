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
		int n = sc.nextInt(), m = sc.nextInt(), target = sc.nextInt() - 1, start = sc.nextInt();
		while (!(n == 0 && m == 0 && target == -1 && start == 0)) {

			ArrayList<Edge> edgeList[] = new ArrayList[n];
			for (int i = 0; i < n; i++)
				edgeList[i] = new ArrayList<>();

			while (m-- > 0) {
				int c1 = sc.nextInt(), c2 = sc.nextInt(), cost = sc.nextInt();
				edgeList[c1].add(new Edge(c2, cost));
				edgeList[c2].add(new Edge(c1, cost));
			}
			
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			int dist[] = new int[n];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[start] = 0;
			pq.add(new Pair(start, 0));
			while (!pq.isEmpty()) {
				Pair p = pq.poll();
				if (p.distance <= dist[p.vertex])
					for (Edge e : edgeList[p.vertex]) { 
						if(p.vertex<=target && e.to == p.vertex+1 && dist[e.to] > p.distance + e.cost){
							dist[e.to] = p.distance + e.cost;
							pq.add(new Pair(e.to, dist[e.to]));
						}
						else if (p.vertex>target &&dist[e.to] > p.distance + e.cost) {
							dist[e.to] = p.distance + e.cost;
							pq.add(new Pair(e.to, dist[e.to]));
						}
					}
			}
			pw.println(dist[target]);
			n =sc.nextInt() ;
			m =sc.nextInt() ;
			target = sc.nextInt()-1 ;
			start =sc.nextInt() ;
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
