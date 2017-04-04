import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// ~~~~~~~~~~~~~~~ Main Method ~~~~~~~~~~~~~~~~~~
		int c = sc.nextInt();
		while (c-- > 0) {
			int n = sc.nextInt(), m = sc.nextInt();// n starts(vertices) , m
													// wormholes(edges)
			ArrayList<Edge>[] edgeList = new ArrayList[n];
			for (int i = 0; i < n; i++)
				edgeList[i] = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				int from = sc.nextInt(), to = sc.nextInt(), time = sc.nextInt();
				edgeList[from].add(new Edge(to, time));
			}

			// idea : run bellman , then pass on everynode , if u can relax then
			// u have a negatice cycle
			int Time[] = new int[n]; // store the ans in
			Arrays.fill(Time, Integer.MAX_VALUE / 2);
			Time[0] = 0;
			for (int i = 0; i < n-1; i++) // pass v-1 times
				for (int u = 0; u < n; u++) // pass on every node
					for (Edge e : edgeList[u]) {// pass on every neighbour
						int time = e.time;
						Time[e.to] = Math.min(Time[e.to], Time[u] + time);
					}
			
			boolean ans = false;
			for (int u = 0; u < n && !ans; u++) // pass on every node
				for (Edge e : edgeList[u]) {// pass on every neighbour
					int time = e.time;
					if(Time[e.to]>Time[u]+time){
						ans = true ; 
						break ;
					}
				}
			pw.println(ans? "possible" : "not possible");
		}
		pw.flush();
	}

	static class Edge {
		int to, time;

		public Edge(int to, int time) {
			// TODO Auto-generated constructor stub
			this.to = to;
			this.time = time;
		}

	}

}
