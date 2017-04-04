import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);
	// 10034	Freckles
	// basic MST Question 
	// Solved using Prim's Algorithm

	public static void main(String[] args) throws IOException {
		// ~~~~~~~~~~~~~~~ Main Method ~~~~~~~~~~~~~~~~~~
		int t = sc.nextInt()  ;
		while (t-- > 0) {
			// input 
			int n = sc.nextInt();
			Point[] point = new Point[n]; 
			for (int i = 0; i < n; i++) {
				double x = sc.nextDouble(), y = sc.nextDouble();
				point[i] = new Point(x, y);
			}

			// Prim's Algorithm
			double ans = 0; // min ink value
			boolean taken[] = new boolean[n];
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			taken[0] = true ;
			for(int i  =  1 ; i < n ;  i ++){
				// add all edges  out from 0 to all other points
				pq.add(new Edge(0, i, point[0], point[i])) ;
			}
		
			while(!pq.isEmpty()){
				Edge e = pq.poll() ;
				if(!taken[e.to]){ 
					taken[e.to] = true ;
					ans+= e.weight ; // add this edge to our answer
					for(int i = 0 ; i < n ; i ++){ // add all outgoing edges 
						if(i!=e.to&&!taken[i])
							pq.add(new Edge(e.to, i, point[e.to], point[i])) ;
					}
				}
			}
			pw.printf("%.2f\n" , ans);
			if(t>0) // printline after two consecutive cases
				pw.println();
		}

		pw.flush();
	}

	static class Point {
		double x, y;

		public Point(double x, double y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}

	}

	static class Edge implements Comparable<Edge> {
		int from, to;
		double weight;

		public Edge(int from, int to, Point p1, Point p2) {
			// TODO Auto-generated constructor stub
			this.from = from;
			this.to = to;
			weight = Math.sqrt(distance(p1, p2));

		}

		public double distance(Point p1, Point p2) {
			return ((p1.x - p2.x) * (p1.x - p2.x)) + ((p1.y - p2.y) * (p1.y - p2.y));
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			Double w1 = weight, w2 = o.weight;
			if (w1.compareTo(w2) != 0)
				return w1.compareTo(w2);
			Integer x1 = to, x2 = o.to;
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
