import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, t = 1;
	static ArrayList<Integer> adjList[], ans;
	static TreeMap<String, Integer> map1;
	static TreeMap<Integer, String> map2;

	static void initialize() throws IOException {
		map1 = new TreeMap<>();
		map2 = new TreeMap<>();
		adjList = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();
		ans = new ArrayList<>();
		// input
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			map1.put(s, i);
			map2.put(i, s);
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int x = map1.get(sc.next()), y = map1.get(sc.next());
			adjList[x].add(y);
			adjList[y].add(x);
		}
	}

	static void solve() {
		for (int i = 0; i < n; i++)
			if (count(i) > count(200))
				ans.add(i);
	}

	static int count(int without) {
		int ans = 0 ;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[] = new boolean[n] ;
		for(int i = 0 ; i < n ; i ++){
			if(!visited[i]&&i!=without){
				q.add(i);
				visited[i] = true ;
				while(!q.isEmpty()){
					int x = q.poll() ;
					visited[x] = true ;
					for(int j = 0 ; j < adjList[x].size() ; j++)
					{
						int y = adjList[x].get(j);
						if(!visited[y]&&y!=without)
							q.add(y);
					}
				}
				ans++ ;
			}
		}
		return ans;
	}

	static void print() {
		TreeSet<String> tmp = new TreeSet<>();
		for (int i = 0; i < ans.size(); i++)
			tmp.add(map2.get(ans.get(i)));

		System.out.printf("City map #%d: %d camera(s) found\n", t++, tmp.size());
		for (String i : tmp)
			System.out.println(i);
	}

	public static void main(String[] args) throws IOException {
		n = sc.nextInt();
		while (true) {
			initialize();
			solve();
			print();
			n = sc.nextInt();
			if(n==0)break ;
			System.out.println();
		}
	}
}
