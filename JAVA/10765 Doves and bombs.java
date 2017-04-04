import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Integer> adjList[];
	static int n, m, num[], low[], parent[];
	static int counter; // to fill the num , inc after each insertion
	static int[] AP; // store in them the the articulation points
						// you can store know them with different
						// data structures

	// explored >> explored = back edge *** (main idea of this algorithm )
	// explored >> unvisited = tree edge (regular)
	// explored >> visited = forward edge (rare)

	static int root, rootchild; // where you first call the dfs and the number
								// of the root's children
								// because this is a special case that the
								// algorithm doesnt check

	static void solve() {
		for (int i = 0; i < n; ++i)
			if (num[i] == 0) {
				root = i;
				rootchild = 0;
				APS(i);
				if (rootchild <= 1) // special case
					AP[i] = 1 ;
				else AP[i] = rootchild ;
			}
	}

	static void APS(int u) { // Articulation Points Search
		low[u] = num[u] = counter++; // first step is to set the num = lowest u
										// can go to
		for (int i = 0; i < adjList[u].size(); i++) {
			int v = adjList[u].get(i);
			if (num[v] == 0) { // tree edge >>>>>> @1
				parent[v] = u;
				if (u == root)
					rootchild++;
				APS(v); // recursion

				if (low[v] >= num[u]) // this is an AP
					AP[u]++;

				// if (low[v] > num[u]) // in case of a Bridge
				// System.out.println("Bridge between " + u + " and " + v);

				low[u] = Math.min(low[u], low[v]);
				// decides the lowest verte that u can get to .(magic happens
				// here)
			} else if (v != parent[u]) // back edge >>>>>>> @2
				low[u] = Math.min(low[u], num[v]);
		}
	}

	public static void main(String[] args) {
		n = sc.nextInt() ;
		m = sc.nextInt();
		while (true) {
			adjList = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjList[i] = new ArrayList<>();
			int x = sc.nextInt() , y= sc.nextInt() ;
			
			while (!(x  == -1 && y  == -1)) {
				adjList[x].add(y);
				adjList[y].add(x);
				x = sc.nextInt() ;
				y = sc.nextInt();
			}
			num = new int[n];
			low = new int[n];
			parent = new int[n];
			root = 0;
			rootchild = 0;
			counter = 1;
			AP = new int[n];
			Arrays.fill(AP, 1);
			solve();			
			PriorityQueue<pair> pq = new PriorityQueue<>() ;
			for(int i = 0 ; i < n ; i ++)
				pq.add(new pair(i, AP[i])) ;
			for(int i = 0 ; i < m ; i ++){
				pair p = pq.poll() ;
				System.out.println(p.idx+" "+p.value);
			}
			n = sc.nextInt() ; 
			m = sc.nextInt();
			System.out.println();
			if(m==0&&n==0)break;
		}
		
	}
	static class pair implements Comparable<pair>{
		int idx , value ;
		public pair(int i , int v ){
			idx = i ; 
			value = v ;
		}
		@Override
		public int compareTo(pair p) {
			// TODO Auto-generated method stub
			if(p.value>value)return 1 ;
			else if(value>p.value)return -1;
			else{
				if(p.idx<idx)return 1 ;
				else if(idx<p.idx)return -1;
			}
			
			return 0;
		}
	}

}

