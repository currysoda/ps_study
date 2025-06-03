package tips;

// 소수(PrimeNumber) 찾기
public class PrimeNumber {
	
	/**
	 * 소수(PrimeNumber) 판별법
	 * 1 ~ N 까지 확인하기(O(n))
	 * 1 ~ k^2 에서 k 까지 확인하기(O(log n))
	 */
	public static void main(String[] args) {
		int N = 11;
		System.out.println("primeNumber(N) = " + primeNumber(N));
	}
	
	public static boolean primeNumber(int num) {
		if (num == 1) {
			return false;
		}
		boolean result = true;
		for (long l = 2L; l <= Math.sqrt(num); l++) {
			if ((num % l) == 0) {
				result = false;
			}
		}
		return result;
	}
}
