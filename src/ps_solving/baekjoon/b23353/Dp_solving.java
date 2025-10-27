package ps_solving.baekjoon.b23353;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Dp_solving {
	
	static class point {
		
		public int i;
		public int j;
		// 0 = 비어있음, 1 = 흑돌, 2 = 백돌
		public int condition;
		// 1 == 좌, 2 == 좌상단, 3 == 상단, 4 == 우상단,  0 == 방향없음
		public int raw_direct;
		// 변경 안한거, 즉 변경 할 수 있음
		public int raw_score;
		public int change_direct;
		// 변경 이미 한거, 즉 추가로 변경할 수 없음, 빈곳 흰돌은 0 으로 시작
		public int change_score;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int       N     = Integer.parseInt(br.readLine());
		int[][]   board = new int[N][N];
		point[][] dp    = new point[N][N];
		// 0 = 비어있음, 1 = 흑돌, 2 = 백돌
		// 흑돌의 가장 긴 길이가 점수
		for (int i = 0; i < N; i++) {
			String[] str_arr = br.readLine().split(" ");
			
			for (int j = 0; j < N; j++) {
				dp[i][j] = new point();
				int temp = Integer.parseInt(str_arr[j]);
				board[i][j] = temp;
				dp[i][j].i = i;
				dp[i][j].j = j;
				dp[i][j].condition = temp;
				dp[i][j].raw_direct = 0;
				dp[i][j].change_direct = 0;
				switch (temp) {
					case 0:
						dp[i][j].raw_score = 0;
						dp[i][j].change_score = 0;
						break;
					case 1:
						dp[i][j].raw_score = 1;
						dp[i][j].change_score = 0;
						break;
					case 2:
						dp[i][j].raw_score = 0;
						dp[i][j].change_score = 0;
						break;
				}
			}
		}
		
		// 점수 매기기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// dp[i][j - 1] == 1
				// dp[i - 1][j - 1] == 2
				// dp[i - 1][j] == 3
				// dp[i - 1][j + 1] == 4
				// 빈칸
				if (dp[i][j].condition == 0) {
					dp[i][j].raw_score = 0;
					dp[i][j].raw_direct = 0;
					dp[i][j].change_score = 0;
					dp[i][j].change_direct = 0;
					continue;
				}
				
				// 흑돌
				if (dp[i][j].condition == 1) {
					
					int max = 0;
					
					// 1
					if (j - 1 >= 0 &&
						(dp[i][j - 1].raw_direct == 1 || dp[i][j - 1].raw_direct == 0) &&
						dp[i][j - 1].raw_score > max) {
						
						dp[i][j].raw_direct = 1;
						dp[i][j].raw_score = dp[i][j - 1].raw_score + 1;
						max = dp[i][j].raw_score;
					}
					
					// 2
					if (i - 1 >= 0 &&
						j - 1 >= 0 &&
						(dp[i - 1][j - 1].raw_direct == 2 || dp[i][j - 1].raw_direct == 0) &&
						dp[i - 1][j - 1].raw_score > max) {
						
						dp[i][j].raw_direct = 1;
						dp[i][j].raw_score = dp[i][j - 1].raw_score + 1;
					}
					
					// 3
					if (i - 1) {
					
					}
				}
				
				// 백돌
				if (dp[i][j].condition == 2) {
				
				}
				
				
			}
		}
		
		br.close();
		bw.close();
	}
	
	public static int max(int... args) {
		
		int result = 0;
		for (int i : args) {
			result = Math.max(result, i);
		}
		
		return result;
	}
	
}
