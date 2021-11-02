import java.lang.Math;

public class Maths {
	public static boolean is_prime(int num) {
		for (int i = 2; i < Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static double pow(double base, double exp) {
		double result = base;
		for (int i = 1; i < exp; i++) {
			result *= base;
		}
		return result;
	}

	public static void fibonacci(int n1, int n2, int itr) {
		int res;
		System.out.println(n1 + "\n" + n2);
		for (int i = 0; i < itr; i++) {
			res = n1 + n2;
			System.out.println(res);
			n1 = n2;
			n2 = res;
		}
	}

	public static double phi() {
		return (1 + Math.sqrt(5)) / 2;
	}

	public static double r2() {
		return Math.sqrt(2);
	}

	public static double e() {
		int res = 999999;
		return pow(1.0 + (1.0 / res), res) ;
	}

	public static double pi() {
		double area = 706.83835;
		double radius = 15.0;
		return area / pow(radius, 2);
	}
}
