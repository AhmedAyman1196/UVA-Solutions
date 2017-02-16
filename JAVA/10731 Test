package graphs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

// 10731 Test
public class StronglyCC {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static ArrayList<Integer> adjList[];
	static int counter, SCC, dfs_num[], dfs_low[];
	static boolean[] visited, exist;
	static Stack<Integer> stack;
	static ArrayList<String> ans;

	static void solve() // O(V + E)
	{
		dfs_num = new int[26];
		dfs_low = new int[26];
		counter = SCC = 0;
		visited = new boolean[26];
		stack = new Stack<>();
		ans = new ArrayList<>();
		for (int i = 0; i < 26; ++i)
			if (dfs_num[i] == 0 && exist[i])
				tarjanSCC(i);
	}

	static void tarjanSCC(int u) {
		dfs_num[u] = dfs_low[u] = ++counter;
		stack.push(u);

		for (int v : adjList[u]) {
			if (dfs_num[v] == 0)
				tarjanSCC(v);
			if (!visited[v])
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
		}
		if (dfs_num[u] == dfs_low[u]) {
			// SCC found
			ArrayList<String> tmp = new ArrayList<>();
			while (true) {
				int v = stack.pop();
				tmp.add((char) (v + 'A') + "");
				visited[v] = true;
				if (v == u)
					break;
			}
			Collections.sort(tmp);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < tmp.size() - 1; i++)
				sb.append(tmp.get(i) + " ");

			sb.append(tmp.get(tmp.size() - 1));
			ans.add(sb.toString());
			SCC++;
		}

	}

	public static void main(String[] args) throws IOException {
		n = sc.nextInt();
		while (true) {

			adjList = new ArrayList[26];
			exist = new boolean[26];
			for (int i = 0; i < 26; i++)
				adjList[i] = new ArrayList<>();
			// input
			for (int i = 0; i < n; i++) {
				int x[] = new int[5];
				for (int j = 0; j < 5; j++) {
					String s = sc.next();
					x[j] = s.charAt(0) - 'A';
					exist[x[j]] = true;
				}
				int choice = sc.next().charAt(0) - 'A';
				for (int j = 0; j < 5; j++)
					if (x[j] != choice)
						adjList[choice].add(x[j]);
			}
			solve();
			Collections.sort(ans);
			for (String s : ans)
				System.out.println(s);
			n = sc.nextInt();
			if (n == 0)
				break;
			System.out.println();
		}
	}

}

