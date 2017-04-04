import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static ArrayList<Integer> adjList[];
	static int counter, dfs_num[], dfs_low[] , t;
	static boolean[] visited;
	static Stack<Integer> stack;
	static TreeMap<String , Integer> map  ;
	static String[] name ;
	static PrintWriter pw = new PrintWriter(System.out) ;

	static void solve() // O(V + E)
	{
		dfs_num = new int[n];
		dfs_low = new int[n];
		counter = 0;
		visited = new boolean[n];
		stack = new Stack<>();

		for (int i = 0; i < n; ++i)
			if (dfs_num[i] == 0)
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
			while (true) {
				int v = stack.pop();
				//Ben, Alexander, Dolly, Benedict
				visited[v] = true;
				if (v == u){
					pw.print(name[v]);
					break;
				}else 
				pw.print(name[v]+", ");
			}
			pw.println();
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
		// input
		name =  new String[n] ;
		map= new TreeMap<>() ;
		counter = 0;// used to map inputs
		for(int i =0 ; i < m ; i ++){
			String s1= sc.next()  ,s2 = sc.next() ;
			if(!map.containsKey(s1)){
				name[counter] = s1 ;
				map.put(s1, counter++);
			}
			if(!map.containsKey(s2)){
				name[counter] = s2;
				map.put(s2, counter++);
			}
			int x1 = map.get(s1) , x2 = map.get(s2);
			adjList[x1].add(x2) ;
		}
		
		return true;
	}

	static void print() {
		if(t!=0)System.out.println();
		System.out.printf("Calling circles for data set %d:\n" ,++t);
		pw.flush();
	}

	public static void main(String[] args) throws IOException {
		while (initialize()) {
			solve();
			print();
		}
	}

}

