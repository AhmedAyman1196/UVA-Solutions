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

	// idea : vertices are the floors , edges are the time taken to go from one
	// floor to the other
	// if time = 0 then its impossible else there is an elevator that takes some
	// time to that floor
	// use the one with minimum time (dijkstra)

	public static void main(String[] args) throws IOException {
		// ~~~~~~~~~~~~~~~ Main Method ~~~~~~~~~~~~~~~~~~
		int n = sc.nextInt();
		while (true) {
			int target = sc.nextInt();
			int time[] = new int[n]; // n elevators
			for (int i = 0; i < n; i++)
				time[i] = sc.nextInt(); // time to move between adjacent floors

			ArrayList<Edge> edgeList[] = new ArrayList[101];
			for (int i = 0; i < 101; i++)
				edgeList[i] = new ArrayList<>();

			for (int elevator = 0; elevator < n; elevator++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
				int size = st.countTokens();
				int x[] = new int[size];
				for (int j = 0; j < size; j++)
					x[j] = Integer.parseInt(st.nextToken());

				for (int i = 0; i < size; i++) {
					for (int j = i + 1; j < size; j++) {
						int timeTaken = time[elevator] * Math.abs(x[i] - x[j]);
						edgeList[x[i]].add(new Edge(x[j], timeTaken, elevator));
						edgeList[x[j]].add(new Edge(x[i], timeTaken, elevator));
					}
				}
			}

			// Dijkstra
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			int dist[] = new int[101];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[0] = 0;

			pq.add(new Pair(0, 0, -1)); // -1 is only for first floor , cost = 0
			while (!pq.isEmpty()) {
				Pair p = pq.poll();
				if (p.distance <= dist[p.vertex])
					for (Edge e : edgeList[p.vertex]) {
						int e1 = p.lastElevator, e2 = e.elevator;
						int nextelev = 0;
						int extra = 0;
						if (e1 == -1) {
							extra = 0;
							nextelev = e2;
						} else if (e1 != e2) {
							extra = 60;
							nextelev = e2;
						}else {
							extra = 0 ; 
							nextelev = e2 ;
						}
						if (dist[e.to] > p.distance + e.time + extra) {
							dist[e.to] = p.distance + e.time + extra;
							pq.add(new Pair(e.to, dist[e.to], nextelev));
						}
					}
			}
			pw.println(dist[target] == Integer.MAX_VALUE ? "IMPOSSIBLE" : dist[target]);
			if (!sc.ready())
				break;
			n = sc.nextInt();
		}
		pw.flush();
	}

	static class Pair implements Comparable<Pair> {
		Integer distance, vertex, lastElevator;

		public Pair(int vertex, int distance, int lastElevator) {
			// TODO Auto-generated constructor stub
			this.vertex = vertex;
			this.distance = distance;
			this.lastElevator = lastElevator;
		}

		@Override
		public int compareTo(Pair p) {
			// TODO Auto-generated method stub
			return distance.compareTo(p.distance);
		}
	}

	static class Edge {
		int to, time, elevator;

		public Edge(int to, int time, int elevator) {
			// TODO Auto-generated constructor stub
			this.to = to;
			this.time = time;
			this.elevator = elevator;
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
