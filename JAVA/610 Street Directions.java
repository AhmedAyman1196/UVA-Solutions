import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Integer> adjList[];
	static int n, m, num[], low[], parent[];
	static int counter, root, rootchild, t = 1;
	static boolean ans[][];

	static void solve() {
		for (int i = 0; i < n; ++i)
			if (num[i] == 0) {
				root = i;
				rootchild = 0;
				ABS(i);
			}
	}

	static void ABS(int u) { // Articulation Bridge Search
		low[u] = num[u] = counter++;
		for (int i = 0; i < adjList[u].size(); i++) {
			int v = adjList[u].get(i);
			if (num[v] == 0) {
				parent[v] = u;
				if (u == root)
					rootchild++;
				ABS(v);

				if (low[v] > num[u]) {
					ans[u][v] = true;
					ans[v][u] = true;
					// System.out.println("Bridge between " + (u + 1) + " and "+
					// (v + 1));
				} else if (!ans[v][u])
					ans[u][v] = true;

				low[u] = Math.min(low[u], low[v]);
			} else if (v != parent[u]) {
				low[u] = Math.min(low[u], num[v]);
				if (!ans[v][u])
					ans[u][v] = true;
			}

		}
	}

	static void initialize() {
		adjList = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();

		num = new int[n];
		low = new int[n];
		parent = new int[n];
		counter = 1;
		root = 0;
		rootchild = 0;
		ans = new boolean[n][n]; // n >= 10^3
		while (m-- > 0) {
			int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
			adjList[x].add(y);
			adjList[y].add(x);
		}
	}

	static void print() {
		System.out.println(t++);
		System.out.println();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (ans[i][j])
					System.out.println(i + 1 + " " + (j + 1));
		System.out.println("#");
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		while (!(n == 0 && m == 0)) {
			initialize();
			solve();
			print();
			n = sc.nextInt();
			m = sc.nextInt();
		}
	}

	static class pair implements Comparable<pair> {
		int x1, x2;

		public pair(int x11, int x22) {
			x1 = x11;
			x2 = x22;
		}

		@Override
		public int compareTo(pair p) {
			// TODO Auto-generated method stub
			if (x1 == p.x1 && x2 == p.x2)
				return 0;
			else
				return -1;

		}
	}
}
