import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static double EPS = 1e-9;
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);
	static int xstart, ystart, n;
	static ArrayList<pair> points;
	static ArrayList<Integer> adjlist[];
	static pair tmp;
	static int counter;
	static boolean visited[];

	static ArrayList<Integer> getClosest(int i) {
		ArrayList<Integer> r = new ArrayList<>();
		ArrayList<pair> ans = new ArrayList<>();

		tmp = points.get(i);

		for (int j = 0; j < points.size(); j++) {
			if (j != i) {
				ans.add(points.get(j));
				Collections.sort(ans);
				if (ans.size() > 2)
					ans.remove(2);
			}
		}
		for (int j = 0; j < 2 && j < ans.size(); j++)
			r.add(ans.get(j).idx);
		// System.out.println(tmp.f+" "+tmp.s+" "+ans.get(0).f+"
		// "+ans.get(0).s+" "+ans.get(1).f+" "+ans.get(1).s);
		return r;
	}

	static void dfs(int u) {
		if (visited[u])
			return;
		counter++;
		visited[u] = true;
		// System.out.println(u + " " + adjlist[u].get(0) + " " +
		// adjlist[u].get(1));
		for(int i = 0 ; i<adjlist[u].size() ; i++)
		dfs(adjlist[u].get(i));
	}

	public static void main(String args[]) throws IOException {
		n = sc.nextInt();
		while (n != 0) {

			xstart = sc.nextInt();
			ystart = sc.nextInt();
			points = new ArrayList<>();
			points.add(new pair(xstart, ystart, 0));
			for (int i = 1; i < n; i++)
				points.add(new pair(sc.nextInt(), sc.nextInt(), i));

			adjlist = new ArrayList[n];

			for (int i = 0; i < n; i++)
				adjlist[i] = getClosest(i);

			visited = new boolean[n];
			counter = 0;
			dfs(0);
			if (counter == n) {
				pw.println("All stations are reachable.");
			} else
				pw.println("There are stations that are unreachable.");
			n = sc.nextInt();
		}
		pw.flush();
		pw.close();
	}

	static class pair implements Comparable<pair> {
		int f, s, idx;

		public pair(int f, int s, int idx) {
			this.f = f;
			this.s = s;
			this.idx = idx;

		}

		@Override
		public boolean equals(Object other) {
			pair x = (pair) other;
			if (x.f == f && x.s == s)
				return true;
			return false;
		}

		@Override
		public int compareTo(pair p) {
			// TODO Auto-generated method stub
			int x = tmp.f, y = tmp.s;
			double d1 = (p.f - x) * (p.f - x) + (p.s - y) * (p.s - y); // p
			double d2 = (f - x) * (f - x) + (s - y) * (s - y); // this

			if (Math.abs(d1 - d2) < EPS) {
				if (p.f == f) {
					if (p.s == s)
						return 0;
					else if (p.s > s)
						return -1;
					else
						return 1;
				} else if (p.f > f)
					return -1;
				else
					return 1;
			} else if (d1 > d2)
				return -1;
			else
				return 1;

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
