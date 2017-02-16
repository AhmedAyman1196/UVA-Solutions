import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {

	// shayfak yala ya yasser yala
	// :P

	public static double distance(double x, double y) {
		return Math.sqrt(x * x + y * y);
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		// int n = sc.nextInt(), m = sc.nextInt();
		// ArrayList<marker> markers = new ArrayList<marker>();
		// for (int i = 0; i < n; i++)
		// markers.add(new marker(sc.nextInt(), sc.nextInt()));
		// ArrayList<marker> caps = new ArrayList<marker>();
		// for (int i = 0; i < n; i++)
		// caps.add(new marker(sc.nextInt(), sc.nextInt()));
		// Collections.sort(markers);
		// Collections.sort(caps);
		// int beauty = 0;
		// int remain = 0;
		//
		// boolean takenmarker[] = new boolean[n];
		// boolean takencap[] = new boolean[m];
		// int markeridx = 0;
		// int capidex = 0;
		// for (int i = 0; i < n; i++) {
		// marker curr = markers.get(i);
		// for (int j = capidex; j < n; j++) {
		// marker currcap = caps.get(j);
		// if (curr.equals(currcap) && !takencap[j]) {
		// takencap[j] = true;
		// takenmarker[i] = true;
		// beauty++;
		// break ;
		// }
		// }
		//
		// }
		// for (int i = 0; i < n; i++) {
		// if (!takenmarker[i]) {
		// marker curr = markers.get(i);
		// for (int j = 0; j < n; j++) {
		// marker currcap = caps.get(j);
		// if (curr.y == currcap.y && !takencap[j]) {
		// takencap[j] = true;
		// takenmarker[i] = true;
		// remain++;
		// break ;
		// }
		// }
		//
		// }
		// }
		//
		// pw.println( (remain + beauty)+" "+beauty );
		//
		// int na = sc.nextInt(), nb = sc.nextInt(), k = sc.nextInt(), m = sc
		// .nextInt();
		// int a[] = new int[na];
		// int b[] = new int[nb];
		// for (int i = 0; i < na; i++)
		// a[i] = sc.nextInt();
		// for(int i = 0 ; i <nb ; i++){
		// b[i] = sc.nextInt() ;
		// }
		// Arrays.sort(b);
		// int t = b[nb-m] ;
		// for(int i = 0 ; i < na ; i++){
		// if(a[i]<t)k-- ;
		// }
		// if(k<=0)pw.println("YES");
		// else pw.println("NO") ;
		//

		double angle = 0.7071067812, x, y;
		int counter = 0;
		while (true) {
			
			int index = 0;
			String s = sc.nextLine();
			if (s.equals("END"))
				break;
			x = 0;
			y = 0;
			boolean finish = false ;
			while (true) {
				StringBuilder num = new StringBuilder();
				StringBuilder dir = new StringBuilder();
				for (int i = index; i < s.length(); i++) {
					index++;
					if(s.charAt(i)=='.'){
						finish  =true ;
						break ;
					}
					if (s.charAt(i) == ',' )
						break;
					if (Character.isDigit(s.charAt(i)))
						num.append(s.charAt(i));
					else
						dir.append(s.charAt(i));
					
				}


				
				
				double mag = Double.parseDouble(num.toString());
				String curr = dir.toString();

				switch (curr) {
				case "N":
					y += mag;
					break;
				case "S":
					y -= mag;
					break;
				case "E":
					x += mag;
					break;
				case "W":
					x -= mag;
					break;
				case "NE":
					x += mag * angle;
					y += mag * angle;
					break;
				case "NW":
					x -= mag * angle;
					y += mag * angle;
					break;
				case "SE":
					x += mag * angle;
					y -= mag * angle;
					break;
				case "SW":
					x -= mag * angle;
					y -= mag * angle;
					break;
				}
				
				if (finish) {
					// output
					counter++;
					pw.printf("Map #%d\n", counter);
					pw.printf("The treasure is located at (%.3f,%.3f).\n", x, y);
					pw.printf("The distance to the treasure is %.3f.\n\n",
							(distance(x, y) * 1000) / 1000);
					
					break;
				}
			}

		}

		pw.flush();
		pw.close();
	}
}

class lab implements Comparable<lab> {
	public int x, y;

	public lab(int x1, int y1) {
		x = x1;
		y = y1;

	}

	@Override
	public int compareTo(lab o) {
		if (x == o.x && y == o.y)
			return 0;
		if (x > o.x)
			return 1;

		return -1;

	}

}

class Triple {
	long x, y, z;

	public Triple(long a, long b, long c) {
		x = a;
		y = b;
		z = c;
	}
}

class Pair implements Comparable<Pair> {
	int first;
	int second;

	Pair(int f, int s) {
		first = f;
		second = s;
	}

	public void add() {
		second++;
	}

	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return (first > second) ? 1 : first < second ? -1 : 0;
	}

}

class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s) {
		br = new BufferedReader(new InputStreamReader(s));
	}

	public Scanner(FileReader f) {
		br = new BufferedReader(f);
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