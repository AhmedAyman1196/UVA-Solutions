import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	// without Scanner Class TLE 
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Integer t = sc.nextInt(), n, m, ans;
		HashMap<Integer, Integer> map;
		while (t-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			ans = 0;
			map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				if (!map.containsKey(x))
					map.put(x, 1);
				else
					map.put(x, map.get(x) + 1);
			}
			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				if (!map.containsKey(x))
					map.put(x, -1);
				else
					map.put(x, map.get(x) - 1);
			}
			Iterator it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				int occ = (int) pair.getValue();
					ans += Math.abs(occ);
				it.remove();
			}
			
			System.out.println(ans);
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

