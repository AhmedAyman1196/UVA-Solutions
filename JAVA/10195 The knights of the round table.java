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
	static final double INF = 1e9, eps = 1e-15;

	public static double dist(int x, int y, int a, int b) {
		return Math.sqrt((long) (x - a) * (x - a) + (long) (y - b) * (y - b));
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		while (true) {

			double a = sc.nextDouble(), b = sc.nextDouble(), c = sc
					.nextDouble();
			if (a == 0 && b == 0 && c == 0) {
				pw.printf("The radius of the round table is: 0.000\n");
			} else {
				double p = (a + b + c) / 2;
				double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
				pw.printf("The radius of the round table is: %.3f\n", 2 * area
						/ (a + b + c));
			}
			if (!sc.ready())
				break;
		}

		pw.flush();
		pw.close();
	}
}

// ----------------Vector---------------------------
class Vector {

	double x, y;

	Vector(double a, double b) {
		x = a;
		y = b;
	}

	Vector(Point a, Point b) {
		this(b.x - a.x, b.y - a.y);
	}

	Vector scale(double s) {
		return new Vector(x * s, y * s);
	} // s is a non-negative value

	double dot(Vector v) {
		return (x * v.x + y * v.y);
	}

	double cross(Vector v) {
		return x * v.y - y * v.x;
	}

	double norm2() {
		return x * x + y * y;
	}

	Vector reverse() {
		return new Vector(-x, -y);
	}

	Vector normalize() {
		double d = Math.sqrt(norm2());
		return scale(1 / d);
	}
}

// ------------point--------------------------------
class Point implements Comparable<Point> {

	static final double EPS = 1e-9;

	double x, y;

	Point(double a, double b) {
		x = a;
		y = b;
	}

	public int compareTo(Point p) {
		if (Math.abs(x - p.x) > EPS)
			return x > p.x ? 1 : -1;
		if (Math.abs(y - p.y) > EPS)
			return y > p.y ? 1 : -1;
		return 0;
	}

	public double dist(Point p) {
		return Math.sqrt(sq(x - p.x) + sq(y - p.y));
	}

	static double sq(double x) {
		return x * x;
	}

	Point rotate(double angle) {
		double c = Math.cos(angle), s = Math.sin(angle);
		return new Point(x * c - y * s, x * s + y * c);
	}

	// for integer points and rotation by 90 (counterclockwise) : swap x and y,
	// negate x

	Point rotate(double theta, Point p) // rotate around p
	{
		Vector v = new Vector(p, new Point(0, 0));
		return translate(v).rotate(theta).translate(v.reverse());
	}

	Point translate(Vector v) {
		return new Point(x + v.x, y + v.y);
	}

	Point reflectionPoint(Line l) // reflection point of p on line l
	{
		Point p = l.closestPoint(this);
		Vector v = new Vector(this, p);
		return this.translate(v).translate(v);
	}

	boolean between(Point p, Point q) {
		return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
				&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
	}

	// returns true if it is on the line defined by a and b
	boolean onLine(Point a, Point b) {
		if (a.compareTo(b) == 0)
			return compareTo(a) == 0;
		return Math.abs(new Vector(a, b).cross(new Vector(a, this))) < EPS;
	}

	boolean onSegment(Point a, Point b) {
		if (a.compareTo(b) == 0)
			return compareTo(a) == 0;
		return onRay(a, b) && onRay(b, a);
	}

	// returns true if it is on the ray whose start point is a and passes
	// through b
	boolean onRay(Point a, Point b) {
		if (a.compareTo(b) == 0)
			return compareTo(a) == 0;
		return new Vector(a, b).normalize().equals(
				new Vector(a, this).normalize());
	}

	// returns true if it is on the left side of Line pq
	// add EPS to LHS if on-line points are accepted
	static boolean ccw(Point p, Point q, Point r) {
		return new Vector(p, q).cross(new Vector(p, r)) > 0;
	}

	static boolean collinear(Point p, Point q, Point r) {
		return Math.abs(new Vector(p, q).cross(new Vector(p, r))) < EPS;
	}

	static double angle(Point a, Point o, Point b) // angle AOB
	{
		Vector oa = new Vector(o, a), ob = new Vector(o, b);
		return Math.acos(oa.dot(ob) / Math.sqrt(oa.norm2() * ob.norm2()));
	}

	static double distToLine(Point p, Point a, Point b) // distance between
														// point p and a line
														// defined by points a,
														// b (a != b)
	{
		if (a.compareTo(b) == 0)
			p.dist(a);
		// formula: c = a + u * ab
		Vector ap = new Vector(a, p), ab = new Vector(a, b);
		double u = ap.dot(ab) / ab.norm2();
		Point c = a.translate(ab.scale(u));
		return p.dist(c);
	}

	// Another way: find closest point and calculate the distance between it and
	// p

	static double distToLineSegment(Point p, Point a, Point b) {
		Vector ap = new Vector(a, p), ab = new Vector(a, b);
		double u = ap.dot(ab) / ab.norm2();
		if (u < 0.0)
			return p.dist(a);
		if (u > 1.0)
			return p.dist(b);
		return distToLine(p, a, b);
	}
	// Another way: find closest point and calculate the distance between it and
	// p
}

// -----------Line Segment---------------------------
class LineSegment {

	Point p, q;

	LineSegment(Point a, Point b) {
		p = a;
		q = b;
	}

	boolean intersect(LineSegment ls) {
		Line l1 = new Line(p, q), l2 = new Line(ls.p, ls.q);
		if (l1.parallel(l2)) {
			if (l1.same(l2))
				return p.between(ls.p, ls.q) || q.between(ls.p, ls.q)
						|| ls.p.between(p, q) || ls.q.between(p, q);
			return false;
		}
		Point c = l1.intersect(l2);
		return c.between(p, q) && c.between(ls.p, ls.q);
	}

}

// -----------------Straight Line-------------------
class Line {

	static final double INF = 1e9, EPS = 1e-9;

	double a, b, c;

	Line(Point p, Point q) {
		if (Math.abs(p.x - q.x) < EPS) {
			a = 1;
			b = 0;
			c = -p.x;
		} else {
			a = (p.y - q.y) / (q.x - p.x);
			b = 1.0;
			c = -(a * p.x + p.y);
		}

	}

	Line(Point p, double m) {
		a = -m;
		b = 1;
		c = -(a * p.x + p.y);
	}

	boolean parallel(Line l) {
		return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS;
	}

	boolean same(Line l) {
		return parallel(l) && Math.abs(c - l.c) < EPS;
	}

	Point intersect(Line l) {
		if (parallel(l))
			return null;
		double x = (b * l.c - c * l.b) / (a * l.b - b * l.a);
		double y;
		if (Math.abs(b) < EPS)
			y = -l.a * x - l.c;
		else
			y = -a * x - c;

		return new Point(x, y);
	}

	Point closestPoint(Point p) {
		if (Math.abs(b) < EPS)
			return new Point(-c, p.y);
		if (Math.abs(a) < EPS)
			return new Point(p.x, -c);
		return intersect(new Line(p, 1 / a));
	}

}

// ---------------------------------------

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