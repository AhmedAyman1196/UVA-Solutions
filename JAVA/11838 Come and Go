import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main { // first SCC question 
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static ArrayList<Integer> adjList[];
	static int  counter, SCC, dfs_num[], dfs_low[];
	static boolean[] visited;
	static Stack<Integer> stack;
	
	static void solve()	 	//O(V + E)
	{
		dfs_num = new int[n] ;
		dfs_low = new int[n] ;
		counter = SCC =0 ; 
		visited = new boolean[n] ;
		stack = new Stack<>() ;
		
		for(int i = 0; i < n; ++i)
			if(dfs_num[i] == 0)
				tarjanSCC(i);
	}
	
	static void tarjanSCC(int u)
	{
		dfs_num[u] = dfs_low[u] = ++counter;
		stack.push(u);
		
		for(int v: adjList[u])
		{
			if(dfs_num[v] == 0)
				tarjanSCC(v);
			if(!visited[v])
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);	
		}
		if(dfs_num[u] == dfs_low[u])
		{
			//SCC found
			while(true)
			{
				int v = stack.pop();
				visited[v] = true;
				if(v == u)
					break;
			}
			SCC++;
		}
		
		
	}
	

	static boolean initialize() throws IOException {
		n = sc.nextInt();
		m = sc.nextInt();
		if (n == 0 && m == 0)
			return false;
		adjList = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();
		while (m-- > 0) { // input
			int x1 = sc.nextInt() - 1, x2 = sc.nextInt() - 1, x3 = sc.nextInt();
			adjList[x1].add(x2);
			if (x3 == 2)
				adjList[x2].add(x1);

		} // end of input

		return true;
	}

	static void print() {
		if (SCC == 1)
			System.out.println(1);
		else
			System.out.println(0);
	}

	public static void main(String[] args) throws IOException {
		while (initialize()) {
			solve();
			print();
		}
	}

}

