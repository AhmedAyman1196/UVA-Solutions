import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		while (true) {
			long n1 = sc.nextLong(), n2 = sc.nextLong();
			pw.println(Math.max(n2 ,  n1) - Math.min(n2, n1) );
			if (!sc.hasNext())
				break;
		}
		pw.flush();
	}

}

