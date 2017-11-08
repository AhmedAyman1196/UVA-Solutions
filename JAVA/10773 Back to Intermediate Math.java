import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double d = Double.parseDouble(st.nextToken());
			double v = Double.parseDouble(st.nextToken());
			double u = Double.parseDouble(st.nextToken());
			if (v == 0 || u == 0 || u <= v) {
				pw.println("Case " + i + ": can't determine");
				continue;
			}
			double fast = d / u;
			double shorty = d / Math.sqrt(u * u - v * v);
			pw.print("Case " + i + ": ");
			pw.printf("%.3f\n", Math.abs(fast - shorty));
		}
		pw.flush();
	}

}

