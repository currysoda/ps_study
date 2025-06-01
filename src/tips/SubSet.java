package tips;

public class SubSet {
	
	public static void main(String[] args) {
		
		// 모든 부분 집합 경우의 수 구하기 (비트 마스킹 방법)
		int[] arr = {1, 2, 3};
		int   n   = arr.length;
		
		// 부분 집합의 총 갯수는 2^n 개 이다.
		// i = 부분 집합의 총 갯수
		for (int i = 0; i < (1 << n); i++) {
			int           temp = i;
			StringBuilder sb   = new StringBuilder();
			// 비트 마스킹 방법으로 부분 집합 경우의 수는 부분 집합의 경우의 수와 1과 비트 비교 연산으로 계산한다.
			// j = 집합 원소 갯수
			for (int j = 0; j < n; j++) {
				// 2진수의 끝자리와 1과 AND 비트 비교해서 1이면 포함 0이면 포함하지 않는다.
				if ((temp & 1) == 1) {
					sb.append(arr[j]).append(" ");
				}
				// 계속 끝자리 비교를 위해 temp를 오른쪽으로 한칸 밀어준다.
				temp = temp >> 1;
			}
			System.out.println("sb.toString() = " + sb.toString());
		}
		
		
	}
}
