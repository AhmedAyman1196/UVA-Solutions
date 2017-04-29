import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// ~~~~~~~~~~~~~~~ Main Method ~~~~~~~~~~~~~~~~~~
		int start = sc.nextInt(), target = sc.nextInt(), n = sc.nextInt(), tc = 1;
		while (!(start == 0 && target == 0 && n == 0)) {
			int button[] = new int[n];
			for (int i = 0; i < n; i++)
				button[i] = sc.nextInt();

			// bfs
			boolean visited[] = new boolean[10000];
			int dist[] = new int[10000];
			Queue<Integer> q = new LinkedList<Integer>();
			boolean found = false;
			q.add(start);
			while (!q.isEmpty() && !found) {
				int curr = q.poll();
				if(curr == target)
					found  = true ;
				for (int i = 0; i < n ; i++) {
					int x = (curr + button[i]) % 10000; // least significant 4 digits
					if (!visited[x]){
						q.add(x);
						dist[x] = dist[curr] + 1 ;
						visited[x] = true ;
					}
				}
			}
			if (!found)
				pw.printf("Case %d: Permanently Locked\n", tc++);
			else
				pw.printf("Case %d: %d\n", tc++, dist[target]);
			// next input
			start = sc.nextInt();
			target = sc.nextInt();
			n = sc.nextInt();
		}
		pw.flush();
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
