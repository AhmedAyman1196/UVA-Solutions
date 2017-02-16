import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Integer> adjList[];
	static int n, num[], low[], parent[], counter;
	static ArrayList<pair> AB;

	static void intitialize() throws IOException {
		n = sc.nextInt();
		adjList = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();
		for (int i = 0; i < n; i++) { // input
			int x = sc.nextInt();
			String s = sc.next();
//			System.out.println(s.substring(1 , s.length()-1)) ;
			int m = Integer.parseInt(s.substring(1, s.length() - 1));
			for (int j = 0; j < m; j++)
				adjList[x].add(sc.nextInt());
		}
		num = new int[n];
		low = new int[n];
		parent = new int[n];
		counter = 1;
		AB = new ArrayList<pair>();
	}

	static void solve() {
		for (int i = 0; i < n; ++i)
			if (num[i] == 0)
				APS(i);
	}

	static void APS(int u) {
		low[u] = num[u] = counter++;
		for (int i = 0; i < adjList[u].size(); i++) {
			int v = adjList[u].get(i);
			if (num[v] == 0) {
				parent[v] = u;
				APS(v);
				if (low[v] > num[u])
					AB.add(new pair(Math.min(u, v), Math.max(v, u)));// bridge
				low[u] = Math.min(low[u], low[v]);
			} else if (v != parent[u])
				low[u] = Math.min(low[u], num[v]);
		}
	}

	static void print() {
		Collections.sort(AB);
		System.out.printf("%d critical links\n", AB.size());
		for (int i = 0; i < AB.size(); i++)
			System.out.printf("%d - %d\n", AB.get(i).idx, AB.get(i).value);
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		while (true) {
			intitialize();
			solve();
			print();
			if (!sc.hasNext())
				break;
		}
	}

	static class pair implements Comparable<pair> {
		int idx, value;

		public pair(int i, int v) {
			idx = i;
			value = v;
		}

		@Override
		public int compareTo(pair p) {
			// TODO Auto-generated method stub
			if (p.idx < idx)
				return 1;
			else if (idx < p.idx)
				return -1;
			else {
				if (p.value < value)
					return 1;
				else if (value < p.value)
					return -1;
			}

			return 0;
		}
	}

}
