package tips;

import java.util.Arrays;

public class PascalTriangle {
	
	public static void main(String[] args) {
		
		int N = 30;
		
		// 파스칼의 삼각형을 저장하는 2차원 배열
		long[][] pascalTriangle = new long[N][N];
		
		// 0 을 넣어서 잘못된 접근임을 알려줌
		for (int i = 0; i < pascalTriangle.length; i++) {
			Arrays.fill(pascalTriangle[i], 0);
		}
		
		// 2차원 배열의 0행은 전부 0 이고 의미있는 값이 없음
		for (int i = 1; i < N; i++) {
			pascalTriangle[i][0] = 1;
			pascalTriangle[i][i] = 1;
			
			// 파스칼 삼각형의 한 행을 채운다 시작과 마지막은 1 1 이기 때문에 i-1 위치의 값까지 찾으면 된다.
			for (int j = 1; j < i; j++) {
				pascalTriangle[i][j] = pascalTriangle[i - 1][j] + pascalTriangle[i - 1][j - 1];
			}
		}
		
		for (int i = 0; i < pascalTriangle.length; i++) {
			for (int j = 0; j < pascalTriangle[i].length; j++) {
				System.out.print(pascalTriangle[i][j] + " ");
			}
			System.out.println();
		}
	}
}
