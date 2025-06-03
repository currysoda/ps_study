package tips;

// 최대공약수와 최소공배수 구하기
public class Gcd {
	
	/**
	 * GCD = Greatest Common Divisor 최대공약수
	 * LCM = Least Common Multiple 최소공배수
	 * 두 자연수 A, B(A >= B) 에서 A * B == (A와 B의 최대공약수) * (A와 B의 최소공배수) 가 성립한다.
	 * A = B * q + r 일때, GCD(A, B) = GCD(B, r) 이 성립한다.
	 * 이를 재귀적 반복을 통해 GCD(r', 0) 일 때,
	 * GCD(A, B) = r' 이다.
	 */
	public static void main(String[] args) {
		
		int a = 15;
		int b = 25;
		
		int gcd = gcd(a, b);
		int lcm = (a * b) / gcd;
		System.out.println("gcd = " + gcd); // gcd = 5
		System.out.println("lcm = " + lcm); // lcm = 75
	}
	
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		else {
			return gcd(b, a % b);
		}
	}
}
