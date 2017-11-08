import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			HashSet<String> set = new HashSet<>();
			boolean found = false;
			PriorityQueue<String> pq = new PriorityQueue<>(); 
			for(int i = 0 ; i < n ; i ++)
				pq.add(sc.next());
			
			for (int i = 0; i < n; i++) {
				String x = pq.poll();
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < x.length()&&!found; j++) {
					sb.append(x.charAt(j));
					if(set.contains(sb.toString()))
						found = true;
				}
				set.add(x);
			}
			if (!found)
				pw.println("YES");
			else pw.println("NO");
		}
		pw.flush();
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

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public boolean isReady() throws IOException {
			return br.ready() || st.hasMoreElements();
		}
	}
}
