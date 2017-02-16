import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
	static int a[][];
	static long value;
	static ArrayList<Integer> ans;
	static HashMap<Integer, pair> map;

	public static void main(String[] args) throws IOException {
		int t = sc.nextInt();
		map = new HashMap<>();
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				map.put(5 * i + j, new pair(i, j));

		while (t-- > 0) {
			int n = sc.nextInt();
			a = new int[5][5];
			for (int i = 0; i < n; i++)
				a[sc.nextInt()][sc.nextInt()] = sc.nextInt();

			int min = Integer.MAX_VALUE;
			ArrayList<Integer> ans = new ArrayList<>() ;
			for (int i1 = 0; i1 < 25; i1++)
				for (int i2 = i1+1; i2 < 25; i2++)
					for (int i3 = i2+1; i3 < 25; i3++)
						for (int i4 = i3+1; i4 < 25; i4++)
							for (int i5 = i4+1; i5 < 25; i5++) {
								pair p1 = map.get(i1), p2 = map.get(i2), p3 = map.get(i3), p4 = map.get(i4),
										p5 = map.get(i5);
								int sum = 0;
								for (int i = 0; i < 5; i++)
									for (int j = 0; j < 5; j++) {
										if (a[i][j] != 0) {
											int tmp[] = new int[5];
											tmp[0] = (Math.abs(p1.i - i) + Math.abs(p1.j - j)) * a[i][j];
											tmp[1] = (Math.abs(p2.i - i) + Math.abs(p2.j - j)) * a[i][j];
											tmp[2] = (Math.abs(p3.i - i) + Math.abs(p3.j - j)) * a[i][j];
											tmp[3] = (Math.abs(p4.i - i) + Math.abs(p4.j - j)) * a[i][j];
											tmp[4] = (Math.abs(p5.i - i) + Math.abs(p5.j - j)) * a[i][j];
											Arrays.sort(tmp);
											sum += tmp[0];
										}
									}
									if(sum<min){
										min =sum ;
										ans.clear();
										ans.add(i1);
										ans.add(i2);
										ans.add(i3) ;
										ans.add(i4) ;
										ans.add(i5) ;
									}
							}

			for (int i = 0; i < 5; i++) {
				if (i == 4)
					pw.println(ans.get(i));
				else
					pw.print(ans.get(i) + " ");
			}
		}
		pw.flush();
		pw.close();
	}

	static class pair implements Comparable<pair> {
		int i, j;

		public pair(int x, int y) {
			i = x;
			j = y;
		}

		@Override
		public int compareTo(pair o) {
			if (i == o.i && j == o.j)
				return 0;
			return 1;
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

